alpha = list(enumerate(input()))
init_lst = [-1 for num in range(26)]

for i in alpha:
    if 'a' <= alpha and alpha <= 'z':
        print(alpha.index(i), end = ' ')

for index, value in enumerate(alpha):
    print(index)