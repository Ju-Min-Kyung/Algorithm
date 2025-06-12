def solution(s):
  
    if not (len(s) == 4 or len(s) == 6):
        return False
    else:
        for k in s:
            if ord(k) > 64:
                return False
        return True
  