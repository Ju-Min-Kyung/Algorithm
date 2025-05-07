def solution(phone_book):
    answer = True
    sb = set(phone_book)
    phone_book.sort()
    for ph in phone_book:
        for s in range(len(ph)):
            if ph[:s] in sb:
                answer = False
                break
    return answer