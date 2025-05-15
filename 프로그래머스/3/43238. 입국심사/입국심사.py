def binary_search(n, times, left, right):
    
    while left <= right:
        mid = (left + right) // 2
        count = 0
        for time in times:
            count += mid // time
     
        if count >= n:
            right = mid - 1
        else:
            left = mid + 1
            
    return left

def solution(n, times):
    answer = 0
    times.sort()
    answer = binary_search(n, times, 1, max(times) * n)
    
    return answer