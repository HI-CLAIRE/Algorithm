def solution(s, n):
    ans = ""
    for i in s:
        if 'A' <= i and i <= 'Z':  
            ans += chr((ord(i)-ord("A")+n) % 26 + ord("A"))
        elif 'a' <= i and i <= 'z':
            ans += chr((ord(i)-ord("a")+n) % 26 + ord("a"))
        else:
            ans += i  
    return ans