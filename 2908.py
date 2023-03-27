A,B = input().split()

if(int(A[0:][::-1])<int(B[0:][::-1])):
    print(B[0:][::-1])
else:
    print(A[0:][::-1])
