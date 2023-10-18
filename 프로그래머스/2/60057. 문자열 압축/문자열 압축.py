def solution(s):
    
    ans = len(s)
    
    # 압축 후보
    for i in range(1, len(s)//2 + 1):
        tmp = s[:i]
        cnt = 1
        shorten = []
        
        for j in range(i, len(s), i):
            if tmp == s[j:j+i]:
                cnt += 1
            else:
                shorten.append([tmp, cnt])
                cnt = 1
                tmp = s[j:j+i]
        shorten.append([tmp, cnt])
        
        # 구한 압축문 중 가장 짧은 압축문 길이 구하기
        total_len = 0
        for tmp, cnt in shorten:
            if cnt > 1:
                total_len += len(tmp) + len(str(cnt))
            else:
                total_len += len(tmp)
        ans = min(ans, total_len)
    return ans