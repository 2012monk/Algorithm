days = {
    "MO": 0, "TU": 1, "WE": 2, "TH": 3, "FR": 4
}


def parse_time(time):
    H, M = time.split(":")
    return int(H) - 9 + +(int(M) == 30)


def _set(table, elm):
    duration = 6
    if len(elm) // 4:
        duration = 3
    for i in range(0, len(elm), 2):
        d = days[elm[i]]
        t = parse_time(elm[i + 1])
        for j in range(t, t + duration):
            table[d][j] = 1


def _unset(table, elm):
    duration = 6
    if len(elm) // 4:
        duration = 3
    for i in range(0, len(elm), 2):
        d = days[elm[i]]
        t = parse_time(elm[i + 1])
        for j in range(t, t + duration):
            table[d][j] = 0


def is_free(table, elm):
    duration = 6
    if len(elm) // 4:
        duration = 3
    for i in range(0, len(elm), 2):
        d = days[elm[i]]
        t = parse_time(elm[i + 1])
        for j in range(t, t + duration):
            if table[d][j]:
                return False
    return True


def f(t):
    for i in range(5):
        for j in range(21):
            print(t[i][j], end=' ')
        print()
    print()


def solution(schedule):
    table = [[0 for _ in range(21)] for _ in range(5)]

    def solve(cur):
        if cur == 5:
            return 1
        ret = 0
        for sc in schedule[cur]:
            elm = sc.split(" ")
            if not is_free(table, elm):
                continue
            _set(table, elm)
            ret += solve(cur + 1)
            _unset(table, elm)
        return ret
    return solve(0)


print(solution(
    [["MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"], ["TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"],
     ["WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"], ["TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"],
     ["FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"]]))
