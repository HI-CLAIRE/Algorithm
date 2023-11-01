import sys
from itertools import permutations

n, m, k = map(int, sys.stdin.readline().split())
box = list(map(int, sys.stdin.readline().split()))

perms = list(permutations(box, n))

min_value = 2147483647
for perm in perms:
  idx, k_idx, tmp, total = 0, 0, 0, 0
  while True:
    if k_idx == k:
      break
    elif tmp + perm[idx] > m:
      total += tmp
      k_idx += 1
      tmp = 0
      continue
    tmp += perm[idx]
    idx += 1
    if idx == n:
      idx = 0
  min_value = min(total, min_value)

print(min_value)