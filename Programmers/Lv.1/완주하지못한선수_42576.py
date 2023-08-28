# 1. Sort 후 p와 c의 이름이 다른것 return
# def solution(participant, completion):
#     p = sorted(participant)
#     c = sorted(completion)
#     for i in range(len(c)):
#         if p[i] != c[i]:
#             return p[i]
#     return p[len(p) - 1]

# 2. hash 사용
#    p를 순회하며 참여자들의 hash값을 더한 sumHash를 구함
#    c를 순회하며 완주자들의 hash값을 sumHash에서 뺌
#    완주하지 못한 참여자의 hash값만 남음 

# 3. Counter 사용
#    key가 이름, value가 count인 dictionary 반환
import collections

participant = list(input().split())
completion = list(input().split())

ans = collections.Counter(participant) - collections.Counter(completion)

print(list(ans.keys())[0])


# 4. 효율성에서 통과를 못함... 왜??
# def solution(participant, completion):
#     for c in completion:
#         if c in participant:
#             participant.remove(c)
#     return participant[0]