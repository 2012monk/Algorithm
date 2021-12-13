#include <bits/stdc++.h>
using namespace std;

int dp[100004],n, i, j;

int main(void) {
    cin >> n;
    for (i=0;i<=n;i++) dp[i] = i;

    for (i=1;i<=n;i++) {
        for (j=1;j*j<=i;j++) {
            dp[i] = min(dp[i], dp[i - j * j] + 1);
        }
    }
    cout << dp[n] << '\n';
    return 0;
}