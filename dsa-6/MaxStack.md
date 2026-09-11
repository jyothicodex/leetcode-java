# Get Max from Stack — Special Stack
https://www.geeksforgeeks.org/problems/get-max-from-stack/1

## 1. Problem in Simple Words
Design a stack that supports `push`, `pop`, `peek`, `isEmpty`, and `getMax()`.

The important requirement is that `getMax()` must return the maximum element in **O(1)** time.

## 2. Main Challenge
A normal stack can get the top element in O(1), but finding the maximum by scanning all elements takes O(n).

We need extra information so the maximum can also be retrieved in O(1).

## 3. Brute Force Approach
Use one normal stack and scan the entire stack whenever `getMax()` is called.

- `push()` → O(1)
- `pop()` → O(1)
- `peek()` → O(1)
- `getMax()` → O(n)

## 4. Optimal Approach / Intuition
Use **two stacks**:

- `stack` → stores actual elements.
- `specialStack` → stores the maximum value at every stack level.

Example:

```text
stack:        [2, 3, 1]
specialStack: [2, 3, 3]

Therefore, specialStack.peek() always gives the current maximum in O(1).

5. Algorithm
Push x into stack.
If specialStack is empty, push x.
Otherwise compare x with the current maximum.
If x is smaller, push the current maximum again.
Otherwise push x because it becomes the new maximum.
For pop(), pop from both stacks.
peek() returns the top of stack.
getMax() returns the top of specialStack.
Handle empty stack cases by returning -1 for peek() and getMax().
6. Pseudocode
push(x):
    stack.push(x)

    if specialStack is empty:
        specialStack.push(x)
    else if x < specialStack.peek():
        specialStack.push(specialStack.peek())
    else:
        specialStack.push(x)

pop():
    stack.pop()
    specialStack.pop()

peek():
    if stack is empty:
        return -1
    return stack.peek()

getMax():
    if specialStack is empty:
        return -1
    return specialStack.peek()

isEmpty():
    return stack.isEmpty()

## 7. Java Code

```java
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
8. Complexity
push() → O(1)
pop() → O(1)
peek() → O(1)
getMax() → O(1)
isEmpty() → O(1)
Extra Space → O(n)
9. Interview Explanation

"I use two synchronized stacks. The normal stack stores the actual values, while the special stack stores the maximum value at every level. Therefore, the current maximum is always at specialStack.peek(), giving O(1) getMax()."

10. Key Learning / Pattern

Augment a data structure with an auxiliary structure to answer an extra query in O(1).

Pattern:

Normal Stack + Auxiliary Stack
        ↓
Store extra information at every level
        ↓
O(1) retrieval of required information

This is the Max Stack version of the Min Stack pattern.

11. My Mistakes While Solving
Initially wrote new stack<>() instead of new Stack<>().
Initially checked stack.isEmpty() instead of specialStack.isEmpty() inside push().
Initially used the Min Stack comparison direction (x < current) without understanding the Max Stack requirement.
Accidentally pushed into the main stack twice.
Placed empty checks outside peek() and getMax().
Put return before the empty check, creating unreachable code.
Forgot () in stack.isEmpty().
Learned that specialStack must maintain one value for every level of the main stack.
12. Similar Questions — Same Exact Pattern / Design
Min Stack — LeetCode #155 → auxiliary stack stores minimum at every level.
Max Stack — LeetCode #716 → supports maximum retrieval/removal using augmented stack design.
Maximum Frequency Stack — LeetCode #895 → maintains additional state to support a special retrieval operation.
Design a Stack With Increment Operation — LeetCode #1381 → stack design with additional state/operations.
Quick Takeaway
stack        → actual values
specialStack → maximum at each level

getMax() → specialStack.peek() → O(1)
