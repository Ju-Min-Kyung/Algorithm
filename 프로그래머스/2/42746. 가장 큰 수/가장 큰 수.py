def solution(numbers):
    answer = ''
    strList = list(map(str, numbers))
               
    strList.sort(key = lambda x: x*3, reverse = True)
    answer = "".join(strList)

    return str(int(answer))
