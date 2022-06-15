a, b = map(int, input().split())

lst = []


def dfs(start):
    if len(lst) == b:
        print(' '.join(map(str, lst)))
        return
    for i in range(start, a+1):
        if i not in lst:
            lst.append(i)
            dfs(i+1)
            lst.pop()

dfs(1)