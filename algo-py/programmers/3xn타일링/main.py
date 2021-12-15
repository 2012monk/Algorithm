def solution(n):
    dp = [0, 3, 11]
    mod = 1_000_000_007
    
    for _ in range(n//2-1):
        dp.append((dp[-1]*4 - dp[-2]) % mod)
    return dp[n//2] % mod
