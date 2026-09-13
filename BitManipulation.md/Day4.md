# Bit Manipulation — 3 Important Patterns

## 1. Odd / Even

### Problem
Check whether a number is odd or even using bit manipulation.

### Main Challenge
The **rightmost bit (bit 0)** tells whether a number is odd or even.

- `0` → Even
- `1` → Odd

### Brute Force
Use `% 2`.

- Time: `O(1)`
- Space: `O(1)`

### Optimal Intuition
The general bit-check pattern is:

`n & (1 << i)`

For bit `0`:

`n & (1 << 0)`

Since `1 << 0 = 1`:

`n & 1`

### Pattern

`(n & 1) != 0` → Odd

`(n & 1) == 0` → Even

### Algorithm
1. Perform `n & 1`.
2. If the result is non-zero → Odd.
3. Otherwise → Even.

### Pseudocode

if (n & 1) != 0
    Odd
else
    Even

### Java

if ((n & 1) != 0) {
    System.out.println("Odd");
} else {
    System.out.println("Even");
}

### Complexity
- Time: `O(1)`
- Space: `O(1)`

### Interview Explanation
"I check the least significant bit using `n & 1`. If it is `1`, the number is odd; otherwise, it is even."

### Key Learning
`n & 1` → **Check bit 0 → Odd / Even**


---

## 2. Power of 2

### Problem
Check whether a number `n` is a power of 2.

Examples:
`1, 2, 4, 8, 16, 32...`

### Main Challenge
A positive power of 2 contains **exactly one SET bit (`1`)**.

Examples:

`1  = 0001`  
`2  = 0010`  
`4  = 0100`  
`8  = 1000`

### Brute Force
Keep dividing `n` by `2` and check whether it reaches `1`.

- Time: `O(log n)`
- Space: `O(1)`

### Optimal Intuition
For a power of 2:

`n` → contains one `1`

`n - 1` → that `1` becomes `0`, and all bits to its right become `1`.

Example:

`8     = 1000`  
`8 - 1 = 0111`

Now:

`1000 & 0111 = 0000`

Therefore, if:

`n & (n - 1) == 0`

then `n` has only one SET bit.

We also need `n > 0`, because `0` is not a power of 2.

### Pattern

`n > 0 && (n & (n - 1)) == 0`

### Algorithm
1. Check `n > 0`.
2. Calculate `n & (n - 1)`.
3. If the result is `0`, `n` is a power of 2.
4. Otherwise, it is not.

### Pseudocode

if n > 0 AND (n & (n - 1)) == 0
    Power of 2
else
    Not a Power of 2

### Java

if (n > 0 && (n & (n - 1)) == 0) {
    System.out.println("Power of 2");
} else {
    System.out.println("Not a Power of 2");
}

### Complexity
- Time: `O(1)`
- Space: `O(1)`

### Interview Explanation
"A power of 2 has exactly one SET bit. `n & (n - 1)` removes the rightmost SET bit, so for a power of 2 the result becomes zero."

### Key Learning
`n & (n - 1)` → **Remove the rightmost SET bit**

Power of 2 check:

`n > 0 && (n & (n - 1)) == 0`


---

## 3. Rightmost SET Bit

### Problem
Find/isolate the **rightmost SET bit** of `n`.

A SET bit means a bit whose value is `1`.

### Main Challenge
Do not confuse:

- **Rightmost bit** → bit position `0`
- **Rightmost SET bit** → rightmost bit whose value is `1`

Example:

`12 = 1100`

Bit positions:

`3 2 1 0`  
`1 1 0 0`

The rightmost SET bit is at position `2`, whose value is `4`.

### Brute Force
Check bits from right to left.

The first bit that is `1` is the rightmost SET bit.

- Time: `O(log n)`
- Space: `O(1)`

### Optimal Intuition
Use two's complement:

`-n = ~n + 1`

Then:

`n & -n`

keeps only the rightmost SET bit.

### Pattern

`n & -n`

### Algorithm
1. Take `n`.
2. Calculate `-n` using two's complement.
3. Perform `n & -n`.
4. The result contains only the rightmost SET bit.

### Pseudocode

result = n & -n
return result

### Java

int result = n & -n;
System.out.println(result);

### Complexity
- Time: `O(1)`
- Space: `O(1)`

### Interview Explanation
"`n & -n` isolates the lowest or rightmost SET bit. The result contains only that bit, with all other bits set to `0`."

### Key Learning
`n & -n` → **Isolate the rightmost SET bit**


---

# Quick Pattern Summary

| Problem | Pattern | Purpose |
|---|---|---|
| Odd / Even | `n & 1` | Check bit 0 |
| Power of 2 | `n > 0 && (n & (n - 1)) == 0` | Check exactly one SET bit |
| Rightmost SET Bit | `n & -n` | Isolate rightmost SET bit |

## Remember

`n & 1`
→ Check bit 0
→ Odd / Even

`n & (n - 1)`
→ Remove rightmost SET bit
→ Power of 2 pattern

`n & -n`
→ Isolate rightmost SET bit
→ Get its value
