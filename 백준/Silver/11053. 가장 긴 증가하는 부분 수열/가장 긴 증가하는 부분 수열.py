N = int(input())
numbers = list(map(int, input().split()))
answer = [1 for _ in range(N)]

answer[0] = 1

for n in range(1, N):
  for k in range(0, n):
    if numbers[n] > numbers[k]:
      answer[n] = max(answer[n], answer[k]+1)
      
print(max(answer))

