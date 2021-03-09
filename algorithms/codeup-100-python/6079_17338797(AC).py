n = int(input())
sum = 0
i = 1

while True:
    if sum>=n:
        break
    else:
        sum+=i
        i+=1

print(i-1)
