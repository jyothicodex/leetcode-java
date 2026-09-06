# Min Stack | LeetCode 155

## Problem

Design a stack that supports:

- `push(val)`
- `pop()`
- `top()`
- `getMin()`

All operations should work in **O(1)** time.

---

## What is the Problem?

A normal stack can perform `push()`, `pop()`, and `top()` in `O(1)`.

But finding the minimum element normally requires checking all elements, which takes `O(n)`.

Goal: Perform `getMin()` in `O(1)`.

---

## Approach

Use two stacks:

- `stack` → stores actual values.
- `minStack` → stores the minimum value at every level.

Example:

Main Stack: `5, 2, 8`  
Min Stack: `5, 2, 2`

Therefore:

- `top()` → `stack.peek()`
- `getMin()` → `minStack.peek()`
- `pop()` → pop from both stacks

---

## Algorithm

### Push

1. Push the value into `stack`.
2. If `minStack` is empty, push the value.
3. Otherwise, compare the value with `minStack.peek()`.
4. Push the smaller value into `minStack`.

### Pop

Pop the top element from both stacks.

### Top

Return `stack.peek()`.

### Get Minimum

Return `minStack.peek()`.

---

## Pseudocode

    PUSH(value):
        stack.push(value)

        IF minStack is empty:
            minStack.push(value)
        ELSE:
            IF value < minStack.top():
                minStack.push(value)
            ELSE:
                minStack.push(minStack.top())

    POP:
        stack.pop()
        minStack.pop()

    TOP:
        return stack.top()

    GETMIN:
        return minStack.top()

---

## Java Code

    import java.util.Stack;

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int value) {
            stack.push(value);

            if (minStack.isEmpty()) {
                minStack.push(value);
            } else if (value < minStack.peek()) {
                minStack.push(value);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

---

## Brute Force

Use only one normal stack.

For `getMin()`:

1. Traverse all elements.
2. Find the minimum.

### Complexity

- `push()` → `O(1)`
- `pop()` → `O(1)`
- `top()` → `O(1)`
- `getMin()` → `O(n)`

---

## Optimized Complexity

- Time → `O(1)` for all operations.
- Space → `O(n)`

---

## Interview Explanation

> "I use two stacks. The main stack stores the actual values, and the second stack stores the minimum value at every level. Therefore, the current minimum is always available at the top of the min stack, allowing `getMin()` to run in `O(1)` time."

---

## Key Learning

Instead of finding the minimum every time, maintain the minimum while pushing elements.

**Main Pattern:**

> Store extra information while updating the data structure so future queries can be answered efficiently.

---

## Mistakes I Made

- Used `stack<Integer>` instead of `Stack<Integer>` because Java is case-sensitive.
- Confused `MinStack` (my class) with `Stack` (Java data structure).
- Wrote `new Stack<>()` without assigning it to a variable.
- Initially confused `getMin()` with the `minStack` variable.
- Used inconsistent variable names like `val` and `value`.

### Remember

- `top()` → `stack.peek()`
- `getMin()` → `minStack.peek()`
- `pop()` → pop from both stacks

---

## Similar Questions

Min Stack #155 ✅
        ↓
Design a Stack With Increment Operation #1381
        ↓
Maximum Frequency Stack #895
        ↓
Max Stack #716

---

## Final Takeaway

    Main Stack → Actual values
    Min Stack  → Minimum at every level

    top()      → Main Stack top
    getMin()   → Min Stack top
    pop()      → Pop from both stacks

**Main Idea:** Maintain extra information while processing instead of calculating it again later.
