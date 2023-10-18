from itertools import product

def solution(word):
    alpha = "AEIOU"
    perms = []
    for i in range(1, 6):
        for p in product(alpha, repeat=i):
            perms.append(''.join(p))
    perms.sort()
    ans = perms.index(word) + 1
    return ans