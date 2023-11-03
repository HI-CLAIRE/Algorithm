import sys
input = sys.stdin.readline

n, d = map(int, input().split())
graph = []
for _ in range(n):
    start, end, l = map(int, input().split())
    if end <= d and end-start >= l:
        graph.append([start, end, l])
dist = [i for i in range(d+1)]
# print(dist)
# 0부터 고속도로의 길이까지 반복
for i in range(d+1):
    # 지름길로 간 거리와 고속도로로 간 거리 비교
    dist[i] = min(dist[i], dist[i-1]+1)

    # 지름길을 반복하여 최단거리 찾기
    for start, end, l in graph:
        if i==start and dist[i]+l < dist[end]:
            dist[end] = dist[i]+l
print(dist[d])