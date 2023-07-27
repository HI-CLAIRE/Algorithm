# 2중 반복문 구조를 이용하는 답안
n, m = map(int, input().split())

res = 0
for i in range(m):
    data = list(map(int, input().split()))
    min_value = 10001
    for a in data:
        min_value = min(min_value, a)
    res = max(res, min_value)
    
print(res)