import re


with open("C:/Users/utkae/PycharmProjects/pythonProject/schedule.json", encoding='utf-8') as f:
    s = f.read()
#objn = r'".+?": \"\S*?\"\,{0,1}\n|".+?": \d+\,{0,1}\n|".+?": true\,{0,1}\n'

s = "<root>" + s[1:-1] + "</root>"
objName = r'".+?": '
objNames = re.findall(objName, s)
#print(objNames)
tags = ["<" + x[1:-3] + ">" for x in objNames]
#print(tags)
for i in range(len(tags)):
    s = s.replace(objNames[i], tags[i], 1)

content = r'<.+?>\".+?\"\,*\n|<.+?>\d+\,*\n|<.+?>true\,*\n|<.+?>false\,*\n|<.+?>none\,*\n'
contents = re.findall(content, s)
#print(*contents, sep="\n")
for i in range(len(contents)):
    s = s.replace(contents[i], contents[i][:-2] + "</" + contents[i][1:contents[i].index(">") + 1] + "\n", 1)
#print(s)


s = s.replace("{", "")
s = s.replace("}", "")

strings = s.split("\n")

for k in range(1, len(strings)):
    onlyTag = r'\s*<[^/]+?>\s*'
    if re.fullmatch(onlyTag, strings[k]):
        for m in range(k, len(strings)):
            if re.fullmatch(r'\s*,\s*', strings[m]):
                strings[m] = re.sub(r',', "</" + strings[k].strip()[1:-1] + ">", strings[m])
                break
for st in strings:
    if len(st.strip()) == 0:
        strings.remove(st)


insertion = None
for k in range(1, len(strings)):
    openArrTag = r'\s*<[^/]+?>\[\s*'
    if re.fullmatch(openArrTag, strings[k]):
        stst = strings[k].strip()
        tabs = len(strings[k][:strings[k].index("<")])
        strings[k] = strings[k][:-1]
        for w in range(k, len(strings)):
            stst1 = strings[w].strip()
            if stst1 == "]":
                tabs1 = len(strings[w][:strings[w].index("]")])
                if tabs == tabs1:
                    strings[w] = strings[w].replace("]", "\t" + "</" + stst[1:-1])
                    insertion = w
                    break
        for w2 in range(k, insertion):
            stst2 = strings[w2].strip()
            if stst2 == ",":
                tabs2 = len(strings[w2][:strings[w2].index(",")])
                if tabs2 == tabs + 4:
                    strings[w2] = strings[w2].replace(",", "</" + stst[1:-1])
                    strings.insert(w2 + 1, " " * tabs2 + stst[:-1])


isShift = [0] * len(strings)
numberOfTabs = [0] * len(strings)

for i in range(1, len(strings)):
    prevstrp = strings[i - 1].strip()
    curstrp = strings[i].strip()
    spacesprev = len(strings[i - 1]) - len(prevstrp)  # number of leading spaces in previous line
    spacesthis = len(strings[i]) - len(curstrp)  # number of leading spaces in current line
    shift = spacesprev - spacesthis
    if shift < 0:
        isShift[i] = 1
    if shift > 0:
        isShift[i] = -1

for i in range(1, len(strings) - 1):
    if isShift[i] == 1:
        numberOfTabs[i] = numberOfTabs[i-1] + 1
    if isShift[i] == 0:
        numberOfTabs[i] = numberOfTabs[i-1]
    if isShift[i] == -1:
        numberOfTabs[i] = numberOfTabs[i-1] - 1

for i in range(len(strings)):
    strings[i] = strings[i].strip()

for i in range(len(strings)):
    strings[i] = "\t" * numberOfTabs[i] + strings[i]




almxml = "\n".join(strings)
almxml = almxml.replace("\"", "")

print(almxml)








































