stack = []
cal = []
p = input()

for s in p:
    if s == '(':
        stack.append(2)
        cal.append("*")
    elif s == ')':
        if stack and stack[-1] == 2:
            stack.append(1)
            cal.append('+')
        else:
            break
    elif s == '[':
        stack.append(3)
        cal.append('*')
    elif s == ']':
        if stack and stack[-1] == 3:
            stack.append(1)
            cal.append('+')

        else:
            break
print(stack)
print(cal)

while len(stack) != 0:
    a = stack.pop()
    b = stack.pop()

