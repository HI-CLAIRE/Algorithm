function solution(x, n) {
    let ans = []
    let next = 0
    while(n--) {
        ans.push(x + next)
        next += x
    }
    return ans
}