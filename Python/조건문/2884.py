# #include <stdio.h>

# int main()
# {
#     int H
#     int M

#     scanf("%d %d", & H, & M)
#     if(M >= 45)
#     {
#         M -= 45
#         printf("%d %d", H, M)
#     }
#     else if(M < 46)
#     {
#         M = 60 - (45 - M)
#         if (H == 0)
#         H = 23
#         else
#         H -= 1
#         printf("%d %d", H, M)
#     }
# }

H, M = map(int, input().split())
if M > 44:
    print(H, M-45)
elif M < 45 and H > 0:
    print(H - 1, M + 15)
else:
    print(23, M + 15)