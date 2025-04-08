import re


def cron(cron_exp):

    cron_exp = str(cron_exp).strip()
    if len(cron_exp.split(' ')) != 5:
        print('Это не крон выражение')
    else:
        # 1,2,3 строки отвечают за минуты
        # 4,5,6 за часы
        # 7,8,9 за дни месяца
        # 10,11,12 за сами месяца
        # 13,14,15 за дни недели
        pattern = r'\D((([0-9]|[1-5][0-9]|\*)(?:/([0-9]|[1-5][0-9]))?)|' \
                  r'((?:([0-9]|[1-5][0-9])\,)+([0-9]|[1-5][0-9]))|' \
                  r'(([0-9]|[1-5][0-9])\-([0-9]|[1-5][0-9]))) ' \
                  r'((([0-9]|1[0-9]|2[0-3]|\*)(?:/([0-9]|1[0-9]|2[0-3]))?)|' \
                  r'((?:([0-9]|1[0-9]|2[0-3])\,)+([0-9]|1[0-9]|2[0-3]))|' \
                  r'(([0-9]|1[0-9]|2[0-3])\-([0-9]|1[0-9]|2[0-3]))) ' \
                  r'((([1-9]|[1-2][0-9]|3[0-1]|\*)(?:/([1-9]|[1-2][0-9]|3[0-1]))?)|' \
                  r'((?:([1-9]|[1-2][0-9]|3[0-1])\,)+([1-9]|[1-2][0-9]|3[0-1]))|' \
                  r'(([1-9]|[1-2][0-9]|3[0-1])\-([1-9]|[1-2][0-9]|3[0-1]))) ' \
                  r'((([1-9]|1[0-2]|\*)(?:/([1-9]|1[0-2]))?|jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)|' \
                  r'((?:([1-9]|1[0-2])\,)+([1-9]|1[0-2]))|((?:(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)\,)+(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec))|' \
                  r'(([1-9]|1[0-2])\-([1-9]|1[0-2]))|((jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)\-(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec))) ' \
                  r'((([0-6]|\*)(?:/([0-6]))?|sun|mon|tue|wed|thu|fri|sat)|' \
                  r'((?:([0-6])\,)+([0-6]))|((?:(sun|mon|tue|wed|thu|fri|sat)\,)+(sun|mon|tue|wed|thu|fri|sat))|' \
                  r'(([0-6])\-([0-6]))|((sun|mon|tue|wed|thu|fri|sat)\-(sun|mon|tue|wed|thu|fri|sat)))\D'
        res = re.findall(pattern, ' ' + cron_exp + ' ', flags=re.IGNORECASE)
        print("Это крон-выражение" if bool(res) else "Это не крон-выражение")

cron('0 0 * * Fri')
test1 = '60 * * * * '  # Слишком много минут
test2 = 'apr 12,13 4-6 sep tue'  # Вместо минут месяц
test3 = '1-57 */3 1,15,31 2,4,6 MON-FRI'  # Всё ок
test4 = ' 23,22,21 4-6 * jun,feb,may 2/3  '  # Всё ок
test5 = '* 11 17,18 jan-jul * 5 4,3'  # Больше 5 аргументов
test6 = '0 18 31 * fri'
tests = [test1, test2, test3, test4, test5,test6]
for test in tests:
    print(test)
    cron(test)
    print('\n')


