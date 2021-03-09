h = input()
n = int(h, 16)

for i in range(1, 16):
    answer = n*i
    # print(f'{h}*{i}={answer}')
    print('%X'%n, '*%X='%i, '%X'%answer, sep='')
