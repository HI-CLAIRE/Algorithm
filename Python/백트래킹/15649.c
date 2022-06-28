#include <stdio.h>
#include <stdbool.h>

void func(int k)
{
    int n, m;
    int arr[10];
    bool isused[10];
    
    if (k == m)
    {
        for(int i = 0; i < m; i++)
            printf("%d ", *arr);
        printf("\n");
        return;
    }
    for(int i = 1; i <= n; i++)
    {
        if(!isused[i])
        {
            arr[k] = i;
            isused[i] = 1;
            func(k+1);
            isused[i] = 0;
        }
    }
}

int main()
{
    int n, m;
    scanf("%d %d", &n, &m);
    func(0);
    return 0;
}