drop table if exists `daily`;
create table `daily`(
 `id` int(5) not null auto_increment ,
  `title` varchar(50) not null  comment '标题' ,
  `body` varchar(300) not null  comment '内容',
  `created_time` datetime not null ,
  `modified_time` datetime  ,
  `category_id` int(5) not null   comment '系统分类',
  `user_id` varchar(50) not null comment '作者',
  `click` int(10) not null default 0,
  primary key (`id`)
) engine=innodb default charset=utf8;

insert  into `daily`(`id`,`title`,`body`,`created_time`,`modified_time`,`category_id`,`user_id`,`click`) values (1,'33','eee','2018-03-20 00:06:06','2018-03-20 00:06:06',1,'1',0),(2,'33','eee','2018-03-20 00:06:40','2018-03-20 00:06:40',1,'1',0),(3,'33','eee','2018-03-20 00:07:18','2018-03-20 00:07:18',1,'1',0),(4,'e','ddds','2018-03-20 00:21:31','2018-03-20 00:21:31',1,'1',0),(5,'ee','eee','2018-03-20 00:24:00','2018-03-20 00:24:00',1,'1',0),(6,'ee','eee','2018-03-20 00:25:25','2018-03-20 00:25:25',1,'1',0),(7,'','','2018-03-20 00:30:45','2018-03-20 00:30:45',0,'1',0),(8,'dd','dddd','2018-03-20 00:31:14','2018-03-20 00:31:14',0,'1',0),(9,'','','2018-03-20 00:31:42','2018-03-20 00:31:42',0,'1',0);
