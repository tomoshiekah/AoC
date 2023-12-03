NUMBERS = {
    "one" : 1, 
    "two" : 2, 
    "three" : 3, 
    "four" : 4, 
    "five" : 5, 
    "six" : 6, 
    "seven" : 7, 
    "eight" : 8, 
    "nine" : 9
}

def main(w):
    cValues = []

    with open('AoC2023/day01.txt') as f:
        for line in f:
            cValues.append(getCalibrationValue(w, line.strip()))
    return sum(cValues)

def getCalibrationValue(w, input):
    if w:
        first = findNumberW(input, True)
        last = findNumberW(input[::-1], False)
    else:
        first = findNumber(input)
        last = findNumber(input[::-1])

    return int(str(first) + str(last))

def findNumber(input):
    for char in input:
        if char.isdigit():
            return char
        
            
def findNumberW(input, first):
    for i in range(len(input)):
        if input[i].isdigit():
            return input[i]
        else:
            writtenN = checkIfNumber(input, i, first)
            if writtenN is not None:
                return writtenN

def checkIfNumber(input, index, first):
    for written in NUMBERS.keys():
        if not first:
            written = written[::-1]

        if input[index: index+len(written)] == written:
            if not first:
                return NUMBERS[written[::-1]]
            return NUMBERS[written]
        

print(main(False))
print(main(True))