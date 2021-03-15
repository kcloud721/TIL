n = int(input())
arr = input().split()
att = [0 for i in range(23)]

for i in range(n):
    att[int(arr[i])-1] += 1

for value in att:
    print(value, end=' ')
