function solution(arr, divisor) {
    var answer = [];
    for(el of arr) {
        if (el % divisor === 0 ) {
            answer.push(el)
        }
    }
    if(answer.length === 0) {
        answer.push(-1)
    } else {
        answer.sort((a,b) => a-b)
    }
    
    return answer
}