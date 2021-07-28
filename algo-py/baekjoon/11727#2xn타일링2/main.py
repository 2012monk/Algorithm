def tile(n: int) -> int:
    a, b = 0, 1
    while n:
        n -= 1
        a, b = b, (a * 2 + b) % 10007
    return b

if __name__ == '__main__':
    print(tile(int(input())))