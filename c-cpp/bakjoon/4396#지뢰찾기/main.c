#include <stdio.h>
#define h for(i=0;i<N;i++)
#define a h for(j=0;j<N;j++)
char o[11][11],g[13][13];
int N,i,j,k,q=0;
void f(int x, int y){
    int nx[]={-1,-1,0,1,1,1,0,-1},ny[]={0,-1,-1,-1,0,1,1,1},c=0;
    q = !q?g[x+1][y+1]=='*':q;
    for(k=0;k<8;k++)c+=g[x+nx[k]+1][y+ny[k]+1]=='*';
    o[x][y]='0'+c;
}
int main(void)
{
    scanf("%d", &N);
    h scanf("%s", &g[i+1][1]);
    h scanf("%s", o[i]);
    a{if(o[i][j]=='x')f(i,j);}
    if(q){a{if(g[i+1][j+1]=='*')o[i][j]='*';}}
    h printf("%s\n", o[i]);
}
