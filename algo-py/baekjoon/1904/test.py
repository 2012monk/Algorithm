l = 7

r = 3
for i in range(2, l + 1, 2):
    r += (l - i) - ((l - i) % 2) + 2

print(r)

l = int(input())
a = 1
b = 2
c = 2
for i in range(2, l):
    c = (a + b) % 15746
    a = b
    b = c

print(c)

print(c % 15746)
