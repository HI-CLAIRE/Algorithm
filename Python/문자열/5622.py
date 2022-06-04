put = input()

dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
ans = 0
for i in range(len(put)):
    for j in dial:
        if put[i] in j:
            ans += dial.index(j) + 3
print(ans)