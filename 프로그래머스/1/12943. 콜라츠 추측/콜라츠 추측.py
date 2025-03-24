def solution(num):
    answer = 0
    check = 0
    if num == 1: 
        return 0
    else:
        while(num != 1 and check < 500):
            
            if num % 2 == 0:
                num = num // 2
            else:
                num = num * 3 + 1
            check += 1
        answer = check if check < 500 else -1
        return answer