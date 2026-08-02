# LeetCode 26 - Remove Duplicates from Sorted Array

## Problem

Given a **sorted** integer array `nums`, remove the duplicates **in-place** such that each unique element appears only once.

Return the number of unique elements (`k`).

### Example

```text
Input:
[1,1,2,2,3]

Output:
k = 3

Modified Array:
[1,2,3,_,_]
```

---

# Intuition

Since the array is **already sorted**, duplicate elements always appear next to each other.

Instead of creating a new array, we overwrite duplicate positions with the next unique element.

We use **Two Pointers**.

- `j` → Searches for the next unique element.
- `k` → Points to the position where the next unique element should be placed.

---

# Algorithm

1. If the array is empty, return `0`.
2. Initialize `k = 1`.
3. Traverse the array from index `1`.
4. Compare the current element with the last unique element (`nums[k-1]`).
5. If they are different:
   - Copy the current element to index `k`.
   - Increment `k`.
6. Return `k`.

---

# Dry Run

```text
nums = [1,1,2,2,3]

Initial

k = 1

j = 1

1 == 1

Duplicate
Skip

----------------

j = 2

2 != 1

nums[k] = nums[j]

[1,2,2,2,3]

k = 2

----------------

j = 3

2 == 2

Duplicate
Skip

----------------

j = 4

3 != 2

nums[k] = nums[j]

[1,2,3,2,3]

k = 3

Return 3
```

---

# Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int k = 1;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[k - 1]) {
                nums[k] = nums[j];
                k++;
            }

        }

        return k;
    }
}
```

---

# Line-by-Line Explanation

## Step 1 : Handle Empty Array

```java
if (nums.length == 0) {
    return 0;
}
```

If the array is empty, there are no unique elements.

---

## Step 2 : Initialize Pointer

```java
int k = 1;
```

- The first element is always unique.
- `k` stores the index where the next unique element should be placed.

---

## Step 3 : Traverse the Array

```java
for (int j = 1; j < nums.length; j++)
```

- `j` searches for the next unique element.
- Start from index `1` because index `0` is already considered unique.

---

## Step 4 : Compare

```java
if (nums[j] != nums[k - 1])
```

Compare the current element with the **last unique element**.

If they are different, we found a new unique element.

---

## Step 5 : Copy

```java
nums[k] = nums[j];
```

Store the new unique element at index `k`.

---

## Step 6 : Move Pointer

```java
k++;
```

Move `k` to the next position for the upcoming unique element.

---

## Step 7 : Return

```java
return k;
```

`k` represents the total number of unique elements.

---

# Mistakes I Made

## ❌ Mistake 1 : Started Loop from Index 0

```java
for(int j = 0; j < nums.length; j++)
```

### Why Wrong?

```text
nums[0] == nums[0]
```

The comparison is always false.

### ✅ Correct

```java
for(int j = 1; j < nums.length; j++)
```

---

## ❌ Mistake 2 : Compared with nums[k]

```java
nums[j] != nums[k]
```

### Why Wrong?

`k` points to the **next insertion position**, not the last unique element.

### ✅ Correct

```java
nums[j] != nums[k - 1]
```

---

## ❌ Mistake 3 : Used Swapping

```java
int temp = nums[k];
nums[k] = nums[j];
nums[j] = temp;
```

### Why Wrong?

The problem only requires the **first k elements** to be unique.

No need to preserve the remaining elements.

### ✅ Correct

```java
nums[k] = nums[j];
```

---

## ❌ Mistake 4 : Forgot Empty Array Case

Input

```text
[]
```

Expected Output

```text
0
```

### ✅ Correct

```java
if(nums.length == 0)
    return 0;
```

---

# Time Complexity

```text
O(n)
```

Each element is visited exactly once.

---

# Space Complexity

```text
O(1)
```

No extra data structure is used.

---

# Pattern Used

```text
Two Pointers
```

- `k` → Position to place the next unique element.
- `j` → Searches for the next unique element.

---

# Key Takeaways

- Since the array is **sorted**, duplicates are adjacent.
- No swapping is required.
- Simply overwrite duplicates.
- `k` always points to the next insertion position.
- `j` scans the array.
- Return `k` because it represents the number of unique elements.
