CREATE TABLE `t_user` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_name` varchar(30) NOT NULL DEFAULT '' COMMENT '账号名',
	`credits` int(11) NOT NULL DEFAULT '0' COMMENT '积分',
	`password` varchar(30) NOT NULL DEFAULT '' COMMENT '密码',
	`last_visit` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '登陆时间',
	`last_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '登陆IP',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号表';

CREATE TABLE `t_login_log` (
	`login_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` int(11) NOT NULL COMMENT 'id',
	`ip` varchar(30) NOT NULL DEFAULT '' COMMENT '登陆IP',
	`login_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '登陆时间',
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号表';