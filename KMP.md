## Key Idea
- Construct a table for Pattern
- Matching with the table created in previous step

## Implementation <sub>Assume the String we are matching is s and pattern we use is p:</sub>
### 1. (Pre/Suf)fix Table Construction:
The value for each index would be: **the length of longest common portion shared by prefix and suffix(end in the particular index)**. Then simply shift everything to right and keep the value of index 0 to be -1

> i.g.: for the index of i+2 in this: **p<sub>0</sub> , p<sub>1</sub> , p<sub>2</sub> , ... , p<sub>i</sub> , p<sub>i+1</sub> , p<sub>i+2</sub>**; if the longest common shared portion is p<sub>0</sub> , p<sub>1</sub> , p<sub>2</sub> == p<sub>i</sub> , p<sub>i+1</sub> , p<sub>i+2</sub>; then the value for index i+2 would be 3. Note that for single character, it is not considered as a match.
___
Example:

String: a b a c d a b

Index : 0 1 2 3 4 5 6

Value : 0 0 1 0 0 1 2

Shift!

String:  a b a c d a b

Index :  0 1 2 3 4 5 6

Value : -1 0 0 1 0 0 1
___

```JAVA
//Code for constructing table
pi[0] = -1;
int k = -1;
for(int i = 1; i <= m; i++) {
while(k >= 0 && P[k+1] != P[i])
  k = pi[k];
pi[i] = ++k;
}
```

### 2. Use The Table:
