def solution(x):
    answer = True
    num_list = list(map(int, str(x)))
    if x % sum(num_list) != 0:
        answer = False
    return answer