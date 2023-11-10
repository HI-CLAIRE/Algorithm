def solution(name):
  ans = 0
  n_len = len(name)
  min_move = n_len - 1
  for i in range(n_len):
    tmp = min(ord(name[i]) - ord("A"), ord("Z") - ord(name[i]) + 1)
    ans += tmp

    next = i + 1
    while next < n_len and name[next] == "A":
      next += 1
    
    a_left = 2 * i + n_len - next
    a_right = i + 2 * (n_len - next)
    min_move = min(min_move, a_left, a_right)
    
    print(f"{name[i]}: {tmp}, {min_move}")

  return ans + min_move