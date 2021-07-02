

p = ["leo", "kiki", "eden"]
c = ["eden", "kiki"]

t = [[["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]],
     [["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]]]
def solution(p, c):
    t = {}
    r = ''
    for n in c:
        if not t.get(n):
            t[n] = 1
        else:
            t[n] = t[n] + 1
    for n in p:
        if t.get(n) == 1:
            t.pop(n)
        elif t.get(n) is None:
            r = n
            break
        else:
            t[n] = t[n] - 1
    return r


for c in t:
    print(solution(c[0], c[1]))