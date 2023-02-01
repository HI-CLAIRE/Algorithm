package 모의SW역량테스트;

import java.util.ArrayList;
import java.util.Scanner;
 
public class 벽돌깨기_0929 {
     
    // 4방 탐색용 delta배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
     
    static int N; // 구슬을 던지는 횟수
    static int W; // 맵의 너비
    static int H; // 맵의 높이
     
    //최솟값
    static int min;
     
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();
             
            int[][] map = new int[H][W];
            // 2차원 배열 입력 받기
            for(int r=0; r<H; r++) {
                for(int c=0; c<W; c++) {
                    map[r][c] = sc.nextInt();
                }
            }
             
            // 재귀함수 1. 구슬을 던지는 함수
            // drop(idx, map)
            // N번 던지므로: idx: 0, 1, 2, .. , N-1
            // 중복 순열
            // W * W .. *W
             
            // 최소값을 초기화 하고 던지기 시작
            min = Integer.MAX_VALUE;
            drop(0, map);
             
            System.out.println("#"+tc+" "+min);
             
             
        }
         
         
    }
 
 
    private static void drop(int idx, int[][] map) {
        // 기저조건
        if(idx == N) {
            int cnt = count(map);
            if(cnt < min) min = cnt;
             
            return;
        }
         
        // 유도 조건
        // 중복 순열
        // c= 0열부터 W-1까지
        // c열에 구슬을 던짐
        for(int c=0; c<W; c++) {
            // c열에 구슬이 던져졌을 때 위에서부터 시작해서
            // 가장 처음 만나는 벽돌을 찾는다.
            int r = 0; // 가장 위
            while(r < H && map[r][c] == 0) r++;
            // 만약에 벽돌 발견했으면 r < H
            // 만약에 벽돌 발견 못했으면 r == H
             
            if(r == H) { // 구슬을 던졌지만 맞은 벽돌이 없는 경우(빈열)
                drop(idx+1, map);
            } else { // 맞은 벽돌이 있는 경우(탐색의 시작 정점이 있다)
                //dfs를 시작
                 
                // dfs를 하면서 벽돌을 제거할 것임
                // 지금 벽돌 부수기가 다음번 던질 때 영향을 주면 안되므로
                // 초기화
                // 1. 배열을 먼저 복사
                int[][] newMap = new int[H][W];
                copy(map, newMap);
                 
                // 2. dfs 탐색 시작
                // dfs() 설계 - 탐색을 할 때 매 정점에서 필요한 정보
                // - 시작 정점 위치: r, c
                // - 2차원 복사한 것: newMap
                // - 현재 정점의 벽돌의 숫자: cnt
                dfs(newMap, r, c, map[r][c]);
                 
                // 3. 벽돌 내리기
                down(newMap);
                 
                // 4. 다음 구슬 던지러가기
                drop(idx+1, newMap);
            }
             
        }
         
         
         
    }
     
    private static void down(int[][] map) {
        // 배열 복사용 리스트를 만들기
        ArrayList<Integer> list = new ArrayList<>();
        for(int c=0; c<W; c++) {
            for(int r =H-1; r>=0; r--){
                if(map[r][c] > 0) { // 0이 아니라면
                    list.add(map[r][c]); // 리스트에 추가하고
                    map[r][c] = 0; // 0으로 만들어줌
                }
            }
            // 리스트의 가장 아래부터 채우기
            int r = H-1;
            for(int i: list) map[r--][c] = i;
            list.clear(); // 리스트를 비우고 다음 열로 간다.
            // 아니면 매번 리스트를 새로 생성해도 됨
        }
         
    }
 
 
    // 시작 정점에서 주어진 map 배열을 재사용
    // 현재위치 r, c이면서, 벽돌의 숫자가 cnt
    // cnt가 1인 경우: 자기 자신만 제거 하고 끝. 재귀호출 X
    // cnt>1인 경우: 자기 자신도 제거하면서. 4방향으로 cnt의 범위만큼 내 주위에 있는 벽돌에 대해서 재귀호출 
    private static void dfs(int[][] map, int r, int c, int cnt) {
        // 자기 자신 제거는 기본
        map[r][c] = 0; // 자기 자신 제거
         
        // 1. cnt == 1
        // 자기 자신을 제거하고 그 다음에 아무것도 하지 않음.
        // 기저조건
        if(cnt == 1) return;
         
        // 2. cnt > 1
        // 유도조건
        // 4방향으로 cnt 범위만큼, 벽돌에 대해서 재귀호출
        for(int d=0; d< 4; d++) {
            // 탐색 위치는 현재 위치 r, c에서 출발
            int nr = r;
            int nc = c;
            for(int k=1; k<cnt; k++) { // k는 1부터 cnt-1까지
                nr += dr[d];
                nc += dc[d];
                // 경계 조건
                if( nr>= 0 && nr <H && nc >=0 && nc <W) {
                    if(map[nr][nc] != 0) {
                        dfs(map, nr, nc, map[nr][nc]);
                    }
                }
            }
             
        }
         
    }
 
 
    // 2차원 배열 복사
    public static void copy(int[][] map, int[][] newMap) {
        for(int r=0; r<H; r++) {
            for(int c=0; c<W; c++) {
                newMap[r][c] = map[r][c];
            }
        }
    }
     
    // 벽돌 개수 세기
    public static int count(int[][] map) {
        int cnt = 0;
        for(int r=0; r<H; r++) {
            for(int c=0; c<W; c++) {
                if(map[r][c] > 0) cnt++;
            }
        }
        return cnt;
    }
     
     
}