
def solution(towers):

    st = []
    b = [0] * len(towers)

    for i, v in enumerate(towers):

        while st and towers[st[-1]] < v:
            st.pop()

        if st:
            b[i] = st[-1] + 1
        st.append(i)
    return b

if __name__ == '__main__':
    n = input()
    ll = list(map(int, input().split()))

    print(*solution(ll))