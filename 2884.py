a,b=map(int,input().split())
if(b>=45):
    print(a, (b-45), sep=" ")
elif(a>=1 and b<45):
    print((a-1), ((b+60)-45))
elif(a<1 and b>=45):
    print(a+24-1,b-45)
else:
    print(a+24-1,(b+60)-45)