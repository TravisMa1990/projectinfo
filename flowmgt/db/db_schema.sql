CREATE TABLE `t_user` (
  `id` VARCHAR(255) NOT NULL,
  `id_p` INTEGER NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户登录名',
  `password` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码',
  `real_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态(0正常 1停用 2删除)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id_p`),
  UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;