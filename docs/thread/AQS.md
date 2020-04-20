# AQS
1.公平锁与非公平锁概念
    公平锁第二个一直竞争
    非公平锁进来就尝试竞争，不成功再等待
2.队列pred thread tail ,前一个节点后一个节点，线程
3.waitestatus 根据前一个节点的等待状态，判断是否需要park当前线程
4.引用跟cas交换的区别
  A指向tail tail指向节点ONode，cas修改tail指向NNode则A仍旧指向ONode 
5.自旋转跟park区别
  只有第二个节点Node会自选，其余节点进入park.    
6.解锁过程

    //waitStatus value to indicate thread has cancelled */
    static final int CANCELLED =  1;
    //waitStatus value to indicate successor's thread needs unparking */
    //需要被唤醒，已经被park
    static final int SIGNAL    = -1;
    //waitStatus value to indicate thread is waiting on condition */
    //在等待锁
    static final int CONDITION = -2;
    //waitStatus value to indicate the next acquireShared should
    //unconditionally propagate
    static final int PROPAGATE = -3;
   //获取下一个节点
   Node s = node.next;
   //如果下一个节点为空，或者取消状态
   //将下一个节点赋值为null,节点断了？
   //他将会从尾部节点逐个循环给s赋值。
   //找到离当前节点最近的节点
   //找到之后就唤醒那个节点的线程
   //正常情况执行线程等待线程都是-1，最后进入线程是0,后续进来的
   //节点会修改前置节点的状态改为-1
   //s.waitStatus>0 情况非常少见
   //释放锁需要考虑三种情况
   //aqs队列不存在,在队尾,在队中
   if (s == null || s.waitStatus > 0) {
       s = null;
       for (Node t = tail; t != null && t != node; t = t.prev)
           if (t.waitStatus <= 0)
               s = t;
   }
   if (s != null)
       LockSupport.unpark(s.thread);
       
6.公平锁快还是非公平锁效率高？ 


7.ws是一个状态？
 首个节点线程为空，不需要线程了，已经拿到线程了本身
  

