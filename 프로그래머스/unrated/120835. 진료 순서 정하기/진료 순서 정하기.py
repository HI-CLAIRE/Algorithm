def solution(emergency):
    ans = []
    tmp = sorted(emergency, reverse=True)
    for i in emergency:
        ans.append(tmp.index(i) + 1)
    return ans