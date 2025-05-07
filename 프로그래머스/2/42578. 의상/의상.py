from itertools import combinations

def solution(clothes):
    answer = 1
    cDict = {}
    lenList = []
    combination = []
    for c in clothes:
        cDict[c[1]] = []
    for c in clothes:
        cDict[c[1]].append(c[0])
    for c in cDict:
        lenList.append(len(cDict[c]))
    
    for l in lenList:
        answer *= l + 1
    answer -= 1
    return answer