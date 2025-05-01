def solution(brown, yellow):
    answer = []
    ex = makeArray(brown + yellow)
    for w, h in ex:
        yellowW = w - 2
        if yellow % yellowW == 0:
            yellowH = yellow // yellowW
            brownW = yellowW + 2
            if w == brownW:
                if yellowH * 2 + brownW * 2 == brown:
                    return [w, h]

def makeArray(num):
    array = []
    for n in range(3, num // 2):
        if num % n == 0 and n >= num // n:
            array.append((n, num // n))
        
    return list(set(array))