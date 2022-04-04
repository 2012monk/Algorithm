import collections

if __name__ == '__main__':
    n = int(input())
    words = [input() for _ in range(n)]
    letters = collections.defaultdict(int)

    for word in words:
        length = len(word) - 1
        for c in word:
            letters[c] += pow(10, length)
            length -= 1

    letters = sorted(letters.values(), reverse=True)

    res, cur = 0, 9
    for v in letters:
        res += cur * v
        cur -= 1
    print(res)
