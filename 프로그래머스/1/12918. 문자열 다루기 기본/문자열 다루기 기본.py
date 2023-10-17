def solution(s):
    if len(s) != 4 and len(s) != 6:
        return False
    for i in s:
        if "0" < i and i > "9":
            return False
    return True

print(solution("12345"))