function solution(my_string, overwrite_string, s) {
    // 1. my_string 의 s번째 인덱스까지 자르기(앞)
    // 2. 앞 + overwrite_string
    // 3. my_string의 (s + overwrite_string.length)번째 인덱스까지 자르기(뒤)
    // 4. ans = 2 + 3
    let ans = "";
    const first = my_string.slice(0, s);
    const second = overwrite_string;
    const endIdx = my_string.length - (s + overwrite_string.length);
    console.log(endIdx)
    
    if(endIdx === 0) {
        return first + second;
    }
    const last = my_string.slice(-endIdx);
    console.log(first, second, last)
    
    ans = first + second + last;
    return(ans);
}