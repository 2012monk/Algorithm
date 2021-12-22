#include <bits/stdc++.h>
using namespace std;

#define F(S,E) for(i=S;i<=E;i++)
int c[365];
int n,s,e,r,m,l,i;

int main(void)
{
    int n,s,e;
    cin>>n;

    while (n--) {
        cin>>s>>e;
        F(s,e) c[i]++;
    }
    F(1,365)
    {
        m = max(c[i], m);
        if (c[i])
            l++;
        else
        {
            r += m * l;
            m = l = 0;
        }
    }
    r += m * l;
    cout << r;
}
