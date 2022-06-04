put = input()

cro_alpha = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for i in cro_alpha:
    put = put.replace(i, "*")
print(len(put))