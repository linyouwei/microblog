drop table if exists `tb_user_daily_details`;
create table `tb_user_daily_details`(
  `id` int(5) not null auto_increment ,
   `daily_id` int(5) not null  ,
   `user_category_id` int(5) not null,
  primary key (`id`)
) engine=innodb default charset=utf8;
