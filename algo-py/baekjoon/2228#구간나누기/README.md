## 접근

완전 탐색으로 모든 경우의 수를 찾는 알고리즘에 중복되는 문제를 재활용한다.

n 개의 원소를 가진 배열을 m개로 나눈다는 과정은 하위의 문제들로 분할이 가능하다.

임의의 구간 인덱스 k 를 선택한 후 k + 2 부터 n까지 배열중 m - 1 구간으로 나누는 문제로 분할한다.

이때 k 번 인덱스에서 m 개의 구간으로 나누었을 때를 dp 테이블에 기록한다.

## 구현

python 구현

```python
def solution(n, k, a):
    cache = [[-float('inf') for _ in range(n + 1)] for _ in range(n + 1)]
    # 캐시 배열은 최소값으로 초기화
    def a_split(st, remain):
        if remain < 0:
            return 0
        if st >= n:
            return -float('inf')
        if cache[st][remain] != -float('inf'):
            return cache[st][remain]
        
        r = [a_split(st + 1, remain)]  # 현재 인덱스를 선택하지 않을때 계산
        s = 0
        for i in range(st, n - (2 * remain)):
            s += a[i]  # 구간합 계산
            r.append(s + a_split(i + 2, remain - 1))
            # 구간합과 현재 선택한 인덱스와 인접하지 않은 구간에서 부분문제의 결과값

        cache[st][remain] = max(r)
        return cache[st][remain]

    return a_split(0, k - 1)
```

