p = ''
while True:
    i = input()
    if i == '.':
        break
    p += i

l = p.split('.')[:-1]

re = []

for i in l:

    st = []
    for s in i:
        if s == '(' or s == '[':
            st.append(s)
        elif s == ')':
            if len(st) and st[-1] == '(':
                st.pop()
            else:
                st.append(s)
                break
        elif s == ']':
            if len(st) and st[-1] == '[':
                st.pop()
            else:
                st.append(s)
                break

    if st:
        re.append("no")
    else:
        re.append("yes")


for s in re:
    print(s)




