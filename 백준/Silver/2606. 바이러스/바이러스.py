from collections import deque

N = int(input()) #컴퓨터의 수
M = int(input()) #연결되어있는 컴퓨터 쌍의 수
graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)
for _ in range(M):
  i, j = map(int, input().split())
  graph[i].append(j)
  graph[j].append(i)
answer = 0

#bfs
q = deque()
q.append(1)
visited[1] = True

while q:
  head = q.popleft()

  for n in graph[head]:
    if visited[n]:
      continue
    q.append(n)
    visited[n] = True
    answer += 1

print(answer)

