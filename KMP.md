#### Key Idea
Construct a table of substring that is both a prefix and suffix and start from then without going back to the front.

#### Implementation
- Initial the first item of table to be 0, as it cannot match any prefix.
- Compare the next char of both prefix and suffix, e.g. str\[table\[i-1]] and str\[i], using while loop until there is a match for reaches 0
  - if they are not equal, then move the table\[i-1] forward, as it should still match str\[i-1]
  - else increment

```JAVA
f(0) = 0
for(i = 1; i < n; i++)
{
	t = f(i-1)
	while(t > 0 && b[i] != b[t])
		t = f(t-1)
	if(b[i] == b[t]){
		++t
	f(i) = t
}
```

#### Application
Pattern matching, such as shortest palindrome.
