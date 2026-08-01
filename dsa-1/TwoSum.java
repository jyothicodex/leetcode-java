# LeetCode 1 - Two Sum

## Pattern
- HashMap (Lookup)
- Array
- Complement Technique

## Difficulty
Easy

---

## Observation

- Array is **unsorted**.
- Need to return **indices**, not values.
- Two Pointers cannot be used directly because sorting changes indices.
- Need fast lookup while traversing.

---

## Brute Force

### Idea
Check every possible pair.

### Code

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++) {

            for(int j = i + 1; j < nums.length; j++) {

                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }
        }

        return new int[]{};
    }
}
```

### Complexity

Time: **O(n²)**

Space: **O(1)**

---

## Optimized Approach

### Idea

Store previously visited numbers in a HashMap.

For every element,

```
complement = target - nums[i]
```

If complement already exists in the HashMap, return both indices.

Otherwise store the current number and continue.

---

## Algorithm

1. Create a HashMap.
2. Traverse the array.
3. Compute complement.
4. Check if complement exists.
5. If yes, return answer.
6. Else store current number and index.
7. Continue.

---

## Code

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
```

---

## Dry Run

```
nums = [2,7,11,15]
target = 9
```

| i | nums[i] | complement | Map | Action |
|---|---------|------------|-----|--------|
|0|2|7|{}|Store 2→0|
|1|7|2|{2=0}|Found → Return {0,1}|

---

## Complexity

Time: **O(n)**

Space: **O(n)**

---

## Interview Notes

- Pattern: **HashMap Lookup**
- Why not Two Pointers? → Array is unsorted and sorting loses original indices.
- Key Formula:
  ```
  complement = target - nums[i]
  ```
- Always **check first**, then **insert**.
- HashMap stores:
  ```
  value → index
  ```

---

## Similar Problems

- 217. Contains Duplicate
- 219. Contains Duplicate II
- 1. Two Sum II (Sorted Array → Two Pointers)
- 560. Subarray Sum Equals K
