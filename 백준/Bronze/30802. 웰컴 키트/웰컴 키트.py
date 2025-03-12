import math
p = int(input())
t_shirts = list(map(int, input().split()))

t_shirt_bundle, pen_bundle = map(int, input().split())

t_shirt_count = 0
pen_bundle_count = 0
pen_count = 0

for t in t_shirts:
  if t <= t_shirt_bundle and not(t == 0):
    t_shirt_count += 1
  else:
    t_shirt_count += math.ceil(t / t_shirt_bundle)

pen_bundle_count = p // pen_bundle
pen_count = p % pen_bundle

print(t_shirt_count)
print(pen_bundle_count, end=" ")
print(pen_count)