#
# Shiro user-role-permission-menu mysql innodb table
#

DROP TABLE IF EXISTS sys_user;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_menu;
DROP TABLE IF EXISTS sys_user_role;
DROP TABLE IF EXISTS sys_role_menu;

CREATE TABLE `sys_user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID(自动递增)',
  `ACCOUNT` varchar(49) NOT NULL COMMENT '用户账号',
  `PASSWORD` varchar(255) NOT NULL COMMENT '登录密码',
  `NICK_NAME` varchar(49) DEFAULT NULL COMMENT '用户昵称',
  `REAL_NAME` varchar(27) DEFAULT NULL COMMENT '真实姓名',
  `MOBILE` bigint(11) DEFAULT NULL COMMENT '手机号',
  `GENDER` varchar(2) DEFAULT NULL COMMENT '用户性别：01男；02女；03保密',
  `AGE` int(3) DEFAULT NULL COMMENT '年龄',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '所在地',
  `BIRTHDAY` varchar(255) DEFAULT NULL COMMENT '生日',
  `STATE` varchar(2) DEFAULT '01' COMMENT '账号状态：01正常；02冻结；99删除',
  `LASTLOGIN_TIME` datetime DEFAULT NULL COMMENT '最近登录时间',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `sys_user_account` (`ACCOUNT`) COMMENT '用户账号唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `sys_role` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID(自动递增)',
  `ROLE_NAME` varchar(49) NOT NULL COMMENT '角色名称',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '详细描述',
  `CREATE_ID` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_ID` bigint(20) DEFAULT NULL COMMENT '更新者',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

CREATE TABLE `sys_menu` (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID(自动递增)',
  `MENU_NAME` varchar(49) DEFAULT NULL COMMENT '栏目名',
  `PERMISSION` varchar(200) NOT NULL COMMENT '权限名称(多个用逗号分隔，如：user:list,user:create）',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '详情描述',
  `URL` varchar(200) DEFAULT NULL COMMENT '链接地址',
  `MENU_CLASS` varchar(100) DEFAULT NULL COMMENT '菜单样式',
  `SORT` int(11) DEFAULT '0' COMMENT '排序(默认0)',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '父级菜单(0本身)',
  `MENU_TYPE` varchar(2) DEFAULT NULL COMMENT '菜单类型：01目录；02菜单；03按钮',
  `STATE` varchar(2) DEFAULT '01' COMMENT '菜单状态：01显示；02禁用',
  `CREATE_ID` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_ID` bigint(20) DEFAULT NULL COMMENT '更新者',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

CREATE TABLE `sys_user_role` (
  `USER_ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联ID(自动递增)',
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `CREATE_ID` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`USER_ROLE_ID`),
  UNIQUE KEY `sys_userid_roleid` (`USER_ID`,`ROLE_ID`) COMMENT '用户角色ID联合唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

CREATE TABLE `sys_role_menu` (
  `ROLE_MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色菜单关联ID(自动递增)',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `MENU_ID` bigint(20) NOT NULL COMMENT '菜单ID',
  `CREATE_ID` bigint(20) DEFAULT NULL COMMENT '创建者',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ROLE_MENU_ID`),
  UNIQUE KEY `sys_roleid_menuid` (`ROLE_ID`,`MENU_ID`) COMMENT '角色菜单ID联合唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

commit;
