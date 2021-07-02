def solution(p):
    answer = True
    p.sort(key=lambda x: len(x))
    for i in range(len(p) - 1):
        for j in range(i + 1, len(p)):
            if p[i] == p[j][:len(p[i])]:
                answer = False
                break

    return answer

def s(p):
    p.sort(key=lambda x: len(x))
    a = True
    for i in range(len(p) - 1):
        for j in range(i + 1, len(p)):
            if p[j].startswith(p[i]):
                a = False
                break

    return a

def solution1(p):
    p.sort(key=len)
    for i, j in zip(p, p[1:]):
        if j.startswith(i):
            return False

    return True


p = [["119", "97674223", "1195524421"],
     ["12", "123", "1235", "567", "88"],
     ["123", "456", "789"]]



for t in p:
    # print(solution(t))
    print(s(t))
    print(solution1(t))



