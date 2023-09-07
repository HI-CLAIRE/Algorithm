name = input()

# 23.09.07
# 조이스틱을 움직여서 모든 요소를 "A"로 만들기

def solution(name):
  ans = 0
  name = list(name)
  idx = 0

  while True:
    # 현재 위치에서 A과 Z 중 가까운 값
    ans += min(ord(name[idx])-ord("A"), ord("Z")-ord(name[idx])+1)

    # 모든 문자열이 "A"가 되면 종료
    name[idx] = "A"
    if name.count("A") == len(name):
      break

    # 다음으로 이동할 위치
    left, right = 1, 1
    while name[idx - left] == "A":
      left += 1
    while name[idx + right] == "A":
      right += 1
    
    # 왼쪽과 오른쪽 중 더 가까운 쪽으로 이동
    if left < right:
      ans += left
      idx -= left
    else:
      ans += right
      idx += right
  
  return ans

print(solution(name))