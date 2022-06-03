def sum(n):
    sum = n
    while n > 0:
        sum += n % 10
        n //= 10
    return int(sum)


arr = set(range(1, 10001))
new_arr = set()
for i in arr:
    new_arr.add(sum(i))

self_number = arr - new_arr
for j in sorted(self_number):
    print(j)