#include <bits/stdc++.h>
using namespace std;

int arr[10], n, m;
bool seen[10];

void track(int k) {
    if (k == m) {
        for (int i=0;i<m; i++) cout << arr[i] << ' ';
        cout << '\n';
        return;
    }
    for (int i=1; i<=n;i++) {
        if (!seen[i]) {
            arr[k] = i;
            seen[i] = 1;
            track(k + 1);
            seen[i] = 0;
        }
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    track(0);
    return 0;
}