from collections import deque

def dfs(node, graph, visited):
  if visited[node]:
    return
  
  print(node, end = ' ')
  visited[node] = True

  for n in graph[node]:
    dfs(n, graph, visited)

def bfs(node, graph, visited):
  q = deque()
  q.append(node)
  visited[node] = True

  while q:
    head = q.popleft()
    print(head, end = ' ')

    for n in graph[head]:
      if visited[n]:
        continue
      q.append(n)
      visited[n] = True


N, M, head = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
for _ in range(M):
  i, j = map(int, input().split())
  graph[i].append(j)
  graph[j].append(i)

for g in graph:
  g.sort()

dfs(head, graph, visited)
visited = [False] * (N + 1)
print()
bfs(head, graph, visited)

