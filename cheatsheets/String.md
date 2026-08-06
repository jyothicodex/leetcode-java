# Java String Cheat Sheet

## Length

```java
str.length();
```

---

## Access Character

```java
char ch = str.charAt(i);
```

---

## String → Character Array

```java
char[] arr = str.toCharArray();
```

---

## Character Array → String

```java
String s = new String(arr);
```

---

## Sort Characters

```java
Arrays.sort(arr);
```

---

## Compare Strings

```java
str1.equals(str2);
```

Never use:

```java
str1 == str2;
```

---

## Traverse String

```java
for(int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
}
```

---

## Substring

```java
str.substring(start, end);
```

---

## Most Used in DSA

| Task | Syntax |
|------|--------|
| Length | `str.length()` |
| Character | `str.charAt(i)` |
| To Char Array | `str.toCharArray()` |
| Sort | `Arrays.sort(arr)` |
| To String | `new String(arr)` |
| Compare | `equals()` |
| Traverse | `for + charAt()` |
