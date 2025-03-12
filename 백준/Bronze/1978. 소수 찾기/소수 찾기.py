count = int(input())
numbers = list(map(int, input().split()))

result = 0
for number in numbers:
  if number >= 2:
    for n in range(2, number+1):
      if number % n == 0:
        if n == number:
          result += 1
        else:
          break

print(result)
