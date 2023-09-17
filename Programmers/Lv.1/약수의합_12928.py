n = int(input())

def solution(n):
    ans = 0
    for i in range(1, n//2 + 1):
        if n % i == 0:
            print(i)
            ans += i
    return ans + n

print(solution(n))