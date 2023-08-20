def solution(s):
    cnt = 0
    for i in s:
        if cnt < 0:
            return False
        if i == "(":
            cnt += 1
        elif i == ")":
            cnt -= 1
    
    if cnt != 0:
        return False
    return True