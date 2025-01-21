function solution(keymap, targets) {
    // 알파벳 초기화
    const alphabetCounts = {};
    for (let i = 0; i < 26; i++) {
        alphabetCounts[String.fromCharCode(65 + i)] = Number.MAX_SAFE_INTEGER;
    }

    // keymap을 통해 최소 누름 수 계산
    for (const key of keymap) {
        [...key].forEach((v, i) => {
            alphabetCounts[v] = Math.min(alphabetCounts[v], i);
        });
    }

    // targets 계산
    const result = targets.map(row => {
        let sum = 0;
        for (const char of row) {
            if (alphabetCounts[char] === Number.MAX_SAFE_INTEGER) {
                // 목표 문자열에 작성 불가능한 문자가 포함된 경우
                return -1;
            }
            sum += alphabetCounts[char] + 1; // 최소 누름 수 합산
        }
        return sum; // 작성 가능한 경우 총 누름 수 반환
    });

    return result;
}
