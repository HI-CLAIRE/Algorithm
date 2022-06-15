#include <stdio.h>

int mul(long long a, long long b, long long m)
{
    if(b == 1)
        return (a % m);
    long long ans = mul(a, b/2, m);
    ans = ans * ans % m;
    if(b % 2 == 0)
        return ans;
    return (ans * a % m);
}

int main()
{
    long long a, b, m;
    scanf("%lld %lld %lld", &a, &b, &m);
    printf("%d", mul(a, b, m));
    return 0;
}