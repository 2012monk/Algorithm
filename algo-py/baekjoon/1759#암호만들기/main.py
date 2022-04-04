def isValid(word):
    vowels = 'aeiou'
    v, c = 0, 0
    for w in word:
        if w in vowels:
            v += 1
        else:
            c += 1
    return v >= 1 and c >= 2


def solution(letters, path, cur, L, result):
    if len(path) == L:
        if isValid(path):
            result.add(path)
        return
    if cur == len(letters):
        return
    solution(letters, path + letters[cur], cur + 1, L, result)
    solution(letters, path, cur + 1, L, result)


if __name__ == '__main__':
    L, C = map(int, input().split())
    inputs = sorted(input().split())
    res = set()
    solution(inputs, "", 0, L, res)
    print("\n".join(sorted(res)))
