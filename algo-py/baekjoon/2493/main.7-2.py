n = int(input())

li = list(map(int, input().split(" ")))
li = [(li[i], i) for i in range(len(li))]
st = [li[0]]
r = [0]
for i in range(1, len(li)):
    while len(st) and st[-1][0] < li[i][0]:
        st.pop()
    if not len(st):
        r.append(0)
    else:
        r.append(st[-1][1] + 1)
    st.append(li[i])

# print(r)
# print(st)
print(*r)
