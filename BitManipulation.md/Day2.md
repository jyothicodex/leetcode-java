# Bit Manipulation — Clear & Toggle i-th Bit

---

# 1. Clear i-th Bit

## Problem

Given an integer `n` and a bit position `i`, make the **i-th bit equal to 0**.

If the bit is already `0`, it remains `0`.

## Main Challenge

Change only the i-th bit to `0` without changing any other bits.

## Brute Force Approach

Convert the number to binary, change the i-th bit to `0`, and convert it back.

- Time: `O(log n)`
- Space: `O(1)`

## Optimal Approach / Intuition

Create a mask with `1` at position `i`:

`1 << i`

We need to make that bit `0`.

First invert the mask using NOT:

`~(1 << i)`

Now the mask has:

- `0` at position `i`
- `1` at all other positions

Then use AND:

`n & ~(1 << i)`

AND keeps other bits unchanged and forces the i-th bit to `0`.

## Pattern

`n & ~(1 << i)`

## Algorithm

1. Create mask: `1 << i`
2. Invert the mask: `~(1 << i)`
3. Perform AND with `n`.
4. The i-th bit becomes `0`.
5. All other bits remain unchanged.

## Pseudocode

mask = 1 << i

n = n & ~mask

return n

## Java Code

int n = 13;
int i = 2;

int result = n & ~(1 << i);

System.out.println(result);

## Example

`n = 13`

Binary:

`13 = 1101`

Clear bit `2`.

Mask:

`1 << 2 = 0100`

Invert:

`~0100 = 1011`

Now:

`1101`
`1011`
`----`
`1001`

`1001 = 9`

Therefore:

`13 → 9`

Bit `2` is now `0`.

## Complexity

- Time: `O(1)`
- Space: `O(1)`

## Interview Explanation

"I create a mask with `1` at the i-th position, invert it using NOT, and AND it with `n`. This forces only the i-th bit to `0`."

## Key Learning

`1 << i` → Create mask

`~(1 << i)` → Put `0` at i-th bit

`n & ~(1 << i)` → **CLEAR i-th bit**


---

# 2. Toggle i-th Bit

## Problem

Given an integer `n` and a bit position `i`, **flip the i-th bit**.

- If it is `0` → make it `1`
- If it is `1` → make it `0`

## Main Challenge

Change the i-th bit while keeping all other bits unchanged.

## Brute Force Approach

Convert the number to binary, flip the i-th bit, and convert it back.

- Time: `O(log n)`
- Space: `O(1)`

## Optimal Approach / Intuition

Create a mask with `1` at position `i`:

`1 << i`

Use XOR:

`n ^ (1 << i)`

XOR has the important property:

- `0 ^ 1 = 1`
- `1 ^ 1 = 0`

So XOR with `1` **flips the bit**.

For all other positions, the mask contains `0`.

And:

- `0 ^ 0 = 0`
- `1 ^ 0 = 1`

Therefore, all other bits remain unchanged.

## Pattern

`n ^ (1 << i)`

## Algorithm

1. Create mask: `1 << i`
2. Perform XOR between `n` and the mask.
3. The i-th bit is flipped.
4. All other bits remain unchanged.

## Pseudocode

mask = 1 << i

n = n ^ mask

return n

## Java Code

int n = 13;
int i = 2;

int result = n ^ (1 << i);

System.out.println(result);

## Example 1 — Toggle 1 to 0

`n = 13`

Binary:

`13 = 1101`

Toggle bit `2`.

Mask:

`1 << 2 = 0100`

Now:

`1101`
`0100`
`----`
`1001`

`1001 = 9`

So:

`13 → 9`

Bit `2`: `1 → 0`

## Example 2 — Toggle 0 to 1

`n = 9`

Binary:

`9 = 1001`

Toggle bit `1`.

Mask:

`1 << 1 = 0010`

Now:

`1001`
`0010`
`----`
`1011`

`1011 = 11`

So:

`9 → 11`

Bit `1`: `0 → 1`

## Complexity

- Time: `O(1)`
- Space: `O(1)`

## Interview Explanation

"I create a mask using `1 << i` and XOR it with `n`. XOR with `1` flips the i-th bit, while XOR with `0` keeps all other bits unchanged."

## Key Learning

`1 << i` → Create mask

`n ^ (1 << i)` → **TOGGLE i-th bit**


---

# Quick Pattern Summary

| Operation | Operator | Pattern | Purpose |
|---|---|---|---|
| Check i-th bit | AND `&` | `n & (1 << i)` | Check bit |
| Set i-th bit | OR `|` | `n \| (1 << i)` | Make bit `1` |
| Clear i-th bit | AND + NOT | `n & ~(1 << i)` | Make bit `0` |
| Toggle i-th bit | XOR `^` | `n ^ (1 << i)` | Flip bit |

## Operator Memory

`&` → **BOTH must be 1**

`|` → **ANY one can make it 1**

`~` → **FLIP all bits**

`^` → **DIFFERENT = 1 / Same = 0**

## Final 4 Patterns

`1 << i`  
→ Mask for i-th bit

`n & (1 << i)`  
→ **CHECK**

`n | (1 << i)`  
→ **SET**

`n & ~(1 << i)`  
→ **CLEAR**

`n ^ (1 << i)`  
→ **TOGGLE**
