def mul(a, b, c):
    if(b==1):
        return a%c
    ans = mul(a, b/2, c)
    ans = ans * ans % c
    if(b % 2 == 0):
        return (ans * a % c)

a, b, c = map(long, input().split())
print(mul(a, b, c))
