import sys
input = sys.stdin.readline

n, d = map(int, input().split())
graph = []
for _ in range(n):
    start, end, l = map(int, input().split())
    if end <= d and end-start>l:
        graph.append([start, end, l])

dest = [i for i in range(d+1)]
for i in range(d+1):
    dest[i] = min(dest[i], dest[i-1]+1)
    print(dest[i])
    for start, end, l in graph:
        if i == start and dest[i] + l < dest[end]:
            dest[end] = dest[i] + l
            print(f"i: {i}, dest[end]: {dest[end]}")