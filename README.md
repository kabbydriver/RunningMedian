The program can be compiled by typing 'make'

Given an even length stream of numbers, the median can be calculated as such

1 2 3 4 5 6


1 2 3

4 5 6

First, split the list into two sorted halves.
Taking the largest number in the left half and
the smallest number in the right half, we
can find the median by averaging these two numbers.

The key here is recognize that we need two sorted
lists, and we will use the largest number in the half
with smaller numbers and the smallest number in the half
with the largest numbers. When given an arbitrary stream
of numbers, we need a way to keep track of two sorted lists.

Using a min-heap and max-heap, we can keep a running median.
The min-heap keeps track of the elements larger than the median,
and the max-heap keeps track of the elements smaller than the median.

When asked to insert a new number, we check if it is smaller than our current
median by peeking at the largest number in the max-heap. 

Where n is the number of items passed through the stream, we get runtimes of

Insert -- log(n)

Median -- O(1)

The heaps will only work when they are kept in balance. After
each insertion, we check to see if the two heaps are not off by more than 1 in
size. If they are, we take the top element out of the larger (by item count) 
heap, and insert it into the smaller (by item count) heap. Computing the median
is simple. The heaps are only ever off by 1 element, so if the sum of their 
counts is even, then they must have the same number of elements. The median is
found by averaging the top element in each heap.
And if the sum of their counts is odd, we take the larger (by item count) 
heap and return its top element. The computation of the median takes the 
same amount of work irrespective of the size of the data set.
