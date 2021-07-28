import sys
def explode(line: str, sub: str):
    if not line:
        return 'FRULA'
    if len(line) < len(sub):
        return line

    res = []
    for i in range(0, len(line) - len(sub) + 1):

        if sub == line[i:i + len(sub)]:
            return explode(''.join(res) + line[len(sub) + i:], sub)
        res.append(line[i])
    return line


l = 'mirkovC4nizCC44'
s = 'C4'
l = '12ab112ab2ab'
s = '12ab'
l = 'CCC44'
s = 'C4'
l = 'acddd'
s = 'abcd'
l = '123'
s = '13'



if __name__ == '__main__':
    sys.setrecursionlimit(1000000)
    l = input()
    s = input()
    print(explode(l, s))