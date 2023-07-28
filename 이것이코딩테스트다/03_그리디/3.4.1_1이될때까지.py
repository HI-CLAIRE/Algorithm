n, k = map(int, input().split())

cnt = 0
while True:
    if n == 1:
        break
    elif n % k == 0:
        n //= k
        cnt += 1
    else:
        n -= 1
        cnt += 1

print(cnt)