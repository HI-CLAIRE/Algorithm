# 1. 큰 사각형 좌측상단 꼭지점과 내용물이 동일한가?
# 2. 동일하지 않다면 l//2 해서 다시 1
# 3. 동일하면 +1

def recur(a, b, l, arr, ans):
    start = arr[a][b]
    for i in range(a,a+l):
        for j in range(b,b+l):
            if arr[i][j] != start:
                l //= 2
                recur(a,b,l,arr,ans)
                recur(a+l,b,l,arr,ans)
                recur(a,b+l,l,arr,ans)
                recur(a+l,b+l,l,arr,ans)
                return
    ans[start] += 1
    return

def solution(arr):
    ans = [0, 0]
    recur(0, 0, len(arr), arr, ans)
    return ans