function solution(str1, str2) {
    let ans = ""
    for(let i=0; i<str1.length; i++) {
        ans += str1[i] + str2[i]
    }
    return ans
}