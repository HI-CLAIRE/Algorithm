def solution(records):
    member_dic = {}
    for rec1 in records:
        tmp_rec = rec1.split()
        if tmp_rec[0] == "Enter" or tmp_rec[0] == "Change":
            member_dic[tmp_rec[1]] = tmp_rec[2]
    
    ans_list = []
    for rec2 in records:
        tmp2 = rec2.split()
        if tmp2[0] == "Enter":
            ans_list.append(f"{member_dic.get(tmp2[1])}님이 들어왔습니다.")
        elif tmp2[0] == "Leave":
            ans_list.append(f"{member_dic.get(tmp2[1])}님이 나갔습니다.")
            
    return ans_list