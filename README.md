# Aigo-season-2

알고리즘 스터디를 위한 공간입니다. 사용 방법을 아래에 안내합니다.  
현재 `.gitignore`에 관련 처리가 되어 있는 언어는 아래와 같습니다.

<p>
    <img src="https://img.shields.io/badge/solve-C-%23A8B9CC?style=flat-square&logo=c"/>&nbsp
    <img src="https://img.shields.io/badge/solve-C++-%2300599C?style=flat-square&logo=c%2B%2B"/>&nbsp
    <img src="https://img.shields.io/badge/solve-Java-%23007396?style=flat-square&logo=java"/>&nbsp
    <img src="https://img.shields.io/badge/solve-Python-%233776AB?style=flat-square&logo=python"/>&nbsp
</p>

## 디렉터리 구조

프로젝트 디렉터리는 아래와 같은 구조로 작성됩니다.

```
/ (루트)
    /알고리즘 문제 출처
        /문제번호 대역 (* optional)
            /문제번호 또는 제목
                /팀원1
                    (소스 코드)
                /팀원2
                    (소스 코드)
                /팀원3
                    (소스 코드)
    .gitignore
    README.md
```

⭐️ 중요한 내용이니 꼭 숙지하고 작성하시기 바랍니다. ⭐️

- 알고리즘 문제 출처  
  해당 알고리즘 문제를 어디에서 가져왔는지를 기록합니다. 규모 있는 온라인 채점 사이트의 경우 해당 사이트명을 기록합니다.

- 문제번호 대역  
  풀이한 문제가 일정 이상이 되어 색인이 곤란한 경우 문제를 대역별로 나누어 저장할 수 있습니다.  
  현재 규칙은 아래와 같습니다.

  - BOJ : 1000 단위 (1000 ~ 1999, 2000 ~ 2999, ...)

- 문제번호 또는 제목  
  문제번호가 존재하는 경우 문제번호, 그렇지 않은 경우 해당 문제를 잘 나타내는 제목을 기록합니다.

- 팀원 디렉터리  
  각자의 문제풀이를 기록합니다. Git 저장소에 컴파일 결과물이 올라가지 않도록 주의해 주세요.  
  또, 기존에 사용되지 않던 언어로 풀이할 경우 관리자에게 알려 주고 `.gitignore` 에 관련 사항을 추가해 주세요.

## 커밋 메시지 작성 방법

아래와 같은 방법으로 작성하여 주시기 바랍니다.

- 동작  
  반드시 첫 대문자로 작성하며, 명령문으로 작성합니다. 다음과 같이 사용할 수 있습니다.  
  Add, Remove, Modify (code)

- 대상 (to)  
  어느 출처의 어떤 문제에 동작을 수행했는지를 나타냅니다. 다음과 같이 사용할 수 있습니다.  
  to Baek's quiz #10024, to kry's quiz "Quick sort"

- 작성자 (by)  
  해당 코드를 누가 작성하였는지를 나타냅니다. GitHub 사용자명으로, 다음과 같이 사용할 수 있습니다.  
  by kry-p

- 설명 (선택)  
  해당 commit에 대한 설명입니다. 문법에 어긋나지 않게 자유롭게 작성 가능하며, 한글도 허용됩니다.  
  제목과 2줄 띄워 작성합니다.

다음은 Commit message의 예시입니다.

```
Add code to Baek's quiz #10024 by kry-p

문제 풀이 예시 설명문입니다. 자유롭게 작성 가능합니다.
단, 한 줄이 너무 길어지지 않게 적절히 줄을 바꾸어 주세요.
```

## Q&A

이 저장소와 관련해 문의할 점이나 문제가 있는 경우 Issue 란이나 소유자에게 직접 문의해 주세요.
