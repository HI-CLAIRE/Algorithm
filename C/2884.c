#include <stdio.h>

int main()
{
    int H;
    int M;

    scanf("%d %d", &H, &M);
    if(M >= 45)
    {
        M -= 45;
        printf("%d %d", H, M);
    }
    else if(M < 46)
    {
        M = 60 - (45 - M);
        if (H == 0)
            H = 23;
        else
            H -= 1;
        printf("%d %d", H, M);
    }
}