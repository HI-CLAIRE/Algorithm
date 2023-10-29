# R : (d+1)%4, L : (d+3)%4
def solution(command):
    dr = [0, 1, 0, -1]  # 북동남서
    dc = [1, 0, -1, 0]
    d = 0
    pos = [0, 0]
    
    for c in command:
        if c == "R":
            d = (d+1) % 4
        elif c == "L":
            d = (d+3) % 4
        elif c == "G":
            pos[0] += dr[d]
            pos[1] += dc[d]
        elif c == "B":
            pos[0] -= dr[d]
            pos[1] -= dc[d]
    return pos