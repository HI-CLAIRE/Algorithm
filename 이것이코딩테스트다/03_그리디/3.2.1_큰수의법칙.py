n, m, k = map(int, input().split())
data = list(map(int, input().split()))

# 입력받은 data 정렬
data.sort()
first = data[n-1]
second = data[n-2]

# first가 더해질 최대횟수 구하기
cnt = k * (m // (k+1))
cnt += m % (k+1)

# cnt만큼 first 곱하고, 남은횟수만큼 second 곱하기
res = cnt * first
res += (m-cnt) * second

print(res)