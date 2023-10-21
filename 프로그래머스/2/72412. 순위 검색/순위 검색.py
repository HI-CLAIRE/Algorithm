# 완탐 -> 정확성 성공 / 효율성 실패(시간초과)

# # 1. 코딩 점수 이외엔 일치해야함 (개인조건, personal)
# # 2. 코딩 점수는 해당 점수 이상인 값들만 (점수조건, score)
# def solution(info, query):
#     info = [i.split(" ") for i in info]
#     query = [q.replace(" and ", " ").split(" ") for q in query]    
#     # 해당 점수 이상인 후보군만 추리기
#     cnt = [0] * len(query)
#     for idx in range(len(query)):
#         for i in info:
#             if int(i[4]) >= int(query[idx][4]):
#                 for j in range(4):
#                     if query[idx][j] != "-" and i[j] != query[idx][j]:
#                         break
#                     if j == 3:
#                         cnt[idx] += 1
#     return cnt

# 딕셔너리, 이분탐색 -> 정확성 성공 / 효율성 성공
from itertools import combinations
from bisect import bisect_left

def solution(info, query):
    # info {"조건": [점수]} 딕셔너리
    ans = []
    info_dict = {}
    for i in range(len(info)):
        ilst = info[i].split()
        ikey = ilst[:-1]    # 조건
        ivalue = ilst[-1]   # 점수
        
        for j in range(5):
            for c in combinations(ikey, j): # 조건 조합 + 숫자 조합 가능성 dict에 다 저장하기
                tmp = "".join(c)
                if tmp in info_dict:
                    info_dict[tmp].append(int(ivalue)) # 존재하는 조합이면 점수만 추가
                else:
                    info_dict[tmp] = [int(ivalue)] # 존재하지 않는다면 새로 추가
    for i in info_dict:
        info_dict[i].sort()
        
    # query {"조건": [점수]} 딕셔너리
    for q in query:
        qlist = q.replace(" and ", " ").split(" ")
        qkey = qlist[:-1]   # 조건
        qvalue = int(qlist[-1])  # 점수
        
        while "-" in qkey:  # "-" 제거
            qkey.remove("-")
        qkey = "".join(qkey)
        
        # query와 info를 비교하면서 해당 query에 info 조합이 존재한다면 이분탐색으로 해당 인덱스 찾은 후 리턴
        if qkey in info_dict:
            scores = info_dict[qkey]
            
            if scores:
                enter = bisect_left(scores, qvalue)
                ans.append(len(scores) - enter)
        else:
            ans.append(0)
    return ans