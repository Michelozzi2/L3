# -*- coding: utf-8 -*-
"""
Created on Thu Dec 14 13:56:20 2023

@author: matth
"""
"""
import numpy as np 
Prix = [0, 4, 4 ,3 ,3, 5 ,5 ,3 ,3 ,5 ,6 ,5 ,5]
Poids = [0 ,5 ,7 ,2 ,2 ,6 ,8 ,3 ,4 ,9 ,11 ,8 ,7]
MaxP = 15
Cout = np.zeros((len(Prix)+1,MaxP+1))


for i in range(1, len(Prix)):
    for w in range(1, MaxP+1):
        if w > Poids[i]:
            Cout[i,w] = max(Cout[i-1,w],
                            Cout[i-1, w-Poids[i]]+Prix[i])
        else:
            Cout[i,w] = Cout[i-1,w]
            
"""
"""
import numpy as np
Mot1 = '-DISTANCES'
Mot2 = '-DETENTES'
PLSS = np.zeros((len(Mot1),len(Mot2)))

for m in range(1, len(Mot1)):
    for n in range(1, len(Mot2)):
        PLSS[m,n] = max(PLSS[m-1, n], PLSS[m, n-1], PLSS[m-1,n-1] + int(Mot1[m] == Mot2[n]))

"""

import numpy as np
Gen1 = '-ACTGACC'
Gen2 = '-AGTCAC'
D = np.zeros((len(Gen2), len(Gen1)))

for i in range(1, len(Gen2)) : D[i,0]=i
for i in range(1, len(Gen1)) : D[0,i]=i
    
for m in range(1, len(Gen2)):
    for n in range(1, len(Gen1)):
        plus = 0
        if Gen2[m]!=Gen1[n] :plus = 1
        D[m,n] = min(D[m-1,n]+1, D[m,n-1]+1, D[m-1, n-1]+plus)









"""
import numpy as np 


Prix = [0, 2, 5, 6, 9, 10, 12, 14, 15]
Best = [0]*len(Prix)
Prec = [0]*len(Prix)


def découpe() :
    global Prix, Prec, Best
    for i in range(1, len(Prix)) :
        Best[i] = Prix[i]
        Prec[i]=i
        for j in range(1, i):
            val = Prix[j]+Best[i-j]
            if val > Best[i]:
                Best[i] = val
                Prec[i]=j
                
découpe()

"""

"""
compter = 0


def fibonacci(n):
    global compter
    compter += 1
    if (n==0) or (n==1):
        return 1
    return fibonacci(n-1) + fibonacci(n-2)

res = fibonacci(30)

Fib = [0]*100
Fib[0] = Fib[1] = 1

def fibonacci(n):
    global compter
    
    for i in range(2, n+1):
        compter += 1
        Fib[i] = Fib[i-1] + Fib[i-2]
        
fibonacci(30)
"""