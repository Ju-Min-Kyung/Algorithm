def solution(n):
    answer = ''
    answer = "수박" * ((n + 1) // 2)
    if not n % 2 == 0:
        answer = answer[0:len(answer)-1]
    return answer