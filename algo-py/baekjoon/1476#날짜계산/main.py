if __name__ == '__main__':
    e, s, m = map(int, input().split())
    y = 1
    i, j, k = 1, 1, 1
    while not ((y - e) % 15 == 0 and (y - s) % 28 == 0 and (y - m) % 19 == 0):
        y += 1
    print(y)
