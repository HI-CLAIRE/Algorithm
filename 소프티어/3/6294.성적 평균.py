import sys

n, k = map(int, sys.stdin.readline().split())
scores = list(map(int, sys.stdin.readline().split()))

for _ in range(k):
    a, b = map(int, sys.stdin.readline().split())
    total = sum(scores[a - 1 : b])
    ans = round(total / (b - a + 1), 2)
    print(f"{ans:.2f}")
