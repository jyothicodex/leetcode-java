
# 🔢 Bit Manipulation — Day 1: Binary Foundations

## 📌 Goal

Build a strong foundation of **binary numbers and bit positions** before starting actual Bit Manipulation DSA problems.

The goal is not to memorize formulas. The goal is to understand:

* What binary numbers are
* What a bit is
* How bit positions work
* How binary and decimal are connected
* What SET and NOT SET mean
* What 2's complement is
* Why powers of 2 are important
* Why `1 << i` is used in Bit Manipulation

---

## 1. 🧩 Binary Number System

A **binary number system** uses only **2 digits**:

```text
0 and 1
```

A **decimal number system** uses **10 digits**:

```text
0 1 2 3 4 5 6 7 8 9
```

Computers use binary because digital systems work with two states, represented as `0` and `1`.

---

## 2. 📍 What is a Bit?

A **bit** is the smallest unit of information in binary.

A bit can have only two values:

```text
0 or 1
```

Example:

```text
10110
```

This number contains **5 bits**.

Each `0` or `1` represents one bit.

---

## 3. 📍 Bit Positions

Bit positions are counted **from right to left**, starting from `0`.

Example:

```text
Number:     1   0   1   1   0
Position:   4   3   2   1   0
```

### ⭐ Important Rule

> The **rightmost bit** is always at position `0`.

Therefore:

```text
Rightmost bit → position 0
Next bit      → position 1
Next bit      → position 2
Next bit      → position 3
...
```

---

## 4. ⚡ Powers of 2

Every bit position represents a **power of 2**.

| Position | Power | Value |
| -------: | ----: | ----: |
|        0 |  `2⁰` |     1 |
|        1 |  `2¹` |     2 |
|        2 |  `2²` |     4 |
|        3 |  `2³` |     8 |
|        4 |  `2⁴` |    16 |
|        5 |  `2⁵` |    32 |
|        6 |  `2⁶` |    64 |
|        7 |  `2⁷` |   128 |

Therefore:

> **The value of bit position `i` is `2ⁱ`.**

For example:

```text
Position 0 → 2⁰ = 1
Position 1 → 2¹ = 2
Position 2 → 2² = 4
Position 3 → 2³ = 8
Position 4 → 2⁴ = 16
Position 5 → 2⁵ = 32
Position 6 → 2⁶ = 64
```

This becomes very important later because:

```text
1 << i = 2ⁱ
```

---

# 5. 🔄 Binary → Decimal

To convert binary to decimal:

> Add the values of the positions where the bit is `1`.

### Example

Convert:

```text
10110
```

to decimal.

First write the positions and values:

```text
Position:   4   3   2   1   0
Value:     16   8   4   2   1
Bit:        1   0   1   1   0
```

The bits that are `1` are at positions:

```text
4, 2, 1
```

Their values are:

```text
16 + 4 + 2 = 22
```

Therefore:

```text
10110₂ = 22₁₀
```

---

# 6. 🔄 Another Binary → Decimal Example

Convert:

```text
101101
```

to decimal.

```text
Position:   5   4   3   2   1   0
Value:     32  16   8   4   2   1
Bit:        1   0   1   1   0   1
```

Only the positions containing `1` contribute:

```text
32 + 8 + 4 + 1 = 45
```

Therefore:

```text
101101₂ = 45₁₀
```

---

# 7. 🔄 Decimal → Binary

To convert decimal to binary:

1. Divide the number by `2`
2. Record the remainder
3. Divide the quotient by `2`
4. Continue until the quotient becomes `0`
5. Read the remainders **from bottom to top**

### Example: `13 → Binary`

```text
13 ÷ 2 = 6   remainder 1
 6 ÷ 2 = 3   remainder 0
 3 ÷ 2 = 1   remainder 1
 1 ÷ 2 = 0   remainder 1
```

Read the remainders from bottom to top:

```text
1101
```

Therefore:

```text
13₁₀ = 1101₂
```

---

# 8. 📝 Decimal → Binary Examples

Some examples:

```text
10 → 1010
18 → 10010
25 → 11001
```

The important thing is to understand the **conversion process**, not memorize the answers.

---

# 9. 🔴 SET and NOT SET

This is very important terminology in Bit Manipulation.

## SET

A bit is **SET** when its value is:

```text
1
```

So:

```text
1 → SET
```

## NOT SET

A bit is **NOT SET** when its value is:

```text
0
```

So:

```text
0 → NOT SET
```

### 🧠 Easy Way to Remember

Think of a switch:

```text
1 → ON  → SET
0 → OFF → NOT SET
```

---

# 10. 📍 Example of SET and NOT SET

Consider:

```text
13 = 1101
```

Write the positions:

```text
Position:   3   2   1   0
Bit:        1   1   0   1
```

Therefore:

```text
Bit 3 → SET
Bit 2 → SET
Bit 1 → NOT SET
Bit 0 → SET
```

So when a DSA question says:

> "Check whether bit `i` is set"

it simply means:

> **Check whether the bit at position `i` is `1`.**

---

# 11. ➕ 2's Complement

**2's complement** is a method used to represent negative numbers in binary.

For our Bit Manipulation foundation, remember these steps:

```text
Positive number
      ↓
Convert to binary
      ↓
Flip every bit
      ↓
Add 1
      ↓
Negative number
```

---

# 12. 🧮 Binary Addition

Important binary addition rules:

```text
0 + 0 = 0
0 + 1 = 1
1 + 0 = 1
1 + 1 = 10
```

When:

```text
1 + 1 = 10
```

we:

```text
Write 0
Carry 1
```

This becomes important when performing the **Add 1** step in 2's complement.

---

# 13. 🔢 Example: `-5` Using 2's Complement

Use **8 bits**.

### Step 1 — Write `+5`

```text
00000101
```

### Step 2 — Flip Every Bit

```text
11111010
```

### Step 3 — Add 1

```text
11111010
+       1
---------
11111011
```

Therefore:

```text
-5 = 11111011
```

---

# 14. 🔢 Example: `-6` Using 2's Complement

### Step 1 — Write `+6`

```text
00000110
```

### Step 2 — Flip Every Bit

```text
11111001
```

### Step 3 — Add 1

```text
11111001
+       1
---------
11111010
```

Therefore:

```text
-6 = 11111010
```

---

# 15. 🔢 Example: `-9` Using 2's Complement

### Step 1 — Write `+9`

```text
00001001
```

### Step 2 — Flip Every Bit

```text
11110110
```

### Step 3 — Add 1

```text
11110110
+       1
---------
11110111
```

Therefore:

```text
-9 = 11110111
```

---

# 16. 🔄 Negative Binary → Decimal

Suppose we have an 8-bit negative number:

```text
11111011
```

To find its magnitude:

### Step 1 — Flip All Bits

```text
00000100
```

### Step 2 — Add 1

```text
00000100
+       1
---------
00000101
```

`00000101` is `5`.

Therefore:

```text
11111011 = -5
```

---

# 17. ⭐ Important Connection: `1 << i`

One of the most important foundations for Bit Manipulation is:

```text
1 << i = 2ⁱ
```

The `<<` operator means **left shift**.

Start with:

```text
0001
```

### Shift by 1

```text
0010
```

Therefore:

```text
1 << 1 = 2
```

### Shift by 2

```text
0100
```

Therefore:

```text
1 << 2 = 4
```

### Shift by 3

```text
1000
```

Therefore:

```text
1 << 3 = 8
```

So:

```text
1 << i = 2ⁱ
```

---

# 18. 🧠 Connection Between Bit Position and `1 << i`

We already learned:

```text
Value of bit position i = 2ⁱ
```

We also learned:

```text
1 << i = 2ⁱ
```

Therefore:

```text
Value of bit position i
        ↓
       2ⁱ
        ↓
    1 << i
```

So:

```text
Value of bit position i = 1 << i
```

This is a **very important connection**.

---

# 19. 🎯 Why `1 << i` Is Useful

Suppose:

```text
i = 2
```

The value of position `2` is:

```text
2² = 4
```

And:

```text
1 << 2 = 4
```

In binary:

```text
0100
```

Notice that the `1` is exactly at position `2`.

```text
Position:   3   2   1   0
Mask:        0   1   0   0
                 ↑
              position 2
```

This is called a **bit mask**.

> A mask helps us target a particular bit.

---

# 20. 🔗 Connection to Bit Checking

Suppose:

```text
n = 9
i = 2
```

First:

```text
9 = 1001
```

Positions:

```text
Position:   3   2   1   0
Bit:        1   0   0   1
                ↑
              bit 2
```

Bit `2` is `0`.

Therefore:

```text
Bit 2 → NOT SET
```

Later, instead of manually converting `9` to binary, we can use:

```java
n & (1 << i)
```

For this example:

```text
9 & (1 << 2)
```

Since:

```text
1 << 2 = 0100
```

we get:

```text
1001
0100
----
0000
```

Result is:

```text
0
```

Therefore:

```text
Bit 2 → NOT SET
```

If the result is **non-zero**:

```text
Bit i → SET
```

This is the bridge between **Day 1 foundation** and **Day 2 Bit Checking**.

---

# 21. 🧠 Day 1 DSA Connection

The concepts we learned are connected like this:

```text
Binary
   ↓
Bits
   ↓
Bit Positions
   ↓
Powers of 2
   ↓
1 << i
   ↓
Mask
   ↓
Bitwise Operators
   ↓
Check / Set / Clear / Toggle
   ↓
Bit Manipulation Tricks
   ↓
XOR Problems
   ↓
Bitmasking
   ↓
LeetCode / OA Problems
```

---

# 22. 🎯 Why We Need This for DSA

In DSA, we will see questions such as:

* Check if the `i`th bit is set
* Set the `i`th bit
* Clear the `i`th bit
* Toggle the `i`th bit
* Count the number of set bits
* Find the single number
* Find the missing number
* Check whether a number is a power of 2
* Generate all subsets using bitmasking

To solve these, we need to understand:

```text
0 and 1
   ↓
Bit position
   ↓
2ⁱ
   ↓
1 << i
   ↓
Mask
```

So the Day 1 concepts are **not separate topics**.

They are the **foundation for actual Bit Manipulation DSA questions**.

---

# 23. 🧠 Day 1 Mental Model

When you see a binary number:

```text
10110
```

Think:

```text
Position:   4   3   2   1   0
Bit:        1   0   1   1   0
Value:     16   8   4   2   1
```

When you see:

```text
bit i
```

think:

```text
value = 2ⁱ
```

When you see:

```text
1 << i
```

think:

```text
2ⁱ
```

When you see:

```text
SET
```

think:

```text
bit = 1
```

When you see:

```text
NOT SET
```

think:

```text
bit = 0
```

---

# 24. ✅ Day 1 Completed Topics

* [x] Binary number system
* [x] Decimal number system
* [x] What is a bit
* [x] Bit positions
* [x] Rightmost position is `0`
* [x] Binary place values
* [x] Powers of 2
* [x] Binary → Decimal
* [x] Decimal → Binary
* [x] SET and NOT SET
* [x] Binary addition
* [x] 2's complement
* [x] Negative binary → Decimal
* [x] Left shift `<<` basic idea
* [x] `1 << i`
* [x] Connection between `2ⁱ` and `1 << i`
* [x] Basic idea of a bit mask
* [x] Connection between binary foundation and bit checking

---

# 📝 Day 1 Practice

During Day 1, we practiced:

```text
Decimal → Binary
Binary → Decimal
Finding bit positions
Finding the value of a bit position
Powers of 2
2's complement
Binary addition
Negative numbers in binary
Understanding SET / NOT SET
Understanding 1 << i
Understanding the basic idea of masks
```

---

# ⭐ Day 1 Key Takeaways

Remember these **10 most important points**:

### 1. Binary uses only `0` and `1`.

### 2. A bit can be only `0` or `1`.

### 3. The rightmost bit is position `0`.

### 4. The value of bit position `i` is `2ⁱ`.

### 5. SET = bit is `1`.

### 6. NOT SET = bit is `0`.

### 7. `1 << i = 2ⁱ`.

### 8. `1 << i` creates a mask with `1` at position `i`.

### 9. Masks are used to work with specific bits.

### 10. These concepts are the foundation for:

```text
Check
Set
Clear
Toggle
Bit Tricks
XOR
Bitmasking
LeetCode
OA Problems
```

---

# 🚀 Day 1 → Day 2

Day 1 gave us the **binary foundation**.

Day 2 builds on it:

```text
AND (&)
   ↓
Mask
   ↓
Check ith bit
   ↓
n & (1 << i)
```

The key formula learned next is:

```java
n & (1 << i)
```

### Result

```text
0         → bit i is NOT SET
non-zero  → bit i is SET
```

---

# 🏁 Day 1 Status

> ## **Binary Foundation: COMPLETED ✅**

### Next:

> **Day 2 — Bitwise AND + Check ith Bit**
