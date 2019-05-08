# algo

## Overview
Record some of my java learning experiences

## 1. Make merge sort concurrent
I have been hearing that merge sort is great as it is easy to implement it in concurrent way. I have tried to implement a `ConcurrentMergeSort`,
and compare its performance with a usual `MergeSort`. You can run the comparison by running the `Runner` class.

I found that if the data size is small, the cocurrent approach is actually slower, possibly due to the overhead to allocate threads.


## Ackowledgement
The `TimeWatch` util is copied from https://stackoverflow.com/questions/1770010/how-do-i-measure-time-elapsed-in-java. Thank you GHad. 
