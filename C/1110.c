#include <stdio.h>

int main()
{
    int put, ten, one, new, newone;
    int tmp;
    int cnt = 0;

    scanf("%d", &put);
    tmp = put;

    while (1)
    {
        ten = put / 10;
        one = put % 10;
        newone = (ten + one) % 10;
        new = (10 * one) + newone;
        put = new;
        cnt++;
        if (tmp == put)
            break;
    }
    printf("%d", cnt);
    return 0;
}
