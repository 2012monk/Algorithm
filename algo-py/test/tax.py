import functools
import math
from sympy import Symbol, solve


def tax(order, sf, tf):
    sup = order - sf
    h = ((sup + (tf / 10)) / 11) * 10
    print(h)
    print(math.ceil(order - h))


order = 120
sf = 0
tf = 20
tax(order, sf, tf)

import re


def number(n):
    num = '0123456789'
    if len(n) != 1 and n[0] == '0':
        return False

    if ',' in n:
        sp = n.split(',')
        if sp[0] == '':
            return False
        for x in sp[0]:
            if x not in num:
                return False

        for x in sp[1:]:
            if len(x) != 3:
                return False
            for t in x:
                if t not in num:
                    return False
    else:
        for t in n:
            if t not in num:
                return False
    return True


tc = [
    '00011312',
    '11,234,534',
    ',13,,,,234',
    '13,234,54,14,',
    '013,321,32',
    '+,0312,32,',
    '434009094400000',
    '013',
    '09--=234--4@34234',
    '13,234,,000',
    '0'
]

for t in tc:
    print(t, number(t))

p1 = re.compile('[0-9]{3}')
p2 = re.compile('[0-9]')
