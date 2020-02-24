王正浩作业

##  Administrator管理员

 URL: /administrator/login?jusername={username}&password={password}
Method：GET 

|        字段        |   类型    |      约束       |        描述        |
| :----------------: | :-------: | :-------------: | :----------------: |
|  administrator_id  |  int(10)  |    主键自增     |    用户管理员id    |
|      username      | char(20)  |    非空,唯一    |   用户管理员账号   |
|       status       |  int(10)  | 非空，默认1启用 | 状态（0禁用，1启用 |
|     creat_time     | datetime  |      非空       |      创建时间      |
|     real_name      | char(20)  |      索引       |   用户管理员姓名   |
|       email        | char(255) |    唯一索引     |   用户管理员邮箱   |
| encrypted_password | char(255) |      非空       | 用户管理员加密密码 |
|     avatar_url     | char(255) |                 |      头像地址      |

---

## Address地址表

|      字段       |    类型     |       约束       |    描述    |
| :-------------: | :---------: | :--------------: | :--------: |
|   address_id    |     int     |    主键 自增     |   地址ID   |
|   customer_id   |     int     | 非空，索引，外键 |   客户ID   |
|  receiver_name  | varchar(20) |       非空       |   收货人   |
|       tag       | varchar(20) |       非空       |    标签    |
| receiver_mobile |    char     |       非空       | 收货人手机 |
|     content     |    char     |       非空       |  地址内容  |

## 客户表 Customer

 1.1客户注册

URL: /customer/register
Method：POS 

1.2客户登录

 URL: /customer/login?username={username}&password={password}
Method：GET 

1.3客户修改密码

 URL: /customer/changepassword
Method：POST 

|        字段        |     类型     |        约束        |             描述              |
| :----------------: | :----------: | :----------------: | :---------------------------: |
|    customer_id     |     int      |     主键,自增      |            客户id             |
|      username      |     char     | 非空非空，唯一索引 |           客户名字            |
|     avatar_url     | varchar(100) |                    |             头像              |
|       mobile       |     char     |      唯一索引      |           客户手机            |
|  mobile_verified   |     bit      |     默认false      |          手机号验证           |
|       email        |     char     |      非空唯一      |             邮箱              |
|   email_verified   |     bit      |     默认false      |           邮箱验证            |
|       status       |   tinyint    |        非空        | 状态（0禁用、1启用、2不安全） |
|    create_time     |   datetime   |        非空        |           创建时间            |
|     real_name      |     char     |        非空        |             姓名              |
| default_address_id |     int      |        外键        |          默认地址ID           |
| encrtpted_password | varchar(100) |        非空        |           加密密码            |
|   reword_points    |     int      |    非空，默认0     |             积分              |
|  news_subscribed   |     bit      |  非空，默认false   |           新闻订阅            |

## Product商品表



|       字段       |     类型     |      约束       |            描述             |
| :--------------: | :----------: | :-------------: | :-------------------------: |
|    product_id    |     int      |    主键自增     |           商品ID            |
| product_abstract |     char     |      非空       |            摘要             |
|   product_code   | varchar(50)  | 非空，唯一索引  |          商品代码           |
|   product_name   | varchar(100) |      非空       |          商品名称           |
|      price       |    double    |      非空       |          商品价格           |
|     discoun      |    double    |                 |      打折（0.01-0.99）      |
|  stock_quantity  |     int      |   非空，默认0   |           库存量            |
|      status      |   tinyint    | 非空，默认1上架 | 状态（0下架、1上架、2待审核 |
|   main_pic_url   | varchar(100) |      非空       |            主图             |
|  reword_points   |     int      |                 |            积分             |
|    sort_order    |     int      |                 |            排序             |

## 商品详情表 productDetail

| 字段           |     类型      |         约束         |     描述     |
| -------------- | :-----------: | :------------------: | :----------: |
| product_id     |      int      | 商品表外键,唯一,非空 |   详情表id   |
| description    |     text      |         非空         |   商品描述   |
| other_pic_urls | varchar(2000) |                      | 图片（数组） |



## 订单表 Order

| 字段          |   类型   |       约束       |                             描述                             |
| ------------- | :------: | :--------------: | :----------------------------------------------------------: |
| order_id      |   int    |    主键,自增     |                            订单id                            |
| customer_id   |   int    | 非空，索引，外键 |                            客户id                            |
| ship_method   |   int    |       非空       |                           递送方式                           |
| reword_points |   int    |                  |                             积分                             |
| update_time   | datetime |       非空       |                           修改时间                           |
| create_time   | datetime |       非空       |                           创建时间                           |
| total_price   |  double  |       非空       |                          订单总金额                          |
| status        | tinyint  |       非空       | 订单状态（0待处理、1处理中、2待发货、3已发货、4待签收、5已签收、6待支付、7已支付、8取消、9拒绝、10完成、11待评价、12已评价） |

## OrderDetail订单详细附表

| 字段               | 类型         | 约束 | 说明                     |
| ------------------ | ------------ | ---- | ------------------------ |
| order_id           | bigint       | 外键 | Id                       |
| ship_method        | smallint     | 非空 | 寄送方式                 |
| ship_address       | varchar(300) | 非空 | 寄送地址                 |
| ship_price         | double       | 非空 | 寄送费用                 |
| pay_method         | smallint     | 非空 | 支付方式                 |
| invoice_address    | varchar(300) | 非空 | 发票地址                 |
| invoice_price      | double       | 非空 | 发票价格                 |
| comment            | varchar(300) |      | 备注                     |
| order_products     | text         | 非空 | 内容（商品对象数组Json） |
| product_id         | int          | 非空 | 商品Id                   |
| product_code       | string       | 非空 | 商品代码                 |
| product_name       | string       | 非空 | 商品名称                 |
| quantity           | int          | 非空 | 商品数量                 |
| unit_price         | double       | 非空 | 单价                     |
| unit_reword_points | int          |      | 单个积分                 |



## 

## ReturnOrderHistory订单历史

|       字段        |     类型     |       约束       |   描述   |
| :---------------: | :----------: | :--------------: | :------: |
| order_history_id  |    bigint    |    主键 自增     |    Id    |
|     order_id      |     int      | 非空，索引，外键 |  订单Id  |
|       time        |   datetime   |       非空       |   时间   |
|      comment      | varchar(300) |       非空       |   备注   |
|   order_status    |   tinyint    |       非空       | 订单状态 |
| customer_notified |     bit      |       非空       | 通知用户 |

## 

## 退货表  **Return** 

|     字段      |     类型     |       约束       |                           描述                           |
| :-----------: | :----------: | :--------------: | :------------------------------------------------------: |
|   return_id   |     int      |    主键 自增     |                         Id退货id                         |
|   order_id    |    bigint    | 非空、索引、外键 |                          订单id                          |
|  order_time   |   datetime   |                  |                         订单时间                         |
|  customer_id  |     int      | 非空、索引、外键 |                        下单客户Id                        |
| customer_name | varchar(20)  |       非空       |                         退货客户                         |
|     email     | varchar(100) |       非空       |                         客户邮箱                         |
|    mobile     | varchar(20)  |       非空       |                        用户手机号                        |
|    status     |   tinyint    |       非空       |            状态（0等待取货、1正在处理、完成）            |
| return_action |   tinyint    |                  |             处理方式（0退货、1换货、2修理）              |
|    comment    | varchar(300) |                  |                           备注                           |
|    opened     |     bit      |       非空       |                         是否开封                         |
|    reason     |   tinyint    |       非空       | 退货原因（0发货过期、1订单错误、2收到错误商品、3质量问题 |
|   quantity    |     int      |       非空       |                       商品数量数量                       |
| product_name  | varchar(100) |       非空       |                         商品名称                         |
| product_code  | varchar(50)  |       非空       |                         商品代码                         |
|  create_time  |   datetime   |    非空，索引    |                         创建时间                         |
|  update_time  |   datetime   |       非空       |                         修改时间                         |

## 退货历史表 ReturnHistory

|       字段        |     类型     |       约束       |     描述     |
| :---------------: | :----------: | :--------------: | :----------: |
| return_history_id |     int      |    主键 自增     |  退货历史id  |
|     return_id     |     int      | 非空，索引，外键 |    退货id    |
|       time        |   datetime   |       非空       |     时间     |
|   return_status   |   tinyint    |       非空       | 退货历史状态 |
|      comment      | varchar(300) |                  |     备注     |
| customer_notified |     bit      |       非空       |   通知客户   |