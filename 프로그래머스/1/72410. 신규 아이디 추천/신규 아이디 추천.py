def solution(s):
    # 1단계
    s = s.lower()
    # 2단계
    ans = ""
    for i in s:
        if i.isalnum() or i in "-_.":
            ans += i
    # 3단계 -> 어짜피 3개 이상은 2+1 이상이니까 2개를 1개로 치환하면 한개짜리만 남음
    while ".." in ans:
        ans = ans.replace("..", ".")
    # 4단계
    ans = ans[1:] if ans[0] == "." and len(ans) > 1 else ans
    ans = ans[:-1] if ans[-1] == "." else ans
    # 5단계
    ans = "a" if ans == "" else ans
    # 6단계
    if len(ans) >= 16:
        ans = ans[:15]
        if ans[-1] == ".":
            ans = ans[:-1]
    # 7단계
    if len(ans) <= 3:
        ans = ans + ans[-1] * (3-len(ans))
    
    return ans