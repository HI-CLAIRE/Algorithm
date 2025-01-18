function solution(absolutes, signs) {
    let ans = 0
    absolutes.forEach((n, i) => {
        ans += signs[i] ? n : -n
    })
    return ans
}