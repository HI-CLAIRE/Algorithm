# 외톨이 알파벳 = string에서 2번 이상 나타나는데 쪼개진 애들
# res -> 알파벳 순으로 sort

def solution(s):
    chk = []
    ans = set()
    for i in range(len(s) -1):
        if s[i] != s[i+1]:
            if s[i] in chk:
                ans.add(s[i])
            chk += s[i]
    if s[-1] in chk:
        ans.add(s[-1])
    return "".join(sorted(list(ans))) if ans else "N"