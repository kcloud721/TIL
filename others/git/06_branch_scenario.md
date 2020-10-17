### ㄴ상황 1. fast-foward

> fast-foward는 feature 브랜치 생성된 이후 master 브랜치에 변경 사항이 없는 상황

1. feature/test branch 생성 및 이동

   ```bash
   $ git checkout -b feature/test
   ```

2. 작업 완료 후 commit

   ```bash
   $ touch test.html
   $ git add .
   $ git commit -m 'Complete test'
   ```


3. master 이동

   ```bash
   $ git checkout master
   $ git log --oneline
   3be2132 (HEAD -> feature/test) Complete test
   29b5ba6 (master) test2
   f6b788e (test) Init
   ```


4. master에 병합

   ```bash
   $ git merge feature/test
   업데이트 중 29b5ba6..3be2132
   Fast-forward
    test.hgtml | 0
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 test.hgtml
   ```


5. 결과 -> fast-foward (단순히 HEAD를 이동)

   ```bash
   $ git log --oneline
   3be2132 (HEAD -> master, feature/test) Complete test
   29b5ba6 test2
   f6b788e (test) Init
   ```

6. branch 삭제

   ```bash
   $ git branch -d feature/test  
   feature/test 브랜치 삭제 (과거 3be2132).
   ```
   
   

---

### 상황 2. merge commit

> 서로 다른 이력(commit)을 병합(merge)하는 과정에서 다른 파일이 수정되어 있는 상황
>
> git이 auto merging을 진행하고, commit이 발생된다.

1. feature/signout branch 생성 및 이동

   ```bash
   $ git checkout -b feature/signout
   ```

2. 작업 완료 후 commit

   ```bash
   $ touch signout.html
   $ git add .
   $ git commit -m 'Complete signout'
   $ git log --oneline
   3bf52db (HEAD -> feature/signout) Complete signout
   3be2132 (master) Complete test
   29b5ba6 test2
   f6b788e (test) Init
   ```

3. master 이동

   ```bash
   $ git checkout master
   $ git log --oneline  
   3be2132 (HEAD -> master) Complete test
   29b5ba6 test2
   f6b788e (test) Init
   ```

4. *master에 추가 commit 이 발생시키기!!*

   * **다른 파일을 수정 혹은 생성하세요!**

     ```bash
     $ touch hotfix.html
     $ git add .
     $ git commit -m 'Hotfix'
     [master 95e20ba] Hotfix
      1 file changed, 0 insertions(+), 0 deletions(-)
      create mode 100644 hotfix.html 
     $ git log --oneline
     95e20ba (HEAD -> master) Hotfix
     3be2132 Complete test
     29b5ba6 test2
     f6b788e (test) Init
     ```

5. master에 병합

   ```bash
   $ git merge feature/signout
   Merge made by the 'recursive' strategy.
    signout.html | 0
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 signout.html
   ```

   ![image-20200918134243297](md-images/image-20200918134243297.png)

6. 결과 -> 자동으로 *merge commit 발생*

   * vim 편집기 화면이 나타납니다.
   
   * 자동으로 작성된 커밋 메시지를 확인하고, `esc`를 누른 후 `:wq`를 입력하여 저장 및 종료를 합니다.
      * `w` : write
      * `q` : quit
      
   * 커밋이  확인 해봅시다.
   
7. 그래프 확인하기

   ```bash
   git log --oneline --graph
   *   5b9b5e1 (HEAD -> master) Merge branch 'feature/signout' into master
   |\  
   | * 3bf52db (feature/signout) Complete signout
   * | 95e20ba Hotfix
   |/  
   * 3be2132 Complete test
   * 29b5ba6 test2
   * f6b788e (test) Init
   ```

8. branch 삭제

   ```bash
   git branch -d feature/signout
   feature/signout 브랜치 삭제 (과거 3bf52db).
   ```

---

### 상황 3. merge commit 충돌

> 서로 다른 이력(commit)을 병합(merge)하는 과정에서 동일 파일이 수정되어 있는 상황
>
> git이 auto merging을 하지 못하고, 해당 파일의 위치에 라벨링을 해준다.
>
> 원하는 형태의 코드로 직접 수정을 하고 merge commit을 발생 시켜야 한다.

1. feature/board branch 생성 및 이동

   ```bash
   $ git checkout -b feature/board
   ```

   

2. 작업 완료 후 commit

   ```bash
   
   ```
   
   


3. master 이동

   ```bash
   $ git checkout master 
   'master' 브랜치로 전환합니다
   ```


4. *master에 추가 commit 이 발생시키기!!*

   * **동일 파일을 수정 혹은 생성하세요!**

     ```bash
     # README를 수정하고
     $ git add .
     $ git commit -m 'update README'
     [master 258d4cc] update READEME
      1 file changed, 1 insertion(+)
     ```

5. master에 병합

   ```bash
   $ git merge feature/board
   자동 병합: README.md
   충돌 (내용): README.md에 병합 충돌
   자동 병합이 실패했습니다. 충돌을 바로잡고 결과물을 커밋하십시오.
   ```
   
   


6. 결과 -> *merge conflict발생*

   ```bash
   $ git status
   현재 브랜치 master
   병합하지 않은 경로가 있습니다.
     (충돌을 바로잡고 "git commit"을 실행하십시오)
     (병합을 중단하려면 "git merge --abort"를 사용하십시오)
   # staging area
   # > 충돌나지 않은 파일
   커밋할 변경 사항:
   	새 파일:       board.html
   
   # 유사 working directory ...
   # > 충돌 일어난 파일
   병합하지 않은 경로:
     (해결했다고 표시하려면 "git add <파일>..."을 사용하십시오)
   	양쪽에서 수정:  README.md
   ```
   
   


7. 충돌 확인 및 해결

   ```bash
   # 해결하고
   $ git add .
   ```
   
   


8. merge commit 진행

    ```bash
    $ git commit
    ```

   * vim 편집기 화면이 나타납니다.
   
   * 자동으로 작성된 커밋 메시지를 확인하고, `esc`를 누른 후 `:wq`를 입력하여 저장 및 종료를 합니다.
      * `w` : write
      * `q` : quit
      
   * 커밋이  확인 해봅시다.
   
9. 그래프 확인하기

    ```bash
   $ git log --oneline --graph
   *   e69d8de (HEAD -> master) Merge branch 'feature/board' into master
   |\  
   | * b825a7b (feature/board) board & README
   * | 258d4cc update READEME
   |/  
   *   5b9b5e1 Merge branch 'feature/signout' into master
   |\  
   | * 3bf52db Complete signout
   * | 95e20ba Hotfix
   |/  
   * 3be2132 Complete test
   * 29b5ba6 test2
   * f6b788e (test) Init
    ```
   
   


10. branch 삭제

    ```bash
    $ git branch -d feature/board
    feature/board 브랜치 삭제 (과거 b825a7b).
    ```
    
    

![image-20200918142129340](md-images/image-20200918142129340.png)

