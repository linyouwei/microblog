drop table if exists `user_daily_details`;
create table `user_daily_details`(
  `id` int(5) not null auto_increment ,
  `user_category_id` int(5) not null,
   `daily_id` int(5) not null  ,
  primary key (`id`)
) engine=innodb default charset=utf8;
