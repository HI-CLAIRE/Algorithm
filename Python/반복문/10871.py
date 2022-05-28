cnt, max = map(int, input().split())
arr = list(map(int, input().split()))

for i in arr:
    if i < max:
        print(i, end=" ")