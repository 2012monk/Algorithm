stack = []
buffer = []
result = False
plusStack = []
# p = "(()[[]])([])"
p = "([](()"


# p = input()

def calc(s):
    ca = 0
    while True:
        if stack and type(stack[-1]) == int:
            ca += stack.pop()
        else:
            break
    # print(ca)
    if stack and stack[-1] == s:
        return ca
    else:
        return 0


for s in p:
    print(stack)
    if s == '(' or s == '[':
        stack.append(s)
    elif s == ')':
        # print(stack)
        if not stack:
            result = True
            break
        if stack[-1] != '(':
            n = calc('(')
            if n == 0:
                result = True
                break
            else:
                # print(stack)
                # print("asdfal")
                stack.pop()
                # stack.pop()
                stack.append(n * 2)
        else:
            stack.pop()
            stack.append(2)
    elif s == ']':
        if not stack:
            result = True
            break
        if stack[-1] != '[':
            n = calc('[')

            if n == 0:
                result = True
                break
            else:
                # stack.pop()
                stack.pop()
                stack.append(n * 3)
        else:
            stack.pop()
            stack.append(3)

print(stack)
# print(stack)

if result:
    print(0)
else:
    try:
        r = 0
        for i in stack:
            r += i

        print(r)
    except:
        print(0)
