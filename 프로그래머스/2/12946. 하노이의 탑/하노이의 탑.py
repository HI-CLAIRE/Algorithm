def recursive(start, end, another, n, answer):
    if n == 1:
        answer.append([start, end])
        return
    
    # 1. 1번에서 2번으로 n-1개를 이동
    recursive(start, another, end, n-1, answer)
    # 2. 1번에서 3번으로 이동
    answer.append([start, end])
    # 3. 2번에서 3번으로 n-1개를 이동
    recursive(another, end, start, n-1, answer)

def solution(n):
    answer = []
    recursive(1, 3, 2, n, answer)
    return answer