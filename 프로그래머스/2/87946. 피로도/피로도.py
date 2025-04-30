from itertools import permutations

def solution(k, dungeons):
    answer = 0
    lists = permutations(dungeons, len(dungeons))
    test = []
    current = k
    for l in lists:
        for t in l:
            if current >= t[0]:
                current -= t[1]
                answer += 1
        test.append(answer)
        current = k
        answer = 0
    answer = max(test)
    return answer