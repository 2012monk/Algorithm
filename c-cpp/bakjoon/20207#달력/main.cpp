#include <bits/stdc++.h>
using namespace std;

int cal[365];

void f(int s, int e)
{
    for (int i = s; i <= e; i++)
        cal[i]++;
}

int main(void)
{
    int n, s, e;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> s >> e;
        f(s, e);
    }

    int ret = 0, mx = 0, len = 0;
    for (int i = 1; i <= 365; i++)
    {
        mx = max(cal[i], mx);
        if (cal[i])
            len++;
        else
        {
            ret += mx * len;
            mx = len = 0;
        }
    }
    ret += mx * len;
    cout << ret << '\n';
}
