drop table if exists `user_login`;
create table `user_login`(
  `id` int(5) not null auto_increment ,
  `user_name` varchar(20) not null,
  `password` varchar(50) not null ,
  `created_time` datetime not null  ,
  `role_id` int(5) not null default 3,
  primary key (`id`)
) engine=innodb default charset=utf8;