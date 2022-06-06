def recur(n):
    if n < 2:
        return(1)
    else:
        return(n * recur(n-1))

n = int(input())
print(recur(n))