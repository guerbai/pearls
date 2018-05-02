# 第一章找到并使用Java解决如下问题

## GenerateNumberFile
第一章第四页，提出了对问题的准确描述，此程序用于生成用于编写该排序算法的磁盘文件样本。    
使用Java代码生成一个磁盘文件，其最多包含n个正整数，每个整数一行，每个数都小于n，n=10^7，无重复整数出现。    
值得一提的点包括：    
使用Java创建文件写入内容；    
for(0, 10000000)加入列表来保证数据不重复；    
使用随机数生成器，随机去掉k(20~50)个1~10^7之间的数字；    
乱序写入文件的方式为，得到集合长度len，index = random(0, len)，写入set.popIndex(index)；    

## CheckSpaceAndTime
查看一个对象的使用内存情况，查看一个方法的调用时间。
查看内存使用RamUsageEstimator类；
查看调用时间使用System.currentTimeMillis();

## MyBitSet
来自己实现一个位向量，主要使用&, |等位操作以及数字的二进制表示。
实现BitSet的几个接口：
构造函数MyBitSet(int size)，可存储size个二进制位；
.getSize()方法，返回size；
.set(int index)，设置index为1;
.clear(int index)，设置index为0;
.get(int index)返回index位的值；
.toString()，像一个数组一样打印；

## FortyTimesReadSort
使用40趟读入文件算法实现该排序。
逐行读入文件；
直接使用Java内置的排序方法；
将结果写入输入文件；
将未含在读入文件内的1-10^7的数字打印出来;