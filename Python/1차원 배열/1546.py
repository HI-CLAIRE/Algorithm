num = int(input())
lst = list(map(int, input().split()))
M = max(lst)

new_lst = []
for i in lst:
    new_lst.append(i / M * 100)
new_avg = sum(new_lst) / num
print(new_avg)