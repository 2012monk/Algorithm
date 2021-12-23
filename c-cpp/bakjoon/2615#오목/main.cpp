#include <bits/stdc++.h>
using namespace std;

int grid[19][19];
int di[] = {1,1,0,-1};
int dj[] = {0,1,1,1};
int i,j;

int f(int i, int j)
{
    if (i < 0 || i >= 19 || j < 0 || j >= 19)
        return -1;
    return grid[i][j];
}

int solve(int x, int y)
{
    for (int d=0;d<4;d++)
    {
        int flag = 1;
        for (int k=1;k<5;k++)
        {
            if (f(i,j) != f(i+di[d]*k,j+dj[d]*k))
                flag = 0;
        }
        if (!flag)
            continue;
        if (f(i,j) == f(i + di[d]*5,j+dj[d]*5))
            continue;
        if (f(i-di[d],j-dj[d]) == f(i+di[d]*4,j+dj[d]*4))
            continue;
        return 1;
    }
    return 0;
}

int main(void)
{
    for (i = 0;i<19;i++)
        for (j=0;j<19;j++) cin >> grid[i][j];

    for (i = 0; i < 19; i++)
    {
        for (j =0;j<19;j++)
        {
            if (grid[i][j] == 0)
                continue;
            if (solve(i,j))
            {
                cout << grid[i][j]<< '\n' << ( i + 1 ) << ' ' << ( j + 1 );
                return 0;
            }
        }
    }
    cout << 0 << '\n';
}
