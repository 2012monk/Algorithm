def check():
    cand = input()
    stack = 0
    for s in cand:
        if s == '(':
            stack += 1
        elif s == ')':
            stack -= 1
            if stack < 0:
                break

    if stack == 0:
        return 'YES'
    else:
        return 'NO'


n = int(input())

for _ in range(n):
    print(check())
