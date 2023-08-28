# 1. Sort 후 p와 c의 이름이 다른것 return
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