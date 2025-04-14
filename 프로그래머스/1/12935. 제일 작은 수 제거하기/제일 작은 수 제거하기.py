def solution(arr):
    answer = []
    min = 100000000000
    for n in arr:
        if n < min:
            min = n

    arr.remove(min)
    if not arr:
        arr.append(-1)
    return arr