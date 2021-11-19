#include <unistd.h>
#include <stdio.h>

char buf[402];

char pos(int x, int y, int size)
{
    if (x < 0 || y < 0 || x >= size || y >= size || size < 0)
        return ' ';
    if (!x || !y || x == size - 1 || y == size - 1)
        return '*';
    return pos(x - 2, y - 2, size - 4);
}

int main(void) {
    int n, size = 1;
    scanf("%d", &n);
    size += 4 * (n - 1);

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++)
            buf[j] = pos(i, j, size);
        buf[size] = '\n';
        write(1, buf, size + 1);
    }
    return 0;
}
