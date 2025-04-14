def solution(s):
    answer = ''
    index = (len(s) - 1) // 2
    answer = s[index:len(s) // 2 + 1]
    return answer