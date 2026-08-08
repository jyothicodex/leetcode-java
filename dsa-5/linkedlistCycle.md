# 🔄 LeetCode 141 - Linked List Cycle

## 📌 Problem

Given the head of a linked list, determine whether the linked list contains a cycle.

A cycle exists if a node can be reached again by continuously following the `next` pointer.

### Example

```text
Input:
3 → 2 → 0 → -4
    ↑         ↓
    └─────────┘

Output:
true
```

If the linked list ends with `null`, there is no cycle.

```text
1 → 2 → 3 → null

Output:
false
```

---

# 🧩 Pattern

## Fast & Slow Pointer Pattern

Also called:

**Floyd's Cycle Detection Algorithm**

We use two pointers:

```text
slow → moves 1 step
fast → moves 2 steps
```

---

# 💡 Intuition

Imagine two runners running on a track.

- `slow` moves one step at a time.
- `fast` moves two steps at a time.

### If there is no cycle

`fast` will eventually reach `null`.

```text
1 → 2 → 3 → null
```

So there is no cycle.

### If there is a cycle

Both pointers enter the cycle.

Since `fast` is moving faster than `slow`, eventually `fast` will catch `slow`.

```text
slow == fast
```

Therefore, a cycle exists.

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

---

# 📋 Algorithm

1. Initialize `slow = head`.
2. Initialize `fast = head`.
3. Continue while `fast != null` and `fast.next != null`.
4. Move `slow` one step.
5. Move `fast` two steps.
6. After moving them, check if `slow == fast`.
7. If they meet, return `true`.
8. If the loop ends, `fast` reached the end, so return `false`.

---

# 📝 Pseudocode

```text
slow = head
fast = head

while(fast != null && fast.next != null)

    slow = slow.next
    fast = fast.next.next

    if(slow == fast)
        return true

return false
```

---

# 🎨 Dry Run - No Cycle

### Input

```text
1 → 2 → 3 → null
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

They are not equal.

---

### Next Check

```text
fast.next == null
```

So the `while` condition becomes false.

The loop ends.

```java
return false;
```

### Result

```text
false
```

There is no cycle.

---

# 🎨 Dry Run - Cycle Exists

### Input

```text
1 → 2 → 3 → 4
    ↑       ↓
    └───────┘
```

The links are:

```text
1 → 2 → 3 → 4
    ↑       ↓
    └───────┘
```

So after `4`, we go back to `2`.

---

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

Not equal.

---

### Iteration 2

`slow` moves one:

```text
slow = 3
```

`fast` moves two:

```text
3 → 4 → 2
```

So:

```text
fast = 2
```

Not equal.

---

### Iteration 3

```text
slow = 4
```

`fast` moves:

```text
2 → 3 → 4
```

So:

```text
fast = 4
```

Now:

```text
slow == fast
```

Therefore:

```java
return true;
```

### Result

```text
true
```

A cycle exists.

---

# 💻 Java Code

```java
class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
```

---

# ⏱️ Complexity

## Time Complexity

```text
O(n)
```

In the worst case, we visit the nodes a constant number of times.

## Space Complexity

```text
O(1)
```

Only two pointers are used.

No extra data structure is required.

---

# ❌ My Mistake

Initially, I wrote:

```java
while(fast != null && fast.next != null){
    fast = fast.next.next;
    slow = slow.next;
}

if(fast == slow){
    return true;
}
else{
    return false;
}
```

The problem was checking:

```java
if(fast == slow)
```

**after the loop.**

---

# ❌ Why Was This Wrong?

Consider a single-node list:

```text
1 → null
```

Initially:

```text
slow = 1
fast = 1
```

The loop does not execute because:

```text
fast.next == null
```

Then the code checks:

```java
fast == slow
```

which is:

```text
1 == 1
```

So it returns:

```text
true
```

❌ But there is no cycle.

---

# ✅ Correct Line

The meeting check must happen **inside the loop after moving both pointers**:

```java
slow = slow.next;
fast = fast.next.next;

if (slow == fast) {
    return true;
}
```

Then after the loop:

```java
return false;
```

---

# 🔄 Wrong vs Correct

## ❌ Wrong

```java
while(fast != null && fast.next != null){
    fast = fast.next.next;
    slow = slow.next;
}

if(fast == slow){
    return true;
}

return false;
```

### Problem

We check whether they are equal even when the loop never ran.

---

## ✅ Correct

```java
while(fast != null && fast.next != null){

    slow = slow.next;
    fast = fast.next.next;

    if(slow == fast){
        return true;
    }
}

return false;
```

### Why?

There are only two possibilities:

```text
Pointers meet
     ↓
   TRUE
```

or

```text
Fast reaches null
     ↓
   FALSE
```

---

# ⚠️ Important Mistakes to Avoid

## 1. Checking `slow == fast` outside the loop

❌ Wrong:

```java
if(slow == fast)
```

after the loop.

✅ Correct:

```java
if(slow == fast)
```

inside the loop, after moving both pointers.

---

## 2. Wrong `while` condition

Use:

```java
while(fast != null && fast.next != null)
```

Why both?

Because we need to safely execute:

```java
fast = fast.next.next;
```

We need:

```text
fast
  ↓
fast.next
  ↓
fast.next.next
```

So both `fast` and `fast.next` must exist.

---

## 3. Moving `fast` only one step

❌ Wrong:

```java
fast = fast.next;
```

Then both pointers move at the same speed.

Use:

```java
fast = fast.next.next;
```

---

## 4. Checking before moving

The important sequence is:

```text
Move slow
Move fast
Check if they meet
```

Not:

```text
Check
Move slow
Move fast
```

---

# 🎤 Interview Explanation

> I will use Floyd's Cycle Detection algorithm with two pointers. `slow` moves one step at a time and `fast` moves two steps at a time. If there is no cycle, `fast` will eventually reach `null`. If a cycle exists, both pointers will enter the cycle, and because `fast` moves faster, it will eventually meet `slow`. Therefore, I check `slow == fast` inside the loop after moving both pointers. If they meet, I return true; if the loop ends, I return false.

---

# 💻 Live Coding Tips

### Step 1

Immediately think:

```text
Cycle → Fast & Slow
```

### Step 2

Initialize:

```java
ListNode slow = head;
ListNode fast = head;
```

### Step 3

Remember the safe loop condition:

```java
while(fast != null && fast.next != null)
```

### Step 4

Move:

```java
slow = slow.next;
fast = fast.next.next;
```

### Step 5

Check:

```java
if(slow == fast)
    return true;
```

### Step 6

After the loop:

```java
return false;
```

---

# 🧠 Quick Revision

```text
Pattern:
Fast & Slow Pointer

slow:
1 step

fast:
2 steps

while:
fast != null && fast.next != null

Inside:
slow = slow.next
fast = fast.next.next

Then:
if(slow == fast)
    return true

After loop:
return false
```

---

# ⭐ Memory Trick

> **Cycle → Fast & Slow → Move → Meet = TRUE → Escape to NULL = FALSE**

---

# 🔗 Related Problems

- **LeetCode 142** — Linked List Cycle II
- **LeetCode 876** — Middle of the Linked List
- **LeetCode 19** — Remove Nth Node From End of List

These problems reuse the **Fast & Slow Pointer** pattern.

---

# 🚀 Key Takeaways

- Use **Floyd's Cycle Detection**.
- `slow` moves 1 step.
- `fast` moves 2 steps.
- Use `while(fast != null && fast.next != null)`.
- Check `slow == fast` **inside the loop**.
- If they meet → cycle exists → `true`.
- If `fast` reaches `null` → no cycle → `false`.
- Time: `O(n)`
- Space: `O(1)`.

## 🔑 Final Template

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        return true;
    }
}

return false;
```
