from itertools import permutations
import copy

def cal(n1, n2, op):
    if op == "+":
        return n1 + n2
    elif op == "-":
        return n1 - n2
    else:
        return n1 * n2

def find_num(arr, op):
    for o in op:
        stack = []
        while len(arr) != 0:
            tmp = arr.pop(0)
            if tmp == o:    # 해당 순서의 연산이면
                stack.append(cal(int(stack.pop()), int(arr.pop(0)), o))
            else:
                stack.append(tmp)
        arr = stack
    return abs(int(arr[0]))

def solution(exp):
    # 1. op의 경우의 수 구하기 (조합)
    op_tmp = "+-*"
    op = list(permutations(op_tmp, 3))
    
    # 2. 숫자와 연산 분리하기
    tmp = ""
    arr = []
    for i in exp:
        if i.isdigit():
            tmp += i
        else:
            arr.append(tmp) # 숫자
            arr.append(i)   # 연산
            tmp = ""
    arr.append(tmp)
    # 3. op 경우의 수 계산해보기
    ans = 0
    for o in op:
        cp = copy.deepcopy(arr)
        num = find_num(cp, o)
        ans = max(ans, num)
    return ans