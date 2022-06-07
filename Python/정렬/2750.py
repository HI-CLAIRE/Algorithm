N = int(input())

lst = []
for i in range(N):
    num = int(input())
    lst.append(num)

for i in sorted(lst):
    print(i)