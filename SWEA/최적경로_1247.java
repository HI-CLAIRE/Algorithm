package SWEA;

import java.util.Scanner;
 
//보통 좌표가 들어오면 int[] pos; [0]:x좌표 , [1]:y좌표
 
public class 최적경로_1247 {
    //좌표를 저장할 클래스 선언
    static class Pos {
        int x, y;
 
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
     
    static int N; //고객의 수 2<=N<=10;
    static Pos com, home;
    static Pos[] cust; //배열도 OK List<Pos> OK
    static int ans;
//  static boolean[] visited; //체크배열을 활용하기위해서
//  static int[] result;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T =sc.nextInt();
        for(int tc = 1; tc<=T ;tc++) {
            N = sc.nextInt();
            com = new Pos(sc.nextInt(), sc.nextInt());
            home = new Pos(sc.nextInt(), sc.nextInt());
            cust = new Pos[N];
            ans = 987654321; 
//          visited = new boolean[N];
            //초기화 완료
             
            for(int i = 0 ; i<N; i++) {
                cust[i] = new Pos(sc.nextInt(), sc.nextInt());
            }//입력완료
             
            perm(0, 0, 0, com); 
             
            System.out.println("#"+tc+" "+ans);
        }//tc
    }//main
    //visited / bitmasking 
    //idx : 판단
    //visited: 방문
    //dist 계산한 결과를 저장.
    //curr : 현재 나는 누구인ㄷ가
    static void perm(int idx, int visited, int dist, Pos curr) {
        if(dist > ans) return;
        //모든 순열을 끝냈다.
        if(idx == N) {
            //마지막손님에서 나의 집까지의 거리를 구해서 현재 내가 가지고 있는 값과 비교하고 갱신할수있으면 한다.
            ans = Math.min(ans, dist + Math.abs(curr.x - home.x)+Math.abs(curr.y-home.y));
            return;
        }
         
        //순열 돌려봐야져
        for(int i = 0 ; i<N ;i++) {
            //i번째 사람 방문안했니?
//          if(!visited[i]) {
//              
//          }
            //i번째 사람 방문 안했다면.
            if((visited & (1<<i)) == 0){
                //방문쳌
                perm(idx+1, visited | (1<<i), dist + Math.abs(curr.x - cust[i].x)+Math.abs(curr.y-cust[i].y), cust[i]);
                //방문풀기
            }
        }
    }
     
     
     
     
}