"""
    결과
    테스트 1 〉	통과 (281.82ms, 74.6MB)
    테스트 2 〉	통과 (278.92ms, 74.5MB)
    테스트 3 〉	통과 (280.25ms, 74.4MB)
    테스트 4 〉	통과 (250.34ms, 80.2MB)
    테스트 5 〉	통과 (235.86ms, 80.2MB)
    테스트 6 〉	통과 (225.81ms, 78.5MB)
    테스트 7 〉	통과 (113.98ms, 27.9MB)
    테스트 8 〉	통과 (118.70ms, 34.3MB)
    테스트 9 〉	통과 (235.98ms, 80.2MB)
    테스트 10 〉	통과 (231.12ms, 80.1MB)
"""


def solution(n, k, cmd):
    st = []
    prev = [-1] + [i for i in range(n)] + [-1]
    prev, nxt = prev[:-2], prev[2:]
    res = ['O' for _ in range(n)]
    print(prev, nxt)
    for c in cmd:
        op = c.split(' ')

        if op[0] == 'U' or op[0] == 'D':
            for _ in range(int(op[1])):
                if op[0] == 'D':
                    k = nxt[k]
                else:
                    k = prev[k]

        elif op[0] == 'C':
            st.append(k)
            res[k] = 'X'
            if prev[k] != -1:
                nxt[prev[k]] = nxt[k]
            if nxt[k] != -1:
                prev[nxt[k]] = prev[k]

            k = nxt[k] if nxt[k] != -1 else prev[k]
        else:
            z = st.pop()
            if prev[z] != -1:
                nxt[prev[z]] = z
            if nxt[z] != -1:
                prev[nxt[z]] = z
            res[z] = 'O'
        print(c, st, k)
    return ''.join(res)


size = 8
pos = 2
# cmd = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]
# cmd = ["U 5", "C", "D 2", "Z", "C"]
# cmd = ["C", "U 4", "C", "D 3", "C", "D 2", "Z"]
# cmd = ["U 1", "C", "C", "C", 'D 1', 'Z']
# cmds = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]
cmds = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"]

print(solution(size, pos, cmds))
