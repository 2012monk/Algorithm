from collections import defaultdict, Counter


def solution(id_list, report, k):
    m = defaultdict(list)
    rep = []
    for name in report:
        r, t = name.split()
        if t not in m[r]:
            rep.append(t)
            m[r].append(t)
    c = Counter(rep)
    res = []
    for n in id_list:
        r = 0
        for rr in m[n]:
            if c[rr] >= k:
                r += 1
        res.append(r)

    return res


print(solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3))
print(
    solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"],
             2))
