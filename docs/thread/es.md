#es
1.index     table(type)
  row       document
  column    filed
  schema    mapping
  
2.节点 分片  副本  
  节点其实就是一个java实例，建议一台机器一个
  master
  data
  coordinating
  hot
  machine learning node
  
  分片 可以reindex进行，一般初始化就不能改，一个分片相当于一个luc
  分片 过多会影响打分 效率
  red主分片没有分片

3. 倒排索引 书
  页码 - 内容
  文字 - 页码 位置
  B+树 哈希拉链
  指定不倒排索引
  
4.可用性 PB级别数据  
  系统日志：每个月一个索引 可以删除
  10万日活，2000万日志 2000万数据 4G  1分片20G   
  3分片 1副本  
  业务日志：每个月一个索引 不可以删除 每个月数据 
  10万日活，2000万日志
  3分片 1副本
  漫画小说：一个索引  百万级别
  3分片 1副本
  
5.  
  