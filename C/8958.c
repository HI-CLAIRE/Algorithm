#include <stdio.h>
#include <string.h>

int main()
{
    int n, sum, cnt;
    char arr[80];

    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        sum = 0;
        cnt = 1;
        scanf("%s", arr);
        for(int j = 0; j < strlen(arr); j++)
        {
            if(arr[j] == 'O')
            {
                sum += cnt;
                cnt++;
            }
            else
                cnt = 1;
        }
        printf("%d\n", sum);
    }
    return 0;
}