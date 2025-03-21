def solution(x, n):
    answer = []
    for count in range(n):
        answer.append(x+count*x)
    return answer