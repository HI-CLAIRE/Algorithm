def solution(numbers, hand):
    pad = [[1,4,7], [2,5,8,0], [3,6,9]]
    ans = ""
    l_pos = [0, 3]
    r_pos = [2, 3]
    for n in numbers:
        if n in pad[0]: # 왼손
            ans += "L"
            l_pos = [0, pad[0].index(n)]
        elif n in pad[2]: # 오른손
            ans += "R"
            r_pos = [2, pad[2].index(n)]
        else:   # 중간(2580)
            now_x = 1
            now_y = pad[1].index(n)
            left = abs(now_x - l_pos[0]) + abs(now_y - l_pos[1])
            right = abs(now_x - r_pos[0]) + abs(now_y - r_pos[1])
            
            if left < right or (left == right and hand == "left"):
                l_pos = [1, pad[1].index(n)]
                ans += "L"
            elif right < left or (left == right and hand == "right"):
                r_pos = [1, pad[1].index(n)]
                ans += "R"
    return ans