from collections import deque

maps = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]

def solution(maps):
  ans = 0

  # 상우하좌
  dx = [-1, 0, 1, 0]
  dy = [0, 1, 0, -1]

  def bfs(x, y):
    q = deque()
    q.append((x, y))

    # queue가 빌 때까지 반복
    while q:
      x, y = q.popleft()
      # 사방탐색
      for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        # 경계확인
        if nx>=0 and nx<len(maps) and ny>=0 and ny<len(maps[0]) and maps[nx][ny] == 1:
          maps[nx][ny] = maps[x][y] + 1
          q.append((nx, ny))
    return maps[len(maps)-1][len(maps[0])-1]
  
  ans = bfs(0, 0)
  return -1 if ans == 1 else ans

print(solution(maps))