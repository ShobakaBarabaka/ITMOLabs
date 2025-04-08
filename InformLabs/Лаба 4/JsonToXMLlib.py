import json
import xmltodict
import simplejson as json1

with open("C:/Users/utkae/PycharmProjects/pythonProject/schedule.json", encoding='utf-8') as f:
    data = json1.load(f)


data = {'root': data}

xml_string = xmltodict.unparse(data, pretty = True)
print(xml_string)