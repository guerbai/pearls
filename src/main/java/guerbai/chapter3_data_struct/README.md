# 第三章 数据决定程序结构

本章内容部分没有找到哪个例子适合写一写的，直接上习题。

# AmericanTax
习题1，美国旧税率的算法，看上去程序比较冗长而if之间的相似度极高。
课后习题提到使用"无限"哨兵值，暂时不理解。
暂使用表驱动法来简化编写。

# GetMA
习题2，变量过多，会有些乱。

# GraphLetter
习题3，其实是个解释器，之后可以以解释器模式来重写此题。
编写此题很简单而有意思，最后通过打印Z来印证程序的正确性。

# MyDate
习题4，处理日期问题总是比较烦人的。

习题5，这题实在没什么意思，直接使用Java String的endsWith()即可解决.

# UseJavaStringTemplate
习题6，这题是让读者使用所谓string template，这个东西在Python与JS中已经内置，或者有更成熟的包比如jinja可以使用。
这里没有必要再去重新用Java实现一个string template，决定尝试使用一下现有的apache的包。

习题7，比较有意思，网上找到了一点有价值的[讨论](https://github.com/filipegoncalves/codinghighway/tree/master/ProgrammingPearls/Column3/3.7.7)。

# LEDNumber
习题8，这题明显不难。