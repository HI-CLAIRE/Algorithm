n = int(input())

for i in range(n):
    lst = list(input())
    sum = 0
    cnt = 1
    for j in lst:
        if j == 'O':
            sum += cnt
            cnt += 1
        else:
            cnt = 1
    print(sum)