def solution(prices):
    answer = []
    check = False
    for i in range(0, len(prices)):
        for j in range(i+1, len(prices)):
            if prices[i] > prices[j]:
             
                answer.append(j - i)
                check = True
                break
        
        if check == False:
            answer.append(len(prices) - i - 1)
        check = False
    return answer