from postfix_notation_convert import *
import re

def operate(a: int, op: str, b: int) -> int:
    op = op.replace('^', '**')
    return eval(str(a) + op + str(b))


def calculate_postfix(postfix_exp: list[str]) -> int:
    stack = []

    for op in postfix_exp:

        if re.match('[0-9]', op):
            stack.append(op)

        else:
            b = stack.pop()
            a = stack.pop()
            result = operate(a, op, b)
            stack.append(result)

    return stack.pop()


def calculate(expression: str) -> int:

    convert = convertExpression(expression)

    return calculate_postfix(convert)

expressions = [
    '1+2*3',  # 7
    '(1+2)*3',  # 9
    '((1-3) * (3 + 4)) / 2',  # -7.0
    '((2 * (2 ^ 3) - (2 ^ 2)) / 2) % 3'  # 0.0

]

if __name__ == '__main__':
    for exp in expressions:
        print(calculate(exp))


