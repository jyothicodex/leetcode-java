important from Day 2.

# 🔢 Bit Manipulation — Day 2: AND & Check Bit

## 📌 Goal

Learn `&` (AND), masks, and how to check whether the `i-th` bit is SET or NOT SET.

---

# 1. 🧩 AND Operator `&`

AND gives `1` only when **both bits are `1`**.

```text
0 & 0 = 0
0 & 1 = 0
1 & 0 = 0
1 & 1 = 1

Example:

  1011
& 0110
------
  0010
2. 📍 SET and NOT SET
1 → SET
0 → NOT SET

Example:

13 = 1101

Position:  3  2  1  0
Bit:       1  1  0  1

So:

Bit 3 → SET
Bit 2 → SET
Bit 1 → NOT SET
Bit 0 → SET
3. 🎯 Mask

A mask is used to target a particular bit.

To create a mask for position i:

1 << i

Remember:

1 << i = 2ⁱ

Example:

i = 2

1 << 2
= 2²
= 4
= 0100

The 1 is at position 2.

Position:  3  2  1  0
Mask:      0  1  0  0
               ↑
4. ✅ Check if i-th Bit is SET

Formula:

n & (1 << i)
Example
n = 9
i = 2

9 = 1001
1 << 2 = 0100

AND:

  1001
& 0100
------
  0000

Result is 0.

Therefore:

Bit 2 → NOT SET
5. ⭐ SET Example
n = 10
i = 3

10 = 1010
1 << 3 = 1000
  1010
& 1000
------
  1000

Result is non-zero.

Therefore:

Bit 3 → SET
6. 🧠 Main Rule
n & (1 << i)
Result = 0
→ Bit i is NOT SET

Result ≠ 0
→ Bit i is SET
7. 💻 Java Code
int n = 9;
int i = 2;

if ((n & (1 << i)) != 0) {
    System.out.println("SET");
} else {
    System.out.println("NOT SET");
}

Output:

NOT SET
🔗 Day 1 → Day 2
Bit position i
      ↓
Value = 2ⁱ
      ↓
1 << i
      ↓
Mask
      ↓
AND (&)
      ↓
Check i-th bit
⭐ Day 2 Key Takeaways
1. & → AND
2. 1 << i → creates mask
3. 1 << i = 2ⁱ
4. SET = 1
5. NOT SET = 0
6. Check bit → n & (1 << i)
7. Result 0 → NOT SET
8. Result non-zero → SET
🚀 Next — Day 3
SET BIT
CLEAR BIT
TOGGLE BIT
