def getFailure(cand):
    t = [0] * len(cand)

    j = 0
    for i in range(1, len(cand)):
        while j > 0 and cand[i] != cand[j]:
            j = t[j - 1]
        if cand[i] == cand[j]:
            j += 1
            t[i] += j
    return t


def kmp(page, target):
    f = getFailure(target)
    j = 0
    result = []
    for i in range(len(page)):
        while j > 0 and page[i] != target[j]:
            j = f[j - 1]
        if page[i] == target[j]:
            j += 1
        if j == len(target):
            result.append(i - len(target) + 1)
            j = f[j - 1]

    return result


tc = 'ABC ABCDAB ABCDABCDABDE'
target = 'ABCDABD'
tc = open('./test-text.txt').read()
target = 'char'
print(tc.split('\n')[0], '1231!!!!!!!!!!!!!!!!!!1')
res = kmp(tc, target)
print(res)
r = ''
p = 0
for i in res:
    r += tc[p:i] + '===++'
    p = i + len(target)
    r += tc[i:p] + '++==='
print(r)
