# RAID LVM

## 개념이해

* LVM [Local Volume Manger] : 논리 하드디스크 관리자
* Linear RAID와 비슷하지만 더 많은 기능
* 물리볼륨을 합쳐서 논리 그룹으로 만들 수 있음
  * 물리그룹 : /dev/sda1, /dev/sdb1 등의 파티션
  * 볼륨그룹 : 물리 볼륨을 합쳐서 1 개의 물리 그룹으로 만든 것
  * 논리그룹 : 볼륨 그룹을 1개 이상으로 나눈 것

## LVM 구현

![image-20200922173911923](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20200922173911923.png)

### 선행 작업

1. 하드디스크 추가

   VM Ware 머신 편집에서 SCSI 하드디스크 2GB, 3GB 추가

2. SCSI 하드디스크 파티션 할당

   ```bash
   $ fdisk /dev/sdb
   $ fdisk /dev/sdc
   n / p / 1 / <enter> / <enter> / t /8e / p / w
   ```

3.  물리적 볼륨 생성

   ```bash
   $ pvcreate /dev/sdb1
   $ pvcreate /dev/sdc1
   ```

4.  2 개의 물리 볼륨을 하나로 묶고 확인

   ```bash
   $ vgcreate myVG /dev/sdb1 /dev/sdc1
   $ vgdisplay
   ```



### LVM 구성

1. 논리 그룹 1GB / 3GB / 1GB로 나누고 확인

   ```bash
   $ lvcreate --size 1G --name myLG1 myVG		# myVG 아래 myLG1을 1GB 크기로 생성
   $ lvcreate --size 3G --name myLG2 myVG
   $ lvcreate --extents 100%FREE --name myLG3 myVG	#나머지 용량 모두 할당
   $ ls -l /dev/myVG
   합계 0
   lrwxrwxrwx. 1 root root 7  9월 22 09:28 myLG1 -> ../dm-0
   lrwxrwxrwx. 1 root root 7  9월 22 09:28 myLG2 -> ../dm-1
   lrwxrwxrwx. 1 root root 7  9월 22 09:29 myLG3 -> ../dm-2
   ```

2. 파일 시스템 생성

   ```bash
   $ mkfs.ext4 /dev/myVG/myLG1
   $ mkfs.ext4 /dev/myVG/myLG2
   $ mkfs.ext4 /dev/myVG/myLG3
   ```

3.  디렉토리 확인

   ```bash
   $ ls /dev/myVG
   myLG1  myLG2  myLG3
   ```

   폴더로 생성됨 확인