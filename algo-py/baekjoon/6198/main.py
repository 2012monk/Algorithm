
# l = [int(input()) for i in range(n)]
#
# st = [l[0]]
# r = [0]
#
# for i in range(n - 1, -1, -1):
#
#     st.append(l[i])


n = int(input())
st = []
r = 0
for i in range(n):
    t = int(input())
    while len(st) and st[-1] <= t:
        st.pop()
    r += len(st)
    st.append(t)

print(r)

