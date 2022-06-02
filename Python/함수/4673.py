arr = set(range(1, 10000))
new_arr = set()
for i in arr:
    for n in str(i):
        i += int(n)
    new_arr.add(i)

self_number = arr - new_arr
for j in sorted(self_number):
    print(j)