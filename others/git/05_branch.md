# Branch 기초 명령어

## 1. 브랜치 생성

* 브랜치 생성

  ```bash
  $ git branch {브랜치이름}
  ```
  
* 브랜치 목록

  ```bash
  $ git branch
  * master
    test
  ```
  
* 브랜치 이동
  
  ```bash
  $ git checkout test
  'test' 브랜치로 전환합니다
  ```
  
  
  

* 브랜치 생성 및 이동

  ```bash
  $ git checkout -b test2
  새로 만든 'test2' 브랜치로 전환합니다
  ```

* 브랜치 병합

  master branch로 이동 후 merge

  ```bash
  $ git log --oneline
  29b5ba6 (HEAD -> test2) test2
  f6b788e (test, master) Init
  
  $ git checkout master
  'master' 브랜치로 전환합니다
  
  $ git merge test2
  업데이트 중 f6b788e..29b5ba6
  Fast-forward
   test2.txt | 0
   1 file changed, 0 insertions(+), 0 deletions(-)
   create mode 100644 test2.txt
  ```

* 브랜치 삭제

  ```bash
  $ git branch -d test2
  test2 브랜치 삭제 (과거 29b5ba6).
  ```

  





* 

  

  