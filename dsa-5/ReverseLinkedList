# 🔄 Reverse Linked List (LeetCode 206)

## 🟢 Problem

Given the `head` of a singly linked list, reverse the list and return the new head.

### Example

**Input**

```text
1 → 2 → 3 → 4 → 5 → null
```

**Output**

```text
5 → 4 → 3 → 2 → 1 → null
```

---

# 🧠 Pattern

> **Linked List → In-Place Reversal (Three Pointer Pattern)**

This is one of the most important Linked List patterns.

Whenever you hear:

- Reverse Linked List
- Reverse first K nodes
- Reverse between left and right
- Reverse in K groups

👉 Think **Three Pointers**

---

# 💡 Intuition

Normally every node points **forward**.

Example:

```text
1 → 2 → 3 → 4
```

We want

```text
1 ← 2 ← 3 ← 4
```

But if we directly change

```java
curr.next = prev;
```

we lose the remaining list.

Example

```text
1 → 2 → 3
```

If we make

```text
1 ← null
```

Where is node **2**?

Lost forever.

So first we **save** the next node.

---

# 🎯 Idea

For every node

1. Save next node
2. Reverse current pointer
3. Move prev
4. Move curr

Repeat until curr becomes null.

---

# 📌 Algorithm

```
Initialize

prev = null
curr = head

while(curr != null)

    Save next node

    Reverse pointer

    Move prev

    Move curr

Return prev
```

---

# 🛠️ What are we using?

## Three Pointers

```text
prev
curr
next
```

### prev

Points to already reversed list.

### curr

Current node being processed.

### next

Temporarily stores next node so we don't lose the remaining list.

---

# 🎨 Visualization

Initial

```text
prev

null

curr
 ↓
1 → 2 → 3 → 4 → null
```

Iteration 1

Save next

```text
next
 ↓
2
```

Reverse

```text
1 → null
```

Move

```text
prev
 ↓
1 → null

curr
 ↓
2 → 3 → 4
```

---

Iteration 2

```text
2 → 1 → null

curr
 ↓
3 → 4
```

---

Iteration 3

```text
3 → 2 → 1 → null

curr
 ↓
4
```

---

Iteration 4

```text
4 → 3 → 2 → 1 → null

curr = null
```

Return

```text
4 → 3 → 2 → 1
```

---

# 🧪 Dry Run

Input

```text
1 → 2 → 3
```

| Iteration | prev | curr | next | Reversed List |
|-----------|------|------|------|---------------|
| Start | null | 1 | - | - |
| 1 | 1 | 2 | 2 | 1 |
| 2 | 2 | 3 | 3 | 2 → 1 |
| 3 | 3 | null | null | 3 → 2 → 1 |

Return

```text
3 → 2 → 1
```

---

# 💻 Java Code

```java
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;      // Save

            curr.next = prev;      // Reverse

            prev = curr;           // Move prev

            curr = next;           // Move curr
        }

        return prev;
    }
}
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```
O(n)
```

Every node is visited exactly once.

---

### Space Complexity

```
O(1)
```

Only three pointers are used.

No extra data structure.

---

# 📝 Remember (Interview Trick)

Always remember this order.

```text
Save

↓

Reverse

↓

Move Prev

↓

Move Curr
```

Or

```
S → R → M → M
```

**S** = Save next

**R** = Reverse pointer

**M** = Move prev

**M** = Move curr

Never change the order.

---

# ❌ Common Mistakes

### ❌ Mistake 1

```java
curr.next = prev;
curr = next;
prev = curr;
```

Wrong.

After moving curr, prev also moves to the next node.

---

### ❌ Mistake 2

```java
curr.next = prev;
```

before saving next.

You lose the remaining list.

---

### ❌ Mistake 3

Returning

```java
return head;
```

Wrong.

Head becomes the last node.

Always return

```java
return prev;
```

---

# 🧩 Pattern Recognition

If the question says

- Reverse Linked List
- Reverse first K nodes
- Reverse between positions
- Reverse every K nodes
- Reverse alternate K nodes

Immediately think

```
Three Pointer Pattern

prev
curr
next
```

---

# 📚 Similar Problems

- LeetCode 92 — Reverse Linked List II
- LeetCode 25 — Reverse Nodes in K Group
- LeetCode 24 — Swap Nodes in Pairs
- LeetCode 61 — Rotate List
- LeetCode 143 — Reorder List
- LeetCode 234 — Palindrome Linked List

---

# ⭐ Key Takeaways

- Reverse is done **in-place**.
- Use **three pointers** (`prev`, `curr`, `next`).
- Save the next node before changing links.
- Return `prev`, not `head`.
- Time: **O(n)**
- Space: **O(1)**
- This is the **foundation** for almost every advanced Linked List reversal problem.
