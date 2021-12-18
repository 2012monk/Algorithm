#include <bits/stdc++.h>
using namespace std;

int arr[100001], dp[100001], n, i, res=-1001;

int main(void) {
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> n;
    for (i=-1;++i<n;cin>>arr[i]);
    dp[0] = arr[0];
    for (i=0;++i<n; dp[i] = max(arr[i], dp[i - 1] + arr[i]));
    for (i=-1;++i<n; res=max(dp[i], res));
    cout << res << "\n";
    return 0;
}