# Valid Parentheses

## Problem

Given a string `s` containing just the characters `(`, `)`, `{`, `}`, `[` and `]`, determine if the input string is valid.

A string is valid if:

1. Every opening bracket has a corresponding closing bracket.
2. Brackets close in the correct order.
3. Every closing bracket has a matching opening bracket.

### Examples

| Input | Output |
|---|---|
| `"()"` | `true` |
| `"()[]{}"` | `true` |
| `"(]"` | `false` |
| `"([)]"` | `false` |
| `"{[]}"` | `true` |

---

## Approach

We use a **Stack** because brackets follow the **Last In, First Out (LIFO)** principle.

- Opening bracket → `push()` into the stack.
- Closing bracket → check the top using `peek()`.
- If the top does not match → return `false`.
- If it matches → `pop()` the opening bracket.
- At the end, the stack must be empty.

---

## Algorithm

1. Create an empty stack.
2. Traverse the string from left to right.
3. For each character:
   - If it is `(`, `[` or `{`, push it into the stack.
   - Otherwise:
     - If the stack is empty, return `false`.
     - Get the top element using `peek()`.
     - Check whether the top matches the current closing bracket.
     - If it does not match, return `false`.
     - If it matches, remove it using `pop()`.
4. After the loop, check whether the stack is empty.
5. Return the result of `stack.isEmpty()`.

---

## Why Stack?

A Stack follows **LIFO — Last In, First Out**.

For example:

```text
([{}])

The brackets are stored as:

Top → {
       [
       (

The last opening bracket { must be matched first.

Therefore, Stack is suitable for this problem.

Dry Run
Example 1 — Valid Case
s = "({[]})"
Character	Action	Stack
(	Push	(
{	Push	({
[	Push	({[
]	Match [ → Pop	({
}	Match { → Pop	(
)	Match ( → Pop	Empty

At the end:

Stack = Empty

Output: true

Example 2 — Invalid Case
s = "([)]"
Character	Action	Stack
(	Push	(
[	Push	([
)	Top is [ → Mismatch	([

) does not match [.

Output: false

Stack Operations
push()

Adds an element to the top of the stack.

stack.push(ch);
peek()

Returns the top element without removing it.

char top = stack.peek();
pop()

Removes the top element.

stack.pop();
isEmpty()

Checks whether the stack is empty.

stack.isEmpty();
Java Solution
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening bracket → push
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // Closing bracket
            else {

                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                // Get the top opening bracket
                char top = stack.peek();

                // Check for mismatch
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {

                    return false;
                }

                // Matching bracket → pop
                stack.pop();
            }
        }

        // Valid only if no opening brackets are left
        return stack.isEmpty();
    }
}
Important Observation

We use peek() before pop().

char top = stack.peek();

if (mismatch) {
    return false;
}

stack.pop();

Why?

Because we first need to check whether the top opening bracket matches the current closing bracket.

Only after confirming the match do we remove it.

peek() = Look at the top
pop() = Remove the top

Complexity Analysis
Time Complexity

O(n)

We traverse the string once.

Each character is pushed and popped at most once.

Space Complexity

O(n)

In the worst case, all characters can be opening brackets and stored in the stack.

Key Pattern
Stack + Matching Pairs
Opening Bracket
       ↓
     PUSH
       ↓
Closing Bracket
       ↓
     PEEK
       ↓
   ┌───┴───┐
 Match   Mismatch
   ↓        ↓
  POP      FALSE
Core Rule
Opening → PUSH

Closing → PEEK
            ↓
         Match?
        /      \
      Yes       No
       ↓         ↓
      POP       FALSE

After loop:
Stack Empty?
    ↓
   TRUE
Edge Cases
Empty String
Input: ""
Output: true
Only Opening Brackets
Input: "((("
Output: false
Closing Bracket First
Input: ")"
Output: false
Correctly Nested Brackets
Input: "{[()]}"
Output: true
Wrong Order
Input: "([)]"
Output: false
Different Types
Input: "()[]{}"
Output: true
Common Mistake

Do not directly pop without checking the top element.

Incorrect
stack.pop();
Correct
char top = stack.peek();

if (mismatch) {
    return false;
}

stack.pop();

First check → then remove.

Pattern to Remember
Opening Bracket
      ↓
    PUSH
      ↓
Closing Bracket
      ↓
    PEEK
      ↓
   CHECK
   ↙   ↘
Match  Mismatch
 ↓       ↓
POP    FALSE
 ↓
Continue
 ↓
End → Stack Empty?
       ↓
      TRUE


Opening → Push
Closing → Peek → Check → Pop
Mismatch → False
End → Stack Empty → True
