# test = "()(((()())(())()))(())"
# test = "(((()(()()))(())()))(()())"
test = "(()()(()())(()))"
# test = input()
st = []
res = 0
for i in test:
    print(st, "res=", res)
    if i == '(':
        st.append(i)
    else:
        if st[-1] == '(':
            st.pop()
            n = 1
            if st and st[-1] != '(':
                n += st.pop()
            if st:
                st.append(n)
        else:
            t = st.pop()
            if st and st[-1] == '(':
                st.pop()
                res += t + 1
                if st and type(st[-1]) == int:
                    t += st.pop()
                    st.append(t)
                else:
                    st.append(t)
            elif st and type(st[-1]) == int:
                t += st.pop()
                st.append(t)


print(res)

