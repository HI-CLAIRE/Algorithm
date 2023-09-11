name = input()

def solution(name):
  ans = 0
  n_len = len(name)
  min_move = n_len - 1
  for i in range(n_len):
    # A와 Z중 가까운 거리 구하기, Z는 한 번 움직이는 거니까 +1
    ans += min(ord(name[i]) - ord("A"), ord("Z") - ord(name[i]) + 1)

    # 연속된 A는 건너뛰어도 됨. 연속된 A의 갯수 구하기
    next = i + 1
    while next < n_len and name[next] == "A":
      next += 1
    
    a_left = 2*i + (n_len - next) # 연속된 A의 왼쪽
    a_right = i + 2*(n_len - next)  # 연속된 A의 오른쪽

    # 기존 0부터 시작 vs 왼쪽 vs 오른쪽
    min_move = min(min_move, a_left, a_right)
    print(f"{name[i]} : {min_move}, {a_left}, {a_right}")

  return ans + min_move

print(solution(name))


# def solution(name):
#     answer = 0
#     n = len(name)

#     def alphabet_to_num(char):
#         num_char = [i for i in range(14)] + [j for j in range(12, 0, -1)]
#         return num_char[ord(char) - ord('A')]

#     for ch in name:
#         answer += alphabet_to_num(ch)

#     move = n - 1
#     for idx in range(n):
#         next_idx = idx + 1
#         while (next_idx < n) and (name[next_idx] == 'A'):
#             next_idx += 1
#         distance = min(idx, n - next_idx)
#         move = min(move, idx + n - next_idx + distance)

#     answer += move
#     return answer
