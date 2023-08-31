from itertools import permutations
import math

nums = sorted(map(int, list(input())))

# 소수구하기
def isPrime(x):
    if x <= 1:
        return False
    for i in range(2, int(math.sqrt(x) + 1)):
        if x % i == 0:
            return False
    return True

cnt = 0
usedNums = set()  # 중복된 숫자제거

# 자릿수를 하나씩 늘려가며 만들어낼 수 있는 숫자순열 list 만들기
for i in range(1, len(nums)+1):
    for p in permutations(nums, i):
        num = int(''.join(map(str, p))) # 튜플로 된 원소 int로 변환
        if isPrime(num) and num not in usedNums:  # 소수이면서 중복되지 않은 숫자면 cnt++
            cnt += 1
            usedNums.add(num)

print(cnt)
