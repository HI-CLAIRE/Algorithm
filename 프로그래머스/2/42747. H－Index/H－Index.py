def solution(citations):
    for i in range(len(citations), -1, -1):
        cnt = 0
        for c in citations:
            if c >= i:
                cnt += 1
        if cnt >= i and len(citations) - cnt <= i:
            return i
    return 0