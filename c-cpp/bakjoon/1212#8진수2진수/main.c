#include <unistd.h>

int main(void) {
    char n[333335], o[1000004];
    int i = 0, j = 1;
    read(0, n, 333335);
    if (n[0] == '0') {
        write(1, "0", 1);
        return 0;
    }
    int t = n[0] - '0';
    if (t & 4)
        o[i++] = '1';
    if (t & 2 || t & 4)
        o[i++] = '0' + !!(t & 2);
    o[i++] = '0' + (t & 1);

    for (; n[j] && n[j] != '\n'; j++) {
        int k = n[j] - '0';
        o[i++] ='0' + !!(k & 4);
        o[i++] ='0' + !!(k & 2);
        o[i++] ='0' + (k & 1);
    }
    write(1, o, i);
    return 0;
}
