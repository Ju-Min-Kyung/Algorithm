def solution(s):
    answer = list(map(str, s))
    for ans in range(0, len(answer)):
        for oth in range(ans + 1, len(answer)):
            if answer[ans] < answer[oth]:
                answer[ans], answer[oth] = answer[oth], answer[ans]
    answer = ''.join(answer)
    return answer