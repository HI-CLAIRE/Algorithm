# [level 1] [PCCP 모의고사 #2] 1번 - 실습용 로봇 - 121687

[문제 링크](https://school.programmers.co.kr/learn/courses/15009/lessons/121687)

### 성능 요약

메모리: 11.6 MB, 시간: 151.14 ms

### 구분

프로그래밍 강의 > PCCP 모의고사 2회

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 10월 29일 17:55:5

### 문제 설명

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>컴퓨터공학과에서는 실습용 로봇을 이용해서 로봇 프로그래밍을 학습합니다. 실습용 로봇은 입력된 명령에 따라  x좌표와 y좌표로 표현되는 2차원 좌표 평면 위를 이동합니다. 하나의 명령은 하나의 문자로 주어지며 각 명령어에 따라 로봇이 수행하는 일은 다음과 같이 네 종류입니다.</p>

<ul>
<li>'R': 로봇이 오른쪽으로 90도 회전합니다.</li>
<li>'L': 로봇이 왼쪽으로 90도 회전합니다.</li>
<li>'G': 로봇이 한 칸 전진합니다.</li>
<li>'B': 로봇이 한 칸 후진합니다.</li>
</ul>

<p>명령어는 각각의 명령들이<br>
모인 하나의 문자열로 주어지며, 차례대로 수행됩니다.</p>

<p>로봇은 처음에 (0, 0) 위치에 +y 축을 향하여 놓여 있습니다.</p>

<p>다음 그림은 번호 순서대로 명령어 "GRGLGRG"의 과정을 보여줍니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/012648ea-a3bc-43c2-a34b-20d8602a51da/%EA%B7%B8%EB%A6%BC1.png" title="" alt="그림1.png"><br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/652fad6c-33c1-41e4-96f0-ed4b2bbba496/%EA%B7%B8%EB%A6%BC2.png" title="" alt="그림2.png"><br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/3ba19b8c-1d67-4c80-a372-bd7e1891a4ef/%EA%B7%B8%EB%A6%BC3.png" title="" alt="그림3.png"><br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/91bc3d05-41bb-4698-bc5e-ddd9b37c21d3/%EA%B7%B8%EB%A6%BC4.png" title="" alt="그림4.png"><br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/98444606-26b7-45ce-8fb0-771c14a7e974/%EA%B7%B8%EB%A6%BC5.png" title="" alt="그림5.png"><br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/2e901864-518f-4168-bc85-0a3983e62ebd/%EA%B7%B8%EB%A6%BC6.png" title="" alt="그림6.png"><br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/da86dda4-d637-4790-afbe-2dffaf1a0d9e/%EA%B7%B8%EB%A6%BC7.png" title="" alt="그림7.png"><br>
<img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/8aa8bdfc-ef62-4d1a-9686-a176502ce4c3/%EA%B7%B8%EB%A6%BC8.png" title="" alt="그림8.png"></p>

<p>로봇에 입력된 명령어를 순서대로 담고 있는 문자열 <code>command</code>가 주어집니다. 로봇이 주어진 명령어들을 순서대로 모두 수행한 뒤 도착한 최종 위치의 좌푯값 x, y를 순서대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>commad</code>의 길이 ≤ 1,000,000</li>
<li><code>command</code>는 'R', 'L', 'G', 'B'으로 구성된 문자열입니다.</li>
<li><code>command</code>에 들어있는 문자 하나하나가 각 명령을 나타내며, 문자열에 먼저 등장하는 명령을 먼저 수행해야 합니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>command</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td><code>"GRGLGRG"</code></td>
<td>[2, 2]</td>
</tr>
<tr>
<td><code>"GRGRGRB"</code></td>
<td>[2, 0]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>문제 예시와 같습니다.</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<ul>
<li>로봇이 이동한 좌표는 (0, 0) → (0, 1) → (1, 1) → (1, 0) → (2, 0) 입니다.</li>
</ul>
</div>
    </div>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/courses/15009/lessons/121687

