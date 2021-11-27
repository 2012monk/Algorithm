#include <stdio.h>
#include <string.h>

char str[100001];

int main(void)
{
    int len, i = 0, j;
    int tmp;
    scanf("%s", str);
    len = strlen(str);

    while (i < len) 
    {
        if (str[i] == '<')
        {
            while (str[i] != '>') printf("%c", str[i++]);
            printf("%c", str[i++]);
        }
        j = i;
        while (str[j] && (str[j] != ' ' || str[j] != '<')) j++;
        tmp = j;
        printf("\n%c %d\n", str[j], j);
        while (j >= i)
            printf("%c", str[--j]);
        i = tmp;
    }
    return 0;
}
