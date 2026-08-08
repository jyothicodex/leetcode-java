# ➕ LeetCode 2 - Add Two Numbers

## 📌 Problem

You are given two non-empty linked lists representing two non-negative integers.

The digits are stored in **reverse order**, and each node contains one digit.

Add the two numbers and return the sum as a linked list.

### Example

```text
Input:

l1 = 2 → 4 → 3
l2 = 5 → 6 → 4

These represent:

342
+ 465
-----
807
```

Output:

```text
7 → 0 → 8
```

Because the result is:

```text
807
```

and digits are stored in reverse order:

```text
7 → 0 → 8
```

---

# 🧩 Pattern

## Linked List Traversal + Carry + Dummy Node

Main ideas:

```text
dummy → builds the answer
curr  → points to the last result node
carry → stores the extra value from addition
```

---

# 💡 Intuition

The digits are already stored in reverse order.

For example:

```text
2 → 4 → 3
```

represents:

```text
342
```

So we can add the numbers exactly like normal addition, starting from the ones place.

At every position:

```text
sum = digit1 + digit2 + carry
```

The digit we put into the result is:

```text
sum % 10
```

The carry for the next position is:

```text
sum / 10
```

### Example

```text
2 + 5 = 7
```

```text
4 + 6 = 10
```

So:

```text
digit = 0
carry = 1
```

Then:

```text
3 + 4 + 1 = 8
```

Final result:

```text
7 → 0 → 8
```

---

# 📋 Algorithm

1. Create a dummy node.
2. Set `curr = dummy`.
3. Set `carry = 0`.
4. Continue while:
   - `l1 != null`, or
   - `l2 != null`, or
   - `carry != 0`.
5. Get the value from `l1`, otherwise use `0`.
6. Get the value from `l2`, otherwise use `0`.
7. Calculate:

```text
sum = val1 + val2 + carry
```

8. Calculate the digit:

```text
digit = sum % 10
```

9. Calculate the new carry:

```text
carry = sum / 10
```

10. Create a new node with `digit`.
11. Attach it using `curr.next`.
12. Move `curr`.
13. Move `l1` if it is not null.
14. Move `l2` if it is not null.
15. Return `dummy.next`.

---

# 📝 Pseudocode

```text
dummy = new Node(-1)
curr = dummy
carry = 0

while(l1 != null OR l2 != null OR carry != 0)

    val1 = 0
    val2 = 0

    if(l1 != null)
        val1 = l1.val

    if(l2 != null)
        val2 = l2.val

    sum = val1 + val2 + carry

    digit = sum % 10
    carry = sum / 10

    curr.next = new Node(digit)
    curr = curr.next

    if(l1 != null)
        l1 = l1.next

    if(l2 != null)
        l2 = l2.next

return dummy.next
```

---

# 🛠️ What Are We Using?

## `dummy`

A helper node used to build the result list.

```text
dummy → result
```

At the end:

```java
return dummy.next;
```

---

## `curr`

Points to the last node in the result.

After adding a digit:

```java
curr.next = new ListNode(digit);
curr = curr.next;
```

---

## `carry`

Stores the extra value that must be added to the next position.

Example:

```text
8 + 7 = 15
```

So:

```text
digit = 5
carry = 1
```

---

# 🎨 Dry Run

## Input

```text
l1 = 2 → 4 → 3
l2 = 5 → 6 → 4
```

Represent:

```text
342 + 465 = 807
```

---

## Initial

```text
carry = 0

dummy → null
  ↑
 curr
```

---

## 🔵 Iteration 1

Values:

```text
l1 = 2
l2 = 5
carry = 0
```

Calculate:

```text
sum = 2 + 5 + 0
    = 7
```

Digit:

```text
7 % 10 = 7
```

Carry:

```text
7 / 10 = 0
```

Create:

```text
7
```

Result:

```text
dummy → 7
         ↑
        curr
```

Move:

```text
l1 → 4
l2 → 6
```

---

## 🔵 Iteration 2

Values:

```text
l1 = 4
l2 = 6
carry = 0
```

Calculate:

```text
sum = 4 + 6 + 0
    = 10
```

Digit:

```text
10 % 10 = 0
```

Carry:

```text
10 / 10 = 1
```

Add:

```text
0
```

Result:

```text
dummy → 7 → 0
              ↑
             curr
```

Move:

```text
l1 → 3
l2 → 4
```

---

## 🔵 Iteration 3

Values:

```text
l1 = 3
l2 = 4
carry = 1
```

Calculate:

```text
sum = 3 + 4 + 1
    = 8
```

Digit:

```text
8 % 10 = 8
```

Carry:

```text
8 / 10 = 0
```

Result:

```text
dummy → 7 → 0 → 8
```

Now:

```text
l1 = null
l2 = null
carry = 0
```

Loop ends.

Return:

```text
dummy.next
```

Final:

```text
7 → 0 → 8
```

---

# 🎨 Dry Run With Final Carry

Consider:

```text
l1 = 9 → 9
l2 = 1
```

This represents:

```text
99 + 1 = 100
```

### Iteration 1

```text
9 + 1 + 0 = 10
```

```text
digit = 0
carry = 1
```

Result:

```text
0
```

---

### Iteration 2

```text
9 + 0 + 1 = 10
```

```text
digit = 0
carry = 1
```

Result:

```text
0 → 0
```

---

### Iteration 3

Both lists are finished, but:

```text
carry = 1
```

So the loop must continue.

```text
0 + 0 + 1 = 1
```

Result:

```text
0 → 0 → 1
```

Correct answer:

```text
100
```

represented as:

```text
0 → 0 → 1
```

---

# 💻 Java Code

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int val1 = 0;
            int val2 = 0;

            if (l1 != null) {
                val1 = l1.val;
            }

            if (l2 != null) {
                val2 = l2.val;
            }

            int sum = val1 + val2 + carry;

            int digit = sum % 10;
            carry = sum / 10;

            curr.next = new ListNode(digit);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }
}
```

---

# ⚠️ Common Mistakes

## 1. Forgetting the Carry

### ❌ Wrong

```java
int sum = val1 + val2;
```

This ignores the carry from the previous digit.

### ✅ Correct

```java
int sum = val1 + val2 + carry;
```

---

# 2. Wrong Digit Calculation

### ❌ Wrong

```java
int digit = sum / 10;
```

`/ 10` gives the carry.

### ✅ Correct

```java
int digit = sum % 10;
```

Example:

```text
sum = 15

digit = 15 % 10 = 5
carry = 15 / 10 = 1
```

---

# 3. Wrong Carry Calculation

### ❌ Wrong

```java
carry = sum % 10;
```

### ✅ Correct

```java
carry = sum / 10;
```

Remember:

```text
% 10 → digit
/ 10 → carry
```

---

# 4. Forgetting to Move `curr`

After creating the result node:

```java
curr.next = new ListNode(digit);
```

we must move:

```java
curr = curr.next;
```

Otherwise every new node will overwrite the same `curr.next`.

### ❌ Wrong

```java
curr.next = new ListNode(digit);
```

### ✅ Correct

```java
curr.next = new ListNode(digit);
curr = curr.next;
```

---

# 5. Moving `l1` or `l2` Without Checking Null

### ❌ Wrong

```java
l1 = l1.next;
l2 = l2.next;
```

One list may be shorter.

Example:

```text
l1 = 9 → 9
l2 = 1
```

After the first iteration, `l2` becomes `null`.

### ✅ Correct

```java
if (l1 != null) {
    l1 = l1.next;
}

if (l2 != null) {
    l2 = l2.next;
}
```

---

# 6. Wrong While Condition

### ❌ Wrong

```java
while(l1 != null && l2 != null)
```

This stops as soon as either list ends.

But the other list may still contain nodes.

Also, there may still be a `carry`.

### ✅ Correct

```java
while(l1 != null || l2 != null || carry != 0)
```

We continue if **anything remains to process**.

---

# 7. Forgetting Final Carry

Example:

```text
9 → 9
1
```

```text
99 + 1 = 100
```

After processing both lists:

```text
l1 = null
l2 = null
carry = 1
```

If the condition is only:

```java
while(l1 != null || l2 != null)
```

the final `1` is lost.

### ✅ Correct

```java
while(l1 != null || l2 != null || carry != 0)
```

---

# 8. Returning `curr`

### ❌ Wrong

```java
return curr;
```

`curr` points to the last node.

### ✅ Correct

```java
return dummy.next;
```

The result starts after the dummy node.

---

# 🔄 Wrong vs Correct

## Sum

### ❌ Wrong

```java
int sum = val1 + val2;
```

### ✅ Correct

```java
int sum = val1 + val2 + carry;
```

---

## Digit

### ❌ Wrong

```java
int digit = sum / 10;
```

### ✅ Correct

```java
int digit = sum % 10;
```

---

## Carry

### ❌ Wrong

```java
carry = sum % 10;
```

### ✅ Correct

```java
carry = sum / 10;
```

---

## While Condition

### ❌ Wrong

```java
while(l1 != null && l2 != null)
```

### ✅ Correct

```java
while(l1 != null || l2 != null || carry != 0)
```

---

## Moving `curr`

### ❌ Wrong

```java
curr.next = new ListNode(digit);
```

### ✅ Correct

```java
curr.next = new ListNode(digit);
curr = curr.next;
```

---

## Return

### ❌ Wrong

```java
return curr;
```

### ✅ Correct

```java
return dummy.next;
```

---

# 🎤 Interview Explanation

> I will add the two linked lists digit by digit, starting from the head because the digits are stored in reverse order. I use a dummy node to build the result and maintain a carry for values greater than 9. At each step, I add the two current digits and the carry, store `sum % 10` as the result digit, and update the carry using `sum / 10`. I continue while either list still has nodes or a carry remains. Finally, I return `dummy.next`.

---

# 💻 Live Coding Tips

When you see:

> Add two numbers represented by linked lists

Think:

```text
Linked List Addition
        ↓
Dummy + Carry
```

Immediately create:

```java
ListNode dummy = new ListNode(-1);
ListNode curr = dummy;
int carry = 0;
```

Then remember:

```text
sum
 ↓
digit = sum % 10
carry = sum / 10
```

### Core Code

```java
int sum = val1 + val2 + carry;

int digit = sum % 10;
carry = sum / 10;

curr.next = new ListNode(digit);
curr = curr.next;
```

---

# 🧠 Quick Revision

```text
Pattern:
Dummy + Carry + Traversal

Initialize:
dummy
curr
carry = 0

Loop:
while(l1 != null || l2 != null || carry != 0)

Get:
val1
val2

Calculate:
sum = val1 + val2 + carry

Digit:
sum % 10

Carry:
sum / 10

Build:
curr.next = new ListNode(digit)
curr = curr.next

Move:
l1 if not null
l2 if not null

Return:
dummy.next
```

---

# ⭐ One-Line Memory

> **Add → Digit `% 10` → Carry `/ 10` → Attach → Move**

---

# ⏱️ Complexity

### Time Complexity

```text
O(max(n, m))
```

where `n` and `m` are the lengths of the two linked lists.

We process each node once.

### Space Complexity

```text
O(max(n, m))
```

The result linked list contains up to `max(n, m) + 1` nodes.

The algorithm itself uses `O(1)` extra pointer space apart from the output list.

---

# 🔗 Related Problems

- **LeetCode 21 - Merge Two Sorted Lists**
- **LeetCode 203 - Remove Linked List Elements**
- **LeetCode 369 - Plus One Linked List**
- **LeetCode 445 - Add Two Numbers II**

---

# 🚀 Key Takeaways

- Digits are stored in reverse order, so addition starts from the head.
- Use a **dummy node** to build the result.
- Use `carry` for sums greater than `9`.
- `% 10` gives the current digit.
- `/ 10` gives the carry.
- `curr` must move after adding a node.
- Lists can have different lengths.
- Continue while a carry remains.
- Return `dummy.next`.
- Time: `O(max(n,m))`
- Extra space: `O(1)` apart from the output list.

## 🔑 Final Template

```java
ListNode dummy = new ListNode(-1);
ListNode curr = dummy;
int carry = 0;

while (l1 != null || l2 != null || carry != 0) {

    int val1 = 0;
    int val2 = 0;

    if (l1 != null) {
        val1 = l1.val;
    }

    if (l2 != null) {
        val2 = l2.val;
    }

    int sum = val1 + val2 + carry;

    int digit = sum % 10;
    carry = sum / 10;

    curr.next = new ListNode(digit);
    curr = curr.next;

    if (l1 != null) {
        l1 = l1.next;
    }

    if (l2 != null) {
        l2 = l2.next;
    }
}

return dummy.next;
```
