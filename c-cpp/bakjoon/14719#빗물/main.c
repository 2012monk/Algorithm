#include <stdio.h>

#define MAX(a, b) ( a > b ? a : b )
int n, h, a[501];

int main(void)
{
    int i, j, cur, ret = 0;
    int lm = 0, rm = 0;

    scanf("%d %d", &h, &n);
    for (i = 0; i < n; i++) scanf("%d", a + i);
    i = 0;
    j = n - 1;

    while ( i < j )
    {
        lm = MAX(lm, a[i]);
        rm = MAX(rm, a[j]);

        if (lm <= rm)
            ret += lm - a[i++];
        else
            ret += rm - a[j--];
    }
    printf("%d\n", ret);
    return 0;
}
