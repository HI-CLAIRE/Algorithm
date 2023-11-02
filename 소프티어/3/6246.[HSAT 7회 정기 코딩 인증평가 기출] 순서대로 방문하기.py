import sys


def dfs(now, next):
    global cnt
    # 현재좌표가 방문해야할 좌표라면
    if now == v_list[next]:
        if next == m - 1:  # 종료지점
            cnt += 1
            return
        else:
            next += 1
    r, c = now
    visit[r][c] = True
    for i in range(4):
        nr, nc = r + dr[i], c + dc[i]
        if 0 <= nr < n and 0 <= nc < n and grid[r][c] != 1 and visit[nr][nc] == False:
            dfs([nr, nc], next)
    visit[r][c] = False
    return


n, m = map(int, sys.stdin.readline().split())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
v_list = []
for _ in range(m):
    r, c = map(int, sys.stdin.readline().split())
    v_list.append([r - 1, c - 1])

visit = [[False] * n for _ in range(n)]
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

# 현재좌표와 v_list의 다음 index 넘겨주기
cnt = 0
dfs(v_list[0], 1)
print(cnt)
