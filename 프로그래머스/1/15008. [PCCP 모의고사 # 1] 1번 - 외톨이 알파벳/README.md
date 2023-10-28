# [level 1] [PCCP 모의고사 #1] 1번 - 외톨이 알파벳 - 15008

[문제 링크](https://school.programmers.co.kr/learn/courses/15008/lessons/121683#)

### 성능 요약

메모리: 10.2 MB, 시간: 0.02 ms

### 구분

프로그래밍 강의 > PCCP 모의고사 1회

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 10월 28일 17:35:55

### 문제 설명

<div class="markdown solarized-dark"><p>알파벳 소문자로만 이루어진 어떤 문자열에서, 2회 이상 나타난 알파벳이 2개 이상의 부분으로 나뉘어 있으면 <code>외톨이 알파벳</code>이라고 정의합니다.</p>

<p>문자열 "edeaaabbccd"를 예시로 들어보면,</p>

<ul>
<li>a는 2회 이상 나타나지만, 하나의 덩어리로 뭉쳐있으므로 <code>외톨이 알파벳</code>이 아닙니다.

<ul>
<li><code>"ede(aaa)bbccd"</code></li>
</ul></li>
<li>b, c도 a와 같은 이유로 <code>외톨이 알파벳</code>이 아닙니다.</li>
<li>d는 2회 나타나면서, 2개의 부분으로 나뉘어 있으므로 <code>외톨이 알파벳</code>입니다.

<ul>
<li><code>"e(d)eaaabbcc(d)"</code></li>
</ul></li>
<li>e도 d와 같은 이유로 <code>외톨이 알파벳</code>입니다.</li>
</ul>

<p>문자열 "eeddee"를 예시로 들어보면,</p>

<ul>
<li>e는 4회 나타나면서, 2개의 부분으로 나뉘어 있으므로 <code>외톨이 알파벳</code>입니다.

<ul>
<li><code>"(ee)dd(ee)"</code></li>
</ul></li>
<li>d는 2회 나타나지만, 하나의 덩어리로 뭉쳐있으므로 <code>외톨이 알파벳</code>이 아닙니다.

<ul>
<li><code>"ee(dd)ee"</code></li>
</ul></li>
</ul>

<p>문자열 <code>input_string</code>이 주어졌을 때, <code>외톨이 알파벳</code>들을 <strong>알파벳순으로</strong> 이어 붙인 문자열을 return 하도록 solution 함수를 완성해주세요. 만약, <code>외톨이 알파벳</code>이&nbsp;없다면 문자열 <code>"N"</code>을 return 합니다.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>input_string</code>의 길이 ≤ 2,600</li>
<li><code>input_string</code>은 알파벳 소문자로만 구성되어 있습니다..</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>input_string</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td><code>"edeaaabbccd"</code></td>
<td><code>"de"</code></td>
</tr>
<tr>
<td><code>"eeddee"</code></td>
<td><code>"e"</code></td>
</tr>
<tr>
<td><code>"string"</code></td>
<td><code>"N"</code></td>
</tr>
<tr>
<td><code>"zbzbz"</code></td>
<td><code>"bz"</code></td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>문제 예시와 같습니다.</li>
<li><code>외톨이 알파벳</code>인 e, d를 알파벳순으로 이어 붙여 문자열을 만들면 "de"가 됩니다.</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<ul>
<li>문제 예시와 같습니다.</li>
</ul>

<p><strong>입출력 예 #3</strong></p>

<ul>
<li>모든 문자들이 한 번씩만 등장하므로 <code>외톨이 알파벳</code>이 없습니다.</li>
</ul>

<p><strong>입출력 예 #4</strong></p>

<ul>
<li><code>외톨이 알파벳</code>인 z, b를 알파벳순으로 이어 붙여 문자열을 만들면 "bz"가 됩니다.</li>
</ul>
</div>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/courses/15008/lessons/121683#