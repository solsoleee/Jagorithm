N,M=map(int,input().split())
list=[i for i in range(1,N+1)]
for i in range(M):
    a,b=map(int,input().split())
    list[a-1:b]=list[a-1:b][::-1]
print(*list)