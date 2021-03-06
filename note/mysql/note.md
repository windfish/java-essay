## 索引：B+ 树

MySql 的B+ 树索引
* 一张表一般有多个索引，比如主键索引和非唯一索引，每个索引都对应一个索引树
* InnoDB 存储引擎：
    * 聚集索引：记录行数据和索引数据，都在同一个索引树上（磁盘上对应一个文件）
        * 一张表仅有一个聚集索引，也就是主键索引
        * 索引树比较大，因为存储行数据
    * 非聚集索引：主键和索引数据，都在同一个索引树上
        * 次要索引、辅助索引
    * 若通过非主键索引查询数据，需通过两个索引树才能查询：
        * 先根据索引查找主键信息
        * 再根据主键查询具体的记录
* MyIsam 存储引擎：
    * 非聚集索引：记录行数据和索引数据，分别存储在不同的地方，索引树上只有索引数据和行数据的磁盘地址（磁盘上对应两个文件）
* 只有树的叶子节点才能存储行数据，叶子节点存储的数据是有序的，是双向链表保存的

## B 树

* 叶子节点和非叶子节点都可以存储行数据



## 锁

MySql 中InnoDB 存储引擎对记录加锁，其实是针对索引进行加锁的

根据哪个索引进行查询，就对哪个索引进行加锁。

*主键索引和次要索引是否都会加锁？*  是的

* InnoDB 中的锁：
    * 行锁（记录锁）
    
    * 间隙锁
        * 通过间隙锁解决了幻读问题
    * 临键锁
    






