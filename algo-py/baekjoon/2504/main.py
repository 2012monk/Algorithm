p = input()

stack = []
calStack = []
for s in p:
    if s == '(':
        stack.append(2)
        calStack.append(('2', "*"))
    elif s == ')':
        if s and stack[-1] == 2:
            stack.pop()
            c = eval(str.join("", calStack.pop()) + '1')
            print(c)
            calStack.append((str(c), "+"))
        else:
            break
    elif s == '[':
        stack.append(3)
        calStack.append(('3', '*'))
    elif s == ']':
        if s and stack[-1] == 3:
            stack.pop()
            c = eval(str.join("", calStack.pop()) + '1')
            calStack.append((str(c), '+'))
        else:
            break

print(stack)
print(calStack)

print(list(map(lambda x: str.join("", x), calStack)))