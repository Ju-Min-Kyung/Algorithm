from itertools import permutations

def solution(numbers):
    answer = 0
    nums = [int(c) for c in numbers]
    p = permutations(nums)
    for c in range(1, len(nums)+1):
        p = list(set(permutations(nums, c)))
        for k in p:
            if k[0] == 0:
                continue
            n = int(''.join(str(x) for x in k))
            
            if isPrime(n):
                answer += 1
    return answer

def isPrime(num):
    i = 2
    if num < 2:
        return False
    elif num == 2:
        return True
    while i < num:
        if num % i == 0:
            return False
        i += 1
    
    return True