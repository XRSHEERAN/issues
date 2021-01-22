# Algorithms

## Intro
This *repo* contains solutions for leetcode questions. I wrote most of those solutions in JAVA and part of them in Python. This project is just for parctising and I have gains familarity with those data structures in all languages especially JAVA.

## Rules of Classification
The repo is casually classified by the company at first. Then I decided to focus on the top interview questions, which is more *general* and *representative*.

## Tips
* Avoid:
```JAVA
if(... && ...)
```
Break the complicated conditions to seperate expressions can boost the execution time

* Don't use foreach in most cases.

## Coding Style
[Trying to follow this.](https://javaranch.com/style.jsp)

## Comparator
```
Here's a complete example using Java 8:

import java.util.*;

public class Test {

    public static void main(String args[]) {

        int[][] twoDim = { {1, 2}, {3, 7}, {8, 9}, {4, 2}, {5, 3} };

        Arrays.sort(twoDim, Comparator.comparingInt(a -> a[0])
                                      .reversed());

        System.out.println(Arrays.deepToString(twoDim));
    }
}
Output:

[[8, 9], [5, 3], [4, 2], [3, 7], [1, 2]]
For Java 7 you can do:

Arrays.sort(twoDim, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o2[0], o1[0]);
    }
});
If you unfortunate enough to work on Java 6 or older, you'd do:

Arrays.sort(twoDim, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return ((Integer) o2[0]).compareTo(o1[0]);
    }
});
```

## About Me
I am fluent with JAVA, C# and Python. Email: xqu25@wisc.edu
