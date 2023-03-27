sum=0
N=int(input())
list=list(map(int,input().split()))
maxg=max(list)
for i in list:
    sum+=i/maxg*100
print(sum/len(list))