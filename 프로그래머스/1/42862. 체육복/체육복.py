def solution(n, lost, reserve):
    
    # 자기 것은 자기가 입어야 되기 때문에 전처리
    s1 = set(lost)
    s2 = set(reserve)
    if s1 & s2:
        for i in s1 & s2:
            lost.remove(i)
            reserve.remove(i)
    
    cnt = 0
    for i in range(1, n+1):
        if i in lost:
            ava = [i-1, i+1]
            for a in ava:
                if a in reserve:
                    cnt += 1
                    reserve.remove(a)
                    break
            continue
        cnt += 1
    return cnt