drop table if exists `tb_user_category`;
create table `tb_user_category`(
  `id` int(5) not null auto_increment ,
  `user_login_id` int(5) not null,
  `category_name` varchar(50) not null,
   `is_delete` tinyint not null default 0,
  primary key (`id`)
) engine=innodb default charset=utf8;

INSERT  INTO `user_category`(`id`,`user_login_id`,`category_name`,`is_delete`) VALUES (1,1,'计算机',0),(2,1,'it',0),(3,1,'金融',0),(4,1,'a',0),(5,1,'b',0),(6,1,'bbb',0),(7,1,'ccc',0);

