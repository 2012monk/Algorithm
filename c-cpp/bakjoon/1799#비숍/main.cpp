#include <bits/stdc++.h>
using namespace std;

int grid[10][10];
int check_left[50];
int check_right[50];
int n, ans[2];

void dfs(int x, int y, int d, int color) {
    if (y >= n) {
        x++;
        y = y % 2 == 0;
    }
    if (x >= n) {
        ans[color] = max(ans[color], d);
        return;
    }
    if (grid[x][y] && !check_left[x + y] && !check_right[x - y + n - 1]) {
        check_left[x + y] = check_right[x - y + n - 1] = 1;
        dfs(x, y + 2, d + 1, color);
        check_left[x + y] = check_right[x - y + n - 1] = 0;
    }
    dfs(x, y + 2, d, color);
}
int main(void) {
    cin >> n;
    for (int i=0;i<n;i++)
        for (int j = 0; j < n ; j ++)
            cin >> grid[i][j];
    dfs(0, 0, 0, 0);
    dfs(0, 1, 0, 1);
    cout << (ans[0] + ans[1]) << '\n';
}
