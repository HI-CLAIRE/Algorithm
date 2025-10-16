function solution(a, b) {
    const tmp1 = a.toString() + b.toString();
    const res1 = parseInt(tmp1);
    const tmp2 = b.toString() + a.toString();
    const res2 = parseInt(tmp2);
    
    return res1 >= res2 ? res1 : res2
}