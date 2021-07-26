from collections import Counter


def solution(s: str) -> str:
    b = Counter(list(s))
    t = 0
    last = ''
    for k, v in b.items():
        if v % 2 != 0:
            t += 1
            last = k
        if t > 1 or not s:
            return "I'm Sorry Hansoo"

    res = [a * (b[a] // 2) for a in sorted(list(set(list(s))))]
    return ''.join(res + [last] + res[::-1])


# if __name__ == '__main__':
#     print(solution(input()))
print(solution('AB'))
