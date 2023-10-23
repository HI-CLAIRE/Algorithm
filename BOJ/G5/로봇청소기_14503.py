# 1. 현재 칸이 0이면 -> 1
# 2. 주변 4칸 모두 청소되어 있으면
#   2-1. 바라보는 방향 유지, 한 칸 후진 -> 청소
#   2-2. 벽이라서 더이상 후진할 수 없으면 return
# 3. 주변 4칸 중 청소되지 않은 칸이 있다면,
#   3-1. 반시계방향 90도 회전 [북,동,남,서] -> (i+3) % 4
#   3-2. 해당 방향으로 전진해서 청소

n, m = map(int, input().split())
pos = list(map(int, input().split()))
room = [list(map(int, input().split())) for _ in range(n)]
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

def dfs(r, c, d, cnt):
    # 1. 청소 안 한 현재칸 청소
    if room[r][c] == 0:
        room[r][c] = -1
        cnt += 1
    elif room[r][c] == 1: 
        # print(cnt)
        return cnt

    # 3. 현재 d의 왼쪽방향을 네 번 보면서 청소할 곳 있는지
    for i in range(4):
        d = (d+3) % 4
        nr = r + dr[d]
        nc = c + dc[d]

        # 범위 안에 있고, 청소하지 않았다면 다시 dfs
        if 0<=nr and nr<n and 0<=nc and nc<m and room[nr][nc]==0:
            return dfs(nr, nc, d, cnt)

    # 2. 후진해서 더 청소할 곳이 있는지 확인
    def back(r, c, d, cnt):
        nd = (d+2) % 4
        r += dr[nd]
        c += dc[nd]
        if 0<=r and r<n and 0<=c and c<m:
            return dfs(r, c, d, cnt)
            
    return back(r, c, d, cnt)

print(dfs(pos[0], pos[1], pos[2], 0))
