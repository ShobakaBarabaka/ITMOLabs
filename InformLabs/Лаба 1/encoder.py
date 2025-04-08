# Функция переводит число из десятичной системы в отрицательную десятичную

def dec_to_negadec(n):
    dgts = []   # список со знаками получаемого числа
    while n != 0:
        dgts.append(n % 10)
        if n % 10 != 0:
            n = (n // (-10)) + 1
        else:
            n = n // (-10)

    print(*dgts[::-1], sep='')
dec_to_negadec(167)