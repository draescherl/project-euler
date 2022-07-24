import sys
sys.setrecursionlimit(2000)

def factorize(x, divider=2, list=[]):
    cond = divider * divider > x
    if not cond and x % divider == 0:
        return factorize(x / divider, divider,     list + [divider])
    if not cond:
        return factorize(x,           divider + 1, list)
    if cond:
        return list + [int(x)]

print(factorize(600851475143))
