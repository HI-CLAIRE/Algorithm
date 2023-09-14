h, w, n, m = map(int, input().split())

x = w // (1+m)	# 가로
y = h // (1+n)	# 세로
if w % (1+m) > 0: x += 1
if h % (1+n) > 0: y += 1

print(x*y)