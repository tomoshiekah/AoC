import numpy
import math

def part1():
    time, record = readInput()
    
    amounts = []
    for i in range(len(time)):
        amounts.append(amountBeatenRecord(time[i], record[i]))
    print(amounts)
    return  numpy.prod(amounts)

def part2():
    splitTime, splitRecord = readInput()
    time = ""
    record = ""
    for i in range(len(splitTime)):
        time += str(splitTime[i])
        record += str(splitRecord[i])
    time = int(time)
    record = int(record)

    return amountBeatenRecord(time, record)

def readInput():
    with open('AoC2023/day06.txt') as f:
        line = f.readline()
        time = [int(s) for s in line.split() if s.isdigit()]
        line = f.readline()
        distance = [int(s) for s in line.split() if s.isdigit()]
    
    return time, distance

def amountBeatenRecord(t, r):
    # rroll * rPress = r Gleichungssystem, idk ob sehr schlau oder sehr dumm
    # t = rroll + rPress
    # rroll = t - rPress
    # rroll = r/rPress
    # t - rPress = r/rPress
    # (t-rpress)*rpress = r
    # t*rpress - rpress^2 = r
    # - rpress^2 + t*rpress - r = 0
    # rpress1/2 = (-t +- sqrt(t^2 - 4*1*(-r)))/-2 mitternachtsformel
    upperEnd = math.floor((-t - math.sqrt(t**2 - 4 * r))/-2)

    lowerEnd = math.ceil((-t + math.sqrt(t**2 - 4 *(-1)*(-r)))/-2)

    if upperEnd*(t-upperEnd) == r:
        upperEnd -= 1
        lowerEnd += 1
    
    return upperEnd-lowerEnd +1

print(part2())