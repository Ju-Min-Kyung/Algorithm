def numberToStr(num):
  return list(map(int, num))

n = input()
s = input()

numbers = numberToStr(s)
print(sum(numbers))