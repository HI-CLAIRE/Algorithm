import sys

# 방향을 찾는 함수 [0,1,2,3]:북,동,남,서 -1:더이상 갈 수 있는 방향이 없음
def find_dir(r, c):
    for i in range(4):
        nr, nc = r + dr[i], c + dc[i]
        nnr, nnc = r + dr[i] * 2, c + dc[i] * 2
        if (
            0 <= nr < n
            and 0 <= nc < m
            and grid[nr][nc] == "#"
            and grid[nnr][nnc] == "#"
            and visit[nr][nc] == False
        ):
            return i
    return -1


# 시작지점이 될 수 있는 후보군 2개 뽑기
def find_start(r, c):
    global start
    cnt = 0
    for i in range(4):
        nr, nc = r + dr[i], c + dc[i]
        if 0 <= nr < n and 0 <= nc < m and grid[nr][nc] == "#":
            cnt += 1
    if cnt == 1:
        start.append([r, c])
    return


def check(now, d):
    global ans
    r, c = now
    visit[r][c] = True
    new_d = find_dir(r, c)
    if new_d == -1:  # 더이상 방문할 곳이 없을 때 탈출
        return
    elif new_d == d:
        ans += "A"
    elif (new_d + 3) % 4 == d:
        ans += "LA"
    elif (new_d + 1) % 4 == d:
        ans += "RA"
    visit[r + dr[new_d]][c + dc[new_d]] = True  # 지나온 한 칸 방문처리
    nr, nc = r + dr[new_d] * 2, c + dc[new_d] * 2  # 새로 이동할 칸은 2칸 전진
    check([nr, nc], new_d)  # 재귀
    return


n, m = map(int, sys.stdin.readline().split())
grid = [sys.stdin.readline().strip() for _ in range(n)]

dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]
visit = [[0] * m for _ in range(n)]

start = []
for i in range(n):
    for j in range(m):
        if grid[i][j] == "#":
            find_start(i, j)

ans = ""
dir = ["^", ">", "v", "<"]
d = find_dir(start[0][0], start[0][1])
check(start[0], d)
print(start[0][0] + 1, start[0][1] + 1)
print(dir[d])
print(ans)