function solution(arr, divisor) {
    // divisor로 나누어 떨어지는 value값만 answer 배열로 필터링
    var answer = arr.filter((v) => v%divisor === 0)
    
    return answer.length === 0 ? [-1] : answer.sort((a, b) => a - b)
}        