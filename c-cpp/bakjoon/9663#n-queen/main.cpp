#include <bits/stdc++.h>
using namespace std;

int r, n, v[40], x[40], y[40];
void find(int k) {
    if (k == n) {
        r++;
        return ;
    }

    for (int i=0;i<n;i++) {
        if (v[i] || x[i + k] || y[k - i + n - 1]) continue;
        v[i] = x[i + k] = y[k-i+n-1] = 1;
        find(k+1);
        v[i] = x[i + k] = y[k-i+n-1] = 0;
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n;
    find(0);
    cout << r;
}
