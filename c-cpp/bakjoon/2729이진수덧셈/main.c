#include <unistd.h>
#include <stdio.h>

#define in_size (162 * 1000)
#define out_size (83 * 1000)
char buf[out_size];
char in_buf[in_size];
int pos = 0;

void solve(int i, int j)
{
    char tmp[83];
    int start = 0;
    int carry = 0, a, b;

    tmp[0] = '0';
    while (in_buf[i] != '\n' || in_buf[j] != ' ')
    {
        a = b = 0;
        if (in_buf[i] != '\n')
            a = in_buf[i--] - '0';
        if (in_buf[j] != ' ')
            b = in_buf[j--] - '0';
        tmp[start++] = ((a ^ b) ^ carry) + '0';
        carry = (a|b)&(a|carry)&(b|carry);
    }
    if (carry)
        tmp[start++] = '1';
    start--;
    while (tmp[start] != '1' && start > 0) start--;
    while (start >= 0)
        buf[pos++] = tmp[start--];
    buf[pos++] = '\n';
}

int main(void)
{
    int t = 0, i = 0, j;
    read(0, in_buf, in_size);
    
    while (in_buf[i] != '\n')
        t = (t * 10) + (in_buf[i++] - '0');
    while (t--)
    {
        while (in_buf[++i] != ' ');
        j = i;
        while (in_buf[++j] != '\n');
        solve(i - 1, j - 1);
    }
    
    buf[pos] = '\0';
    write(1, buf, pos);
}

