def solution(s):
    cnt = 0
    ans = ""
    for i in s:
        if ("A" <= i and i <= "Z") or ("a" <= i and i <= "z"):
            if cnt % 2 == 0:
                ans += i.upper()
            else:
                ans += i.lower()
            cnt += 1
        else:
            ans += i
            cnt = 0
    return ans