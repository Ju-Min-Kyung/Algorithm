N = int(input())
words = []
for n in range(N):
  words.append(input())

w = sorted(set(words), key = lambda x: (len(x), x))

for word in w:
  print(word)
