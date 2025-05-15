def binary_search(n, array):
  left = 0
  right = len(array) - 1
  while left <= right:
    idx = (left + right) // 2
    if array[idx] == n:
      return True
    if array[idx] > n:
      right = idx - 1
    if array[idx] < n:
      left = idx + 1
  
  return False


N = int(input())
inputList = list(map(int, input().split()))

M = int(input())
array = list(map(int, input().split()))
inputList.sort()
for num in array:
  if binary_search(num, inputList):
    print("1")
  else:
    print("0")
