#include <stdio.h>
#include <algorithm>
using namespace std;

#define SIZE 1024
int n, grid[SIZE][SIZE];

int solve(int x, int y, int size)
{
    int tmp[4];

    if (size == 1)
        return grid[x][y];
    size >>= 1;
    tmp[0] = solve(x, y, size);
    tmp[1] = solve(x + size, y, size);
    tmp[2] = solve(x, y + size, size);
    tmp[3] = solve(x + size, y + size, size);
    sort(tmp, tmp + sizeof(tmp)/sizeof(int));
    return tmp[2];
}

int main(void)
{
    scanf("%d", &n);
    for (int i = 0 ; i < n;i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &grid[i][j]);
    printf("%d", solve(0, 0, n));
}

