from itertools import product

def solution(word):
    answer = 0
    n = len(word)
    result = []
    wList = ["A", "E", "I", "O", "U"]
    for i in range(1, 6):
        result += list(product(wList, repeat = i))
    
    result.sort()
    for k in range(len(result)):
        if ''.join(result[k]) == word:
            answer = k + 1
            break
    return answer