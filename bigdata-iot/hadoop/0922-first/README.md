# Hadoop 개발 준비

## 







```bash
[root@hadoopserver .ssh]# ls
known_hosts
[root@hadoopserver .ssh]# ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa
Generating public/private dsa key pair.
Your identification has been saved in /root/.ssh/id_dsa.
Your public key has been saved in /root/.ssh/id_dsa.pub.
The key fingerprint is:
SHA256:4xYNKD6MN/fuga1fY8Cnl85qm3AlLGDiuRFGVUvVK8E root@hadoopserver
The key's randomart image is:
+---[DSA 1024]----+
|  ....oo..       |
| .   . oE .      |
|  + + o .. .     |
| o O o o.o.      |
|  = * o S.+      |
|   + + * O .     |
|  .   o O *      |
|       *.O .     |
|      .+Boo      |
+----[SHA256]-----+
[root@hadoopserver .ssh]# ls
id_dsa  id_dsa.pub  known_hosts
```

