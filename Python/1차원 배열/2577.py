lst = []
mul = 1
for i in range(3):
    lst.append(int(input()))
    mul *= lst[i]
mul = list(str(mul))
for j in range(10):
    print(mul.count(str(j)))