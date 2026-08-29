# 🔢 Bit Manipulation — Day 2: Check Bit

## 📌 Goal

Learn how to check whether the `i`th bit is **SET (1)** or **NOT SET (0)**.

---

# 1. 🧠 SET vs NOT SET

```text
1 → SET
0 → NOT SET

Example:

13 = 1101

Position:  3  2  1  0
Bit:       1  1  0  1

So:

bit 3 → SET
bit 2 → SET
bit 1 → NOT SET
bit 0 → SET
2. 🔹 AND &

AND gives 1 only when both bits are 1.

0 & 0 = 0
0 & 1 = 0
1 & 0 = 0
1 & 1 = 1

Think:

1 & 1 → 1
anything else → 0
3. 🎯 Mask

To check position i, we need a mask.

Mask = 1 << i

Remember:

1 << i = 2ⁱ

Example:

i = 2

1 << 2
= 4
= 0100

The 1 is at position 2.

Position:  3  2  1  0
Mask:      0  1  0  0
               ↑
             check
4. ⭐ Check ith Bit

Formula:

n & (1 << i)

Meaning:

n
&
mask
↓
check only bit i
5. 🔍 Example — NOT SET
n = 9
i = 2
9  = 1001
mask = 0100

AND:

  1001
& 0100
------
  0000

Result = 0

Therefore:

bit 2 → NOT SET
6. 🔍 Example — SET
n = 13
i = 2
13 = 1101
mask = 0100
  1101
& 0100
------
  0100

Result ≠ 0

Therefore:

bit 2 → SET
🧠 Remember This
Need to check bit i
        ↓
Create mask
        ↓
1 << i
        ↓
AND with n
        ↓
n & (1 << i)
        ↓
0       → NOT SET
non-zero → SET
💻 Java
int n = 9;
int i = 2;

if ((n & (1 << i)) != 0) {
    System.out.println("SET");
} else {
    System.out.println("NOT SET");
}
🔗 Day 1 → Day 2
DAY 1
bit position
     ↓
2ⁱ
     ↓
1 << i
     ↓
MASK

DAY 2
MASK
 ↓
&
 ↓
CHECK BIT
 ↓
SET / NOT SET
⭐ Day 2 Key Points
1 → SET
0 → NOT SET
& → AND
1 << i → creates mask for position i
n & (1 << i) → checks bit i
0 → NOT SET
non-zero → SET
🏁 Status

Day 2 — Check Bit ✅
