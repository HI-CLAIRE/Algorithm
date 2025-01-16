function solution(x) {
    const itoa = x.toString();
    let sum = 0;
    for(c of itoa) {
        sum += Number(c)
    }
    if(x % sum === 0) return true
    else return false
}