def solution(sizes):
    answer = 0
    result = []
    sizes.sort(key = lambda x: (x[0], x[1]), reverse = True)
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]:
            sizes[i][1], sizes[i][0] = sizes[i][0], sizes[i][1]
    
    w = max(sizes, key = lambda x: x[0])[0]
    h = max(sizes, key = lambda x: x[1])[1]
    answer = w * h
    return answer