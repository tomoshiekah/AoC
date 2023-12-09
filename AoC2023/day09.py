def main(next=True):
    values = readInput()
    nextValues = []
    for value in values:
        nextValues.append(getNextValues(value, next))

    return sum(nextValues)

def readInput():
    values = []
    with open('AoC2023/day09.txt') as f:
        for line in f:
            l = line.strip().split(' ')
            s = [int(i) for i in l]
            values.append(s)

    return values

def getNextValues(history, next):
    if all(x == 0 for x in history):
        return 0
    else:
        distances = []
        for i in range(len(history)-1):
            distances.append(history[i+1]-history[i])
        
        if next:
            return history[-1]+getNextValues(distances, next)
        else:
            return history[0]-getNextValues(distances, next)
    
print(main(next=False))