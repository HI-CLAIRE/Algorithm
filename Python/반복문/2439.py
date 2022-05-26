# #include <stdio.h>

# int main()
# {
#     int n;
#     scanf("%d", &n);

#     for(int i = 1; i <= n; i++)
#     {
#         for(int j = n; j > 0; j--)
#         {
#             if(j > i)
#                 printf(" ");
#             else
#                 printf("*");
#         }
#         printf("\n");
#     }
# }

n = int(input())

for i in range(1, n+1):
    print(" " * (n-i) + "*" * i)