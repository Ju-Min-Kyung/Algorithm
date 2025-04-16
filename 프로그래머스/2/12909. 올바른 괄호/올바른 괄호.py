def solution(s):
    answer = True
    
    stack = []
    for w in s:
        if w == "(" :
            stack.append(w)
        else:
            if stack:
                stack.pop()
            else:
                return False
    
    if not stack:
        return True
    else:
        return False
