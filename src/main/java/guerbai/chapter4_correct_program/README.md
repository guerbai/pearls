# 第四章 编写正确的程序

# BinarySearch
通过使用书中内容的伪码编写出正确的二分搜索程序.
recursionBinarySearch(), 对应习题3.

习题1、2、8的解答依书中引导留到9.3节处理。

# SegmentsBinarySearch
习题7，线段集二分搜索，引入area的概念更容易理解与编写，与之前的整数二分搜索不同，
基于area的二分搜索必定能找到包含该点的区域，退出循环相对简单一些。

# IterationFastPow
习题9最后提了一句，快速幂函数的迭代版本。
编写中注意循环条件为n>0，则result一定会乘上evenMul(当n==1时，这一退出处理很重要)。
要清楚evenMul代表的是什么，一个动态变化有幂关系的乘数，将其纳入result中。
