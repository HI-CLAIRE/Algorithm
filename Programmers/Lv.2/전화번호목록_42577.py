pb = list(input().split())

pb.sort()

for i in range(len(pb)-1):
    if(pb[i+1].startswith(pb[i])):
        print(False)

print(True)

# Hash로 풀기
# def solution(phone_book):
#     answer = True
#     hash_map = {}
#     for phone_number in phone_book:
#         hash_map[phone_number] = 1
#     for phone_number in phone_book:
#         temp = ""
#         for number in phone_number:
#             temp += number
#             if temp in hash_map and temp != phone_number:
#                 answer = False
#     return answer
