# 🔄 LeetCode 142 - Linked List Cycle II

## 📌 Problem

Given the head of a linked list, return the node where the cycle begins.

If there is no cycle, return `null`.

### Important

We are **not just checking whether a cycle exists**.

- LeetCode 141 → Does a cycle exist?
- LeetCode 142 → **Where does the cycle start?**

---

## 🧩 Pattern

### Fast & Slow Pointer + Floyd's Cycle Detection

This problem uses the same first step as LeetCode 141:

```text
slow → 1 step
fast → 2 steps
```

But after they meet, we use a second step to find the **starting node of the cycle**.

---

# 💡 Intuition

Consider:

```text
1 → 2 → 3 → 4 → 5
        ↑       ↓
        └───────┘
```

The cycle starts at:

```text
3
```

First, use `slow` and `fast` to detect the cycle.

When they meet, we know:

```text
A cycle exists
```

But the meeting point is **not necessarily the cycle start**.

So we use another pointer.

### The trick

After `slow` and `fast` meet:

1. Keep one pointer at the meeting point.
2. Put another pointer at `head`.
3. Move both **one step at a time**.
4. The point where they meet is the cycle starting node.

---

# 🧠 Why Does This Work?

Suppose:

```text
head → A → B → C → D → E
              ↑       ↓
              └───────┘
```

Let:

```text
a = distance from head to cycle start
b = distance from cycle start to meeting point
c = remaining distance in cycle
```

When `slow` and `fast` meet:

```text
slow distance = a + b
```

`fast` has travelled twice as far:

```text
fast distance = a + b + cycle length
```

Because `fast` travels twice as fast:

```text
2(a + b) = a + b + cycle length
```

Therefore:

```text
a + b = cycle length
```

So:

```text
a = cycle length - b
```

That means the distance from the meeting point back to the cycle start is exactly the same as the distance from `head` to the cycle start.

Therefore:

```text
head → cycle start
meeting point → cycle start
```

have equal distances.

So if both pointers move one step at a time, they meet exactly at the cycle start.

---

# 📋 Algorithm

## Phase 1 - Detect the Cycle

1. Initialize `slow = head`.
2. Initialize `fast = head`.
3. Move:
   - `slow` one step.
   - `fast` two steps.
4. If `slow == fast`, a cycle exists.
5. If `fast == null` or `fast.next == null`, there is no cycle.

## Phase 2 - Find the Cycle Start

6. Keep `slow` at the meeting point.
7. Reset `fast` to `head`.
8. Move both one step at a time.
9. When `slow == fast`, that node is the cycle start.
10. Return `slow`.

---

# 📝 Pseudocode

```text
slow = head
fast = head

while(fast != null && fast.next != null)

    slow = slow.next
    fast = fast.next.next

    if(slow == fast)

        fast = head

        while(slow != fast)

            slow = slow.next
            fast = fast.next

        return slow

return null
```

---

# 🛠️ What Are We Using?

### `slow`

First:

```text
Moves 1 step
```

After meeting:

```text
Moves 1 step
```

### `fast`

First:

```text
Moves 2 steps
```

After meeting:

```text
Reset to head
Moves 1 step
```

### Two Phases

```text
Phase 1:
Detect meeting point

Phase 2:
Find cycle start
```

---

# 🎨 Dry Run

Consider:

```text
1 → 2 → 3 → 4 → 5
        ↑       ↓
        └───────┘
```

Cycle starts at:

```text
3
```

---

## Phase 1 - Detect Cycle

### Initial

```text
slow = 1
fast = 1
```

---

### Iteration 1

Slow moves 1:

```text
slow = 2
```

Fast moves 2:

```text
fast = 3
```

So:

```text
slow = 2
fast = 3
```

Not equal.

---

### Iteration 2

Slow:

```text
slow = 3
```

Fast:

```text
3 → 4 → 5
```

So:

```text
fast = 5
```

Not equal.

---

### Iteration 3

Slow:

```text
slow = 4
```

Fast:

```text
5 → 3 → 4
```

So:

```text
fast = 4
```

Now:

```text
slow == fast
```

They meet at:

```text
4
```

⚠️ Important:

**4 is NOT the cycle start.**

The cycle starts at:

```text
3
```

---

# 🔄 Phase 2 - Find Cycle Start

Now:

```text
slow = 4
```

Reset:

```java
fast = head;
```

So:

```text
slow = 4
fast = 1
```

---

### Iteration 1

Move both one step:

```text
slow = 5
fast = 2
```

Not equal.

---

### Iteration 2

```text
slow = 3
fast = 3
```

They meet.

Therefore:

```text
3
```

is the cycle start.

Return:

```java
return slow;
```

---

# 💻 Java Code

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Phase 2: Find cycle start
                fast = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
```

---

# ⚠️ Common Mistakes

## ❌ Mistake 1 - Returning the meeting point

A very common mistake is:

```java
if (slow == fast) {
    return slow;
}
```

This only tells us that a cycle exists.

The meeting point is **not necessarily the cycle start**.

### Example

```text
1 → 2 → 3 → 4 → 5
        ↑       ↓
        └───────┘
```

They might meet at:

```text
4
```

But the cycle starts at:

```text
3
```

### ❌ Wrong

```java
if (slow == fast) {
    return slow;
}
```

### ✅ Correct

```java
if (slow == fast) {

    fast = head;

    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow;
}
```

---

# ❌ Mistake 2 - Forgetting to reset `fast`

After the meeting:

```text
slow = meeting point
fast = meeting point
```

We need:

```java
fast = head;
```

### ❌ Wrong

```java
while(slow != fast) {
    ...
}
```

without resetting `fast`.

They are already equal, so the loop would not execute.

### ✅ Correct

```java
fast = head;
```

Then:

```java
while(slow != fast)
```

---

# ❌ Mistake 3 - Moving `fast` two steps in Phase 2

Phase 1:

```java
fast = fast.next.next;
```

Phase 2 is different.

Both pointers must move **one step**:

```java
slow = slow.next;
fast = fast.next;
```

### Remember

```text
Phase 1:
slow → 1
fast → 2

Phase 2:
slow → 1
fast → 1
```

---

# ❌ Mistake 4 - Wrong while condition in Phase 1

### ❌ Wrong

```java
while(fast != null)
```

Because we access:

```java
fast.next.next
```

### ✅ Correct

```java
while(fast != null && fast.next != null)
```

This safely allows `fast` to move two steps.

---

# ❌ Mistake 5 - Forgetting the no-cycle case

If there is no cycle:

```text
1 → 2 → 3 → null
```

Eventually:

```text
fast == null
```

or:

```text
fast.next == null
```

So we exit the loop.

Then:

```java
return null;
```

---

# 🔄 Wrong vs Correct

## Detecting the Cycle

### ❌ Wrong

```java
while(fast != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

### ✅ Correct

```java
while(fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

---

## After Meeting

### ❌ Wrong

```java
return slow;
```

### ✅ Correct

```java
fast = head;

while(slow != fast) {
    slow = slow.next;
    fast = fast.next;
}

return slow;
```

---

## Phase 2 Pointer Movement

### ❌ Wrong

```java
fast = fast.next.next;
```

### ✅ Correct

```java
fast = fast.next;
```

Both pointers move one step in Phase 2.

---

# 🎤 Interview Explanation

> I use Floyd's Cycle Detection algorithm with two pointers. In the first phase, `slow` moves one step and `fast` moves two steps. If they never meet, there is no cycle and I return null. If they meet, I know a cycle exists, but the meeting point is not necessarily the cycle's starting node. So I reset `fast` to the head and move both `slow` and `fast` one step at a time. The node where they meet again is the starting node of the cycle, so I return that node.

---

# 💻 Live Coding Tips

When you see:

> "Find the starting node of a cycle"

Immediately think:

```text
Cycle Start
     ↓
Fast + Slow
     ↓
Two Phases
```

### Phase 1

```java
slow = slow.next;
fast = fast.next.next;
```

Find the meeting point.

### Phase 2

```java
fast = head;

while(slow != fast) {
    slow = slow.next;
    fast = fast.next;
}
```

Find the cycle start.

### Final

```java
return slow;
```

---

# 🧠 Quick Revision

```text
Pattern:
Floyd's Cycle Detection

PHASE 1:
slow = head
fast = head

while(fast != null && fast.next != null)

    slow = slow.next
    fast = fast.next.next

    if(slow == fast)
        cycle found

PHASE 2:
fast = head

while(slow != fast)

    slow = slow.next
    fast = fast.next

return slow
```

---

# ⭐ One-Line Memory

> **Meet first → Reset fast to head → Move both 1 step → Meet again = Cycle Start**

---

# 🔗 Related Problems

- **LeetCode 141** - Linked List Cycle
- **LeetCode 876** - Middle of the Linked List
- **LeetCode 19** - Remove Nth Node From End
- **LeetCode 287** - Find the Duplicate Number

---

# 🚀 Key Takeaways

- LeetCode 141 asks **whether** a cycle exists.
- LeetCode 142 asks **where** the cycle starts.
- Phase 1 uses `slow` = 1 step and `fast` = 2 steps.
- The first meeting point is **not necessarily the cycle start**.
- Reset `fast = head`.
- Phase 2 moves both pointers one step.
- Their second meeting point is the cycle start.
- If no meeting occurs, return `null`.
- Time: `O(n)`
- Space: `O(1)`

## 🔑 Final Template

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {

        fast = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

return null;
```
