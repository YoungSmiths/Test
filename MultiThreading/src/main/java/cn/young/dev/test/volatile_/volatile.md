> ## 关键字Volatile
> java中这个关键字一直很模糊,之前只知道和多线程同步有关系,今天仔细的调研了一番.
> * 首先,介绍一下"锁":定义...,特征有两:一.互斥;二.可见性
> * 互斥...,可见性:这个有点复杂,简单的说就是java中多线程操作一个共享变量时可能会出现变量不一致等问题,而可见性保证了共享变量在各个线程中永远是最新的值.
> * 而Volatile只实现了可见性,因此有人说Volatile是synchronized的弱实现.
> * 相关博客:https://www.ibm.com/developerworks/cn/java/j-jtp06197.html
> * 总结:节本清楚怎么回事,但还是没有彻底搞明白,上述博客中提供了volatile的集中使用情况,个人觉得还是用Synchronized吧,除非要求提高性能,可以考虑volicate
> * create:2017.09.22

> 
