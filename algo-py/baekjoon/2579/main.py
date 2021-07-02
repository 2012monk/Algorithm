n = 6
l = [10, 20, 15, 25, 10, 20]

# l.reverse()
r = []

r.append(l[0])
r.append(max(l[0] + l[1], l[1]))
r.append(max(l[0] + l[2], l[1] + l[2]))

for i in range(3, n):
    r.append(max(r[i - 2] + l[i], r[i - 3] + l[i] + l[i - 1]))


print(r)