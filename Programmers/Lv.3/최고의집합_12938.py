def solution(n, s):
    div = s // n
    mod = s % n

    if(n > s):
        return [-1]
    
    ans_list = [div] * n
    for i in range(mod):
        ans_list[n-i-1] += 1

    return ans_list