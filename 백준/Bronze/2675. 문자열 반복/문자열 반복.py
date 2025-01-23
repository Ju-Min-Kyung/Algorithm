n = int(input())
data = []
for i in range(n):
  temp = input().split()
  num = int(temp[0])
  text = temp[1]
  data.append((num, text))
  
for case in data:
    for letter in case[1]:
       print(letter * case[0], end = "")
    print("")