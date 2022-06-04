import string

put = input()
abc = list(string.ascii_lowercase)
ABC = list(string.ascii_uppercase)

num_lst = [0] * 26
for i in put:
    if i in abc:
        num_lst[ord(i) - ord('a')] += 1
    elif i in ABC:
        num_lst[ord(i) - ord('A')] += 1
max = max(num_lst)

cnt = 0
for j in num_lst:
    if j == max:
        cnt += 1

if cnt != 1:
    print("?")
else:
    print(chr(num_lst.index(max) + 65))