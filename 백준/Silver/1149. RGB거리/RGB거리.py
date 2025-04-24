N = int(input())
colors = [[0, 0, 0]] + [list(map(int, input().split())) for _ in range(N)]

cost = [[0, 0, 0] for _ in range(N+1)]
cost[1] = colors[1][:]

for i in range(2, N+1):
    cost[i][0] = colors[i][0] + min(cost[i-1][1], cost[i-1][2])
    cost[i][1] = colors[i][1] + min(cost[i-1][0], cost[i-1][2])
    cost[i][2] = colors[i][2] + min(cost[i-1][0], cost[i-1][1])

print(min(cost[N]))
