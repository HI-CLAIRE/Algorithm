def solution(user_id, banned_id):
    # 1. 가능한 id 목록 뽑아내기
    able_lst = []
    for b in banned_id:
        able_ids = []
        for u in user_id:
            if len(b) == len(u):
                for i in range(len(b)):    # banned_id의 알파벳 순회하면서 user_id와 비교
                    if b[i] != "*" and b[i] != u[i]:
                        break
                    if i == len(b) -1: able_ids.append(u)
        able_lst.append(able_ids)
        
    # 2. 가능한 id 조합 찾아내기
    lst = []    # 가능한 id 조합 저장
    res_lst = []    # 모든 조합들이 저장된 리스트
    find_comb(able_lst, lst, 0, res_lst)
    print(res_lst)
    return len(res_lst)

def find_comb(able_lst, lst, idx, res_lst):
    if idx == len(able_lst):
        lst.sort()
        if lst not in res_lst:
            res_lst.append(lst[:])
        return

    for i in able_lst[idx]:
        if i not in lst:
            lst.append(i)
            find_comb(able_lst, lst, idx+1, res_lst)
            lst.remove(i)