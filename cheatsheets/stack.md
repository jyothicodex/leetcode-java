# Java Syntax Cheat Sheet — Stack, Queue, Hashing

## 1. Stack — LIFO

**LIFO = Last In, First Out**

Stack\<Integer> stack = new Stack<>();
Stack\<Character> stack = new Stack<>();

### Main Operations

stack.push(10);     // add to top  
stack.pop();        // remove top  
stack.peek();       // see top  
stack.isEmpty();    // check empty  
stack.size();       // size

### Example

push 1 → [1]  
push 2 → [1, 2]  
peek   → 2  
pop    → 2



---

## 2. Queue — FIFO

**FIFO = First In, First Out**

Queue\<Integer> q = new LinkedList<>();

### Main Operations

q.add(10);          // add at back  
q.remove();         // remove from front  
q.peek();           // see front  
q.isEmpty();        // check empty  
q.size();           // get size

### Example

add 1    → [1]  
add 2    → [1, 2]  
peek     → 1  
remove   → 1



---

## 3. HashSet — Unique Elements

HashSet\<Integer> set = new HashSet<>();

### Main Operations

set.add(10);        // add element  
set.remove(10);     // remove element  
set.contains(10);   // check if exists  
set.isEmpty();      // check empty  
set.size();         // size

### Use HashSet When

> **"Have I seen this before?"**  
> **"Do I need only unique elements?"**

### Example

add 10 → [10]  
add 20 → [10, 20]  
add 10 → ignored



---

## 4. HashMap — Key → Value

HashMap\<Integer, Integer> map = new HashMap<>();

### Main Operations

map.put(1, 10);         // key 1 → value 10  
map.get(1);             // get value  
map.containsKey(1);     // check if key exists  
map.remove(1);          // remove key-value pair  
map.size();             // size

### Frequency Counting

map.put(x, map.getOrDefault(x, 0) + 1);

### Use HashMap When

> **"How many times?"**  
> **"Do I need a key → value relationship?"**

### Example

1 → 2  
2 → 3  
3 → 1

Key   Value  
 1  →  2  
 2  →  3  
 3  →  1



---

# 🧠 One-Line Memory

| **Data Structure** | **Remember**            |
| ------------------ | ----------------------- |
| **Stack**          | Last In, First Out      |
| **Queue**          | First In, First Out     |
| **HashSet**        | Unique / Seen?          |
| **HashMap**        | Frequency / Key → Value |

### Quick Pattern Recognition

Need last/recent element?     → Stack  
Need first/oldest element?    → Queue  
Need unique / seen check?     → HashSet  
Need frequency / mapping?     → HashMap


## 5. StringBuilder

**Principle:** StringBuilder is used to create and modify strings efficiently.

### Syntax

```java
### StringBuilder sb = new StringBuilder();
Main Operations
sb.append(x);
sb.reverse();
sb.toString();
append(x) → adds characters or a String to the end.
reverse() → reverses the characters.
toString() → converts StringBuilder into a String.
Small Example
StringBuilder sb = new StringBuilder();

sb.append("abc");       // "abc"
sb.append("d");         // "abcd"

sb.reverse();           // "dcba"

String result = sb.toString();  // String: "dcba"
Output
abc
abcd
dcba
🧠 Memory
append()    → Add
reverse()   → Reverse
toString()  → StringBuilder → String
