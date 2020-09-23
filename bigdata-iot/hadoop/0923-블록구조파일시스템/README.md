



# 0923 블록구조 파일시스템

## Namenode + Secondary Namenode + DataNode

![image-20200923110459000](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200923110459000.png)



1. jdk설치

2. hostname 및 ip주소 설정, 방화벽 비활성

3. SSH 설정

    ```bash
    $ ssh-copy-id -i /root/.ssh/id_dsa.pub root@mainserver
    $ ssh-copy-id -i /root/.ssh/id_dsa.pub root@dataserver
    $ ssh-copy-id -i /root/.ssh/id_dsa.pub root@secondserver
    /usr/bin/ssh-copy-id: INFO: Source of key(s) to be installed: "/root/.ssh/id_dsa.pub"
    The authenticity of host 'secondserver (192.168.111.121)' can't be established.
    ECDSA key fingerprint is SHA256:LPI/6+aXbLsbqvdx6VVEEQXTYZUF8Qv5slb99qFtfj0.
    ECDSA key fingerprint is MD5:da:73:52:2a:19:c7:71:cc:e9:29:1f:34:bf:38:ca:9a.
    Are you sure you want to continue connecting (yes/no)? yes
    /usr/bin/ssh-copy-id: INFO: attempting to log in with the new key(s), to filter out any that are already installed
    /usr/bin/ssh-copy-id: INFO: 1 key(s) remain to be installed -- if you are prompted now it is to install the new keys
    root@secondserver's password: 

    Number of key(s) added: 1

    Now try logging into the machine, with:   "ssh 'root@secondserver'"
    and check to make sure that only the key(s) you wanted were added.
    ```

4. SSH 키를 만들어서 컴퓨터 간 자유롭게 접속할 수 있도록 설정

    ```bash
    $ ssh secondserver
    Last login: Wed Sep 23 09:32:40 2020
    $ exit
    logout
    Connection to secondserver closed.
    $ ssh dataserver
    Last login: Wed Sep 23 09:32:48 2020
    $ exit
    logout
    Connection to dataserver closed.
    $ ssh mainserver
    Last login: Wed Sep 23 09:32:14 2020
    $ exit
    logout
    Connection to mainserver closed.
    ```

5. 비밀번호 필요없이 파일전송 가능

   ```bash
   $ scp /etc/hosts root@secondserver:/etc/hosts
   hosts                                         100%  314   125.4KB/s   00:00  
   ```

6. jdk설치 위해 설치파일 및 /etc/profile 전송

   ```bash
   $ scp ./jdk-8u261-linux-x64.tar.gz root@secondserver:/root
   jdk-8u261-linux-x64.tar.gz                    100%  136MB  34.1MB/s   00:04    
   $ scp ./jdk-8u261-linux-x64.tar.gz root@dataserver:/root
   jdk-8u261-linux-x64.tar.gz                    100%  136MB  29.7MB/s   00:04    
   $ scp /usr/bin/java root@dataserver:/usr/bin/java
   java                                          100% 8680     3.4MB/s   00:00    
   $ scp /usr/bin/java root@secondserver:/usr/bin/java
   java                                          100% 8680     4.1MB/s   00:00    
   ```

7. ssh로 원격접속하여 설치

    ```bash
    $ ssh root@secondserver tar xvf /root/jdk*
    $ ssh root@secondserver cp -r /root/jdk1.8.0 /usr/local
    ```

    ```bash
    $ ssh root@dataserver tar xvf /root/jdk*
    $ ssh root@dateserver cp -r /root/jdk1.8.0 /usr/local
    ```

8. 하둡다운로드

    ```bash
    $ wget https://archive.apache.org/dist/hadoop/common/hadoop-1.2.1/hadoop-1.2.1.tar.gz
    ```

9. /etc/profile 설정, 적용, 배포

    ```bash
    $ vi /etc/profile
    52 JAVA_HOME=/usr/local/jdk1.8.0
    53 CLASSPATH=/usr/local/jdk1.8.0/lib
    54 HADOOP_HOME=/usr/local/hadoop-1.2.1
    55 export JAVA_HOME CLASSPATH HADOOP_HOME
    56 PATH=$JAVA_HOME/bin:$HADOOP_HOME/bin:.:$PATH
    57 export PATH USER LOGNAME MAIL HOSTNAME HISTSIZE HISTCONTROL

    $ source /etc/profile
    $ scp /etc/profile root@secondserver:/etc/profile
    $ scp /etc/profile root@dataserver:/etc/profile
    ```

10. 환경설정 파일 수정 configuration

11. /usr/local/hadoop-1.2.1/

    ```bash
    $ vi hadoop.env.sh
    9 export JAVA_HOME=/usr/local/jdk1.8.0
    10 export HADOOP_HOME_WARN_SUPPRESS="TRUE"
    ```

    ```bash
    $ vi - core-site.xml
    <configuration>
    <property>
    <name>fs.default.name</name>
    <value>hdfs://mainserver:9000</value>
    </property>
    <property>
    <name>hadoop.tmp.dir</name>
    <value>/usr/local/hadoop-1.2.1/tmp</value>
    </property>
    </configuration>
    ```

    ```bash
    $ vi hdfs-site.xml
    <configuration>
    <property>
    <name>dfs.replication</name>
    <value>2</value>
    </property>
    <property>
    <name>dfs.webhdfs.enabled</name>
    <value>true</value>
    </property>
    <property>
    <name>dfs.name.dir</name>
    <value>/usr/local/hadoop-1.2.1/name</value>
    </property>
    <property>
    <name>dfs.data.dir</name>
    <value>/usr/local/hadoop-1.2.1/data</value>
    </property>
    </configuration>
    ```

    ```bash
    $vi mapred-site.xml
    <configuration>
    <property>
    <name>mapred.job.tracker</name>
    <value>mainserver:9001</value>
    </property>
    ```

    ```bash
    $ vi masters
    secondserver
    ```

    ```bash
    $ vi slaves
    secondserver
    dataserver
    ```



12. 셋팅 마친 후 hadoop폴더 압축 및 배포

    ```bash
    $ tar cvfz hadoop.tar.gz ./hadoop-1.2.1
    $ scp hadoop.tar.gz root@secondserver:/usr/local
    $ scp hadoop.tar.gz root@dataserver:/usr/local
    ```

13. 각 컴퓨터에서 압축 해제

    ```bash
    $ ssh root@secondserver tar xvf /usr/local/hadoop.tar.gz
    $ ssh root@dataserver tar xvf /usr/local/hadoop.tar.gz                                                      
    ```

14. 홈디렉토리에 압축해제 되어서 루트폴더로 옮김

    ```bash
    $ ssh root@dataserver mv /root/hadoop-1.2.1 /usr/local
    $ ssh root@secondserver mv /root/hadoop-1.2.1 /usr/local
    ```



15. 하둡 포맷, 실행
    
    ```bash
    $ hadoop namenode -format
    $ start-all.sh
    ```

16. 데이터 다운로드(2007.csv) 및 압축풀고 옮기기

    ```bash
    $ hadoop fs -mkdir /air
    $ hadoop fs -put 2007.csv  /air
    $ cd /usr/local/hadoop-1.2.1/
    ```

17. wordcount 빅데이터 분석

    ```bash
    $ hadoop jar hadoop-examples-1.2.1.jar wordcount /air /outpu
    ```



### 분산 시스템 쪼개기

mainserver + secondeserver + dataserver 세 개로 나뉘어진 것을 mainserver로만 운용

1. hadoop 중지

   ```bash
   $ stop-all.sh
   ```

2. /usr/local/hadoop-* 의 데이터 삭제

   ```bash
   $ rm -rf name data tmp
   ```

3. 환경설정 변경

   * core-site.xml

     name을 로컬호스트로 변경 (mainserver도 되는듯)

     ```xml
     <property>
     <name>fs.default.name</name>
     <value>hdfs://localhost:9000</value>
     </property>
     ```

   * hdfs-site.xml

     replication 1로 변경

     ```xml
     <property>
     <name>dfs.replication</name>
     <value>1</value> 
     </property>
     ```

   * mapred-stie.xml

     tracker 로컬호스트로 변경

     ```xml
     <property>
     <name>mapred.job.tracker</name>
     <value>localhost:9001</value>
     </property>
     ```

   * masters

     ```bash
     mainserver
     ```

   * slaves

     ```bash
     mainserver
     ```

4. 포맷 후 재실행

   ```bash
   $ hadoop namenode -format
   $ start-all.sh
   ```

   



# 하둡 분산 파일 시스템

# HDFS

| 대용량 파일 시스템             | 특징                                                         |
| ------------------------------ | ------------------------------------------------------------ |
| DAS (Direct-Attached Storage)  | 서버에 직접 연결된 스토리지. 외장형 하드디스크로 이해.       |
| NAS (Network-Attached Storage) | 가정, 회사 부서 같은 작은 단위의 파일 서버. 별도 운영체제 필요. 파일 시스템을 안정적으로 공유 가능 |
| SAN (Storage Area Network)     | 수십, 수백 대의 SAN 스토리지를 데이터 서버에 연결해 총괄적으로 관리해주는 네트워크. 규모 가장 큼 |

