a, d, n = input().split()
a = int(a)
d = int(d)
n = int(n)
result = 1

for i in range(0, n):
    if i==0:
        result *= a
    else:
        result *= d

print(result)

