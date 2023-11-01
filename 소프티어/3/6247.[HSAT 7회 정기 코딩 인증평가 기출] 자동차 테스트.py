import sys
import bisect

n, q = map(int, sys.stdin.readline().split())
car = list(map(int, sys.stdin.readline().split()))
car.sort()
# [1,2,3,5,6]

for _ in range(q):
    m = int(sys.stdin.readline())
    if m >= car[-1] or m <= car[0]:
        print(0)
        continue

    idx = bisect.bisect_left(car, m)
    if car[idx] != m:
        print(0)
        continue
    left = idx
    right = n - idx - 1
    print(left * right)
