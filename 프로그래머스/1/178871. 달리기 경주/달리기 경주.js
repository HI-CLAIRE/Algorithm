function solution(players, callings) {
    const playerIndexMap = {};
    
    // players의 index Map 생성
    for (let i = 0; i < players.length; i++) {
        playerIndexMap[players[i]] = i;
    }
    
    for (let i = 0; i < callings.length; i++) {
        // 현재 callings가 players에 있는 위치
        const currentIdx = playerIndexMap[callings[i]];
        // 현재 위치의 player보다 앞에 있는 플레이어
        const frontPlayer = players[currentIdx - 1];
        
        // 앞 요소와 swap
        players[currentIdx - 1] = callings[i];
        players[currentIdx] = frontPlayer;
        
        // playerIndexMap도 갱신
        playerIndexMap[callings[i]] = currentIdx - 1;
        playerIndexMap[frontPlayer] = currentIdx;    
    }
    
    return players;
}
