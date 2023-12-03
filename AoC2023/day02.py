AMOUNT = {
    "red" : 12,
    "green" : 13,
    "blue" : 14
}

def part1():
    gameNumbers = []

    with open('AoC2023/day02.txt') as f:
        for line in f:
            game, input = line.strip().split(":")
            if isPossible(input):
                gameNumbers.append(int(game.split(" ")[1]))
            
    return sum(gameNumbers)

def isPossible(input):
    rounds = input.split(";")
    for round in rounds:
        colors = round.split(",")
        for color in colors:
            amount, name = color.strip().split(" ")
            if int(amount) > AMOUNT[name]:
                return False
    
    return True

def part2():
    gameNumbers = []

    with open('AoC2023/day02.txt') as f:
        for line in f:
            _, input = line.strip().split(":")
            minAmounts = getMinAmounts(input)
            power = 1
            for a in minAmounts:
                power = power * minAmounts[a]
            
            gameNumbers.append(power)
            
    return sum(gameNumbers)

def getMinAmounts(input):
    minAmounts = {
        "red" : 0,
        "green" : 0,
        "blue" : 0
    }

    rounds = input.split(";")
    for round in rounds:
        colors = round.split(",")
        for color in colors:
            amount, name = color.strip().split(" ")
            if minAmounts[name] < int(amount):
                minAmounts[name] = int(amount)
    
    return minAmounts

print(part1())
print(part2())