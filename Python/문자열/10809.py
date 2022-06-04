alpha = input()

for i in range(97, 123):
    if chr(i) in alpha:
        print(alpha.index(chr(i)), end = ' ')
    else:
        print(-1, end = ' ')