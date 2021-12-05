#include <stdio.h>

char buf[33];

int main(void)
{
    int n, p=32;
    scanf("%d", &n);
    while (n--)
    {
        buf[p--] = n % 2 ? '7' : '4';
        n /= 2;
    }
    printf("%s\n", &buf[p + 1]);
}
