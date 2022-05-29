first_put = int(input())
put = first_put
cnt = 0

while 1:
    ten = put // 10
    one = put % 10
    newone = (ten + one) % 10
    new = (10 * one) + newone
    put = new
    cnt += 1
    if put == first_put:
        break
print(cnt)
