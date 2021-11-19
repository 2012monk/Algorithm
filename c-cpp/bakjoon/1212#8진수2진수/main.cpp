#include <iostream>
using namespace std;

void change(int t)
{
    cout << (t / 4) << ((t / 2) % 2) << (t % 2);
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    char n[333334];
    cin >> n;

    int t = n[0] - '0';
    if (t / 4)
        cout << (t / 4);
    if (t / 4 || ((t / 2)) % 2)
        cout << ((t / 2) % 2);
    cout << (t % 2);
    for (int i = 1; n[i]; i++)
        change(n[i] - '0');
    cout << '\n';
    return 0;
}
