import re


def compare(op1: str, op2: str) -> bool:
    priority = {
        '/': 5,
        '*': 5,
        '+': 3,
        '-': 3,
        '(': 1
    }
    return priority[op1] > priority[op2]


def convert(expression: str) -> str:
    res = []
    st = []
    for c in expression:
        if re.match('[A-Z]', c):
            res.append(c)
        elif c == '(':
            st.append(c)
        elif c == ')':
            while st and st[-1] != '(':
                res.append(st.pop())
            st.pop()
        else:
            while st and not compare(c, st[-1]):
                res.append(st.pop())
            st.append(c)

    return ''.join(res+list(reversed(st)))


if __name__ == '__main__':
    print(convert(input()))
