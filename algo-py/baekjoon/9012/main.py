def check():
    re = input()
    st = []
    tf = False
    for s in re:
        if s == '(':
            st.append(s)
        elif s == ')':
            if len(st) > 0:
                st.pop(-1)
            else:
                tf = True
                break
    # print(st)
    if len(st) == 0 and not tf:
        print("YES")
    else:
        print('NO')


n = int(input())
# print(n)
for i in range(n):
    check()
