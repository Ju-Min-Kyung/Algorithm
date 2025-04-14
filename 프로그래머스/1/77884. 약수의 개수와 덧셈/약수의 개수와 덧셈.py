def solution(left, right):
    answer = 0
    for n in range(left, right + 1):
        if find(n):
            answer += n
        else:
            answer -= n
    return answer

def find(num):
    count = 0
    for n in range(1, num+1):
        if num % n == 0:
            count += 1
    
    if count % 2 == 0:
        return True
    else:
        return False