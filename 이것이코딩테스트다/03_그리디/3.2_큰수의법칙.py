n, m, k = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
first = data[n - 1]
second = data[n - 2]

res = 0
while True:
	for i in range(k):
		if m == 0:
			break
		res += first
		m -= 1
	res += second
	m -= 1
	if m == 0:
		break

print(res)