n = int(input())

cnt_not = 0
for i in range(n):
    word = input()
    check = []
    for j in word:
        if check.count(j) != 0:
            if j != check[-1]:
                cnt_not += 1
                break
        else:
            check.append(j)
print(n - cnt_not)