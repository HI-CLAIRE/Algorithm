n = int(input())

for _ in range(n):
    num, abc = input().split()
    for i in abc:
        print(i * int(num), end="")
    print()