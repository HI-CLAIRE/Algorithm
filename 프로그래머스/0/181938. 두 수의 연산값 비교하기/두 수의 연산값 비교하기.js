function solution(a, b) {
    const res1 = Number(`${a}${b}`)
    const res2 = 2 * a * b
    return(Math.max(res1, res2))
}