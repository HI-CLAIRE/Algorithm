import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
belt_tmp = list(map(int, input().split()))
belt = []
for i in belt_tmp:
    belt.append([i, 0])
dq = deque(belt)

# 1. 회전
# 2. 이동 (내린다)
# 3. 올린다
zero, cnt = 0, 0
while True:
    cnt += 1
    # 1. 회전
    last = dq.pop()
    dq.appendleft(last)
    # print(f"회전한 dq: {dq}")

    # 2. 이동
    if dq[n-1][1] == 1:  # 마지막 칸에 로봇이 있으면 내려
        dq[n-1][1] = 0

    for i in range(len(dq)-2, -1, -1):
        if dq[i][1] == 1 and dq[i+1][0]!=0 and dq[i+1][1]!=1: # 해당칸에 로봇이 있고 다음칸의 내구도가 0이 아니면
            dq[i+1][1] = 1 # 로봇 옮기기
            dq[i][1] = 0 # 해당칸 로봇 빼주기
            dq[i+1][0] -= 1 # 내구도 깎기
            if dq[i+1][0] == 0:
                zero += 1

    if dq[n-1][1] == 1:  # 마지막 칸에 로봇이 있으면 내려
        dq[n-1][1] = 0

    # 3. 올린다
    if dq[0][0] != 0:
        dq[0][1] = 1    # 로봇 올리기
        dq[0][0] -= 1   # 내구도 깎기
        if dq[0][0] == 0:
            zero += 1
    
    # print(f"로봇 올리기: {dq}")
    # print("-------------------")
    
    # for i in range(len(dq)):
    #     if dq[i][0] == 0:
    #         zero += 1

    if zero >= k:
        break
    # print(f"이동한 dq: {dq}")
print(cnt)