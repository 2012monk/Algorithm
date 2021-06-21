import sys

res = list(input())
n = int(input())

buffer = []
for _ in range(n):
    cmd = sys.stdin.readline().replace("\n", "")
    if cmd.startswith('P'):
        res.append(cmd.split(" ")[1])
    elif cmd == 'L':
        if res:
            buffer.append(res.pop())
    elif cmd == 'D':
        if buffer:
            res.append(buffer.pop())
    elif cmd == 'B':
        if res:
            res.pop()


print(str.join("", res + buffer[::-1]))

