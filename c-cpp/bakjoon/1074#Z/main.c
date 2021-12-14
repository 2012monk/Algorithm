#include <stdio.h>
int n,r,c;
int f(int i, int j,int h){
    if (h==1) return 0;
    h>>=1;
    if(i<h&&j>=h)return h*h+f(i,j-h,h);
    if(i>=h&&j<h)return 2*h*h+f(i-h,j,h);
    if(i>=h&&j>=h)return 3*h*h+f(i-h,j-h,h);
    return f(i,j,h);
}
int main(void){
    scanf("%d %d %d",&n,&r,&c);
    printf("%d",f(r,c,(1<<n)));
    return 0;
}