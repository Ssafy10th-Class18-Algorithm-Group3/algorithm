import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
M = list(map(int, input().split()))
Q = deque()
ans = [1]

for i in range(1, n):
    Q.append((M[i], i+1))

cnt = M[0]
while Q:
    if cnt > 0:
        for _ in range(cnt-1):
            Q.append(Q.popleft())
        value, idx = Q.popleft()
    else:
        for _ in range(-cnt-1):
            Q.appendleft(Q.pop())
        value, idx = Q.pop()
    cnt = value
    ans.append(idx)

print(*ans)
