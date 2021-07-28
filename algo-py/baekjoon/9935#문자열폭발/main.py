# 시간복잡도 O(n) 공간복잡도 O(n)
def explode(line: str, sub: str) -> str:

    st = []

    p = 0

    for i in range(len(line)):

        if line[i] == sub[p]:
            p += 1
        elif line[i] == sub[0]:
            p = 1
        else:
            p = 0
        st.append((line[i], p))
        if p == len(sub):
            for _ in range(len(sub)):
                st.pop()
            if st:
                p = st[-1][1]
            else:
                p = 0

    return ''.join(map(lambda x: x[0], st)) if st else 'FRULA'


l = 'mirkovC4nizCC44'
s = 'C4'
# l = '12ab112ab2ab'
# s = '12ab'
if __name__ == '__main__':
    l = input()
    s = input()
    print(explode(l, s))