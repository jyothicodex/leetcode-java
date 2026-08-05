# Merge Sorted Array (Brute Force)

## Problem
Merge two sorted arrays `nums1` and `nums2` into a single sorted array.

## Approach
- Create a temporary array `temp` of size `m + n`.
- Use three pointers:
  - `i` for `nums1`
  - `j` for `nums2`
  - `k` for `temp`
- Compare elements from both arrays and insert the smaller one into `temp`.
- Copy the remaining elements from either array.
- Copy the merged array back into `nums1`.

## Algorithm
1. Create a temporary array `temp` of size `m + n`.
2. Initialize `i = 0`, `j = 0`, `k = 0`.
3. While both arrays have elements (`i < m && j < n`):
   - If `nums1[i] <= nums2[j]`, store `nums1[i]` in `temp` and increment `i` and `k`.
   - Otherwise, store `nums2[j]` in `temp` and increment `j` and `k`.
4. Copy the remaining elements of `nums1` into `temp`.
5. Copy the remaining elements of `nums2` into `temp`.
6. Copy all elements from `temp` back into `nums1`.

## Time Complexity
- **O(m + n)**

## Space Complexity
- **O(m + n)**

## Java Code

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < m) {
            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            nums1[x] = temp[x];
        }
    }
}
```
