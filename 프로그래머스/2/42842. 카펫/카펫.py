def solution(B, Y):
    # 1. (가로, 세로) 조합 구하기
    target = B // 2
    comb, ans = [], [0, 0]
    for i in range(target - 1, target//2, -1):
        comb.append([i, target - i])
    # 2. Y랑 네모 빈칸이랑 일치하는지 보기
    for a, b in comb:
        if Y == (a-2) * b and a >= (b+2):
            ans = [a, b+2]
    return ans