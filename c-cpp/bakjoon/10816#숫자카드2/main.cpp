#include <bits/stdc++.h>
using namespace std;
int a[5000005];
int m,n,i;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (i=0;i<n;)cin >> a[i++];
    sort(a, a+n);
    cin >> m;
    while (m--) {
        int t;
        cin >> t;
        cout << upper_bound(a, a+n, t) - lower_bound(a, a+n, t) << '\n';
    }
}