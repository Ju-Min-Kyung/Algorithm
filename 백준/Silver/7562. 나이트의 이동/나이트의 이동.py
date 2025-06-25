N = int(input())
for _ in range(N):
    I = int(input())
    c_x, c_y = map(int, input().split())
    l_x, l_y = map(int, input().split())

    graph = [[-1] * I for _ in range(I)]
    graph[c_x][c_y] = 0
    visited = [(c_x, c_y)]
    
    dx = [2, 2, -2, -2, 1, 1, -1, -1]
    dy = [1, -1, 1, -1, 2, -2, 2, -2]

    idx = 0
    while idx < len(visited):
        x, y = visited[idx]
        idx += 1

        if (x, y) == (l_x, l_y):
            break

        for i in range(8):
            nx, ny = dx[i] + x, dy[i] + y
            if 0 <= nx < I and 0 <= ny < I and graph[nx][ny] == -1:
                graph[nx][ny] = graph[x][y] + 1
                visited.append((nx, ny))

    print(graph[l_x][l_y])
