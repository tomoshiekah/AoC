def part1():
    space = readInput()
    galaxies = findAllGalaxies(space)

    shortestPaths = []
    for galaxy in galaxies:
        galaxies.remove(galaxy)
        shortestPaths.append(findShortestPaths(galaxy, galaxies))
    return sum(shortestPaths)

def readInput():
    input = []
    with open('AoC2023/test.txt') as f:
        for line in f:
            input.append(line.strip())
            if '#' not in line:
                input.append(line.strip())
    
    return verticallyExpand(input)

def verticallyExpand(input):
    emptyRows = []
    for i in range(len(input[0])):
        if not verticalGalaxies(i, input):
            emptyRows.append(i)
            
    before = 0
    for row in emptyRows:
        for j in range(len(input)):
            input[j] = input[j][:row+before] + '.' + input[j][before+row:]
        before += 1

    return input

def verticalGalaxies(i, input):
    for horizontal in input:
        if horizontal[i] == '#':
            return True
    return False

def findAllGalaxies(space):
    galaxies = []
    for y in range(len(space)):
        for x in range(len(space[0])):
            if space[y][x] == '#':
                galaxies.append([y, x])

    return galaxies

def findShortestPaths(galaxy, galaxies):
    pathsLength = 0
    for other in galaxies:
        yLength = abs(galaxy[0] - other[0])
        xLength = abs(galaxy[1] - other[1])
        pathsLength += yLength + xLength
    
    return pathsLength

print(part1())

#TODO: Debug