# 🔗 LeetCode 21 - Merge Two Sorted Lists

## 📌 Problem Statement

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one sorted linked list and return the head of the merged linked list.

---

# 💡 Intuition

Since both linked lists are already sorted, compare the current nodes of both lists and attach the smaller node to the answer. A **Dummy Node** helps build the merged list without handling special cases for the head.

---

# 🧩 Pattern

**Dummy Node Pattern**

Use this pattern whenever you need to:

- Merge linked lists
- Build a new linked list
- Insert nodes sequentially

---

# 🛠️ What are we using?

### 1. Dummy Node

A temporary node that acts as the starting point of the merged list.

```java
ListNode dummy = new ListNode(-1);
```

### 2. Current Pointer

Used to build the merged linked list.

```java
ListNode curr = dummy;
```

---

# 📋 Algorithm

1. Create a dummy node.
2. Create a `curr` pointer pointing to the dummy node.
3. Traverse both linked lists until one becomes `null`.
4. Compare the current nodes of both lists.
5. Attach the smaller node to `curr.next`.
6. Move the corresponding list pointer.
7. Move `curr` forward.
8. Attach the remaining nodes of the non-empty list.
9. Return `dummy.next`.

---

# 🎨 Dry Run

### Input

```text
list1 = 1 → 2 → 4

list2 = 1 → 3 → 4
```

### Initially

```text
dummy(-1)
   |
 curr

list1 → 1 → 2 → 4

list2 → 1 → 3 → 4
```

---

### Compare 1 and 1

Take list1.

```text
dummy → 1
          ↑
        curr
```

---

### Compare 2 and 1

Take list2.

```text
dummy → 1 → 1
              ↑
            curr
```

---

### Compare 2 and 3

Take list1.

```text
dummy → 1 → 1 → 2
                  ↑
                curr
```

---

### Compare 4 and 3

Take list2.

```text
dummy → 1 → 1 → 2 → 3
                      ↑
                    curr
```

---

### Compare 4 and 4

Take list1.

```text
dummy → 1 → 1 → 2 → 3 → 4
                          ↑
                        curr
```

---

### list1 becomes null

Attach remaining list2.

```text
dummy → 1 → 1 → 2 → 3 → 4 → 4
```

Return

```text
dummy.next
```

---

# 💻 Java Code

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }
}
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n + m)
```

- `n` = Length of list1
- `m` = Length of list2

Each node is visited exactly once.

---

### Space Complexity

```text
O(1)
```

No extra linked list is created.

---

# ❌ Common Mistakes

### 1. Using `while` instead of `if`

❌ Wrong

```java
while(list1 != null){
    curr.next = list1;
}
```

This causes an infinite loop.

✅ Correct

```java
if(list1 != null){
    curr.next = list1;
}
```

---

### 2. Returning the dummy node

❌ Wrong

```java
return dummy;
```

✅ Correct

```java
return dummy.next;
```

---

### 3. Forgetting to move `curr`

Always write

```java
curr = curr.next;
```

after attaching a node.

---

# 🧠 Remember

```text
Create Dummy
      ↓
Create curr
      ↓
Compare Nodes
      ↓
Attach Smaller Node
      ↓
Move List Pointer
      ↓
Move curr
      ↓
Attach Remaining List
      ↓
Return dummy.next
```

---

# 🎤 Interview Explanation

> I create a dummy node to simplify handling the head of the merged list. A `curr` pointer starts from the dummy node. While both lists have nodes, I compare their current values, attach the smaller node, move the corresponding list pointer, and then move `curr`. After one list becomes empty, I attach the remaining nodes of the other list. Finally, I return `dummy.next`, which is the head of the merged linked list.

---

# 📚 Similar Problems

- LeetCode 2 – Add Two Numbers
- LeetCode 23 – Merge K Sorted Lists
- LeetCode 24 – Swap Nodes in Pairs
- LeetCode 86 – Partition List
- LeetCode 92 – Reverse Linked List II

---

# ⚡ Quick Revision

- ✅ Pattern → Dummy Node Pattern
- ✅ Create `dummy` and `curr`
- ✅ Compare both lists
- ✅ Attach smaller node
- ✅ Move corresponding list pointer
- ✅ Move `curr`
- ✅ Attach remaining list
- ✅ Return `dummy.next`

**Time Complexity:** `O(n + m)`

**Space Complexity:** `O(1)`

---

# ⭐ Key Takeaways

- Use the **Dummy Node Pattern** to simplify linked list construction.
- Always compare the current nodes of both lists.
- Attach the smaller node and move the corresponding pointer.
- Move `curr` after every attachment.
- Attach the remaining list after the loop.
- Return `dummy.next`, not `dummy`.
