
drop table if exists `user_daily_tags`;
create table `user_daily_tags`(
  `id` int(5) not null auto_increment ,
   `user_login_id` int(5) not null,
  `daily_id` int(5) not null  ,
   `name` varchar(50) not null,
  primary key (`id`)
) engine=innodb default charset=utf8;