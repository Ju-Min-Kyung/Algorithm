def findTriangle(a, b, c):
  if a*a == b*b + c*c:
    print("right")
  else:
    print("wrong")


while(1):
  triangle = list(map(int, input().split()))
  triangle.sort(reverse=True)
  a = triangle[0]
  b = triangle[1]
  c = triangle[2]

  if a == 0 and b == 0 and c == 0:
    break
  else:
    findTriangle(a, b, c)


