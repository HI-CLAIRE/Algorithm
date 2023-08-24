sides = list(map(int, input().split()))

min_num = min(sides)
max_num = max(sides)

cnt = 0
# max가 가장 클 때
# tmp > max - min
for i in range(max_num - min_num, max_num):
    cnt += 1

# 나머지가 가장 클 때
# tmp < max + min
for j in range(max_num, max_num + min_num - 1):
    cnt += 1

print(cnt)