from collections import Counter

def solution(nums):
    counter = Counter(nums)
    n = len(nums) // 2
    
    if n <= len(counter):
        answer = n
    else:
        answer = len(counter)
        
    return answer