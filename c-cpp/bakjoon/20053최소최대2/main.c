#include <stdio.h>
#include <unistd.h>

#define MIN(a, b) a > b ? b : a
#define MAX(a, b) a > b ? a : b

int main(void) {
    int c, n, t, min, max;

    scanf("%d", &t);
    while(t--) {
        scanf("%d", &n);
        scanf("%d", &c);
        max = min = c;
        while (--n) {
            scanf("%d", &c);
            min = MIN(min, c);
            max = MAX(max, c);
        }
        printf("%d %d\n", min, max);
    }
    return 0;
}
