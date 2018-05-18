# 第二章 啊哈！算法

## BitUpBinaryUp
文件中有40亿-1个数字随机排列，不重复，大小在1-40亿之间，找出它。
从最高位利用0和1进行二分，想法很新颖。
在这里不去操作40亿个数字，进行降维操作；
也不去读写临时文件， 在代码中体现出这种思路与处理细节就好了。

## VectorLeftRoll
书中提到的几个向量左旋转的实现。
iSpaceRoll()，使用i个额外的内存空间的解法；
moveOnePerRoll(), 每次移动旋转一个位置；
acrobatics(), 杂技算法，想象成一条首尾相接的环带；
recursionRoll(), 
rollHand(), 翻手算法。
当n与i达到一定量时，检测程序运行时间与所占额外空间。

## Identifier
变位词程序。
使用预处理程序将anagramDict以HashMap存入内存，习题1的二分搜索并不需要使用，O(1)就可取到变位词。
习题6同样。

## FindMultipleInt
寻找4.3*10^9个int中的一个重复整数。
依然像BitUpBinaryUp一样采取降维操作，代码亦与其基本相同。

## TransposeMatrix
习题7，只看课后的答案刚开始怎么也不理解这题怎么个解法。
直到在[github](https://github.com/harrifeng/MyWay/blob/master/NOTE/ProgrammingPearls_2.org)看到了一个图示加讲解才被该解法惊到。
还有一点容易理解错，先对列排序再对行排序是说，对列排序后，在所有列相同的items中对行排序(而这一点，往往在第一次排序中即已处理好了)。
该类的编写中有范型的处理以及sort时根据匿名函数的使用。

## SmallSubSet
习题8，提供时间复杂度为O(n)的算法实现。
使用选择算法，待到习题11.9时再来更新。