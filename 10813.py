N,M=map(int,input().split())
list=[]
for i in range(1,N+1):
    list.append(i)
for i in range(M):
    a,b=map(int,input().split())
    list[a-1],list[b-1]=list[b-1],list[a-1]
for i in list:
    print(i,end=" ")