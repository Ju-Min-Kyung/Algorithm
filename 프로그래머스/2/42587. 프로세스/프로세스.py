import collections

def solution(priorities, location):
    answerQueue = []
    readyQueue = [(n, priorities[n]) for n in range(0, len(priorities))]
    
    while len(readyQueue) > 1:
        process = readyQueue.pop(0)
        if max(readyQueue, key = lambda t: t[1])[1] <= process[1]:
            answerQueue.append(process)
        else:
            readyQueue.append(process)
    answerQueue.append(readyQueue.pop(0))
    print(answerQueue)
    for idx in range(0, len(answerQueue)):
        if answerQueue[idx][0] == location:
            return idx + 1