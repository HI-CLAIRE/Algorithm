def solution(n):
    answer = []
    while(n > 10):
        answer.append(n % 10)
        n //= 10
    answer.append(n)
    return answer
        