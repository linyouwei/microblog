drop table if exists `category`;
create table `category`(
  `id` int(5) not null auto_increment ,
  `category_name` varchar(50) not null,
  primary key (`id`)
) engine=innodb default charset=utf8;