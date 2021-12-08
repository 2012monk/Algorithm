#include <stdio.h>

int n, grid[128][128];
int res[2];

int is_full(int x, int y, int size)
{
    int color = grid[x][y];
    for (int i = x; i < x + size; i++)
    {
        for (int j = y; j < y + size; j++)
        {
            if (color != grid[i][j])
                return 0;
        }

    }
    return 1;
}

void count(int x, int y, int size)
{
    if (size == 1 || is_full(x, y, size))
    {
        res[grid[x][y]]++;
        return ;
    }
    size >>= 1;
    count(x, y, size);
    count(x + size, y, size);
    count(x, y + size, size);
    count(x + size, y + size, size);
}

int main(void)
{
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n ; j++)
            scanf("%d", &grid[i][j]);

    count(0, 0, n);
    printf("%d\n%d\n", res[0], res[1]);
}
