# 第五章 编程小事

# EnsureCorrectBinarySearch
确保正确性的二分搜索，主要是实践内容部分提到的关于assert与test脚手架的点。
里面使用到了Java的assert功能，需要在Edit Configurations中的VM options中加-ea来开启。

值得一提的是习题七，通过给脚手架type来实现两种方法，一种是可以利用缓存的顺序搜索，另一种则是打乱顺序的ArrayList。
由测试结果可见，明显后者要慢不少，原因是因为当n足够大之后，命中二级缓存的概率大大减小了。
这里将打乱的过程放到java的static块中，不会产生额外的影响。
