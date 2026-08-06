# Java HashMap & HashSet Cheat Sheet (DSA)

## HashMap

### 1. Create

```java
HashMap<Integer, Integer> map = new HashMap<>();
HashMap<Character, Integer> map = new HashMap<>();
HashMap<String, List<String>> map = new HashMap<>();
```

---

### 2. Insert

```java
map.put(key, value);
```

Example:

```java
map.put(2, 0);
```

---

### 3. Get Value

```java
map.get(key);
```

Example:

```java
map.get(2);
```

---

### 4. Check Key Exists

```java
map.containsKey(key);
```

Example:

```java
if (map.containsKey(7)) {
    // do something
}
```

---

### 5. Update Frequency

```java
if (map.containsKey(ch)) {
    map.put(ch, map.get(ch) + 1);
} else {
    map.put(ch, 1);
}
```

Shortcut:

```java
map.put(ch, map.getOrDefault(ch, 0) + 1);
```

---

### 6. Remove

```java
map.remove(key);
```

---

### 7. Size

```java
map.size();
```

---

### 8. Compare Two Maps

```java
map1.equals(map2);
```

Used in:
- Valid Anagram

---

### 9. Get All Values

```java
map.values();
```

Used in:
- Group Anagrams

---

### 10. Get All Keys

```java
map.keySet();
```

---

# HashSet

### 1. Create

```java
HashSet<Integer> set = new HashSet<>();
```

---

### 2. Add

```java
set.add(num);
```

---

### 3. Check Exists

```java
set.contains(num);
```

---

### 4. Remove

```java
set.remove(num);
```

---

### 5. Size

```java
set.size();
```

---

# Common Interview Patterns

## Two Sum

```java
if (map.containsKey(target - nums[i])) {
    return new int[]{map.get(target - nums[i]), i};
}

map.put(nums[i], i);
```

---

## Contains Duplicate

```java
if (set.contains(num)) {
    return true;
}

set.add(num);
```

---

## Frequency Map

```java
if (map.containsKey(ch)) {
    map.put(ch, map.get(ch) + 1);
} else {
    map.put(ch, 1);
}
```

or

```java
map.put(ch, map.getOrDefault(ch, 0) + 1);
```

---

## Group Anagrams

```java
if (!map.containsKey(key)) {
    map.put(key, new ArrayList<>());
}

map.get(key).add(str);
```

---

# Must Remember

| Method | Purpose |
|---------|---------|
| `put()` | Insert key-value pair |
| `get()` | Get value using key |
| `containsKey()` | Check key exists |
| `add()` | Add element to HashSet |
| `contains()` | Check element in HashSet |
| `remove()` | Remove key/element |
| `values()` | Get all values |
| `keySet()` | Get all keys |
| `equals()` | Compare two HashMaps |
| `getOrDefault()` | Frequency counting shortcut |
