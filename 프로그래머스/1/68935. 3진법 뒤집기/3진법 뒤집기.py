def solution(n):
    ans = ""
    while(n > 0):
        ans += str(n % 3)
        n //= 3
    return int(ans, 3)