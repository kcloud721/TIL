h, b, c, s = input().split()
h = int(h)
b = int(b)
c = int(c)
s = int(s)

size_bit = (h*b*c*s)/8
size_byte = size_bit / (2**10)
size_mb = size_byte / (2**10)
print(round(size_mb, 1), "MB")

