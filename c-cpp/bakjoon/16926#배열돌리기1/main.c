#include <stdio.h>

void rotate(int arr[][300], int x, int y, int xsize, int ysize)
{
    int start = arr[x][y];
    int nx[] = {-1, 0, 1, 0};
    int ny[] = {0, 1, 0, -1};
    int cnt, dx, dy, d = 0;
    int xbound = x, ybound = y;

    cnt = 2 * xsize + 2 * ysize - 4;

    while (cnt > 1) {
        dx = x + nx[d];
        dy = y + ny[d];
        if (dx < xbound || dx >= xbound + xsize || dy < ybound || dy >= ybound + ysize) {
            d = (d + 1) % 4;
            continue;
        }
        arr[x][y] = arr[dx][dy];
        x = dx;
        y = dy;
        cnt--;
    }
    arr[x][y] = start;
}

int main(void)
{
    int arr[300][300];
    int n, m, r;

    scanf("%d %d %d\n", &n, &m, &r);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d",&arr[i][j]);
        }
    }

    while (r--) {
        for (int i = 0; i < n / 2 && i < m / 2; i++) {
            rotate(arr, i, i, n - i * 2, m - i * 2);
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            printf("%d ", arr[i][j]);
        printf("\n");
    }
    return 0;
}

