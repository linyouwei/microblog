use `microblog`
drop table if exists `user_img`;
create table `user_img`(
 `id` int(5) not null auto_increment ,
  `img_path` varchar(200) not null,
  `user_login_id` int(5) not null,
  primary key (`id`)
) engine=innodb default charset=utf8;