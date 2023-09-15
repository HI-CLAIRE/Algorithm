import copy

number = input()
k = int(input())

def solution(number, k):
    num_list = list(number)
    i = 0
    while k > 0:
        # k+1 만큼이 가능한 애들이니까 그 중에 max값 찾기
        max_num = max(num_list[i : i+k+1])
        max_idx = num_list[i:].index(max_num) + i
        del num_list[i:max_idx]
        print(f"{i}번째 : {num_list}")
        k -= max_idx - i # (max_idx-i) : 지운 k의 갯수
        print(f"남은 k: {k}")
        i += 1  # idx 땡겨주기
    return "".join(num_list)

print(solution(number, k))