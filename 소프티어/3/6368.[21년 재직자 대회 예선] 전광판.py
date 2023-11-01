import sys

t = int(sys.stdin.readline())

num_dict = {
    "0": [1, 1, 1, 1, 1, 1, 0],
    "1": [0, 1, 1, 0, 0, 0, 0],
    "2": [1, 1, 0, 1, 1, 0, 1],
    "3": [1, 1, 1, 1, 0, 0, 1],
    "4": [0, 1, 1, 0, 0, 1, 1],
    "5": [1, 0, 1, 1, 0, 1, 1],
    "6": [1, 0, 1, 1, 1, 1, 1],
    "7": [1, 1, 1, 0, 0, 1, 0],
    "8": [1, 1, 1, 1, 1, 1, 1],
    "9": [1, 1, 1, 1, 0, 1, 1],
    "z": [0, 0, 0, 0, 0, 0, 0],
}  # 빈칸

for _ in range(t):
    A, B = map(str, sys.stdin.readline().split())
    a = "z" * (5 - len(A)) + A  # 다섯자리 문자열로 포맷 고정
    b = "z" * (5 - len(B)) + B

    cnt = 0
    for i in range(5):
        if a[i] != b[i]:
            a_list = num_dict.get(a[i])
            b_list = num_dict.get(b[i])
            for j in range(7):
                if a_list[j] != b_list[j]:
                    cnt += 1

    print(cnt)
