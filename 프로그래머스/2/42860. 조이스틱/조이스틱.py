def solution(name):
    answer = 0
    n = len(name)

    for char in name:
        diff = min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)
        answer += diff

    move = n - 1 
    for i in range(n):
        next_idx = i + 1
        while next_idx < n and name[next_idx] == 'A':
            next_idx += 1
            
        move = min(move, 2 * i + n - next_idx)
        move = min(move, 2 * (n - next_idx) + i)

    answer += move
    return answer
