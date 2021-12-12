#include <stdio.h>

char b[1002][26];
int n, k, t;
int i, j;
char start[27], end[27], ans[27];

void swap(char *a, char *b)
{
    char tmp = *a;
    *a = *b;
    *b = tmp;
}

int check()
{
    for (i = 0; i < k - 1;i++)
    {
        if (start[i] == end[i])
            ans[i] = '*';
        else if (start[i] == end[i + 1] && start[i + 1] == end[i])
        {
            ans[i] = '-';
            swap(&start[i], &start[i + 1]);
        }
        else
            return 0;
    }
    return 1;
}

void move(char seats[])
{
    for (j = 0; j < k - 1; j++)
    {
        if (b[i][j] == '-')
            swap(&seats[j], &seats[j + 1]);
    }
}

int main(void)
{

    scanf("%d", &k);
    scanf("%d", &n);
    scanf("%s", end);

    for (i = 0 ; i < k; i++)
        start[i] = i + 'A';
    for (i = 0; i < n; i++)
    {
        scanf("%s", b[i]);
        if (b[i][0] == '?')
            t = i;
    }

    for (i = 0; i < t; i++)
        move(start);

    for (i = n - 1; i > t; i--)
        move(end);

    if (check())
        printf("%s", ans);
    else
    {
        for (i = 0; i < k - 1; i++)
            printf("%c", 'x');
    }
}

