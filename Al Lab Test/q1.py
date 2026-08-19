from collections import deque

rows = int(input("Enter rows: "))
cols = int(input("Enter columns: "))

grid = []
start = None

print("Enter grid:")
for i in range(rows):
    row = input().split()
    grid.append(row)
    for j in range(cols):
        if row[j] == 'S':
            start = (i, j)

q = deque([start])
visited = {start}
parent = {}
target = None

while q:
    x, y = q.popleft()

    if grid[x][y] == 'E':
        target = (x, y)
        break

    for dx, dy in [(-1,0),(1,0),(0,-1),(0,1)]:
        nx, ny = x + dx, y + dy
        if 0 <= nx < rows and 0 <= ny < cols:
            if (nx, ny) not in visited and grid[nx][ny] in ('C', 'E'):
                visited.add((nx, ny))
                parent[(nx, ny)] = (x, y)
                q.append((nx, ny))

if target is None:
    print("No reachable emergency room")
else:
    path = []
    cur = target
    while cur != start:
        path.append(cur)
        cur = parent[cur]
    path.append(start)
    path.reverse()

    print(f"Nearest available emergency room: ({target[0]}, {target[1]})")
    print(f"Minimum number of movements: {len(path) - 1}")
    print("Route: " + " -> ".join(f"({r},{c})" for r, c in path))