import math
map = {}

def part1():
    directions = readInput()
    position = 'AAA'
    steps = 0
    while not position == 'ZZZ':
        position, steps = getPlace(position, directions, steps)
        print(steps, position)
    return steps

def part2():
    directions = readInput()
    positions = []
    for key in map.keys():
        if key[-1] == 'A':
            positions.append(key)

    steps = 0
    finished = False
    while not finished:
        positions, steps = getPlaces(positions, directions, steps)
        print(steps, positions)

        amount = 0
        for position in positions:
            if position[-1] == 'Z':
                amount += 1
        
        if amount == len(positions):
            finished = True
    return steps

def maybeBetterPart2():
    directions = readInput()
    positions = []
    for key in map.keys():
        if key[-1] == 'A':
            positions.append(key)

    steps = 0
    finished = False
    positionSteps = []
    while not finished:
        positions, steps = getPlaces(positions, directions, steps)
        print(steps, positions)

        for position in positions:
            if position[-1] == 'Z':
                positionSteps.append(steps)
                positions.remove(position)
        
        if len(positions) == 0:
            if not allFinished(steps, positionSteps):
                steps = findLowestAmount(positionSteps)
            finished = True

    return steps

def readInput():
    with open('AoC2023/day08.txt') as f:
        directions = f.readline().strip()
        mapList = f.readlines()[1:]
        for line in mapList:
            l = line.split('=')
            destination1 = l[1].strip()[1:4]
            destination2 = l[1].strip()[6:9]
            map[l[0].strip()] = [destination1, destination2] # map is available everywhere (!)

    return directions

def getPlace(position, directions, steps):
    if not directions:
        return position, steps
    elif directions[0] == 'R':
        i = 1
    else:
        i = 0
    
    steps += 1
    return getPlace(map[position][i], directions[1:], steps)

def getPlaces(positions, directions, steps):
    if not directions:
        return positions, steps
    elif directions[0] == 'R':
        i = 1
    else:
        i = 0
    
    steps += 1
    for n in range(len(positions)):
        positions[n] = map[positions[n]][i]
    return getPlaces(positions, directions[1:], steps)

def allFinished(steps, positionSteps):
    for pS in positionSteps:
        if not steps%pS == 0:
            return False
    return True

def findLowestAmount(positionSteps):
    lcm = 1
    for i in range(len(positionSteps)):
        lcm = abs(lcm*positionSteps[i]) // math.gcd(lcm, positionSteps[i])
    
    return lcm

print(maybeBetterPart2())