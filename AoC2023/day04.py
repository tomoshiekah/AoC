def part1():
    allGamePoints = []

    with open('AoC2023/day04.txt') as f:
        for line in f:
            w, o = line.strip().split(':')[1].split('|')

            winningNum = w.split(' ')
            winningNum = list(filter(('').__ne__, winningNum))
            ownNum = o.split(' ')
            ownNum = list(filter(('').__ne__, ownNum))

            points = 0.5
            for num in ownNum:
                if num in winningNum:
                    points = points*2
            
            if points == 0.5:
                points = 0
            
            allGamePoints.append(int(points))
    
    return sum(allGamePoints)

def part2():
    copiesOfCard = {}
    with open('AoC2023/day04.txt') as f:
        for line in f:
            g, numbers= line.strip().split(':')
            game = int(g.split(' ')[-1])

            w, o = numbers.split('|')

            winningNum = w.split(' ')
            winningNum = list(filter(('').__ne__, winningNum))
            ownNum = o.split(' ')
            ownNum = list(filter(('').__ne__, ownNum))

            if game not in copiesOfCard:
                copiesOfCard[game] = 1
            else:
                copiesOfCard[game] += 1
            
            amount = 0
            for num in ownNum:
                if num in winningNum:
                    amount += 1
            
            if amount > 0:
                for i in range(amount):
                    a = game+i+1
                    if a in copiesOfCard:
                        copiesOfCard[a] += 1*copiesOfCard[game]
                    else:
                        copiesOfCard[a] = 1*copiesOfCard[game]
        
    return sum(copiesOfCard.values())

                 

print(part2())