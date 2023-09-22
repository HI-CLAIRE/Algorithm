import sys

m = int(sys.stdin.readline())

my_set = set()
for _ in range(m):
    data = sys.stdin.readline().split()

    if len(data) == 1:
        if data[0] == "all":
            my_set = set([i for i in range(1, 21)])
        else:
            my_set = set()
        continue

    cmd, num = data[0], int(data[1])
    if cmd == "add":
        my_set.add(num)
    elif cmd == "remove":
        my_set.discard(num)
    elif cmd == "check":
        print(1 if num in my_set else 0)
    elif cmd == "toggle":
        if num in my_set:
            my_set.discard(num)
        else:
            my_set.add(num)