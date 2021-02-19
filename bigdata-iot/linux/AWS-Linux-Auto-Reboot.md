# Amazon Linux 자동 재부팅 (cron)

1. timezone 변경 (to KST)
2. CRON 자동 재부팅 설정

## 1. timezone 변경

1. 현재시간 확인

   ```bash
   $ date
   2021. 02. 17. (수) 03:15:12 UTC
   ```

   Amazon Linux 시간은 따로 설정하지 않았을 경우 UTC로 설정이 되어 있는 듯 하다. 이를 서울 시간으로 바꿔준다.

2. 서울 파일 확인

   ```bash
   $ ls /usr/share/zoneinfo/Asia
   ```

3. localtime 재설정

   ```bash
   $ sudo ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
   ```

4. 변경된 시간 확인

   ```bash
   $ date
   2021. 02. 17. (수) 12:45:13 KST
   ```



## 2. CRON 자동 재부팅 설정

매일 새벽 4시 서버를 재부팅하도록 설정하고자 한다.

1. cron 편집모드 실행

   ```bash
   $ crontab -e
   ```

   

2. 명령어 추가 후 저장

   ```bash
   00 04 * * * sudo /sbin/reboot
   ```

   root reboot, reboot -f 등 여러 버전의 명령어가 있던데 Amazon Linux의 ec2-user 계정에서는 위의 명령어가 제대로 작동한다.

   

3. 명령 등록 되었는지 확인

   ```bash
   $ crontab -l
   00 04 * * * sudo /sbin/reboot
   ```

   

4. cron 서비스 재시작

   ```bash
   $ sudo service crond restart
   Stopping crond:                                            [  OK  ]
   Starting crond:                                            [  OK  ]
   ```

   OS 버전에 따라 다르게 나오기도 하나봄

   ```bash
   $ sudo service crond restart
   Redirecting to /bin/systemctl restart crond.service
   ```



1분 후의 시간으로 설정하여 cron 실행을 테스트 해볼 수 있다. 만약 재부팅이 실행되지 않는다면 cron log 를 참조하면 됨.

* 로그 보기

  ```bash
  vi /var/spool/mail/ec2-user 
  ```

정상적으로 재부팅이 실행된다면 로그가 기록되지는 않는 듯 하다. cron 실행되면 바로 꺼져버려서 그런듯?