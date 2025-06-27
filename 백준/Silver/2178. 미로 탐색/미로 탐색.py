from collections import deque
N, M = map(int, input().split()) 
graph = []
for i in range(N):
  line = input().strip()
  row = list(map(int, line))
  graph.append(row)

c_row = (0, 0)
l_row = (N-1, M-1)
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
q = deque()
q.append(c_row)


while q:
  x, y = q.popleft()

  for i in range(len(dx)):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
      q.append((nx, ny))
      graph[nx][ny] = graph[x][y] + 1

print(graph[N-1][M-1])