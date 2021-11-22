#include <iostream>
#include <cstring>
#include <cstdio>
using namespace std;

#define INF 987654321

int orig[50][50];
int arr[6][3];
int v[6];
int n, m, k, ans = INF;


void get_min(int A[][50])
{
    int tmp = 0;

    for (int i = 0 ; i < n ; i++)
    {
        tmp = 0;
        for (int j = 0; j < m; j++)
            tmp += A[i][j];
        ans = min(ans, tmp);
   }
}

void rotate(int A[][50], int x, int y, int bound, int t)
{
    int nx[] = {1, 0, -1, 0};
    int ny[] = {0, 1, 0, -1};
    int start = A[x][y];
    int s = bound, c_s = bound;
    int d = 0;

    while (t-- > 1)
    {
        A[x][y] = A[x + nx[d]][y + ny[d]];
        x += nx[d];
        y += ny[d];
        if (--c_s == 1)
        {
            d = (d + 1) % 4;
            c_s = s = bound;
        }
    }

    A[x][y] = start;
}

void rotate_square(int A[][50], int x, int y, int bound)
{
    int b, size;

    for (int i = 0; i < bound / 2; i++)
    {
        b = bound - i * 2;
        size = b * 4 - 4;
        if (!size)
            break;
        rotate(A, x + i, y + i, bound - i * 2, size);
    }
}

void solve(int A[][50], int cur)
{
    int r, c, s;
    int x, y;
    int tmp[50][50];

    if (cur == 0)
    {
        get_min(A);
        return ;
    }

    for (int i = 0; i < k; i++)
    {
        if (v[i])
            continue;
        v[i] = 1;
        copy(&A[0][0], &A[0][0] + 2500, &tmp[0][0]);
        r = arr[i][0];
        c = arr[i][1];
        s = arr[i][2];
        x = r - s - 1;
        y = c - s - 1;
        rotate_square(tmp, x, y, r + s - x);
        solve(tmp, cur - 1);
        v[i] = 0;
    }

}


int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n >> m >> k;

    for (int i = 0;i < n; i++)
        for (int j = 0; j < m; j++) cin >> orig[i][j];

    for (int i = 0; i < k; i++)
        cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
    
    solve(orig, k);
    cout << ans << '\n';
    return 0;
}

