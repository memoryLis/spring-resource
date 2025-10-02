1 事务的7种传播行为
required ,requires_new ,support ,no_support, mandatory, nested, never
处理当前事务时，如果外界有事务
    1 如果当前事务是never 抛异常 
    2 NOT_SUPPORTED:外界有事务，但是当前NOT_SUPPORTED不支持事务，直接挂起外界事务，本事务以非事务方式运行
    3 REQUIRES_NEW：当前外界有事务，但是当前REQUIRES_NEW需要一个新事务，当前直接创建一个新事务，挂起外界事务
    4 NESTED：嵌套事务，这时外界有事务，判断是否允许嵌套事务，不允许抛出异常，允许嵌套使用保存点形式执行嵌套事务
    5 REQUIRED：当前外界有事务，REQUIRED允许当前事务，直接加入外界事务,Support ，mandatory,也是如此
处理当前事务时，如果外界没有事务
    1 外界没有事务，但是当前事务传播行为是PROPAGATION_MANDATORY，表示需要一个事务，直接报错
    2 外界没有事务，但是当前事务传播行为是PROPAGATION_REQUIRED，PROPAGATION_REQUIRES_NEW，PROPAGATION_NESTED
当前直接创建一个新事务
    3 如果是never ,support,no_support正常运行，不创建事务


2 事务的核心组件
1. PlatformTransactionManager：事务管理器（核心接口）
   作用：是事务管理的「执行者」，负责事务的具体操作（开启、提交、回滚）。
   核心方法：
   getTransaction(TransactionDefinition definition)：根据事务定义（如隔离级别、传播行为）开启一个事务，返回事务状态（TransactionStatus）。
   commit(TransactionStatus status)：提交事务。
   rollback(TransactionStatus status)：回滚事务。
   实现类：Spring 针对不同数据源提供了具体实现，例如：
   DataSourceTransactionManager：用于 JDBC 或 MyBatis 等基于数据源的事务。
示例：声明式事务中，Spring 会自动通过 PlatformTransactionManager 完成事务的提交 / 回滚。
2. TransactionDefinition：事务属性定义
   作用：定义事务的「规则」，描述事务的行为特征，供 PlatformTransactionManager 开启事务时使用。
   核心属性：
   传播行为（Propagation）：定义方法间调用时事务的传播方式（最核心的属性），例如：
   REQUIRED（默认）：如果当前有事务，则加入；否则新建事务。
   REQUIRES_NEW：无论当前是否有事务，都新建一个事务，原事务挂起。
   SUPPORTS：如果当前有事务，则加入；否则以非事务方式执行。
   隔离级别（Isolation）：定义事务间的隔离程度，解决脏读、不可重复读、幻读问题，例如：
   DEFAULT（默认）：使用数据库默认隔离级别（如 MySQL 默认为 REPEATABLE_READ）。
   READ_UNCOMMITTED、READ_COMMITTED、REPEATABLE_READ、SERIALIZABLE。
   超时时间（Timeout）：事务的最大执行时间（秒），超时未完成则自动回滚（默认 - 1，即不超时）。
   是否只读（ReadOnly）：设置为 true 时，事务仅执行查询操作（无写操作），数据库可优化性能（默认 false）。
示例：@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED) 就是通过 TransactionDefinition 定义的事务属性。
3. TransactionStatus：事务状态
   作用：记录事务执行过程中的「实时状态」，是 PlatformTransactionManager 操作事务的依据。
   核心信息：
   是否处于活动状态（isActive()）：事务是否正在执行。
   是否需要回滚（isRollbackOnly()）：标记事务是否需要回滚（例如手动调用 setRollbackOnly() 后）。
   是否是新事务（isNewTransaction()）：判断当前事务是否是新建的（非嵌套或加入的）。
   挂起的资源（getSuspendedResources()）：事务挂起时保存的资源（如 REQUIRES_NEW 传播行为中，原事务会被挂起）。
示例：当方法抛出未捕获的异常时，Spring 会通过 TransactionStatus 标记事务为「需要回滚」，最终由 PlatformTransactionManager 执行回滚。
4. TransactionSynchronizationManager：事务同步管理器
   作用：是事务同步的「容器」，负责在当前线程中绑定事务相关资源（如数据库连接、事务同步器），协调事务与其他资源的同步。
   核心功能：
   线程绑定：将事务资源（如 Connection）与当前线程绑定，确保同一事务中多次数据库操作使用同一个连接。
   管理 TransactionSynchronization 实例：注册事务同步器，在事务的不同阶段（提交前、提交后、回滚后）触发回调。
示例：在事务执行过程中，TransactionSynchronizationManager 会将数据库连接绑定到当前线程，避免多线程环境下连接混乱。
5. TransactionSynchronization：事务同步回调
   作用：定义事务生命周期中「额外操作」的回调接口，允许在事务的关键节点（如提交后、回滚后）执行自定义逻辑。
   核心方法（按执行顺序）：
   suspend()：事务挂起时调用（如 REQUIRES_NEW 传播行为中，原事务被挂起）。
   resume()：事务恢复时调用。
   beforeCommit(boolean readOnly)：事务提交前调用（可用于最后检查）。
   beforeCompletion()：事务完成前调用（无论提交还是回滚，适合资源清理）。
   afterCommit()：事务提交成功后调用（适合记录日志、刷新缓存等）。
   afterCompletion(int status)：事务完成后调用（无论成功失败，status 标记结果）。


