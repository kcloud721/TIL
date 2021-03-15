a, m, d, n = input().split()
a = int(a)
m = int(m)
d = int(d)
n = int(n)
result = 1

for i in range(0, n):
    if i==0:
        result = a
    else:
        result = result*m + d

print(result)

