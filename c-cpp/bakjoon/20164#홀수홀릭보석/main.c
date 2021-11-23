#include <stdio.h>
#include <string.h>

#define MAX(a, b) a > b ? a : b
#define MIN(a, b) a < b ? a : b

int mx = -__INT_MAX__ - 1, mn = __INT_MAX__;

void comb(int n, int start, int end, int total, int size, char numbers[]);

int convert(char n[], int st, int end)
{
    int ret = 0;
    while (st <= end)
        ret = (ret * 10) + n[st++] - '0';
    return ret;
}

void fill(char dst[], int n)
{
    int x = n, i = 0;

    while (x /= 10) i++;

    while (n)
    {
        dst[i--] = (n % 10) + '0';
        n /= 10;
    }
}

void solve(int len, int total, char numbers[])
{
    int i;

    for (i = 0; i < len; i++)
        total += (numbers[i] - '0') & 1;
    if (len == 1)
    {
        mx = MAX(total, mx);
        mn = MIN(total, mn);
        return ;
    }
    comb(0, 0, len - 1, total, MIN(3, len), numbers);
}

void comb(int n, int start, int end, int total, int size, char numbers[])
{
    char path[10] = {'\0', };
    int i, t = 0;

    if (size == 1)
    {
        n += convert(numbers, start, end);
        fill(path, n);
        solve(strlen(path), total, path);
        return ;
    }

    for (i = start; i <= end - 1; i++)
    {
        t = (t * 10) + numbers[i] - '0';
        comb(n + t, i + 1, end, total, size - 1, numbers);
    }
}

int main(void)
{
    char numbers[10] = {'\0', };
    scanf("%s", numbers);
    solve(strlen(numbers), 0, numbers);
    printf("%d %d\n", mn, mx);
    return 0;
}

