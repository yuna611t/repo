def check_digit(args):
    ret = ""

    if not args.isdigit():
        return "Error"
    if not len(args) == 11 and not len(args) == 12:
        return "Error"

    if len(args) == 11:
        ret = calculate_check_digit(args)
    if len(args) == 12:
        my_number = args[0:11]
        cd = args[11]
        if cd == calculate_check_digit(my_number):
            ret = "OK"
        else:
            ret = "NG"

    return ret


def calculate_check_digit(args):
    x = 0
    p = args[::-1]
    q = 0
    a = 0

    for n in range(1,12):
        if n >= 1 and n <= 6:
            q = n + 1
        elif n >= 7 and n <= 11:
            q = n - 5
        a += int(p[n-1]) * q

    remainder = a % 11
    if remainder <= 1:
      x = 0
    else:
      x = 11 - remainder

    return str(x)


try:
    while True:
        input = raw_input().strip()
        print check_digit(input)

except EOFError:
    pass
