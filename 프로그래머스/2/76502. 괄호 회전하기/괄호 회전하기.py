from collections import deque

def check(s):
    while True:
        if "()" in s:
            s = s.replace("()", "")
        elif "{}" in s:
            s = s.replace("{}", "")
        elif "[]" in s:
            s = s.replace("[]", "")
        else:
            return False if s else True

def solution(s):
    dq = deque(s)
    ans = 0
    for i in range(len(s)):
        if check("".join(dq)):
            ans += 1
        dq.rotate(-1)
    return ans