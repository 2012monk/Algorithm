#include <iostream>
using namespace std;

#define ll long long

int solve(ll x)
{
    if (x == 1)
        return 0;
    ll i = 1;
    while (i << 1 < x)
        i <<= 1;
    return solve(x - i) ^ 1;
}

int main(void)
{
    ll n;
    cin >> n;
    cout << solve(n);
}
