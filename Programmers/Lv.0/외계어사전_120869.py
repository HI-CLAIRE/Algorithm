spell = list(input().split())
dic = list(input().split())

# set으로 자료형 통일
spell = set(spell)

# 단어와 알파벳의 차집합을 구했을 때 아무것도 남지 않으면 return 1
# 무언가 남아있다면 return 2
for s in dic:
    if not spell - set(s):
        print(1)
    print(2)