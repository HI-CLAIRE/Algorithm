def solution(pb):
    pb.sort()
    
    for i in range(len(pb) - 1):
        if(pb[i+1].startswith(pb[i])):
            return False
    return True