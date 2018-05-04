drop table if exists `tb_user_details`;
create table `tb_user_details`(
 `id` int(5) not null auto_increment ,
  `user_login_id` int(5) not null,
  `gender` int(1),
  `img_path` varchar(50),
  `birthday` datetime ,
  `province` int(11),
  `city` int(11),
  `marriage` int(1),
  primary key (`id`)
) engine=innodb default charset=utf8;