N,M=map(int,input().split())
list=[]
for i in range(N):
    list.append(0)
for i in range(M):
    a,b,c=map(int,input().split())
    for j in range(a,b+1):
        list[j-1]=c
for i in list:
    print(i, end=" ")