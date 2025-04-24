str1 = input()
str2 = input()

answer = [[0 for _ in range(len(str2) + 1)] for _ in range(len(str1) + 1)]

for s1 in range(1, len(str1)+1):
  for s2 in range(1, len(str2)+1):
    if str1[s1-1] == str2[s2-1]:
      answer[s1][s2] = answer[s1-1][s2-1] + 1
    else:
      answer[s1][s2] = max(answer[s1-1][s2], answer[s1][s2-1]) 

print(answer[len(str1)][len(str2)])
