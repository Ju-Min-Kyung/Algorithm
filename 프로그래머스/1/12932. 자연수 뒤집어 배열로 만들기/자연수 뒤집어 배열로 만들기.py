def solution(n):
    answer = []
    input = n
    while input > 0:
        answer.append(input % 10)
        input = input // 10

    return answer