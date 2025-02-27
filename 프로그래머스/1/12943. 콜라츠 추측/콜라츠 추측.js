function defEvenOdd(num) {
    return num % 2 === 0 ? num / 2 : num * 3 + 1;
}

function solution(num) {
    let cnt = 0;

    while (num !== 1 && cnt < 500) {
        num = defEvenOdd(num);
        cnt++;
    }

    return num === 1 ? cnt : -1;
}
