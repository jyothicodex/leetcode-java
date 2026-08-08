# 🔗 LeetCode 203 - Remove Linked List Elements

## 📌 Problem

Given the head of a linked list and an integer `val`, remove all the nodes of the linked list that have `Node.val == val`.

Return the head of the modified linked list.

### Example

```text
Input:
1 → 2 → 6 → 3 → 4 → 5 → 6
val = 6

Output:
1 → 2 → 3 → 4 → 5
```

---

# 🧩 Pattern

## Dummy Node + Traversal

We use:

```text
dummy → helper node
curr  → builds the result
temp  → scans the original list
```

---

# 💡 Intuition

We scan the linked list using `temp`.

For every node:

- If its value is equal to `val`, skip it.
- If its value is not equal to `val`, keep it in the result list.

The `dummy` node makes it easier to build the result without separately handling the head.

### Important Idea

```text
temp = scanner
curr = builder
```

`temp` checks every node.

`curr` only moves when we keep a node.

---

# 📋 Algorithm

1. Create a dummy node.
2. Set `curr = dummy`.
3. Set `temp = head`.
4. Traverse while `temp != null`.
5. If `temp.val != val`:
   - Connect `curr.next = temp`.
   - Move `curr = curr.next`.
6. Move `temp = temp.next` in every iteration.
7. After the loop, set `curr.next = null` to remove any old connection from the last kept node.
8. Return `dummy.next`.

---

# 📝 Pseudocode

```text
dummy = new Node(-1)
curr = dummy
temp = head

while(temp != null)

    if(temp.val != val)

        curr.next = temp
        curr = curr.next

    temp = temp.next

curr.next = null

return dummy.next
```

---

# 🛠️ What Are We Using?

## `dummy`

A helper node placed before the actual head.

```text
dummy → head
```

It makes building the result easier.

---

## `curr`

Points to the last node that we kept.

```text
curr = curr.next
```

Only move `curr` when a node is accepted.

---

## `temp`

Scans the original linked list.

```java
temp = temp.next;
```

`temp` must move exactly once in every iteration.

---

# 🎨 Dry Run

### Input

```text
1 → 2 → 6 → 3 → 4 → 5 → 6 → null

val = 6
```

---

## Initial State

```text
dummy → null
  ↑
 curr

temp
 ↓
1 → 2 → 6 → 3 → 4 → 5 → 6 → null
```

---

## Iteration 1

```text
temp = 1
```

Check:

```text
1 != 6
```

Keep it.

```java
curr.next = temp;
curr = curr.next;
```

Result:

```text
dummy → 1
         ↑
        curr
```

Then:

```java
temp = temp.next;
```

Now:

```text
temp = 2
```

---

## Iteration 2

```text
temp = 2
```

Check:

```text
2 != 6
```

Keep it.

Result:

```text
dummy → 1 → 2
              ↑
             curr
```

Move:

```text
temp = 6
```

---

## Iteration 3

```text
temp = 6
```

Check:

```text
6 == 6
```

Skip it.

Do NOT move `curr`.

Only:

```java
temp = temp.next;
```

Now:

```text
temp = 3
```

Result still:

```text
dummy → 1 → 2
```

---

## Iteration 4

```text
temp = 3
```

```text
3 != 6
```

Keep it.

```text
dummy → 1 → 2 → 3
                   ↑
                  curr
```

Move:

```text
temp = 4
```

---

## Iteration 5

```text
temp = 4
```

Keep it.

```text
dummy → 1 → 2 → 3 → 4
```

Move:

```text
temp = 5
```

---

## Iteration 6

```text
temp = 5
```

Keep it.

```text
dummy → 1 → 2 → 3 → 4 → 5
```

Move:

```text
temp = 6
```

---

## Iteration 7

```text
temp = 6
```

Since:

```text
6 == val
```

skip it.

Move:

```text
temp = null
```

---

# ⚠️ Why Do We Need `curr.next = null`?

This was an important mistake during implementation.

The original list contains:

```text
5 → 6 → null
```

We reuse the original node `5`.

Therefore, even after filtering, `5` may still point to the old `6`.

So without:

```java
curr.next = null;
```

we can accidentally get:

```text
1 → 2 → 3 → 4 → 5 → 6
```

instead of:

```text
1 → 2 → 3 → 4 → 5 → null
```

Setting:

```java
curr.next = null;
```

cuts the old connection.

Final:

```text
1 → 2 → 3 → 4 → 5 → null
```

---

# 💻 Java Code

```java
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode temp = head;

        while (temp != null) {

            if (temp.val != val) {
                curr.next = temp;
                curr = curr.next;
            }

            temp = temp.next;
        }

        curr.next = null;

        return dummy.next;
    }
}
```

---

# ❌ Mistakes I Made

## Mistake 1 - `temp` did not move when the value matched

Initially:

```java
while(temp != null) {
    if(temp.val != val) {
        curr.next = temp;
        temp = temp.next;
        curr = curr.next;
    }
}
```

### Problem

If:

```text
temp.val == val
```

the `if` condition is false.

Therefore:

```java
temp = temp.next;
```

does not execute.

`temp` stays on the same node forever.

### Result

```text
Infinite Loop
↓
Time Limit Exceeded
```

### ❌ Wrong

```java
if(temp.val != val) {
    ...
    temp = temp.next;
}
```

### ✅ Correct

Move `temp` outside the `if`:

```java
if(temp.val != val) {
    curr.next = temp;
    curr = curr.next;
}

temp = temp.next;
```

---

# ❌ Mistake 2 - Moving `temp` Twice

I also tried:

```java
if(temp.val != val) {
    curr.next = temp;
    temp = temp.next;
    curr = curr.next;
}

temp = temp.next;
```

### Problem

When the node is valid, `temp` moves:

```text
inside if → once
outside if → again
```

So it moves twice.

### Result

Some nodes get skipped.

### Example

```text
1 → 2 → 3
```

At `1`:

```text
temp = 1
```

Inside `if`:

```text
temp = 2
```

Outside:

```text
temp = 3
```

Node `2` was skipped.

### ❌ Wrong

```java
if(temp.val != val) {
    temp = temp.next;
}

temp = temp.next;
```

### ✅ Correct

```java
if(temp.val != val) {
    curr.next = temp;
    curr = curr.next;
}

temp = temp.next;
```

---

# ❌ Mistake 3 - Forgetting `curr.next = null`

The result initially looked like:

```text
1 → 2 → 3 → 4 → 5 → 6
```

even though `6` should be removed.

### Why?

We reused the original node `5`.

Originally:

```text
5 → 6
```

So `5` still had its old `next` pointer.

### ❌ Missing

```java
curr.next = null;
```

### ✅ Correct

```java
curr.next = null;
```

This disconnects the unwanted old node.

---

# 🔄 Wrong vs Correct

## Moving `temp`

### ❌ Wrong

```java
if(temp.val != val) {
    temp = temp.next;
}
```

### ✅ Correct

```java
if(temp.val != val) {
    curr.next = temp;
    curr = curr.next;
}

temp = temp.next;
```

---

## Moving `curr`

### ❌ Wrong idea

Move `curr` for every node.

### ✅ Correct

Move `curr` only when the node is kept.

```java
if(temp.val != val) {
    curr.next = temp;
    curr = curr.next;
}
```

---

## Ending the Result

### ❌ Missing

```java
curr.next = null;
```

### ✅ Correct

```java
curr.next = null;
```

This cuts the old connection.

---

# 🧠 Important Pointer Rule

Remember:

```text
temp → scanner
curr → builder
```

### `temp`

Moves every time:

```java
temp = temp.next;
```

### `curr`

Moves only when we keep the node:

```java
curr = curr.next;
```

### Final connection

```java
curr.next = null;
```

---

# 🎤 Interview Explanation

> I use a dummy node and two pointers. `temp` scans the original linked list, while `curr` builds the result list. For every node, if its value is not equal to the target value, I connect it to `curr` and move `curr`. Regardless of whether the node is kept or removed, I always move `temp` forward. After traversal, I set `curr.next` to null to remove any old connection from the last kept node. Finally, I return `dummy.next`.

---

# 💻 Live Coding Tips

When you see:

> "Remove all nodes with a particular value"

Think:

```text
Remove Nodes
     ↓
Dummy + Traversal
```

Then immediately create:

```java
ListNode dummy = new ListNode(-1);
ListNode curr = dummy;
ListNode temp = head;
```

Use this structure:

```java
while(temp != null) {

    if(temp.val != val) {
        curr.next = temp;
        curr = curr.next;
    }

    temp = temp.next;
}

curr.next = null;

return dummy.next;
```

---

# 🧠 Quick Revision

```text
Pattern:
Dummy Node + Traversal

dummy:
helper node

temp:
scans original list

curr:
builds result

If temp.val != val:
    attach temp
    move curr

Always:
    move temp

After loop:
    curr.next = null

Return:
    dummy.next
```

---

# ⭐ One-Line Memory

> **Temp scans everything, Curr keeps valid nodes, Temp always moves, Curr moves only when keeping.**

---

# ⏱️ Complexity

### Time Complexity

```text
O(n)
```

Every node is visited once.

### Space Complexity

```text
O(1)
```

Only pointers are used.

---

# 🔗 Related Problems

- **LeetCode 21** - Merge Two Sorted Lists → Dummy Node
- **LeetCode 203** - Remove Linked List Elements → Dummy Node + Traversal
- **LeetCode 19** - Remove Nth Node From End → Dummy + Fast/Slow
- **LeetCode 24** - Swap Nodes in Pairs → Dummy + Pointer Manipulation

---

# 🚀 Key Takeaways

- Use the **Dummy Node + Traversal** pattern.
- `temp` is the scanner.
- `curr` is the builder.
- `temp` must move exactly once per iteration.
- `curr` moves only when a node is kept.
- If `temp.val == val`, simply skip the node.
- After traversal, use `curr.next = null` to cut any old connection.
- Return `dummy.next`.
- Time: `O(n)`
- Space: `O(1)`

## 🔑 Final Template

```java
ListNode dummy = new ListNode(-1);
ListNode curr = dummy;
ListNode temp = head;

while (temp != null) {

    if (temp.val != val) {
        curr.next = temp;
        curr = curr.next;
    }

    temp = temp.next;
}

curr.next = null;

return dummy.next;
```
