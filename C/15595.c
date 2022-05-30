#include <stdio.h>

long long sum(int *a, int n)
{
    long long ans = 0;

    for(int i = 0; i <= n; i++)
        ans += a[i];
    return (ans);
}

// int main()
// {
//     long long n = 5;
//     int a[5] = {1, 2, 3, 4, 5};
//     long long ans;

//     ans = sum(a, n);
//     printf("answer is 15 : %lld", ans);
//     return 0;
// }