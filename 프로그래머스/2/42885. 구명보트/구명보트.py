import math

def solution(people, limit):
    answer = 0
    start = 0
    end = len(people) - 1
    
    people.sort(reverse = True)
    
    for p in people:
        if end <= start:
            break
            
        if people[start] + people[end] <= limit:
            print(start)
            print(end)
            answer += 1
            end -= 1
            start += 1
        else:
            start += 1
    print(answer)
    answer += len(people) - answer * 2
    return answer