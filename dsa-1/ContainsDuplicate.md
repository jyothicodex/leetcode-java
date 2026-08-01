
# LeetCode 217 - Contains Duplicate

## Pattern
- HashSet (Lookup)
- Array
- Duplicate Detection

## Difficulty
Easy

---

## Observation

- We only need to determine whether a duplicate exists.
- We do not need the index or frequency of an element.
- While traversing the array, if an element has already been seen, we immediately return `true`.
- Since we only need to check whether an element exists, **HashSet** is the best choice.
- HashSet provides **O(1)** average lookup time.

---

# Brute Force

## Idea

Compare every element with every other element.

If any two elements are equal, return `true`.

---

## Algorithm

1. Traverse the array using index `i`.
2. Traverse the remaining array using index `j`.
3. If `nums[i] == nums[j]`, return `true`.
4. Otherwise continue searching.
5. If no duplicates are found, return `false`.

---

## Code

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {

        for(int i = 0; i < nums.length; i++) {

            for(int j = i + 1; j < nums.length; j++) {

                if(nums[i] == nums[j]) {
                    return true;
                }

            }
        }

        return false;
    }
}
```

---

## Complexity

**Time Complexity:** `O(n²)`

**Space Complexity:** `O(1)`

---

# Optimized Approach (HashSet)

## Idea

Instead of comparing every pair, store every visited element in a HashSet.

If the current element already exists in the HashSet, a duplicate is found.

Otherwise, insert the current element and continue.

---

## Why HashSet?

HashSet stores only unique elements.

```
Value
```

It allows

- O(1) average lookup
- O(1) average insertion

Thus reducing the time complexity from **O(n²)** to **O(n)**.

---

## Algorithm

1. Create an empty `HashSet<Integer>`.
2. Traverse the array.
3. Check whether the current element exists in the HashSet.
4. If it exists, return `true`.
5. Otherwise insert the current element into the HashSet.
6. Continue until the array ends.
7. Return `false` if no duplicates are found.

---

## Code

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {

            if(set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}
```

---

## Dry Run

**Input**

```
nums = [1,2,3,1]
```

| Current Element | HashSet | Action |
|-----------------|---------|--------|
|1|{}|Add 1|
|2|{1}|Add 2|
|3|{1,2}|Add 3|
|1|{1,2,3}|Duplicate Found → Return true|

**Output**

```
true
```

---

# Complexity Analysis

**Time Complexity:** `O(n)`

- Single traversal of the array.
- HashSet lookup and insertion take **O(1)** on average.

**Space Complexity:** `O(n)`

- In the worst case, all unique elements are stored in the HashSet.

---

# Interview Notes

### Pattern

✅ HashSet Lookup

---

### Key Observation

- Need to check whether an element has already been seen.
- No need to store index or frequency.
- Think **HashSet**.

---

### Why HashSet instead of HashMap?

HashSet stores only unique values.

HashMap stores

```
Key → Value
```

Since we only need to know whether an element exists, storing an extra value is unnecessary.

---

### Why not Sorting?

Sorting can also detect duplicates by comparing adjacent elements.

However,

- Sorting takes **O(n log n)** time.
- HashSet solves the problem in **O(n)**.

Therefore, HashSet is the optimal solution.

---

### Data Structure Used

```
HashSet<Value>
```

---

### Interview Keywords

- HashSet
- Lookup
- Duplicate Detection
- Unique Elements
- Single Pass
- Optimization

---

# Similar Problems

- 219. Contains Duplicate II
- 220. Contains Duplicate III
- 128. Longest Consecutive Sequence
- 349. Intersection of Two Arrays
- 1. Two Sum
