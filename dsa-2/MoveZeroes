# LeetCode 283 - Move Zeroes

## Problem

Given an integer array `nums`, move all the `0`s to the end while maintaining the relative order of the non-zero elements.

The operation must be performed **in-place** without making a copy of the array.

### Example

```text
Input:
[0,1,0,3,12]

Output:
[1,3,12,0,0]
```

---

# Intuition

We want all **non-zero elements** to appear at the beginning of the array while preserving their order.

Use **Two Pointers**:

- `j` → Traverses the array.
- `i` → Points to the position where the next non-zero element should be placed.

Whenever we find a non-zero element, we swap it with the element at index `i`.

Since the entire array is returned (not just the first `k` elements like Remove Duplicates), **swapping is necessary** to move the zero toward the end.

---

# Algorithm

1. Initialize `i = 0`.
2. Traverse the array using pointer `j`.
3. If `nums[j]` is non-zero:
   - Swap `nums[i]` and `nums[j]`.
   - Increment `i`.
4. Continue until the end of the array.
5. The array is modified in-place.

---

# Dry Run

```text
nums = [0,1,0,3,12]

Initially

i = 0

---------------------------------

j = 0

nums[j] = 0

Skip

Array

[0,1,0,3,12]

---------------------------------

j = 1

nums[j] = 1

Swap nums[0] and nums[1]

[1,0,0,3,12]

i = 1

---------------------------------

j = 2

nums[j] = 0

Skip

---------------------------------

j = 3

nums[j] = 3

Swap nums[1] and nums[3]

[1,3,0,0,12]

i = 2

---------------------------------

j = 4

nums[j] = 12

Swap nums[2] and nums[4]

[1,3,12,0,0]

i = 3

Final Answer

[1,3,12,0,0]
```

---

# Code

```java
class Solution {
    public void moveZeroes(int[] nums) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != 0) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }
}
```

---

# Line-by-Line Explanation

## Step 1 : Initialize Pointer

```java
int i = 0;
```

- `i` points to the position where the next non-zero element should be placed.

---

## Step 2 : Traverse the Array

```java
for(int j = 0; j < nums.length; j++)
```

- `j` scans every element in the array.

---

## Step 3 : Check for Non-Zero

```java
if(nums[j] != 0)
```

If the current element is non-zero, it should be moved to the front.

---

## Step 4 : Swap

```java
int temp = nums[i];
nums[i] = nums[j];
nums[j] = temp;
```

Swap the non-zero element with the element at index `i`.

### Why Swap?

Unlike **Remove Duplicates**, we must return the **entire modified array**.

If we simply copied:

```java
nums[i] = nums[j];
```

the old zero would remain in its original position, creating duplicate values.

Swapping ensures:

- Non-zero element moves to the front.
- Zero automatically moves toward the end.
- Relative order of non-zero elements is preserved.

---

## Step 5 : Move Pointer

```java
i++;
```

The next non-zero element should be placed at the next position.

---

# Mistakes I Could Have Made

## ❌ Mistake 1 : Starting `i` from 1

```java
int i = 1;
```

### Why Wrong?

The first non-zero element should be placed at index `0`.

### ✅ Correct

```java
int i = 0;
```

---

## ❌ Mistake 2 : Incrementing `i` Every Iteration

```java
i++;
```

outside the `if` block.

### Why Wrong?

`i` should move **only after placing a non-zero element**.

### ✅ Correct

```java
if(nums[j] != 0){
    ...
    i++;
}
```

---

## ❌ Mistake 3 : Using Assignment Instead of Swap

```java
nums[i] = nums[j];
```

### Why Wrong?

This problem requires the **entire array** to be correctly modified.

Simply assigning loses the original value and does not move zeros to the end.

### ✅ Correct

```java
int temp = nums[i];
nums[i] = nums[j];
nums[j] = temp;
```

---

# Why We Used Swap Here but Not in Remove Duplicates?

## Remove Duplicates

```text
Return only first k unique elements.
```

The remaining elements are ignored.

So copying is sufficient.

```java
nums[k] = nums[j];
```

---

## Move Zeroes

```text
Return the entire modified array.
```

Every element matters.

Zeros must physically move to the end.

Therefore **swap** is required.

---

# Time Complexity

```text
O(n)
```

Each element is visited once.

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

- `i` → Position for the next non-zero element.
- `j` → Traverses the array.

---

# Key Takeaways

- Keep all non-zero elements together.
- Maintain their relative order.
- Swap only when a non-zero element is found.
- Increment `i` only after placing a non-zero element.
- Swapping is necessary because the entire array must be correctly modified.
