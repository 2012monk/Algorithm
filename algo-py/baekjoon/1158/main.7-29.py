
def josephus(n, k):
    table = [i for i in range(1, n + 1)]
    res = []
    p = k - 1
    for _ in range(n - 1):
        res.append(str(table.pop(p)))
        p = (p + k - 1) % len(table)
    res.append(str(table.pop()))
    return "<" + ", ".join(res) + ">"

if __name__ == '__main__':
    n, k = map(int, input().split())
    print(josephus(7, 3))
