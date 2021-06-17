total = int(input())

input_list = []

for i in range(total):
    input_list.append(list(map(int, input().split(" "))))

result = [0 for i in range(6)]

r = 0
prev = 0
for i in range(total):
    if i == 0:
        m = min(input_list[i])
        prev = input_list[i].index(m)
    else:
        tmp = input_list[i].copy()
        tmp.pop(prev)
        m = min(tmp)
        prev = input_list[i].index(m)

    r += m
print(r)
