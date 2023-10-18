def solution(answers):
    one_cnt, two_cnt, three_cnt = 0, 0, 0
    
    one_list = [1,2,3,4,5]
    two_list = [2,1,2,3,2,4,2,5]
    three_list = [3,3,1,1,2,2,4,4,5,5]

    for i in range(len(answers)):
        if answers[i] == one_list[i%5]:
            one_cnt += 1
        if answers[i] == two_list[i%8]:
            two_cnt += 1
        if answers[i] == three_list[i%10]:
            three_cnt += 1
    
    cnt_list = [one_cnt, two_cnt, three_cnt]
    
    ans = []
    for i in range(3):
        if cnt_list[i] == max(cnt_list):
            ans.append(i+1)
            
    return ans