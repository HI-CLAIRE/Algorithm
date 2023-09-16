
number = input()
k = int(input())

def solution(number, k):
    stack = []
    for n in number:
        while stack and k>0 and stack[-1] < n:
            stack.pop()
            k -= 1
        stack.append(n)
    if k != 0:
        stack = stack[:-k]
    return "".join(stack)

# 시간초과 코드
# import copy
# def solution(number, k):
#     num_list = list(number)
#     i = 0
#     while k > 0:
#         # 만약 앞에서 이미 숫자가 다 채워졌다면 뒤는 다 버리고 탈출
#         if i >= len(num_list) - k:
#             del num_list[i:]
#             break
#         # k+1 만큼이 가능한 애들이니까 그 중에 max값 찾기
#         end = i+k+1
#         if end > len(num_list):
#             end = len(num_list)
#         # max_num = max(num_list[i : end])
#         max_num = "0"
#         for a in num_list[i:end]:
#             if a == "9":
#                 max_num = "9"
#                 break
#             if a > max_num:
#                 max_num = a

#         max_idx = num_list[i:].index(max_num) + i
#         del num_list[i:max_idx]
#         # print(f"{i}번째 : {num_list}")
#         k -= max_idx - i # (max_idx-i) : 지운 k의 갯수
#         # print(f"남은 k: {k}")
#         i += 1  # idx 땡겨주기
#     return "".join(num_list)

print(solution(number, k))