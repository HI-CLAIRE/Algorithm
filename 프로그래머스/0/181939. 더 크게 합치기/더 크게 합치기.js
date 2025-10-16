function solution(a, b) {
  const num1 = Number(`${a}${b}`);
  const num2 = Number(`${b}${a}`);
  return Math.max(num1, num2);
}
