import math
from collections import defaultdict


def getMinute(s: str):
    h, m = map(int, s.split(":"))
    return 60 * h + m


def solution(fees, records):
    m = defaultdict(list)
    for rec in records:
        t, car, inout = rec.split(" ")
        car = int(car)
        if inout == 'OUT':
            m[car].pop()
            m[car].append(getMinute(t) - m[car].pop())
        else:
            m[car].append(getMinute(t))
            m[car].append(-1)
    print(m)
    end = getMinute("23:59")
    for n in m:
        if m[n][-1] == -1:
            m[n].pop()
            t = end - m[n].pop()
            m[n] = t + sum(m[n])
        else:
            m[n] = sum(m[n])
    answer = []
    for car in sorted(list(m)):
        if m[car] <= fees[0]:
            answer.append(fees[1])
        else:
            answer.append((math.ceil((m[car] - fees[0]) / fees[2]) * fees[3])+fees[1])

    return answer


print(solution([180, 5000, 10, 600],
               ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))
