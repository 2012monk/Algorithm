#include <stdio.h>


int map[26][2];

void set() {
    int i;
    char seq[3][10] = {
        {'q', 'w', 'e', 'r' ,'t' ,'y', 'u' ,'i' ,'o' ,'p'},
        {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k' , 'l'},
        {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };
    int len[3] ={10, 9, 7};
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < len[i]; j++) {
            map[seq[i][j]][0] = i;
            map[seq[i][j]][1] = j;
        }
    }
}

int _abs(int a) {
    if (a < 0)
        return -a;
    return a;
}

int is_right(char c) {
    return (map[c][0] == 2 && map[c][1] > 3) || ( map[c][1] > 4 );
}

int count_dist(int cur, int next) {
    int x = _abs(map[cur][0] - map[next][0]);
    int y = _abs(map[cur][1] - map[next][1]);
    return x + y;
}

int main(void)
{
    char l, r;
    char input[102] = {0, };
    int i, dist = 0;
    char cur;
    set();
    scanf("%c %c", &l, &r);
    scanf("%s", input);
    for (i = 0; input[i]; i++) {
        if (is_right(input[i])) {
            cur = r;
            r = input[i];
        }
        else {
            cur = l;
            l = input[i];
        }
        dist += count_dist(cur, input[i]) + 1;
    }
    printf("%d\n", dist);
}

