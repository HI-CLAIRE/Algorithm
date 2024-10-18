function solution(n) {
    const sqrtNum = Math.sqrt(n)
    const isInteger = sqrtNum % 1
    
    if(!isInteger) {
        return Math.pow(sqrtNum + 1, 2)
    } else {
        return -1
    }
}