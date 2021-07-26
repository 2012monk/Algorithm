from collections import deque


def solution(n: int, k: int, cmd: str) -> str:
    st = []
    ll = deque([i for i in range(k, n)] + [i for i in range(k)])
    res = ['O' for _ in range(n)]

    for op in cmd:
        c = op.split(' ')

        if len(c) > 1:
            if c[0] == 'U':
                ll.append(ll.popleft())
            else:
                ll.appendleft(ll.pop())

        elif c[0] == 'C':
            i = ll.popleft()
            st.append(i)
            if ll[0] < i:
                ll.appendleft(ll.pop())
            res[i] = 'X'
        else:
            z = st.pop()
            i = 0
            print(ll)
            while ll[i] > z and i < len(ll) - 1:
                i += 1
            ll.insert(i, z)
            print(ll)
            res[z] = 'O'

    return ''.join(res)

print(solution(8,	2,	["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]))