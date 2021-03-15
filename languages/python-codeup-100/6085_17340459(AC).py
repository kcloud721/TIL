w, h, b = input().split()
w = int(w)
h = int(h)
b = int(b)

size_bit = (w*h*b)/8
size_byte = size_bit / (2**10)
size_mb = size_byte / (2**10)
print("{0:.2f}".format(size_mb), "MB")
# print(round(size_mb, 2), "MB")

