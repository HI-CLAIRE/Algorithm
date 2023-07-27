# min()함수를 이용하는 예시
n, m =  map(int, input().split())

res = 0
for i in range(n):
    data = list(map(int, input().split()))
    min_value = min(data)
    res = max(res, min_value)

print(res)
