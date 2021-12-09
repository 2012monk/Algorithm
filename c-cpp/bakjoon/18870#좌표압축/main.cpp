#include <bits/stdc++.h>
using namespace std;

int a[1000003], n, i;
vector<int> u;
set<int> s;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (i=0;i<n;i++) {
        cin >> a[i];
        s.insert(a[i]);
    }
    for (auto it=s.begin();it!=s.end();it++) u.push_back(*it);
    sort(u.begin(), u.end());
    for (i=0;i<n;i++) {
        cout << lower_bound(u.begin(), u.end(), a[i]) - u.begin() << ' ';
    }

}