# LeetCode 242 - Valid Anagram

## Pattern
- HashMap (Frequency Count)
- Sorting
- String
- Character Frequency

## Difficulty
Easy

---

## Observation

- An anagram is formed by rearranging the letters of another word.
- Both strings must have the **same length**.
- Every character must appear the **same number of times** in both strings.
- We need to compare the frequency of each character.
- A **HashMap** (or an array of size 26 for lowercase letters) is suitable for counting character frequencies.

---

# Brute Force

## Idea

Sort both strings alphabetically.

If the sorted strings are equal, they are anagrams.

---

## Algorithm

1. Check if both strings have the same length.
2. Convert both strings into character arrays.
3. Sort both arrays.
4. Compare the sorted arrays.
5. If both are equal, return `true`; otherwise return `false`.

---

## Code

```java
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }
}
```

---

## Complexity

**Time Complexity:** `O(n log n)`

**Space Complexity:** `O(n)`

---

# Optimized Approach (HashMap)

## Idea

Count the frequency of every character in both strings.

If the frequency of every character is the same, both strings are anagrams.

---

## Why HashMap?

HashMap stores

```
Character → Frequency
```

It allows

- O(1) average insertion
- O(1) average lookup

This reduces the time complexity from **O(n log n)** to **O(n)**.

---

## Algorithm

1. If the lengths are different, return `false`.
2. Create two HashMaps.
3. Traverse both strings.
4. Count the frequency of every character.
5. Compare both HashMaps.
6. If they are equal, return `true`; otherwise return `false`.

---

## Code

```java
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {

            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        return map1.equals(map2);
    }
}
```

---

## Dry Run

**Input**

```
s = "anagram"
t = "nagaram"
```

Frequency Count

| Character | s | t |
|-----------|---|---|
| a | 3 | 3 |
| n | 1 | 1 |
| g | 1 | 1 |
| r | 1 | 1 |
| m | 1 | 1 |

Both HashMaps are equal.

**Output**

```
true
```

---

# Complexity Analysis

**Time Complexity:** `O(n)`

- Single traversal of both strings.
- HashMap operations take **O(1)** on average.

**Space Complexity:** `O(n)`

- HashMaps store the frequency of the characters.

---

# Interview Notes

### Pattern

✅ HashMap (Frequency Count)

---

### Key Observation

- Same length is mandatory.
- Compare **character frequencies**, not the order.
- Think **HashMap** or **Frequency Array**.

---

### Why check length first?

If the lengths are different, the strings can never be anagrams.

Example:

```
abc
abcd
```

Return `false` immediately.

---

### Why not compare characters directly?

The order may be different.

Example:

```
listen
silent
```

The characters are in different positions, but the frequency of every character is the same.

---

### Data Structure Used

```
Character → Frequency
```

---

### Interview Keywords

- HashMap
- Frequency Count
- Character Counting
- String
- Anagram
- Lookup

---

# Similar Problems

- 49. Group Anagrams
- 383. Ransom Note
- 205. Isomorphic Strings
- 389. Find the Difference
- 451. Sort Characters By Frequency
