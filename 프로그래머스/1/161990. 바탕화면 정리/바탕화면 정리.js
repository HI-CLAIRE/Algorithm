function solution(wallpaper) {
    // (5,1) (4,4) (3,3) (7,2)
    // (3,1) (7 + 1, 4 + 1)
    
    // 1. wallpaper를 이중순회
    // N = wallpaper.length, M = wallpaper[0].length
    
    // 2. wallpaper[i][j] === "#"
    // 1) 최솟값 비교 min
    // 2) 최댓값 비교 max
    // ans = [minX, minY, maxX, maxY]
    
    const N = wallpaper.length
    const M = wallpaper[0].length
    
    let [minX, minY, maxX, maxY] = [51, 51, 0, 0]
    for(i=0; i<N; i++) {
        for(j=0; j<M; j++) {
            if(wallpaper[i][j] === "#") {
                if(i < minX) {
                    minX = i
                } if(i > maxX) {
                    maxX = i
                } if(j < minY) {
                    minY = j
                } if(j > maxY) {
                    maxY = j
                }
            }
        }
    }
    
    const ans = [minX, minY, maxX + 1, maxY + 1]
    return ans
}