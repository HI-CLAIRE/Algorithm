function solution(n, arr1, arr2) {
    const result = [];

    for (let i = 0; i < n; i++) {
        // arr1[i]와 arr2[i]의 이진수를 직접 생성
        let binary1 = '';
        let binary2 = '';
        let num1 = arr1[i];
        let num2 = arr2[i];

        // arr1[i]의 이진수 생성
        for (let j = 0; j < n; j++) {
            // 2^j의 위치에서 비트 확인
            if (num1 % 2 === 1) {
                binary1 = '1' + binary1; // 앞에 추가
            } else {
                binary1 = '0' + binary1;
            }
            num1 = Math.floor(num1 / 2); // 다음 비트로 이동
        }

        // arr2[i]의 이진수 생성
        for (let j = 0; j < n; j++) {
            if (num2 % 2 === 1) {
                binary2 = '1' + binary2; // 앞에 추가
            } else {
                binary2 = '0' + binary2;
            }
            num2 = Math.floor(num2 / 2); // 다음 비트로 이동
        }

        let row = '';

        // 두 이진수를 비교하여 '#' 또는 ' ' 추가
        for (let j = 0; j < n; j++) {
            if (binary1[j] === '1' || binary2[j] === '1') {
                row += '#';
            } else {
                row += ' ';
            }
        }

        result.push(row);
    }

    return result;
}
