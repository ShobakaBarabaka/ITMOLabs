import re


def smile(string):
    pattern = r'=-\\'
    res = re.findall(pattern, string)
    print(string, '\n', len(res))


test1 = "=-\\gdfgdfgdfg=---\\dfg=-\\"  # 2 смайлика
test2 = "\-===--\\=-\\"  # 1 смайлик
test3 = "Helloooo :-\\"  # 0 смайликов
test4 = "Hi, sweetie =-)"  # 0 смайликов
test5 = "=-\/"  # 1 смайлик
test6 = ''
tests = [test1, test2, test3, test4, test5,test6]
for test in tests:
    smile(test)
