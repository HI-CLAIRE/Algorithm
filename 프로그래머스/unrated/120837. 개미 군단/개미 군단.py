def solution(hp):
    cnt = 0
    while(True):
        if hp // 5 > 0:
            cnt += hp//5
            hp %= 5
        elif hp // 3 > 0:
            cnt += hp//3
            hp %= 3
        else:
            cnt += hp
            break
    return cnt