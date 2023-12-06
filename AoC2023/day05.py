def part1():
    phases = readInput()
    for seed in range(len(phases[0])):
        for i in range(1, len(phases)):
            phases[0][seed] = findNextStep(i, phases, phases[0][seed])
        
    return min(int(s) for s in phases[0])

def part2():
    phases = readInput()
    seedRun = []
    for s in range(0,len(phases[0]),2):
        for seed in range(phases[0][s], phases[0][s]+phases[0][s+1]):
            seedRun.append(seed)
            for i in range(1, len(phases)):
                seedRun[-1] = findNextStep(i, phases, seedRun[-1])
        print('one done.')
    
    return min(int(s) for s in seedRun)

def part2BetterHopefully(): #not true at all, is way worse, lol (but was kinda obvious actually)
    phases = readInput()
    seedRun = []
    lookUpDicts = makeDicts(phases[1:])
    for s in range(0,len(phases[0]),2):
        for seed in range(phases[0][s], phases[0][s]+phases[0][s+1]):
            seedRun.append(seed)
            for i in range(0, len(phases)-1):
                if seedRun[-1] in lookUpDicts[i].keys():
                    seedRun[-1] = lookUpDicts[i][seedRun[-1]]
    
    return min(int(s) for s in seedRun)

def makeDicts(ph):
    dicts = []
    for phase in ph:
        dicts.append({})
        for part in phase:
            for value in range(part[2]):
                dicts[-1][part[1]+value] = part[0] + value

        print('newDict')
    return dicts
    
                       
    
def findNextStep(i, phases, seedN):
    for ranges in phases[i]:
        dif = seedN-ranges[1]
        if dif >= 0 and dif < ranges[2]:
            return ranges[0]+dif
    
    return seedN

def readInput():
    phases = []
    with open('AoC2023/day05.txt') as f:
        for line in f:
            line = line.strip()
            if line and line[0].isalpha():
                phases.append([])
                if 'seeds:' in line:
                    seeds = line.strip().split(' ')[1:]
                    for i in range(len(seeds)):
                        seeds[i] = int(seeds[i])
                        
                    phases[-1] = seeds
            elif line and line[0].isdigit():
                numbers = line.split(' ')
                for i in range(len(numbers)):
                    numbers[i] = int(numbers[i])

                phases[-1].append(numbers)
    
    return phases

print(part2())