java.io中最为核心的概念是流（stream），面向流编程，java中，一个流要么是输入流，要么是输出流
java.nio中拥有3个核心概念：selector，channel，buffer；java.nio中，面向块(block)或是缓冲区(buffer)编程的，
buffer本身就是一块内存，实际就是个数组，数据的读.写都是通过buffer来实现的。

java中的原生8种基本数据类型都有各自对应的buffer类型，（除Boolean外），如IntBuffer,CharBuffer,ByteBuffer,LongBuffer,ShortBuffer
所有数据的读写都是通过buffer来进行的，永远不会出现直接channel中直接写入，读取数据
与stream不同的是，channel是双向的，一个流只可能是InputStream或是OutputStream，channel则是双向的，channel打开后可以进行读又可以进行写



capacity： 最大容量，它永远不可能为负数，并且是不会变化的
limit：  限制，它永远不可能为负数，并且不会大于capacity
position：下一个读或写的位置，它永远不可能为负数，并且不会大于limit






selector：
1.一个channel注册到selector上，这个动作是通过selectionKey来表示的；
一个selector会维护三种selectionKey的集合
key set  表示注册到selector上面所有的selectionKey，通过keys()方法返回   全集
selected-key set  表示感兴趣的selectionKey  通过selectedKeys()方法返回  子集



buffer.put()  往此buffer中放置元素（往数组中写）
buffer.get()  从buffer中取出元素

channel.read(byteBuffer);  从通道中读取数据放置到buffer当中  对于buffer来说是写
channel.write(byteBuffer); 从buffer中读取数据写入通道中，   对于buffer来说是读



selectionKey
要点
是一个抽象类,表示selectableChannel在Selector中注册的标识.每个Channel向Selector注册时,都将会创建一个selectionKey
选择键将Channel与Selector建立了关系,并维护了channel事件.
可以通过cancel方法取消键,取消的键不会立即从selector中移除,而是添加到cancelledKeys中,在下一次select操作时移除它.所以在调用某个key时,需要使用isValid进行校验.

操作集

interest 集合:当前channel感兴趣的操作,此类操作将会在下一次选择器select操作时被交付,可以通过selectionKey.interestOps(int)进行修改.
ready 集合:表示此选择键上,已经就绪的操作.每次select时,选择器都会对ready集合进行更新;外部程序无法修改此集合.

操作属性

OP_ACCEPT:连接可接受操作,仅ServerSocketChannel支持
OP_CONNECT:连接操作,Client端支持的一种操作
OP_READ/OP_WRITE

0表示什么？

这些opts都不为0，如果向selector之中register一个为“0”的opts，表示此channel不关注任何类型的事件。（言外之意，register方法只是获取一个selectionKey，具体这个Channel对何种事件感兴趣，可以在稍后操作）

方法列表
public abstract SelectableChannel channel():返回此选择键所关联的通道.即使此key已经被取消,仍然会返回.
public abstract Selector selector():返回此选择键所关联的选择器,即使此键已经被取消,仍然会返回.
public abstract boolean isValid():检测此key是否有效.当key被取消,或者通道被关闭,或者selector被关闭,都将导致此key无效.在AbstractSelector.removeKey(key)中,会导致selectionKey被置为无效.
public abstract void cancel():请求将此键取消注册.一旦返回成功,那么该键就是无效的,被添加到selector的cancelledKeys中.cancel操作将key的valid属性置为false,并执行selector.cancel(key)(即将key加入cancelledkey集合)
public abstract int interesOps():获得此键的interes集合.
public abstract SelectionKey interestOps(int ops):将此键的interst设置为指定值.此操作会对ops和channel.validOps进行校验.如果此ops不会当前channel支持,将抛出异常.
public abstract int readyOps():获取此键上ready操作集合.即在当前通道上已经就绪的事件.
public final boolean isReadable(): 检测此键是否为"read"事件.等效于:k.,readyOps() & OP_READ != 0;还有isWritable(),isConnectable(),isAcceptable()
public final Object attach(Object ob):将给定的对象作为附件添加到此key上.在key有效期间,附件可以在多个ops事件中传递.
public final Object attachment():获取附件.一个channel的附件,可以再当前Channel(或者说是SelectionKey)生命周期中共享,但是attachment数据不会作为socket数据在网络中传输.

