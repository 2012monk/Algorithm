import sys

def build(root, parent, tree, graph):
    if parent != -1:
        tree[parent].append(root)
    for node in graph[root]:
        if node != parent:
            build(node, root, tree,graph)


def countSubTree(node, tree, size):
    size[node] = 1
    for child in tree[node]:
        countSubTree(child, tree, size)
        size[node] += size[child]


if __name__ == '__main__':
    input = sys.stdin.readline
    sys.setrecursionlimit(int(10e6))
    n, root, q = map(int, input().split())
    g = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        u, v = map(int, input().split())
        g[u].append(v)
        g[v].append(u)
    tree = [[] for _ in range(n + 1)]
    size = [0 for _ in range(n + 1)]
    build(root, -1, tree, g)
    countSubTree(root, tree, size)
    r = [str(size[int(input())]) for _ in range(q)]
    print('\n'.join(r))


