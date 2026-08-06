HashMap Basics
1. Create
HashMap<Integer, Integer> map = new HashMap<>();

or

HashMap<Character, Integer> map = new HashMap<>();

or

HashMap<String, List<String>> map = new HashMap<>();
2. Put (Insert)
map.put(key, value);

Example

map.put(2, 0);

Map

{2=0}
3. Get Value
map.get(key);

Example

map.get(2);

Output

0
4. Check if Key Exists
map.containsKey(key)

Example

if(map.containsKey(7))

Used in:

Two Sum
Group Anagrams
Frequency Map
5. Update Frequency
if(map.containsKey(ch)){
    map.put(ch, map.get(ch)+1);
}
else{
    map.put(ch,1);
}

Shortcut (remember later)

map.put(ch, map.getOrDefault(ch,0)+1);
6. Remove
map.remove(key);
7. Size
map.size();
8. Compare Maps
map1.equals(map2);

Used in:

Valid Anagram
9. Get All Values
map.values();

Used in:

Group Anagrams
10. Get All Keys
map.keySet();
HashSet Basics
1. Create
HashSet<Integer> set = new HashSet<>();
2. Add
set.add(5);
3. Contains
set.contains(5);
4. Remove
set.remove(5);
5. Size
set.size();
Interview Patterns
Two Sum
if(map.containsKey(target - nums[i])){
    return new int[]{map.get(target-nums[i]), i};
}

map.put(nums[i], i);
Contains Duplicate
if(set.contains(num)){
    return true;
}

set.add(num);
Frequency Map
if(map.containsKey(ch)){
    map.put(ch, map.get(ch)+1);
}
else{
    map.put(ch,1);
}
Group Anagrams
if(!map.containsKey(key)){
    map.put(key, new ArrayList<>());
}

map.get(key).add(str);
The 8 methods you should memorize
Method	Purpose
put()	Insert key-value
get()	Get value
containsKey()	Check key exists
contains() (HashSet)	Check element exists
add() (HashSet)	Insert element
remove()	Delete
values()	Get all values
equals()	Compare two maps
My suggestion

Make one notebook page titled "Java DSA Cheat Sheet" and write only these methods. Before solving any HashMap/HashSet problem (Two Sum, Group Anagrams, Valid Anagram, Contains Duplicate, Top K Frequent, etc.), spend 2 minutes revising this page. After a week, you'll stop thinking about syntax and can focus on the algorithm instead.
