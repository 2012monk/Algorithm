#include <stdio.h>
#include <string.h>

#define SIZE 100001
char str[SIZE];

void reverse(int i, int j)
{
    while (i < j)
    {
        char c = str[j];
        str[j] = str[i];
        str[i] = c;
        i++;
        j--;
    }
}

int main(void)
{
    int len, i = 0, j;
    int tmp;
    
    fgets(str, SIZE, stdin);
    len = strlen(str);
    if (str[len - 1] == '\n')
        str[len--] = '\0';

    while (i < len)
    {
        j = i;
        if (str[i] == '<')
        {
            while (j < len && str[j] != '>') j++;
            if (j - i < 2)
                reverse(i, j++);
        }
        else
        {
            while (j < len && str[j] != ' ' && str[j] != '<') j++;
            reverse(i, j - 1);
        }
        i = j;
        if(j < len && (str[j] == ' ' || str[j] == '>'))
            i++;
    }
    printf("%s", str);
    return 0;
}
