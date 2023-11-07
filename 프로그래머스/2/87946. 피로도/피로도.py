from itertools import permutations

def solution(k, dungeons):
    perm = list(permutations(dungeons, len(dungeons)))
    
    max_cnt = 0
    for tup in perm:
        cnt = 0
        tmp_k = k
        for p in tup:
            if p[0] <= tmp_k:
                cnt += 1
                tmp_k -= p[1]
                max_cnt = max(max_cnt, cnt)
                if max_cnt == len(dungeons):
                    return max_cnt
    return max_cnt