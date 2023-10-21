def solution(prices):
    ans = [0] * len(prices)
    for i in range(len(prices) - 1):
        for j in range(i, len(prices)):
            if prices[i] > prices[j]:
                ans[i] += j - i
                break
        if ans[i] == 0:
            # print(ans)
            ans[i] += j - i
    return ans