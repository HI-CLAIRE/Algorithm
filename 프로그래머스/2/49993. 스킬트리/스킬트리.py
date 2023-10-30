def solution(skill, trees):
    cnt = 0
    for tree in trees:
        cnt += check(skill, tree)
    return cnt

def check(skill, tree):
    cnt = 0
    tmp = ""
    flag = 1
    for t in tree:
        if t in skill:
            tmp += t
            if tmp != skill[:skill.index(t) + 1]:
                flag = 0
                break
    if flag: cnt += 1
    return cnt