# 중위 표기식에서 후위 표기식으로 변환하기 위한 algorithm
import re

"""
:param op1 현재대상
:param op2 비교할 대상
:return op1 > op2
"""


def compareOp(op1: str, op2: str):
    priority = {
        '%': 5,
        '^': 5,
        '*': 5,
        '/': 5,
        '+': 3,
        '-': 3,
        '(': 1
    }

    return priority[op1] >= priority[op2]


def convertExpression(expression: str) -> list[str]:
    stack = []
    result = []

    for char in expression.replace(' ', ''):

        # if char in number:
        if re.match('[0-9a-zA-Z]', char):
            result.append(char)

        elif char == '(':
            stack.append(char)
        elif char == ')':
            while stack and stack[-1] != '(':
                result.append(stack.pop())
            stack.pop()
        else:

            # 우선순위가 op1 < op2 일때 True
            while stack and not compareOp(char, stack[-1]):
                result.append(stack.pop())
            stack.append(char)

    # stack 이 비어있지않으면 스택에서 모두꺼내서 저장
    if stack:
        result.extend(stack[::-1])
    return result


###### TEST code

expressions = [
    '1+2*3',  # 123*+
    '(1+2)*3',  # 12+3*
    '((1-3) * (3 + 4)) / 2',  # 13-34+*2/
    'A*B-C/D',
    ' (a+f*(b^d^g))/(a+b)d+e%c'

]

if __name__ == '__main__':
    for expression in expressions:
        converted = ''.join(convertExpression(expression))
        print(converted)
