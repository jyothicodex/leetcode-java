# Get Max from Stack — Special Stack

🔗 [GeeksForGeeks — Get Max from Stack](https://www.geeksforgeeks.org/problems/get-max-from-stack/1)

---

## 1. Problem in Simple Words

Design a stack that supports:

- `push(x)` → insert an element
- `pop()` → remove the top element
- `peek()` → return the top element
- `isEmpty()` → check whether the stack is empty
- `getMax()` → return the maximum element in **O(1)**

---

## 2. Main Challenge

A normal stack can return the top element in O(1), but finding the maximum requires checking all elements.

So:

**Normal `getMax()` → O(n)**

We need:

**`getMax()` → O(1)**

---

## 3. Brute Force Approach

Use one normal stack.

For `getMax()`:

1. Traverse all elements.
2. Keep track of the largest element.
3. Return the maximum.

### Complexity

- `push()` → O(1)
- `pop()` → O(1)
- `peek()` → O(1)
- `getMax()` → O(n)

---

## 4. Optimal Approach / Intuition

Use **two stacks**:

- `stack` → stores actual values
- `specialStack` → stores the maximum at every level

### Example

After:

`push(2) → push(3) → push(1)`

`stack` → `[2, 3, 1]`

`specialStack` → `[2, 3, 3]`

Why?

- After `2` → maximum = `2`
- After `3` → maximum = `3`
- After `1` → maximum is still `3`

Therefore:

`specialStack.peek()` = current maximum

So `getMax()` works in **O(1)**.

---

## 5. Algorithm

### Push

1. Push `x` into `stack`.
2. If `specialStack` is empty, push `x` into `specialStack`.
3. Otherwise, check the current maximum using `specialStack.peek()`.
4. If `x` is smaller than the current maximum, push the current maximum again.
5. Otherwise, push `x` because it becomes the new maximum.

### Pop

1. Pop from `stack`.
2. Pop from `specialStack`.

Both stacks stay synchronized.

### Peek

1. If `stack` is empty, return `-1`.
2. Otherwise, return `stack.peek()`.

### Get Max

1. If `specialStack` is empty, return `-1`.
2. Otherwise, return `specialStack.peek()`.

### Is Empty

1. Return `stack.isEmpty()`.

---

## 6. Pseudocode

### `push(x)`

1. `stack.push(x)`
2. If `specialStack` is empty:
   - `specialStack.push(x)`
3. Otherwise:
   - `currentMax = specialStack.peek()`
   - If `x < currentMax`:
     - `specialStack.push(currentMax)`
   - Else:
     - `specialStack.push(x)`

### `pop()`

1. `stack.pop()`
2. `specialStack.pop()`

### `peek()`

1. If stack is empty → return `-1`
2. Otherwise → return `stack.peek()`

### `getMax()`

1. If special stack is empty → return `-1`
2. Otherwise → return `specialStack.peek()`

### `isEmpty()`

1. Return `stack.isEmpty()`

---

## 7. Java Code

    import java.util.Stack;

    class SpecialStack {
        Stack<Integer> stack;
        Stack<Integer> specialStack;

        public SpecialStack() {
            stack = new Stack<>();
            specialStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);

            if (specialStack.isEmpty()) {
                specialStack.push(x);
            } else if (x < specialStack.peek()) {
                specialStack.push(specialStack.peek());
            } else {
                specialStack.push(x);
            }
        }

        public void pop() {
            stack.pop();
            specialStack.pop();
        }

        public int peek() {
            if (stack.isEmpty()) {
                return -1;
            }

            return stack.peek();
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        public int getMax() {
            if (specialStack.isEmpty()) {
                return -1;
            }

            return specialStack.peek();
        }
    }

---

## 8. Complexity

| Operation | Time |
|---|---:|
| `push()` | O(1) |
| `pop()` | O(1) |
| `peek()` | O(1) |
| `getMax()` | O(1) |
| `isEmpty()` | O(1) |

**Extra Space:** O(n)

---

## 9. Interview Explanation

I use two synchronized stacks. The normal stack stores the actual values, while the special stack stores the maximum at every level.

Therefore, `specialStack.peek()` always gives the current maximum in **O(1)**.

---

## 10. Key Learning / Pattern

### Auxiliary Stack Pattern

When a stack needs extra information in **O(1)**, maintain another stack to store that information.

**Normal Stack + Auxiliary Stack → O(1) extra query**

For this problem:

- `stack` → actual values
- `specialStack` → maximum at every level

### Recognition Trick

If the question says:

**"Get maximum from stack in O(1)"**

Think:

**Two Stacks → Normal Stack + Max Stack**

If the question says:

**"Get minimum from stack in O(1)"**

Think:

**Two Stacks → Normal Stack + Min Stack**

---

## 11. My Mistakes While Solving

- Used `new stack<>()` instead of `new Stack<>()`.
- Initially checked `stack.isEmpty()` instead of `specialStack.isEmpty()` inside `push()`.
- Initially used the Min Stack comparison without thinking about the Max Stack requirement.
- Accidentally pushed into the main stack twice.
- Placed empty checks outside `peek()` and `getMax()`.
- Put `return` before the empty check, creating unreachable code.
- Forgot `()` in `stack.isEmpty()`.
- Learned that `specialStack` must maintain one value for every level of the main stack.

---

## 12. Similar Questions — Same Exact Pattern / Design

### Min Stack — LeetCode #155

Same exact auxiliary-stack design.

`Normal Stack + Min Stack`

Instead of storing the maximum at every level, store the minimum.

### Max Stack — LeetCode #716

Related maximum-tracking stack design with additional operations.

---

# Quick Revision 🧠

### Question

**Get MAX from Stack in O(1)**

### Think

**Two Stacks**

### Structure

- `stack` → actual values
- `specialStack` → maximum at every level

### Operations

- `push(x)` → push value + update max stack
- `pop()` → pop from both
- `peek()` → `stack.peek()`
- `getMax()` → `specialStack.peek()`
- `isEmpty()` → `stack.isEmpty()`

### One-Line Memory

**Main stack stores values; special stack remembers the maximum at each level.**

### Pattern

**Need extra information from a stack in O(1)? Think about an auxiliary stack.**
