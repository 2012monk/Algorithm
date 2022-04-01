def get_primes(limit):
    sieve = [1] * (limit + 1)
    arr = [2]
    for i in range(3, int(limit ** 0.5) + 1, 2):
        if sieve[i]:
            for j in range(i * i, limit + 1, i * 2):
                sieve[j] = 0
    for i in range(3, limit + 1, 2):
        if not sieve[i]:
            continue
        arr.append(i)
    return arr


if __name__ == '__main__':
    n = int(input())
    arr = get_primes(n)
    size = len(arr)
    lo, hi, s, r = 0, 0, 0, 0
    while 1:
        if s >= n:
            s -= arr[lo]
            lo += 1
        elif hi == size:
            break
        else:
            s += arr[hi]
            hi += 1
        if s == n:
            r += 1

    print(r)
