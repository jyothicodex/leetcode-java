# Sort Colors (LeetCode 75)

## Problem
Given an array `nums` containing only `0`s, `1`s, and `2`s, sort the array in-place without using the library sort function.

## Approach
Use the **Dutch National Flag Algorithm** with three pointers:
- `i` → Next position for `0`
- `j` → Current element being processed
- `k` → Next position for `2`

### Pointer Roles
- `i` keeps track of where the next `0` should be placed.
- `j` traverses the array.
- `k` keeps track of where the next `2` should be placed.

## Algorithm
1. Initialize three pointers:
   - `i = 0`
   - `j = 0`
   - `k = nums.length - 1`
2. Traverse the array while `j <= k`.
3. If `nums[j] == 0`:
   - Swap `nums[i]` and `nums[j]`.
   - Increment both `i` and `j`.
4. If `nums[j] == 1`:
   - Increment `j`.
5. If `nums[j] == 2`:
   - Swap `nums[j]` and `nums[k]`.
   - Decrement `k`.
   - Do **not** increment `j` because the swapped element must be checked.
6. Continue until `j > k`.

## Time Complexity
- **O(n)**

## Space Complexity
- **O(1)**

## Java Code

```java
class Solution {
    public void sortColors(int[] nums) {

        int i = 0, j = 0, k = nums.length - 1;

        while (j <= k) {

            if (nums[j] == 2) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            }

            else if (nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }

            else {
                j++;
            }
        }
    }
}
```
