# 🔢 Bit Manipulation — Check Odd or Even

## 1. Problem
Determine whether a number is **odd or even** using bit manipulation.

## 2. Main Challenge
Identify whether the **rightmost bit (bit 0)** is `0` or `1`.

- `0` → Even
- `1` → Odd

## 3. Brute Force
Use the modulo operator:

```java
if (n % 2 == 0)
    // Even
else
    // Odd

Time: O(1)
Space: O(1)

4. Optimal Approach / Intuition

The rightmost bit represents 2⁰ = 1.

Therefore:

Even numbers always have rightmost bit 0
Odd numbers always have rightmost bit 1

We already know how to check the i-th bit:

(n & (1 << i)) != 0

For the rightmost bit, i = 0:

(n & (1 << 0)) != 0

Since:

1 << 0 = 1

we get:

(n & 1) != 0
5. Algorithm
Take the number n.
Create a mask for bit position 0.
AND n with the mask.
If result is non-zero → Odd.
Otherwise → Even.
6. Pseudocode
if (n & 1) != 0
    Odd
else
    Even
7. Java Code
int n = 13;

if ((n & 1) != 0) {
    System.out.println("Odd");
} else {
    System.out.println("Even");
}
8. Complexity

Time: O(1)
Space: O(1)

9. Interview Explanation

"An even number has 0 as its rightmost bit, while an odd number has 1.
So I use AND with 1 to check bit 0: (n & 1) != 0 means odd."

10. Key Learning / Pattern
Need to check rightmost bit
        ↓
Bit position = 0
        ↓
1 << 0
        ↓
1
        ↓
n & 1

Pattern: Derive n & 1 from the general check i-th bit pattern instead of memorizing it.

11. My Mistakes While Solving
No major mistake.
Correctly derived odd/even from the rightmost bit.
Correctly connected it to the previously learned check-i-th-bit formula.
12. Similar Questions — Same Exact Pattern
Check whether the 0th bit of a number is set.
Given n, determine whether bit 0 is SET or NOT SET.
Check whether the least significant bit (LSB) is 1.

Core pattern: Check a specific bit using a mask + AND.
