# 🔗 LeetCode 876 - Middle of the Linked List

## 📌 Problem

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the **second middle node**.

### Examples

```text
Input:
1 → 2 → 3 → 4 → 5

Output:
3 → 4 → 5
```

For an even-length list:

```text
Input:
1 → 2 → 3 → 4 → 5 → 6

Output:
4 → 5 → 6
```

The two middle nodes are `3` and `4`, so we return the **second middle node**, `4`.

---

# 🧩 Pattern

## Fast & Slow Pointer Pattern

This is the same pattern used in:

- LeetCode 141 - Linked List Cycle
- LeetCode 19 - Remove Nth Node From End
- LeetCode 142 - Linked List Cycle II

### Pointers

```text
slow → moves 1 step
fast → moves 2 steps
```

---

# 💡 Intuition

Instead of counting the length of the linked list first, we can use two pointers.

- `slow` moves one node at a time.
- `fast` moves two nodes at a time.

When `fast` reaches the end, `slow` will be at the middle.

### Why?

Because `fast` moves twice as fast as `slow`.

So when `fast` travels the whole list, `slow` travels approximately half of it.

---

# 📋 Algorithm

1. Initialize `slow = head`.
2. Initialize `fast = head`.
3. Traverse while `fast != null` and `fast.next != null`.
4. Move `slow` one step.
5. Move `fast` two steps.
6. When the loop ends, `slow` points to the middle node.
7. Return `slow`.

---

# 📝 Pseudocode

```text
slow = head
fast = head

while(fast != null && fast.next != null)

    slow = slow.next
    fast = fast.next.next

return slow
```

---

# 🛠️ What Are We Using?

## `slow`

Moves one node at a time.

```java
slow = slow.next;
```

## `fast`

Moves two nodes at a time.

```java
fast = fast.next.next;
```

## Loop Condition

```java
while(fast != null && fast.next != null)
```

This safely allows:

```java
fast.next.next
```

to be accessed.

---

# 🎨 Dry Run - Odd Length

### Input

```text
1 → 2 → 3 → 4 → 5 → null
```

### Start

```text
slow = 1
fast = 1
```

---

### Iteration 1

Move `slow` one step:

```text
slow = 2
```

Move `fast` two steps:

```text
fast = 3
```

Now:

```text
slow = 2
fast = 3
```

---

### Iteration 2

Move `slow`:

```text
slow = 3
```

Move `fast`:

```text
3 → 4 → 5
```

So:

```text
fast = 5
```

Now:

```text
slow = 3
fast = 5
```

---

### Next Loop Check

```text
fast != null       → true
fast.next != null  → false
```

Loop ends.

Therefore:

```text
slow = 3
```

Return:

```text
3 → 4 → 5
```

✅ Correct.

---

# 🎨 Dry Run - Even Length

### Input

```text
1 → 2 → 3 → 4 → 5 → 6 → null
```

### Start

```text
slow = 1
fast = 1
```

---

### Iteration 1

```text
slow = 2
fast = 3
```

---

### Iteration 2

```text
slow = 3
fast = 5
```

---

### Iteration 3

```text
slow = 4
fast = null
```

Now the loop ends.

Therefore:

```text
slow = 4
```

Return:

```text
4 → 5 → 6
```

✅ Correct.

### Important

For an even-length list:

```text
1 → 2 → 3 → 4 → 5 → 6
        ↑   ↑
      middle nodes
```

The problem asks for the **second middle node**, so we return:

```text
4
```

The `slow/fast` approach naturally gives us the second middle node.

---

# 💻 Java Code

```java
class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
```

---

# ⏱️ Complexity

## Time Complexity

```text
O(n)
```

`fast` travels through the list, so we visit the nodes once.

## Space Complexity

```text
O(1)
```

Only two pointers are used.

---

# ⚠️ Common Mistakes

## ❌ Mistake 1 - Moving both pointers at the same speed

Wrong:

```java
slow = slow.next;
fast = fast.next;
```

Both pointers move one step.

They will not give us the middle correctly.

### ✅ Correct

```java
slow = slow.next;
fast = fast.next.next;
```

Remember:

```text
slow → 1 step
fast → 2 steps
```

---

## ❌ Mistake 2 - Wrong `while` condition

Wrong:

```java
while(fast != null)
```

This is not safe because inside the loop we use:

```java
fast.next.next
```

`fast.next` could be `null`.

### ✅ Correct

```java
while(fast != null && fast.next != null)
```

This guarantees that both:

```text
fast
fast.next
```

exist before doing:

```java
fast.next.next
```

---

## ❌ Mistake 3 - Returning `fast`

Wrong:

```java
return fast;
```

`fast` is moving twice as fast and eventually reaches `null`.

### ✅ Correct

```java
return slow;
```

`slow` is the pointer that ends at the middle.

---

## ❌ Mistake 4 - Counting the length first

A possible approach is:

```text
1. Count all nodes
2. Find n/2
3. Traverse again
```

This works, but requires two traversals.

The fast/slow approach finds the middle in **one traversal**.

---

## ❌ Mistake 5 - Returning the first middle for even length

For:

```text
1 → 2 → 3 → 4 → 5 → 6
```

The middle nodes are:

```text
3 and 4
```

The problem requires the **second middle**, so answer is:

```text
4
```

Starting both pointers at `head` naturally gives the second middle.

---

# 🔄 Wrong vs Correct

## Pointer Movement

### ❌ Wrong

```java
slow = slow.next;
fast = fast.next;
```

### ✅ Correct

```java
slow = slow.next;
fast = fast.next.next;
```

---

## Loop Condition

### ❌ Wrong

```java
while(fast != null)
```

### ✅ Correct

```java
while(fast != null && fast.next != null)
```

---

## Return

### ❌ Wrong

```java
return fast;
```

### ✅ Correct

```java
return slow;
```

---

# 🎤 Interview Explanation

> I will use the fast and slow pointer technique. The slow pointer moves one step while the fast pointer moves two steps. When the fast pointer reaches the end of the list, the slow pointer will be at the middle. For an even-length list, this approach naturally returns the second middle node, which is what the problem requires. The solution takes O(n) time and O(1) space.

---

# 💻 Live Coding Tips

When you see:

> "Find the middle of a linked list"

Immediately think:

```text
Middle → Fast & Slow
```

Then write:

```java
ListNode slow = head;
ListNode fast = head;
```

Use:

```java
while(fast != null && fast.next != null)
```

Inside:

```java
slow = slow.next;
fast = fast.next.next;
```

Finally:

```java
return slow;
```

---

# 🧠 Quick Revision

```text
Pattern:
Fast & Slow

slow:
1 step

fast:
2 steps

Loop:
while(fast != null && fast.next != null)

Inside:
slow = slow.next
fast = fast.next.next

Return:
slow

Time:
O(n)

Space:
O(1)
```

---

# ⭐ One-Line Memory

> **Fast moves 2, Slow moves 1 → Fast reaches end → Slow is at middle.**

---

# 🔗 Related Problems

- **LeetCode 141** - Linked List Cycle
- **LeetCode 142** - Linked List Cycle II
- **LeetCode 19** - Remove Nth Node From End
- **LeetCode 234** - Palindrome Linked List

All of these use the **Fast & Slow Pointer** pattern in different ways.

---

# 🚀 Key Takeaways

- Use **Fast & Slow Pointers**.
- `slow` moves one step.
- `fast` moves two steps.
- Use `fast != null && fast.next != null`.
- Return `slow`.
- For even-length lists, this returns the **second middle node**.
- Time: `O(n)`
- Space: `O(1)`

## 🔑 Final Template

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;
}

return slow;
```
