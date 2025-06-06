def solution(price, money, count):
    answer = 0
    k = price
    while k <= price * count:
        answer += k 
        k += price
    
    if answer <= money:
        return 0
    else:
        return answer - money