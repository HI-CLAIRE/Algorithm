num_lst = set(range(1, 10001))
new_numlst = set()

for i in range(1, 10001):
    for j in str(i):
        i = i + int(j)
    new_numlst.add(i)

self_num = sorted(num_lst - new_numlst)
for i in self_num:
    print(i)