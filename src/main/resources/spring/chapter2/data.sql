CREATE TABLE `t_user` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_name` varchar(30) NOT NULL DEFAULT '' COMMENT '�˺���',
	`credits` int(11) NOT NULL DEFAULT '0' COMMENT '����',
	`password` varchar(30) NOT NULL DEFAULT '' COMMENT '����',
	`last_visit` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '��½ʱ��',
	`last_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '��½IP',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�˺ű�';

CREATE TABLE `t_login_log` (
	`login_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`user_id` int(11) NOT NULL COMMENT 'id',
	`ip` varchar(30) NOT NULL DEFAULT '' COMMENT '��½IP',
	`login_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '��½ʱ��',
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�˺ű�';