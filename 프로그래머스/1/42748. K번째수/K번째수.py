def solution(array, commands):
    ans = []
    for c in commands:
        tmp = array[c[0]-1:c[1]]
        tmp.sort()
        ans.append(tmp[c[2]-1])
        tmp = []
    return ans