fix, change, cost = map(int, input().split())

if change >= cost:
    print(-1)
else:
    print(fix // (cost - change) + 1)