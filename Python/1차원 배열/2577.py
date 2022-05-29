a = int(input())
b = int(input())
c = int(input())

ans = list(str(a * b * c))
for i in range(10):
    print(ans.count(str(i)))