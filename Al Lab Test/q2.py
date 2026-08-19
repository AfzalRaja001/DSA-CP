from copy import deepcopy

DIRS = [(-1, 0), (0, 1), (1, 0), (0, -1)]   

def find_start(grid):
    for i, row in enumerate(grid):
        for j, c in enumerate(row):
            if c == 'S':
                return (i, j)

def valid(grid, x, y):
    rows, cols = len(grid), len(grid[0])
    return 0 <= x < rows and 0 <= y < cols and grid[x][y] != 'X'


def simple_reflex_agent(grid, max_steps=1000, loop_threshold=4):
    
    grid = deepcopy(grid)
    x, y = find_start(grid)
    visit_counts = {}
    inspected = set()
    movements = 0
    log = []
    stuck_in_loop = False
    total_inspect = sum(row.count('I') for row in grid)

    for _ in range(max_steps):
        visit_counts[(x, y)] = visit_counts.get((x, y), 0) + 1
        if visit_counts[(x, y)] >= loop_threshold:
            stuck_in_loop = True
            break

        if grid[x][y] == 'I':
            grid[x][y] = 'N'
            inspected.add((x, y))
            log.append(f"INSPECT at ({x},{y})")
            if len(inspected) == total_inspect:
                break
            continue

        moved = False
        for dx, dy in DIRS:
            nx, ny = x + dx, y + dy
            if valid(grid, nx, ny):
                x, y = nx, ny
                movements += 1
                log.append(f"MOVE to ({x},{y})")
                moved = True
                break
        if not moved:
            break

    repeated_visits = sum(c - 1 for c in visit_counts.values() if c > 1)
    return {
        "inspected": len(inspected),
        "movements": movements,
        "repeated_visits": repeated_visits,
        "log": log,
        "completed": len(inspected) == total_inspect,
        "stuck_in_loop": stuck_in_loop,
    }


def model_based_agent(grid, max_steps=200):
    
    grid = deepcopy(grid)
    x, y = find_start(grid)
    total_inspect = sum(row.count('I') for row in grid)

    visited = set()
    visit_counts = {}
    inspected = set()
    movements = 0
    log = []
    stack = [(x, y)]

    for _ in range(max_steps):
        visited.add((x, y))
        visit_counts[(x, y)] = visit_counts.get((x, y), 0) + 1

        if grid[x][y] == 'I':
            grid[x][y] = 'N'
            inspected.add((x, y))
            log.append(f"INSPECT at ({x},{y})")
            if len(inspected) == total_inspect:
                break
            continue

        unvisited_move = None
        for dx, dy in DIRS:
            nx, ny = x + dx, y + dy
            if valid(grid, nx, ny) and (nx, ny) not in visited:
                unvisited_move = (nx, ny)
                break

        if unvisited_move:
            x, y = unvisited_move
            stack.append((x, y))
        else:
            stack.pop()
            if not stack:
                break
            x, y = stack[-1]
        movements += 1
        log.append(f"MOVE to ({x},{y})")

    repeated_visits = sum(c - 1 for c in visit_counts.values() if c > 1)
    return {
        "inspected": len(inspected),
        "movements": movements,
        "repeated_visits": repeated_visits,
        "log": log,
        "completed": len(inspected) == total_inspect,
    }


if __name__ == "__main__":
    grid = [
        list("SNINX"),
        list("NXNNI"),
        list("INNXN"),
        list("NNINN"),
        list("XNNNI"),
    ]

    r1 = simple_reflex_agent(grid)
    r2 = model_based_agent(grid)

    print("Agent 1: Simple Reflex Agent")
    print("Locations inspected :", r1["inspected"])
    print("Movements           :", r1["movements"])
    print("Repeated visits     :", r1["repeated_visits"])

    print("\nAgent 2: Model-Based Reflex Agent")
    print("Locations inspected :", r2["inspected"])
    print("Movements           :", r2["movements"])
    print("Repeated visits     :", r2["repeated_visits"])


    