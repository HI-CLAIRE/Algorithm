from itertools import combinations
import math

# 소수구하기
def primenum(x):
    for i in range(2, int(math.sqrt(x) + 1)):
        if x % i == 0:
            return False
    return True

# input
nums = list(map(int, input().split()))

ans = []
data = list(combinations(nums, 3)) # 조합 구하는 라이브러리
for a, b, c in data:
    tmp = a+b+c
    if primenum(tmp):
        ans.append(tmp)
print(len(ans))