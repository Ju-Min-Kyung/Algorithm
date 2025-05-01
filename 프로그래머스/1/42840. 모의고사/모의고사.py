def solution(answers):
    answer = []
    first = [1, 2, 3, 4, 5] * (len(answers) // 5 + 1)
    second = [2, 1, 2, 3, 2, 4, 2, 5] * (len(answers) // 8 + 1)
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * (len(answers) // 10 + 1)
    firstCheck = 0
    secondCheck = 0
    thirdCheck = 0
    
    for a in range(len(answers)):
      
        if first[a] == answers[a]:
            firstCheck += 1
            
        if second[a] == answers[a]:
            secondCheck += 1
        if third[a] == answers[a]:
            thirdCheck += 1
    
    m = max(firstCheck, secondCheck, thirdCheck)
    checks = [firstCheck, secondCheck, thirdCheck]

    for i in range(len(checks)):
        if m == checks[i]:
            answer.append(i + 1)
    
    return answer