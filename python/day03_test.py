import unittest

from day03 import solve1, solve2


class Day03(unittest.TestCase):

    def test1_example_input(self):
        example_input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        self.assertEqual(161, solve1(example_input))

    def test2_example_input(self):
        example_input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
        self.assertEqual(161, solve2(example_input))
