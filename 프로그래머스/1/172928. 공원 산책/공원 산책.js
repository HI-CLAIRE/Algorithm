function solution(park, routes) {
    // 1. park에서 시작 지점 찾기
    // 2. routes 순회
    // 3. 시작지점으로부터 routes의 방향과 주어진 칸만큼 이동
    // 4. 이동 전에 영역 밖을 벗어나거나 장애물을 만나면 break
    // 5. 없다면 이동
    
    const row = park.length
    const col = park[0].length
    
    // 시작 지점
    let start = []
    for(i=0; i<row; i++) {
        for(j=0; j<col; j++) {
            if(park[i][j] === "S") {
                start = [i, j]
                break;
            }
        }
    }
    
    // 방향
    // 북N 동E 남S 서W
    const directions = {
        N: [-1, 0],
        E: [0, 1],
        S: [1, 0],
        W: [0, -1]
    }
    routes.forEach((route) => {
        const [dir, amount] = route.split(" ")
        
        // 임시좌표, flag 생성
        let flag = 0
        let [nr, nc] = start
        
        // 방향 및 이동거리만큼 이동 준비
        const n = Number(amount)
        for(i=0; i<n; i++) {
            nr += directions[dir][0]
            nc += directions[dir][1]
        
            // 경계 && 장애물 검사
            // 경계를 벗어나면 flag 내리고 break
            if (nr < 0 || nc < 0 || nr >= row || nc >= col || park[nr][nc] === "X") {
                flag = 1
                break
            }
        }
        // flag가 올라갔을 때만 이동
        if(flag === 0) {
            start = [nr, nc]
        }
    })
    
    return start
}