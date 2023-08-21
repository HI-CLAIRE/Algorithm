import itertools

def solution(nums):
    wantNum = len(nums) / 2
    uniq = set(nums)
    uniqNum = len(uniq)
    
    if(wantNum <= uniqNum):
        return wantNum
    else:
        return uniqNum