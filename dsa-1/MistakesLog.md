# DSA Mistake Log

## LC 1 - Two Sum

### ❌ Mistake
- Remembered HashMap but forgot the approach.
- Forgot what to check first.
- Forgot what to store in the HashMap.

### ✅ Correct Thinking

```text
For every current number:

1. Calculate needed = target - current.
2. Check if needed already exists in HashMap.
3. If YES → return stored index and current index.
4. If NO → store current number and its index.
```

### ✅ What to Store

```text
Key   = Current Number
Value = Current Index
```

### 🔑 One-Line Reminder

```text
CHECK first → STORE later.
Never store before checking.
```

---

## LC 217 - Contains Duplicate

### ❌ Mistakes
- Wrote `return false` when duplicate was found.
- Wrote `return true` after the loop.
- Wrote `add.set()` instead of `set.add()`.

### ✅ Correct Thinking

```text
Traverse every element.

Already in HashSet?

YES → return true

NO → set.add(element)

After traversal ends → return false
```

### 🔑 One-Line Reminder

```text
Duplicate found = TRUE
No duplicate after complete traversal = FALSE
```

---

# Common Mistakes to Avoid

- ❌ Store before checking (Two Sum)
- ❌ Reverse true/false returns
- ❌ Forget what HashMap stores (Key vs Value)
- ❌ Write wrong method syntax (`add.set()` ❌ → `set.add()` ✅)


# DSA Mistake Log

---

## LC 1 - Two Sum

### ❌ Mistakes
- Remembered HashMap but forgot the approach.
- Forgot what to check first.
- Forgot what to store in the HashMap.

### ✅ Correct Thinking

1. Calculate `needed = target - current`.
2. Check if `needed` exists in HashMap.
3. If YES → return stored index and current index.
4. If NO → store current number and its index.

### ✅ HashMap

Key = Current Number

Value = Current Index

### 🔑 Remember

CHECK FIRST

↓

STORE LATER

---

## LC 217 - Contains Duplicate

### ❌ Mistakes

- Returned `false` when duplicate was found.
- Returned `true` after the loop.
- Wrote `add.set()` instead of `set.add()`.

### ✅ Correct Thinking

Traverse array.

Already exists?

YES → return true

NO → set.add(num)

Loop ends → return false

### 🔑 Remember

Duplicate Found = TRUE

No Duplicate = FALSE

---

## LC 242 - Valid Anagram

### ❌ Mistakes

- Forgot `charAt(i)` syntax.
- Forgot to use `Character` as HashMap key.
- Forgot length check.

### ✅ Correct Thinking

1. Length check.
2. Traverse strings.
3. Access character using `charAt(i)`.
4. Count frequency.
5. Compare HashMaps.

### ✅ Java Syntax

```java
char ch = s.charAt(i);
```

```java
HashMap<Character, Integer> map = new HashMap<>();
```

```java
return map1.equals(map2);
```

### 🔑 Remember

String

↓

charAt(i)

↓

Character

↓

Frequency Count

↓

Compare Maps
