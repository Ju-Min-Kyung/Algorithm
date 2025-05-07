def solution(participant, completion):
    answer = ''
    countDict = {}
    for p in participant:
        countDict[p] = 0
    
    for p in participant:
        countDict[p] += 1
    
    for c in completion:
        countDict[c] -= 1
    
    for p in participant:
        if countDict[p] > 0:
            answer = p
            break
    
    return answer