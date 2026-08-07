# 🔗 LeetCode 21 - Merge Two Sorted Lists

## 📌 Problem Statement

Given the heads of two sorted linked lists `list1` and `list2`, merge them into one sorted linked list and return the head of the merged list.

---

# 🧠 Pattern

**Dummy Node Pattern**

Whenever a question asks to:
- Merge linked lists
- Build a new linked list
- Insert nodes one by one

👉 Think **Dummy Node + Current Pointer**

---

# 💡 Intuition

Since both linked lists are already sorted, compare the current node of each list and attach the smaller node to the merged list.

A **Dummy Node** helps avoid handling the head node separately.

---

# 📋 Algorithm

1. Create a dummy node.
2. Point `curr` to the dummy node.
3. Traverse both linked lists until one becomes `null`.
4. Compare `list1.val` and `list2.val`.
5. Attach the smaller node to `curr.next`.
6. Move the corresponding list pointer.
7. Move `curr` to the next node.
8. Attach the remaining nodes of the non-empty list.
9. Return `dummy.next`.

---

# 📝 Pseudocode

```text
1. Create dummy node.

2. curr = dummy

3. While(list1 != null && list2 != null)

      if(list1.val <= list2.val)
          curr.next = list1
          list1 = list1.next
      else
          curr.next = list2
          list2 = list2.next

      curr = curr.next

4. If(list1 != null)
       curr.next = list1

5. Else
       curr.next = list2

6. Return dummy.next
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

```
O(n + m)
```

- `n` = Length of list1
- `m` = Length of list2

Each node is visited exactly once.

### Space Complexity

```
O(1)
```

Only pointers are used.

---

# ❌ Mistakes to Avoid

### ❌ Mistake 1 (Time Limit Exceeded)

```java
while(list1 != null){
    curr.next = list1;
}
```

or

```java
while(list2 != null){
    curr.next = list2;
}
```

### Why is it wrong?

Inside the loop, neither `list1` nor `list2` is moved.

Example:

```java
while(list1 != null){
    curr.next = list1;
}
```

`list1` always points to the same node.

Condition:

```text
list1 != null
```

is always true.

➡️ Infinite Loop

➡️ Time Limit Exceeded (TLE)

---

### ✅ Correct

```java
if(list1 != null){
    curr.next = list1;
}
else{
    curr.next = list2;
}
```

We simply attach the remaining linked list because it is already sorted.

---

### ❌ Mistake 2

Returning

```java
return dummy;
```

### ✅ Correct

```java
return dummy.next;
```

---

### ❌ Mistake 3

Forgetting

```java
curr = curr.next;
```

The merged list will not grow correctly.

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

> I create a dummy node to simplify handling the head of the merged list. A current pointer starts from the dummy node. While both linked lists contain nodes, I compare their current values and attach the smaller node to the merged list. Then I move the corresponding list pointer and the current pointer. After one list becomes empty, I attach the remaining nodes of the other list directly and finally return `dummy.next`.

---

# ⭐ Quick Revision

- Pattern → Dummy Node Pattern
- Create `dummy`
- Create `curr`
- Compare both nodes
- Attach smaller node
- Move corresponding list pointer
- Move `curr`
- Attach remaining list
- Return `dummy.next`

**Time:** `O(n + m)`

**Space:** `O(1)`
