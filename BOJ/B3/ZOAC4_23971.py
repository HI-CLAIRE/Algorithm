h, w, n, m = map(int, input().split())

maps = [[0]*w for _ in range(h) ]

dr = [0, 1, 1]
dc = [1, 1, 0]

for i in range(w):
	for j in range(h):
		for k in range(3):
			nr = i + dr[k]
			nc = j + dc[k]
			if nr>=0 and nr<w and nc>=0 and nc<h:
				maps[nr][nc] = 1

for i in maps:
	for j in i:
		print(j, end=" ")
	print()