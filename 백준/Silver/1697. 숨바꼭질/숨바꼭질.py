from collections import deque

N, K = map(int, input().split())
graph = [0] * 1000001
visited = [False] * 1000001

dx = [1, -1]
q = deque()

q.append(N)

while q:
  head = q.popleft()
  visited[head] = True
  if head == K:
    break
  
  nx_2 = head * 2
  if 0<= nx_2 < len(graph) and not visited[nx_2]:
    visited[nx_2] = True
    graph[nx_2] = graph[head] + 1
    q.append(nx_2)
  
  for i in range(2):
    nx = head + dx[i]
  
    if 0 <= nx < len(graph) and not visited[nx]:
      visited[nx] = True
      graph[nx] = graph[head] + 1
      q.append(nx)

print(graph[K])