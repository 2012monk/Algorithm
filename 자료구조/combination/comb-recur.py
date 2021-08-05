from typing import List

# nCr = n-1Cr + n-1Cr-1 응용

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        self.comb(n,k,1,[],res)
        return res

    def comb(self, n, k, t, path, res):
        if k == 0:
            res.append(path[:])
            return
        if t > n:
            return

        self.comb(n, k - 1, t + 1, path + [t], res)
        self.comb(n, k, t + 1, path[:], res)