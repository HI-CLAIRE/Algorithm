from itertools import permutations

n, k = map(int, input().split())  # 던전 갯수, 피로도
dungeons = [list(map(int, input().split())) for _ in range(n)]

perm = list(permutations(dungeons, len(dungeons)))  # 가능한 순열 모두 구하기


max_cnt = 0
for tup in perm:
    cnt = 0
    tmp_k = k # 임시피로도
    for p in tup: # 완성된 순열튜플에서 순회하기
        if p[0] <= tmp_k:
            cnt += 1
            tmp_k -= p[1]
            max_cnt = max(cnt, max_cnt)

print(max_cnt)