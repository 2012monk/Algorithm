total = 3

input_list = [[26, 40, 83],
              [49, 60, 57],
              [13, 89, 99]]

inputString = ['26 40 83',
               '49 60 57',
               '13 89 99']

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
print(result)
print(min(result)+min(input_list[-1]))
