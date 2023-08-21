def solution(s):
    # 룩업 테이블 활용
    table = {
        "zero": "0",
        "one": "1",
        "two": "2",
        "three": "3",
        "four": "4",
        "five": "5",
        "six": "6",
        "seven": "7",
        "eight": "8",
        "nine": "9"
    }

    for key, value in table.items():
        s = s.replace(key, value)

    return int(s)