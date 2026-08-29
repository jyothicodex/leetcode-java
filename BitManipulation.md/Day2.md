# 🔢 Bit Manipulation — Day 2: Check a Bit

## 📌 Goal

Learn how to check whether the `i`th bit of a number is **SET (`1`) or NOT SET (`0`)**.

This is the first useful Bit Manipulation operation that we can directly use in DSA problems.

---

# 1. 🧠 What is SET?

A bit can be:

```text
1 → SET
0 → NOT SET

Example:

13 = 1101

Position:  3  2  1  0
Bit:       1  1  0  1

Therefore:

bit 3 → SET
bit 2 → SET
bit 1 → NOT SET
bit 0 → SET
2. ❓ Why Do We Need to Check a Bit?

A DSA question may ask:

"Check whether the ith bit is SET."

For example:

n = 13
i = 2

We need to find:

Is bit 2 = 1 or 0?

For small numbers, we can convert to binary and directly see it.

But in programming, we use bitwise operations to check it efficiently.

3. 🔹 AND &

AND compares two bits.

0 & 0 = 0
0 & 1 = 0
1 & 0 = 0
1 & 1 = 1
🧠 Remember

AND gives 1 only when both bits are 1.

4. 🎯 What is a Mask?

A mask is a number used to target a particular bit.

Suppose:

i = 2

We want:

Position:  3  2  1  0
Mask:      0  1  0  0
              ↑
           target

So our mask is:

0100

The mask has:

1 → at the position we want to check
0 → everywhere else
5. 🧩 How to Create the Mask?

We use:

1 << i

From Day 1:

1 << i = 2ⁱ

Example:

i = 2

1 << 2
= 2²
= 4
= 0100

Therefore:

1 << 2 → 0100

The 1 is at position 2.

6. ⭐ Check Bit Formula

Now combine the number, mask and AND:

n & (1 << i)

Meaning:

        1 << i
           ↓
       Create mask
           ↓
      n & mask
           ↓
      Check bit i
7. 🔍 Example — Bit is SET
n = 13
i = 2
Step 1: Number
13 = 1101
Step 2: Mask
1 << 2 = 0100
Step 3: AND
  1101
& 0100
------
  0100

Result:

0100 ≠ 0

Therefore:

bit 2 → SET
8. 🔍 Example — Bit is NOT SET
n = 9
i = 2
Step 1: Number
9 = 1001
Step 2: Mask
1 << 2 = 0100
Step 3: AND
  1001
& 0100
------
  0000

Result:

0000 = 0

Therefore:

bit 2 → NOT SET
9. 🧠 Why Does AND Work?

The mask has 1 only at the position we want.

Example:

Number:  1 1 0 1
Mask:    0 1 0 0
            ↑
         check here

At the target position:

If number has 1
1 & 1 = 1

Result is non-zero:

→ SET
If number has 0
0 & 1 = 0

Result is zero:

→ NOT SET

So AND lets us check only the bit we are interested in.

10. 💻 Java Code
int n = 13;
int i = 2;

if ((n & (1 << i)) != 0) {
    System.out.println("SET");
} else {
    System.out.println("NOT SET");
}

Output:

SET
11. ❓ Why != 0?

The expression:

n & (1 << i)

can give:

0

or a non-zero value such as:

1
2
4
8
16
...

We only care whether the result is zero or not.

0        → NOT SET
non-zero → SET

Therefore:

(n & (1 << i)) != 0

means:

"Is the ith bit SET?"

12. 📝 Practice Question 1
Question
n = 13
i = 2

Find whether bit 2 is SET.

Solution
13 = 1101

1 << 2 = 0100

Now:

  1101
& 0100
------
  0100

Result is non-zero.

Answer
bit 2 → SET
13. 📝 Practice Question 2
Question
n = 10
i = 3
Solution
10 = 1010

1 << 3 = 1000

AND:

  1010
& 1000
------
  1000

Result is non-zero.

Answer
bit 3 → SET
14. 📝 Practice Question 3
Question
n = 10
i = 1
Solution
10 = 1010

1 << 1 = 0010

AND:

  1010
& 0010
------
  0010

Result is non-zero.

Answer
bit 1 → SET
15. 📝 Practice Question 4
Question
n = 9
i = 2
Solution
9 = 1001

1 << 2 = 0100

AND:

  1001
& 0100
------
  0000

Result is 0.

Answer
bit 2 → NOT SET
16. 🧠 The Pattern to Remember

Whenever the question says:

"Check whether bit i is SET."

Think:

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
Check result

Then:

0        → NOT SET
non-zero → SET
17. 🔗 Day 1 → Day 2 Connection
Day 1

We learned:

Bit position i
      ↓
Value = 2ⁱ
      ↓
1 << i
      ↓
Mask
Day 2

We use that mask:

Mask
  ↓
AND &
  ↓
Check bit
  ↓
SET / NOT SET

So:

Day 1 → Create the mask
Day 2 → Use the mask
18. 🎯 How This Helps in DSA

Checking bits is the foundation for many Bit Manipulation problems.

Later we will use the same idea for:

Check a bit
    ↓
Set a bit
    ↓
Clear a bit
    ↓
Toggle a bit
    ↓
Count set bits
    ↓
Check power of 2
    ↓
XOR problems
    ↓
Bitmasking
    ↓
LeetCode / OA questions

The goal is to recognize the pattern when you see a question involving bits, positions, masks, or binary representation.

⭐ Day 2 Quick Revision
SET       → 1
NOT SET   → 0

&         → AND

1 << i    → mask for position i

n & (1 << i)
          → check bit i

Result = 0
          → NOT SET

Result ≠ 0
          → SET
🧠 One Example to Remember
n = 13
i = 2

13      = 1101
1 << 2  = 0100

1101
0100
----
0100

0100 ≠ 0000
      ↓
bit 2 is SET
