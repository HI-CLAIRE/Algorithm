function solution(name, yearning, photo) {
  const obj = name.reduce((acc, cur, idx) => {
    acc[cur] = yearning[idx];
    return acc;
  }, new Object());
  return photo.map((v) => {
    return v
      .map((e) => {
        if (obj[e] !== undefined) return obj[e];
        else return 0;
      })
      .reduce((acc, cur) => acc + cur, 0);
  });
}
