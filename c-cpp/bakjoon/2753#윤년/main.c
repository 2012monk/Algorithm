#include <stdio.h>

int main()
{
    int t;

    scanf("%d", &t);
    if (t % 4 == 0) {
        if (t % 100 || !(t % 400))
            printf("%d", 1);
        else
            printf("%d", 0);
    }
    else
        printf("%d", 0);
    return 0;
}
