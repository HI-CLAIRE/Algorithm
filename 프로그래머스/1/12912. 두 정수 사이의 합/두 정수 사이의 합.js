function solution(a, b) {
    const diff = Math.abs(a-b)
    return (a + b) / 2 * (diff + 1)
}