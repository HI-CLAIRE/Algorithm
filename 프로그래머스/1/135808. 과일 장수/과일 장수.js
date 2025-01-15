function solution(k, m, score) {
    // k 점수, m개씩 포장, 가장 낮은 점수 p, 한 상자 가격 p*m
    // 얻을 수 있는 최대 이익
    score.sort((a, b) => b - a)
    const total = score.length
    
    // total을 m으로 나눈 몫이 나올 수 있는 상자의 갯수
    // 상자의 갯수만큼 for문 순회하여 (m-1)*i 번째 인덱스의 값을 모두 더함
    // 2 5 8 11
    // 3-1 6-1 9-1
    let ans = 0
    for(i=1; i<=parseInt(total/m); i++) {
        const lastIndex = m * i - 1
        const earnings = score[lastIndex] * m
        // console.log(lastIndex)
        ans += earnings
    }
    
    return ans
}