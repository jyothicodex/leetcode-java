# Bit Manipulation — Check & Set i-th Bit

---

## AND & OR Truth Table

| A | B | A & B (AND) | A \| B (OR) |
|---|---|-------------|-------------|
| 0 | 0 | 0 | 0 |
| 0 | 1 | 0 | 1 |
| 1 | 0 | 0 | 1 |
| 1 | 1 | 1 | 1 |

### Easy Way to Remember

- `AND (&)` → **BOTH must be 1**
- `OR (|)` → **ANY one being 1 is enough**

---

# 1. Check i-th Bit

## Problem

Given an integer `n` and a bit position `i`, check whether the **i-th bit is SET (`1`) or NOT SET (`0`)**.

## Main Challenge

Create a mask that has `1` only at position `i`.

Bit positions start from `0` from the right.

Example:

`13 = 1101`

Position:

`3 2 1 0`

Bit:

`1 1 0 1`

## Brute Force Approach

Convert the number to binary and check the bit at position `i`.

- Time: `O(log n)`
- Space: `O(1)`

## Optimal Approach / Intuition

Create a mask using:

`1 << i`

Then use AND:

`n & (1 << i)`

Why AND?

Because AND returns `1` only when **both bits are 1**.

The mask has `1` only at position `i`, so it checks only that bit.

## Pattern

`(n & (1 << i)) != 0`

- Result non-zero → i-th bit is SET
- Result `0` → i-th bit is NOT SET

## Algorithm

1. Create mask: `1 << i`
2. Perform `n & mask`.
3. If the result is non-zero, the i-th bit is SET.
4. Otherwise, the i-th bit is NOT SET.

## Pseudocode

mask = 1 << i

if (n & mask) != 0
    SET
else
    NOT SET

## Java Code

int n = 13;
int i = 2;

if ((n & (1 << i)) != 0) {
    System.out.println("SET");
} else {
    System.out.println("NOT SET");
}

## Example

`n = 13`

Binary:

`13 = 1101`

Check bit `2`.

Mask:

`1 << 2 = 0100`

Now:

`1101`
`0100`
`----`
`0100`

Result is non-zero.

Therefore, **bit 2 is SET**.

## Complexity

- Time: `O(1)`
- Space: `O(1)`

## Interview Explanation

"I create a mask using `1 << i` and use AND with `n`. If the result is non-zero, the i-th bit is SET; otherwise it is NOT SET."

## Key Learning

`1 << i` → Create mask for i-th bit

`n & (1 << i)` → Check i-th bit


---

# 2. Set i-th Bit

## Problem

Given an integer `n` and a bit position `i`, make the **i-th bit equal to 1**.

If the bit is already `1`, it remains `1`.

## Main Challenge

Change only the required bit without changing the other bits.

## Brute Force Approach

Convert the number to binary, change the i-th bit to `1`, and convert it back.

- Time: `O(log n)`
- Space: `O(1)`

## Optimal Approach / Intuition

Create a mask using:

`1 << i`

Then use OR:

`n | (1 << i)`

Why OR?

Because OR makes the result `1` if **at least one of the bits is 1**.

So, placing `1` at position `i` forces that bit to become `1`.

The other bits remain unchanged.

## Pattern

`n | (1 << i)`

## Algorithm

1. Create mask: `1 << i`
2. Perform OR between `n` and the mask.
3. The i-th bit becomes `1`.
4. All other bits remain unchanged.

## Pseudocode

mask = 1 << i

n = n | mask

return n

## Java Code

int n = 9;
int i = 1;

int result = n | (1 << i);

System.out.println(result);

## Example

`n = 9`

Binary:

`9 = 1001`

Set bit `1`.

Mask:

`1 << 1 = 0010`

Now:

`1001`
`0010`
`----`
`1011`

`1011 = 11`

Therefore:

`9 → 11`

and bit `1` is now SET.

## Complexity

- Time: `O(1)`
- Space: `O(1)`

## Interview Explanation

"I create a mask using `1 << i` and OR it with `n`. OR forces the i-th bit to `1` while keeping all other bits unchanged."

## Key Learning

`1 << i` → Create mask for i-th bit

`n | (1 << i)` → Set i-th bit


---

# Quick Pattern Summary

| Operation | Operator | Pattern | Purpose |
|---|---|---|---|
| Check i-th bit | AND `&` | `n & (1 << i)` | Check whether bit is `1` |
| Set i-th bit | OR `|` | `n \| (1 << i)` | Make bit `1` |

## Remember

`&` → **BOTH**

`|` → **ANY**

`1 << i` → **Mask for i-th bit**

`n & (1 << i)` → **CHECK**

`n | (1 << i)` → **SET**
