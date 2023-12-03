engine = []

def main(first):
    if not engine:
        with open('AoC2023/day03.txt') as f:
            file = f.readlines()
            for j in file:
                engine.append(j.strip())
    
    if first:
        return firstPart()
    else:
        return secondPart()
    

def firstPart():
    partNumbers = []

    for i in range(len(engine)):
        for partI in findParts(engine[i]):
            partNumbers.append(findAdjacentNumbers(i, partI))
    
    sumNumbers = 0
    for row in partNumbers:
        for element in row:
            sumNumbers += element

    return sumNumbers

def findParts(line):
    return [pos for pos, char in enumerate(line) if char != '.' and not char.isdigit()]

def findAdjacentNumbers(i, partI):
    adNumbers = []

    adNumbers.append(lookForNumber('left', i, partI))
    adNumbers.append(lookForNumber('right', i, partI))
    adNumbers.append(lookForNumber('up', i, partI))
    adNumbers.append(lookForNumber('down', i, partI))
    adNumbers.append(lookForNumber('lup', i, partI))
    adNumbers.append(lookForNumber('rup', i, partI))
    adNumbers.append(lookForNumber('ldown', i, partI))
    adNumbers.append(lookForNumber('rdown', i, partI))

    adNumbers = list(set(adNumbers))
    adNumbers.remove(0)
    return adNumbers

def lookForNumber(dir, i, partI):
    if dir == 'left' or dir == 'lup' or dir == 'ldown':
        if partI != 0:
            partI -= 1
        else:
            return 0
    elif dir == 'right' or dir == 'rup' or dir == 'rdown':
        if partI != len(engine[0])-1:
            partI += 1
        else:
            return 0
        
    if dir == 'up' or dir == 'lup' or dir == 'rup':
        if i != 0:
            i -= 1
        else:
            return 0
    elif dir == 'down' or dir == 'ldown' or dir == 'rdown':
        if i != len(engine)-1:
            i += 1
        else:
            return 0
        
    if engine[i][partI].isdigit():
        numberR = findRest(1, i, partI, engine[i][partI])
        numberL = findRest(-1, i, partI, engine[i][partI])
        return int(numberL + numberR[1:])
    else:
        return 0


def findRest(d, i, partI, partNum):
    if partI+d < len(engine[0]) and engine[i][partI+d].isdigit():
        if d == 1:
            return findRest(1, i, partI+d, partNum + engine[i][partI+d])
        else:
            return findRest(-1, i, partI+d, engine[i][partI+d] + partNum)
    else:
        return partNum
    
def secondPart():
    partNumbers = []

    for i in range(len(engine)):
        for partI in findGears(engine[i]):
            partNumbers.append(findAdjacentNumbers(i, partI))
    
    ratio = []
    for row in partNumbers:
        if len(row) == 2:
            temp = row[0]*row[1]
            ratio.append(temp)

    return sum(ratio)

def findGears(line):
    return [pos for pos, char in enumerate(line) if char == '*']

print(main(True))
print(main(False))