# 🚀 LeetCode 11 - Container With Most Water

> **Difficulty:** Medium  
> **Pattern:** Two Pointers (Opposite Direction)

---

# 📝 Problem Statement

You are given an integer array `height` of length `n`.

There are `n` vertical lines drawn such that the two endpoints of the `iᵗʰ` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container such that the container contains the maximum amount of water.

Return the **maximum amount of water** a container can store.

---

# 💡 Approach

We use the **Two Pointer** technique.

- Place one pointer at the beginning (`left`) and another at the end (`right`).
- Calculate the current container area.
- Update the maximum area found so far.
- Move the pointer with the **smaller height**.
- Repeat until both pointers meet.

Instead of checking every possible pair (`O(n²)`), we intelligently eliminate impossible candidates, achieving an **O(n)** solution.

---

# 📌 Algorithm

1. Initialize:
   - `left = 0`
   - `right = height.length - 1`
   - `maxArea = 0`

2. While `left < right`:
   - Calculate:
     - `minHeight = min(height[left], height[right])`
     - `width = right - left`
     - `area = minHeight × width`
   - Update `maxArea`.
   - If `height[left] < height[right]`
     - Move `left++`
   - Otherwise
     - Move `right--`

3. Return `maxArea`.

---

# 💻 Java Code

```java
class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = minHeight * width;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
```

---

# 🧪 Dry Run

### Input

```text
height = [1,8,6,2,5,4,8,3,7]
```

| Left | Right | Min Height | Width | Area | Max Area | Move |
|------|-------|------------|------:|-----:|---------:|------|
| 0 | 8 | 1 | 8 | 8 | 8 | Left++ |
| 1 | 8 | 7 | 7 | 49 | 49 | Right-- |
| 1 | 7 | 3 | 6 | 18 | 49 | Right-- |
| 1 | 6 | 8 | 5 | 40 | 49 | Right-- |
| 1 | 5 | 4 | 4 | 16 | 49 | Right-- |
| 1 | 4 | 5 | 3 | 15 | 49 | Right-- |
| 1 | 3 | 2 | 2 | 4 | 49 | Right-- |
| 1 | 2 | 6 | 1 | 6 | 49 | Right-- |

### Output

```text
49
```

---

# ❓ Why Move the Smaller Height?

The area depends on two factors:

- **Height = Minimum of the two heights**
- **Width = Distance between the pointers**

```
Area = min(height[left], height[right]) × (right - left)
```

Whenever we move a pointer:

- The **width always decreases**.

### ❌ If we move the taller pointer

- Width decreases.
- Smaller height remains unchanged.
- The limiting height does not improve.

Therefore, the area **cannot become larger**.

### ✅ If we move the shorter pointer

- Width decreases.
- There is a possibility of finding a taller line.
- The limiting height may increase.

Hence, there is still a chance of obtaining a larger area.

This is why we always move the pointer pointing to the **smaller height**.

---

# ⏱️ Complexity Analysis

| Complexity | Value |
|------------|-------|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(1)` |

### Why?

- Each pointer moves at most `n` times.
- No extra data structures are used.

---

# 🎯 Interview Explanation (30 Seconds)

> I use two pointers, one starting from the left and one from the right. At every step, I calculate the container area using the shorter height because the amount of water is limited by the smaller wall. Then I move the pointer with the smaller height since moving the taller pointer cannot increase the container height while the width always decreases. This greedy approach eliminates unnecessary comparisons and gives an optimal **O(n)** time complexity instead of the **O(n²)** brute-force solution.

---

# 🔑 Key Takeaways

- ✔ Two Pointer Pattern
- ✔ Opposite Direction Traversal
- ✔ Greedy Pointer Movement
- ✔ Move the Smaller Height
- ✔ Optimal `O(n)` Time Complexity
- ✔ Constant `O(1)` Space Complexity

---

# 📚 Related Problems

- 42. Trapping Rain Water
- 167. Two Sum II - Input Array Is Sorted
- 15. 3Sum
- 16. 3Sum Closest
- 18. 4Sum

---

⭐ **Pattern Learned:** Opposite Direction Two Pointers
