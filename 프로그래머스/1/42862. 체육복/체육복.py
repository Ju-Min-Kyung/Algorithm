def solution(n, lost, reserve):
    
    lostSet = set(lost) - set(reserve)
    reserveSet = set(reserve) - set(lost)
    for reserve in reserveSet :
        if reserve - 1 in lostSet:   
            lostSet.remove(reserve - 1)
            continue
        if reserve + 1 in lostSet:  
            lostSet.remove(reserve + 1)

        
    answer = n - len(lostSet)       
    
    
    return answer