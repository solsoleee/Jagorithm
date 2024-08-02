list=[]
for i in range(30):
    list.append(0)
for i in range(28):
    a=int(input())
    list[a-1]=1
for i in range(30):
    if(list[i]==0):
        print(i+1)