from itertools import combinations_with_replacement

n, s = map(int, input().split())


# s까지의 리스트 하나 생성
first_list = []
for i in range(1, s+1):
    first_list.append(i)

# 가능한 조합 찾기
first_comb = list(combinations_with_replacement(first_list, n))

# sum이 s인 조합만 살리기
able_comb = []
for j in first_comb:
    if sum(j) == s:
        able_comb.append(j)

# 가장 큰 곱셈의 조합 찾기
max_mul = 0
ans_list = [-1]
for k in able_comb:
    ans_list = []
    tmp = 1
    for l in k:
        tmp *= l
        ans_list.append(l)
    if tmp > max_mul:
        max_mul = tmp

print(ans_list)




# for a in range(1, s//2 + 1):
#     b = s - a
#     tmp_mul = a * b
#     if tmp_mul > max_mul:
#         max_mul = tmp_mul
#         result_set = [a, b]
# print(result_set)