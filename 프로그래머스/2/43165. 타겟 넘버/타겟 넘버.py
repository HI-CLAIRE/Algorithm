from itertools import product

def solution(numbers, target):
    # 만들 수 있는 숫자 조합 만들기
    op_list = list(product([1, -1], repeat=len(numbers)))
    ans = 0
    for op in op_list:
        op = list(op)
        tmp = 0
        for i in range(len(op)):
            tmp += op[i] * numbers[i]
        if tmp == target:
            ans += 1
    return ans