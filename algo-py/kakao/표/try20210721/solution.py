# 효율성 실패
"""
    효율성  테스트
    테스트 1 〉	실패 (시간 초과)
    테스트 2 〉	실패 (시간 초과)
    테스트 3 〉	통과 (2029.22ms, 22.1MB)
    테스트 4 〉	통과 (107.37ms, 28.4MB)
    테스트 5 〉	통과 (108.63ms, 28.3MB)
    테스트 6 〉	실패 (시간 초과)
    테스트 7 〉	통과 (1834.39ms, 18.7MB)
    테스트 8 〉	통과 (3931.44ms, 23.6MB)
    테스트 9 〉	실패 (시간 초과)
    테스트 10 〉	실패 (시간 초과)
"""
def solution(n, k, cmds):
    st = []
    for c in cmds:
        if c.startswith('U'):
            k -= int(c.split()[1])
            k = k if k >= 0 else 0
        elif c.startswith('D'):
            k += int(c.split()[1])
            k = k if k < n else n - 1
        elif c == 'C':
            st.append(k)
            n -= 1
            k = k if k < n else n - 1
        else:
            if not st:
                continue
            z = st.pop()
            n += 1
            if k >= z:
                k += 1

    res = ['O' for _ in range(n)]
    while st:
        res.insert(st.pop(), 'X')
    return ''.join(res)

n = 6
k = 2
# cmd = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]
# cmd = ["U 5", "C", "D 2", "Z", "C"]
# cmd = ["C", "U 4", "C", "D 3", "C", "D 2", "Z"]
cmd = ["U 2", "C", "C", "C", 'U 3', 'Z']

print(solution(n, k, cmd))
