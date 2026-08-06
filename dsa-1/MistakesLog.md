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
