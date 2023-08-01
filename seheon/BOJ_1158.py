import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
M = [int(x) for x in range(1, n+1)]
Q = deque(M)
ans = []

cnt = 0
while Q:
    x = Q.popleft()
    cnt += 1
    if cnt == k:
        cnt = 0
        ans.append(x)
        continue
    Q.append(x)

print("<", end="")
for i in range(n):
    if i == n-1:
        print(ans[i], end="")
        break
    print(ans[i], end=", ")
print(">", end="")