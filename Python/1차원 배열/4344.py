C = int(input())

for _ in range(C):
    lst = list(map(int, input().split()))
    avg = sum(lst[1:]) / lst[0]
    cnt = 0
    for i in lst[1:]:
        if i > avg:
            cnt += 1
    student_avg = cnt / lst[0] * 100
    print(f"{student_avg:.3f}%")