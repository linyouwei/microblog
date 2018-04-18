drop table if exists `comment`;
create table `comment`(
  `id` int(5) auto_increment ,
  `content` varchar(200) not null ,
  `created_time` datetime not null ,
  `daily_id` int(5) not null ,
   `user_id` int(5) not null ,
  primary key (`id`)
) engine=innodb default charset=utf8;