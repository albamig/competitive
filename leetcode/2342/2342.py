from typing import List, Dict


class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        reduction = self.reduce(nums)

        res = -1
        for equal_sum_list in reduction:
            if len(equal_sum_list) >= 2:
                for i in range(0, len(equal_sum_list)):
                    for j in range(0, len(equal_sum_list)):
                        if i != j:
                            sum_eqs = equal_sum_list[i] + equal_sum_list[j]

                            if sum_eqs > res:
                                res = sum_eqs

        return res

    def reduce(self, nums: List[int]) -> List[List[int]]:
        red = {}
        for num in nums:
            sum_digits = self.get_digits_sum(num)

            if sum_digits in red:
                red[sum_digits].append(num)
            else:
                red.update({sum_digits: [num]})

        return list(red.values())

    def get_digits_sum(self, num: int) -> int:
        sum = 0
        while num != 0:
            sum = sum + (num % 10)
            num = num // 10

        return sum


if __name__ == '__main__':
    s = Solution()

    nums = [18, 43, 36, 13, 7]
    assert s.maximumSum(nums) == 54

    nums = [10, 12, 19, 14]
    assert s.maximumSum(nums) == -1

    nums = [368, 369, 307, 304, 384, 138, 90, 279, 35, 396, 114, 328, 251, 364, 300, 191, 438, 467, 183]
    assert s.maximumSum(nums) == 835
