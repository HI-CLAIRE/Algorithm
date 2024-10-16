function solution(n) {
    let arr = Array.from(String(n))
    return Number(arr.sort((a,b) => b-a).join(''))
}