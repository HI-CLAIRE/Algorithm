a, b = map(int, input().split())

lst = []

def dfs():
    if len(lst) == b:
        print(' '.join(map(str, lst)))
        return
    for i in range(1, a+1):
        if i not in lst:
            lst.append(i)
            dfs()
            lst.pop()

dfs()