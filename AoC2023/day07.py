from collections import Counter

def main(joker):
    games = [[] for i in range(7)]
    with open('AoC2023/day07.txt') as f:
        for line in f:
            game = line.strip().split(' ')
            if joker:
                games[findJokerCategory(game[0])].append(game)
            else:
                games[findCategory(game[0])].append(game)
    
    sorted_games = sorting_cards(games, joker)

    points = 0
    for i in range(len(sorted_games)):
        points += (i+1) * int(sorted_games[i][1])
    
    return points

def findCategory(cards):
    count = Counter(cards)
    if len(count) == 1:
        return 6
    elif len(count) == 2:
        if 4 in count.values():
            return 5
        else:
            return 4
    elif len(count) == 3:
        if 3 in count.values():
            return 3
        else:
            return 2
    elif len(count) == 4:
        return 1
    else:
        return 0

def findJokerCategory(cards):
    c = list(cards)
    if 'J' in c:
        count = Counter(c)
        max = ['J',0]
        for char in count.keys():
            if not char == 'J' and count[char] > max[1]:
                max = [char, count[char]]
        
        for i in range(len(c)):
            if c[i] == 'J':
                c[i] = max[0]

    return findCategory(''.join(c))

def sorting_cards(games, joker):
    sorted_cards = []
    for category in games:
        if len(category) == 0:
            continue
        elif len(category) == 1:
            sorted_cards.append(category[0])
        else:
            sorted_category = sorting_category(category, joker)
            for draw in sorted_category:
                sorted_cards.append(draw)
    return sorted_cards


def sorting_category(category, joker):
    if joker:
        category.sort(key=getJokerKey)
    else:
        category.sort(key=getKey)
    return category

LVALUES = {
    'T' : 10,
    'J' : 11,
    'Q' : 12,
    'K' : 13,
    'A' : 14
}

def getKey(c):
    key = ""
    for card in c[0]:
        if card.isalpha():
            key = key + str(LVALUES[card])
        else:
            key = key + '0' + card
    
    return int(key)

LVALUESJOKER = {
    'T' : '10',
    'J' : '01',
    'Q' : '12',
    'K' : '13',
    'A' : '14'
}

def getJokerKey(c):
    key = ""
    for card in c[0]:
        if card.isalpha():
            key = key + LVALUESJOKER[card]
        else:
            key = key + '0' + card
    
    return int(key)

print(main(True))
