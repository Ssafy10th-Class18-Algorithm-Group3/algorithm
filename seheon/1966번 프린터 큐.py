import sys
input = sys.stdin.readline
from collections import deque

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    M = list(map(int, input().split()))
    A = []
    for i in range(n):
        if i == m:
            A.append((M[i], 1))
            continue
        A.append((M[i], 0))
    Q = deque(A)
    M.sort()
    cnt = 1
    while True:
        w, flag = Q.popleft()
        if M[-1] == w:
            if flag == 1:
                print(cnt)
                break
            M.pop()
            cnt += 1
        else:
            Q.append((w, flag))