# RAID

## 여러 개의 하드디스크 추가하기 (p.333)

RAID > 마운트 과정을 통해 mydata 폴더에 하드디스크 붙임

sdb > 새로 추가한 하드디스크

```bash
$ ls -l sd*
brw-rw----. 1 root disk 8,  0  9월 21 09:26 sda
brw-rw----. 1 root disk 8,  1  9월 21 09:26 sda1
brw-rw----. 1 root disk 8,  2  9월 21 09:26 sda2
brw-rw----. 1 root disk 8, 16  9월 21 09:26 sdb
```

### fdisk 명령을 통한 파일시스템 생성

```bash
$ fdisk /dev/sdc	# [SCSI 0:2](sdc) 하드디스크 선택
$ Command : n		# 새로운 파티션 분할
$ Select : p		# Primary 파티션 선택
$ Partition number : 1	# 파티션 번호 1번 선택
$ First sector : 'enter'	# 시작섹터 번호입력 (default 값 입력 위해 그냥 엔터)
$ Last sector : 'enter'		# 마지막섹터 번호입력 (default 값 입력 위해 그냥 엔터)
$ Command : t		# 파일 시스템 유형 선택
$ Hex Code : fd		# 'Linux raid autodetect' 유형 번호 입력
$ Command : p		# 설정된 내용 확인
$ Command : w 		# 설정 저장
```



아래는 명령어 및 로그 풀버전

```bash
$ fdisk /dev/sdb
Welcome to fdisk (util-linux 2.23.2).

Changes will remain in memory only, until you decide to write them.
Be careful before using the write command.

Device does not contain a recognized partition table
Building a new DOS disklabel with disk identifier 0x262144e5.

Command (m for help): n
Partition type:
   p   primary (0 primary, 0 extended, 4 free)
   e   extended
Select (default p): p
Partition number (1-4, default 1): 1
First sector (2048-2097151, default 2048): 
Using default value 2048
Last sector, +sectors or +size{K,M,G} (2048-2097151, default 2097151): 
Using default value 2097151
Partition 1 of type Linux and of size 1023 MiB is set

Command (m for help): p

Disk /dev/sdb: 1073 MB, 1073741824 bytes, 2097152 sectors
Units = sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
Disk label type: dos
Disk identifier: 0x262144e5

   Device Boot      Start         End      Blocks   Id  System
/dev/sdb1            2048     2097151     1047552   83  Linux

Command (m for help): w
The partition table has been altered!

Calling ioctl() to re-read partition table.
Syncing disks.

```

### 포맷

```bash
$ mkfs.ext4 /dev/sdb1
mke2fs 1.42.9 (28-Dec-2013)
Filesystem label=
OS type: Linux
Block size=4096 (log=2)
Fragment size=4096 (log=2)
Stride=0 blocks, Stripe width=0 blocks
65536 inodes, 261888 blocks
13094 blocks (5.00%) reserved for the super user
First data block=0
Maximum filesystem blocks=268435456
8 block groups
32768 blocks per group, 32768 fragments per group
8192 inodes per group
Superblock backups stored on blocks: 
	32768, 98304, 163840, 229376

Allocating group tables: done                            
Writing inode tables: done                            
Creating journal (4096 blocks): done
Writing superblocks and filesystem accounting information: done
```

### 마운트 및 확인

```bash
$ mount /dev/sdb1 /mydata
$ ls -l /dev/sd*
brw-rw----. 1 root disk 8,  0  9월 21 09:26 /dev/sda
brw-rw----. 1 root disk 8,  1  9월 21 09:26 /dev/sda1
brw-rw----. 1 root disk 8,  2  9월 21 09:26 /dev/sda2
brw-rw----. 1 root disk 8, 16  9월 21 09:35 /dev/sdb
brw-rw----. 1 root disk 8, 17  9월 21 09:40 /dev/sdb1
```

### 마운트 해제

```bash
$ umount /dev/sdb1
```



## Linear RAID 구현 (p.356)

#### 하드디스크 9개 준비

1. VMware Edit virtual machine settings에서 하드디스크 9개 추가 (p. 358 참조)

2. 장착한 장치가 /dev 디렉터리에 있는지 확인

   ```bash
   $ ls -l /dev/sd*
   ```

#### fdisk 명령으로 파티션 생성

1.  /dev/sdb ~ /deb/sdj 까지 9개 같은 작업 반복

   ```bash
   $ fdisk /dev/sdc	# [SCSI 0:2](sdc) 하드디스크 선택
   $ Command : n		# 새로운 파티션 분할
   $ Select : p		# Primary 파티션 선택
   $ Partition number : 1	# 파티션 번호 1번 선택
   $ First sector : 'enter'	# 시작섹터 번호입력 (default 값 입력 위해 그냥 엔터)
   $ Last sector : 'enter'		# 마지막섹터 번호입력 (default 값 입력 위해 그냥 엔터)
   $ Command : t		# 파일 시스템 유형 선택
   $ Hex Code : fd		# 'Linux raid autodetect' 유형 번호 입력
   $ Command : p		# 설정된 내용 확인
   $ Command : w 		# 설정 저장	
   ```

2.  파티션 생성 확인

   ```bash
   $ ls /dev/sd*
   $ fdisk -l /dev/sdb; fdisk -l /dev/sdc
```
   
3.  mdadm 명령어를 사용한 RAID 구성

    ```bash
    $ mdadm --create /dev/md9 --level=linear --raid-devices=2 /dev/sdb1 /dev/sdc1
    ```

    * **mdadm 명령**

      ```bash
      --create /dev/md9	# md9 장치에 RAID 생성
      --level-linear 		# Linear RAID 지정. 0은 RAID 0 / 1은 RAID 1
      --raid-devices=2 /dev/sdb1 /dev/sdc1	# 2개의 하드디스크 사용, 각 장치 경로
      ```

4.  RAID 확인

    ```bash
    $ mdadm --detail --scan
    ```

5.   포맷  : 파티션 장치의 파일 시스템 생성

    ```bash
    $ mkfs.ext4 /dev/md9
    ```

6.   마운트할 디렉터리 생성

    ```bash
    $ mkdir raidLinear
    ```

7.   마운트 및 확인

    ```bash
    $ mount /dev/md9 /raidLinear
    $ df
    ```

8.   부팅시 자동 마운트 설정

    /etc/fstab 파일 밑에 아래와 같은 코드 추가

     ```bash
    /dev/md9	/raidLinear	ext4	defaults	0	0
     ```

9.  RAID 내용 확인

    ```bash
    $ mdadm --detail /dev/md9
    ```

    

### Next : 

1. RAID 0, RAID 5 구성
2. 고장내고 복구하기
3. RAID 6, RAID 1+0 구성
4. 고장내고 복구하기