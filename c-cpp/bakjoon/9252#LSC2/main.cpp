#include <cstdio>
#include <cstring>
using namespace std;

char A[1001],B[1001],res[1001];
int dp[1001][1001],n,m;
#define max(a,b) a > b ? a : b
int main() {
    scanf("%s %s",A,B);
    n=strlen(A);
    m=strlen(B);

    for (int i=1;i<=n;i++) {
        for (int j=1;j<=m;j++) {
            if (A[i-1] == B[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
            else dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        }
    }

    int x=n,y=m,r=dp[n][m];
    printf("%d\n", r);
    while (r) {
        if (dp[x][y] == dp[x-1][y]) x--;
        else if (dp[x][y] == dp[x][y-1]) y--;
        else{
            res[--r]=A[x-1];
            x--;
            y--;
        }
;
    }

    printf("%s\n",res);
}
