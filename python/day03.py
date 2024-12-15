import re


def solve1(problem_input: str) -> int:
    pattern = r"mul\(\d{1,3},\d{1,3}\)"
    matches = re.findall(pattern, problem_input)
    total = 0
    for match in matches:
        first, second = match.replace("mul(", "").replace(")", "").split(",")
        total += (int(first) * int(second))
    return total


def solve2(problem_input):
    pass


if __name__ == '__main__':
    with open("inputs/day03.txt") as file:
        print(solve1(file.read()))
