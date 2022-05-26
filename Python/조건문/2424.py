A, B = map(int, input().split())
C = int(input())

if(B + C  < 60):
    print(A, B + C)
elif(B + C >= 60):
    A += (B + C) // 60
    B = (B + C) % 60
    if (A > 23):
        A -= 24
    print(A, B)