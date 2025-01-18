function solution(numbers) {
    const sum = numbers.reduce((acc, cur) => acc + cur)
    return 45 - sum
}