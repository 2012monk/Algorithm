#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    map<string, int> m;
    int n, idx;
    string file;

    cin >> n;
    for (int i = 0; i < n; i++) 
    {
        cin >> file;
        for (idx = 0;file[idx] != '.'; idx++);
        file = file.substr(idx + 1, file.length());
        m[file]++;
    }

    for (auto i = m.begin(); i != m.end(); i++) 
        cout << i->first << ' ' << i->second << '\n';
    return 0;
}
