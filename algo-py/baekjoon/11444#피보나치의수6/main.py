MOD = 1000000007
def mat_mul(mat1, mat2, size=2):
    tmp = [[0 for _ in range(size)] for _ in range(size)]
    for i in range(size):
        for j in range(size):
            for k in range(size):
                tmp[i][j] += (mat1[i][k] * mat2[k][j]) % MOD
    return tmp


def power(n):
    mat = [[1, 1], [1, 0]]
    res = [[1, 1], [1, 0]]
    while n > 0:
        if n & 1:
            res = mat_mul(mat, res)
        mat = mat_mul(mat, mat)
        n //= 2
    return res


if __name__ == '__main__':
    print(power(int(input()) - 2)[0][0] % MOD)
