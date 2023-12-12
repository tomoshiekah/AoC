import math

pipes = []

def part1():
    start = readInput() # start[0]: y, start[1]: x, weil strings in Liste :/
    amount = startLoop(start)
    return math.floor(amount/2)

def readInput():
    with open('AoC2023/day10.txt') as f:
        input = f.readlines()
        start = [-1, -1]
        for i in range(len(input)):
            pipes.append(input[i].strip())
            if start[1] == -1:
                start = [i, pipes[i].find('S')]

    return start

def startLoop(s):
    print(str(s[0]+1), str(s[1]), pipes[s[0]+1][s[1]], NEXTDIR['down'].keys())
    if len(pipes) > s[0]+1 and pipes[s[0]+1][s[1]] in NEXTDIR['down'].keys():
        next = [s[0]+1, s[1]]
        dir = 'down'
    elif -1 < s[0]-1 and pipes[s[0]-1][s[1]] in NEXTDIR['up'].keys():
        next = [s[0]-1, s[1]]
        dir = 'up'
    elif -1 < s[1]-1 and pipes[s[0]][s[1]-1] in NEXTDIR['left'].keys():
        next = [s[0], s[1]-1]
        dir = 'right'
    else:
        next = [s[0], s[1]+1]
        dir = 'left'
    
    return getNextLoopIterative(dir, next)

NEXTDIR = {
    'down' : {
        '|' : 'down',
        'L' : 'right',
        'J' : 'left'
    },
    'up' : {
        '|' : 'up',
        '7' : 'left',
        'F' : 'right'
    },
    'left' : {
        '-' : 'left',
        'F' : 'down',
        'L' : 'up'
    },
    'right' : {
        '-' : 'right',
        '7' : 'down',
        'J' : 'up'
    }
}

NEXTI = {
    'down' : [1,0],
    'up' : [-1,0],
    'left' : [0,-1],
    'right' : [0,1]
}

def getNextLoopIterative(dir, pos):
    i = 1
    while not pipes[pos[0]][pos[1]] == 'S':
        dir = NEXTDIR[dir][pipes[pos[0]][pos[1]]] # update direction
        step = NEXTI[dir]
        pos = [pos[0] + step[0], pos[1] + step[1]] # update position
        i += 1
    return i



print(part1())