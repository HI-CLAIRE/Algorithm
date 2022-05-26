n = int(input())

for i in range(0, n):
    a, b = map(int, input().split())
    print("Case #{}: {}" .format(i + 1, a + b))