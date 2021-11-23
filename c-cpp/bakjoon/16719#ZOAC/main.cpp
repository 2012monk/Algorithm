#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

#define _MAX 101
string word;
int n, v[_MAX];
string res;

int main(void)
{
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    vector<pair<string, int>> res;
    cin >> word;
    n = word.length();

    for (int i = 1; i <= n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            string tmp;

            if (v[j])
                continue;
            for (int k = 0; k < n; k++)
            {
                if (j == k || v[k])
                    tmp += word[k];
            }
            res.push_back({ tmp, j });
        }
        sort(res.begin(), res.end());
        cout << res[0].first << '\n';
        v[res[0].second] = 1;
        res.clear();
    }
    return 0;
}
