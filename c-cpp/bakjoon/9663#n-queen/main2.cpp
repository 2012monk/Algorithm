#include <iostream>
using namespace std;

int n, grid[16];
int dfs(int cur)
{
    int ret = 0;

    if (cur == n)
        return 1;
    for (int i = 0; i < n; i++)
    {
        int flag = 1;
        grid[cur] = i;
        for (int j = 0; j < cur; j++)
        {
            if (grid[cur] == grid[j]
                || grid[j] - grid[cur] == cur - j
                || grid[cur] - grid[j] == cur - j) {
                flag = 0;
                break;
            }
        }
        if (flag)
            ret += dfs(cur + 1);
    }
    return ret;
    
}

int main(void)
{
    cin >> n;
    cout << dfs(0) << '\n';
}
