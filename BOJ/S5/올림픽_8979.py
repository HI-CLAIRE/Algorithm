N, K = map(int, input().split())

medals = [list(map(int, input().split())) for _ in range(N)]

medals.sort(key = lambda x : (x[1], x[2], x[3]), reverse=True)

idx = [medals[i][0] for i in range(N)].index(K)

for j in range(N):
    if medals[idx][1:] == medals[j][1:]:
        print(j+1)
        break