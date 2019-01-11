/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : wifireport

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2019-01-11 14:53:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for monitor_host
-- ----------------------------
DROP TABLE IF EXISTS `monitor_host`;
CREATE TABLE `monitor_host` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hostName` varchar(200) DEFAULT NULL COMMENT '主机名',
  `visiableName` varchar(200) DEFAULT NULL COMMENT '主机显示名称',
  `isShow` int(5) DEFAULT '1' COMMENT '是否显示:1显示;2:不显示',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monitor_host
-- ----------------------------
INSERT INTO `monitor_host` VALUES ('1', 'Zabbix server', 'Zabbix server', '1', '');
INSERT INTO `monitor_host` VALUES ('2', 'Zabbix agentd', 'Zabbix agentd 001', '1', null);

-- ----------------------------
-- Table structure for monitor_item
-- ----------------------------
DROP TABLE IF EXISTS `monitor_item`;
CREATE TABLE `monitor_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `typeId` bigint(20) NOT NULL,
  `itemName` varchar(200) DEFAULT NULL COMMENT '监控项名称',
  `itemKey` varchar(200) DEFAULT NULL COMMENT '监控项',
  `resultType` int(1) DEFAULT '3' COMMENT '返回值类型 0:浮点 1:字符串 2:日志 3:整数(默认) 4:文本',
  `isShow` int(1) DEFAULT '1' COMMENT '是否显示:1显示 0不显示',
  `isHot` int(1) DEFAULT '0' COMMENT '热门监控项:一个类型最多配置一个热门的',
  `seq` int(5) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monitor_item
-- ----------------------------
INSERT INTO `monitor_item` VALUES ('1', '1', 'CPU1分钟平均负载值', 'system.cpu.load[percpu,avg1]', '0', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('2', '1', 'CPU5分钟平均负载值', 'system.cpu.load[percpu,avg5]', '0', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('3', '1', 'CPU15分钟平均负载值', 'system.cpu.load[percpu,avg15]', '0', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('4', '1', 'CPU闲置时长占比(%)', 'system.cpu.util[,idle]', '0', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('5', '1', 'CPU系统时长占比(%)', 'system.cpu.util[,system]', '0', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('6', '2', '内存可用容量占比(%)', 'vm.memory.size[pavailable]', '0', '0', '0', null, null);
INSERT INTO `monitor_item` VALUES ('7', '2', '内存已用容量占比(%)', 'vm.memory.size[pused]', '0', '0', '0', null, null);
INSERT INTO `monitor_item` VALUES ('8', '3', '硬盘空闲容量占比(%)', 'vfs.fs.size[/,pfree]', '0', '1', '1', '4', null);
INSERT INTO `monitor_item` VALUES ('9', '3', '硬盘已用容量占比(%)', 'vfs.fs.size[/,pused]', '0', '0', '0', null, null);
INSERT INTO `monitor_item` VALUES ('10', '4', '网卡eth1入口流量的速率(Kbps)', 'net.if.in[eth1]', '3', '1', '0', '3', null);
INSERT INTO `monitor_item` VALUES ('11', '4', '网卡eth1出口流量的速率(Kbps)', 'net.if.out[eth1]', '3', '1', '0', '4', null);
INSERT INTO `monitor_item` VALUES ('12', '4', '网卡eth0入口流量的速率(bps)', 'net.if.in[eth0]', '3', '1', '0', '1', null);
INSERT INTO `monitor_item` VALUES ('13', '4', '网卡eth0出口流量的速率(bps)', 'net.if.out[eth0]', '3', '1', '0', '2', null);
INSERT INTO `monitor_item` VALUES ('14', '1', 'CPU等待I/O操作的时长占比(%)', 'system.cpu.util[,iowait]', '0', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('15', '1', 'CPU用户时长占比(%)', 'system.cpu.util[,user]', '0', '1', '1', null, null);
INSERT INTO `monitor_item` VALUES ('16', '1', 'CPU上下文交换(sps)', 'system.cpu.switches', '3', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('17', '1', 'CPU软中断时长占比(%)', 'system.cpu.util[,softirq]', '0', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('18', '1', 'CPU虚拟服务时长占比(%)', 'system.cpu.util[,steal]', '0', '1', '0', null, '虚拟 CPU 等待实际 CPU 的时间的百分比。 低 steal 值意味着你的应用程序在目前的虚拟机上运作良好。因为你的虚拟机不会经常地为了 CPU 时间与其它虚拟机激烈竞争，你的虚拟机会更快地响应。');
INSERT INTO `monitor_item` VALUES ('19', '1', 'CPU改变过优先级的进程时长占比(%)', 'system.cpu.util[,nice]', '0', '0', '0', null, '用户进程空间内改变过优先级的进程占用CPU百分比');
INSERT INTO `monitor_item` VALUES ('20', '1', 'CPU中断时长占比(%)', 'system.cpu.util[,interrupt]', '0', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('21', '1', 'CPU中断(ips)', 'system.cpu.intr', '3', '1', '0', null, '');
INSERT INTO `monitor_item` VALUES ('22', '2', '内存可用容量(MB)', 'vm.memory.size[available]', '3', '1', '1', '2', null);
INSERT INTO `monitor_item` VALUES ('23', '2', '内存总容量(MB)', 'vm.memory.size[total]', '3', '1', '0', '1', null);
INSERT INTO `monitor_item` VALUES ('24', '3', '硬盘总容量(GB)', 'vfs.fs.size[/,total]', '3', '1', '0', '1', null);
INSERT INTO `monitor_item` VALUES ('25', '3', '硬盘空闲容量(GB)', 'vfs.fs.size[/,free]', '3', '1', '0', '2', null);
INSERT INTO `monitor_item` VALUES ('26', '3', '硬盘已用容量(GB)', 'vfs.fs.size[/,used]', '3', '1', '0', '3', null);
INSERT INTO `monitor_item` VALUES ('27', '3', '硬盘inodes数量空闲占比(%)', 'vfs.fs.inode[/,pfree]', '0', '0', '0', null, null);
INSERT INTO `monitor_item` VALUES ('28', '6', '交换分区总容量(MB)', 'system.swap.size[,total]', '3', '1', '0', '1', null);
INSERT INTO `monitor_item` VALUES ('29', '6', '交换分区空闲容量(MB)', 'system.swap.size[,free]', '3', '1', '0', '2', null);
INSERT INTO `monitor_item` VALUES ('30', '6', '交换分区空闲容量占比(%)', 'system.swap.size[,pfree]', '0', '1', '0', '3', null);
INSERT INTO `monitor_item` VALUES ('31', '5', '所有用户的进程数量(个)', 'proc.num[]', '3', '1', '0', null, null);
INSERT INTO `monitor_item` VALUES ('32', '5', '所有用户运行的进程数量(个)', 'proc.num[,,run]', '3', '1', '0', null, null);

-- ----------------------------
-- Table structure for monitor_type
-- ----------------------------
DROP TABLE IF EXISTS `monitor_type`;
CREATE TABLE `monitor_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL,
  `isShow` int(5) DEFAULT '1' COMMENT '是否显示:1显示 0不显示',
  `seq` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of monitor_type
-- ----------------------------
INSERT INTO `monitor_type` VALUES ('1', 'CPU', 'cpu', '1', null);
INSERT INTO `monitor_type` VALUES ('2', '内存', 'memory', '1', null);
INSERT INTO `monitor_type` VALUES ('3', '硬盘', 'disk', '1', null);
INSERT INTO `monitor_type` VALUES ('4', '网卡', 'if', '1', null);
INSERT INTO `monitor_type` VALUES ('5', '进程', 'process', '1', null);
INSERT INTO `monitor_type` VALUES ('6', '交换分区', 'swap', '1', null);

-- ----------------------------
-- Table structure for s_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `s_dictionary`;
CREATE TABLE `s_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(200) DEFAULT NULL,
  `val` varchar(200) DEFAULT NULL,
  `text` varchar(200) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `active` char(1) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_dictionary
-- ----------------------------
INSERT INTO `s_dictionary` VALUES ('1', 'DIC', 'S_DIC', '数据字典', null, '1', '');

-- ----------------------------
-- Table structure for s_fileinfo
-- ----------------------------
DROP TABLE IF EXISTS `s_fileinfo`;
CREATE TABLE `s_fileinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `displayName` varchar(250) DEFAULT NULL,
  `fileSize` bigint(20) DEFAULT NULL,
  `realPath` varchar(250) DEFAULT NULL,
  `webPath` varchar(250) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_fileinfo
-- ----------------------------

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `lvl` int(11) DEFAULT NULL,
  `leaf` char(1) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `module_id` bigint(20) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `menuType` varchar(20) NOT NULL,
  `script` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES ('1', 'Menu', '菜单根节点', '0', '0', null, null, '', 'BackGround', '', null, null);
INSERT INTO `s_menu` VALUES ('50', 'Menu', '系统管理', '1', '0', '1', null, '_mainFrame', 'BackGround', '', null, '1');
INSERT INTO `s_menu` VALUES ('100', 'Menu', '用户管理', '2', '1', '50', '3', '_mainFrame', 'BackGround', '', null, null);
INSERT INTO `s_menu` VALUES ('101', 'Menu', '角色管理', '2', '1', '50', '28', '_mainFrame', 'BackGround', '', null, null);
INSERT INTO `s_menu` VALUES ('102', 'Menu', '组织架构管理', '2', '1', '50', '16', '_mainFrame', 'BackGround', '', null, null);
INSERT INTO `s_menu` VALUES ('103', 'Menu', '资源管理', '2', '1', '50', '35', '_mainFrame', 'BackGround', '', null, null);
INSERT INTO `s_menu` VALUES ('104', 'Menu', '菜单管理', '2', '1', '50', '53', '_mainFrame', 'BackGround', '', null, null);
INSERT INTO `s_menu` VALUES ('200', 'Menu', '字典表管理', '2', '1', '50', '43', '_mainFrame', 'BackGround', '', null, null);
INSERT INTO `s_menu` VALUES ('201', 'Menu', '系统登出', '2', '1', '50', null, '_mainFrame', 'BackGround', 'if (confirm(\"确定系统登出？\")) {\ntop.location.href = basePath+\"/systemAction!j_spring_security_logout\";}', null, '9');
INSERT INTO `s_menu` VALUES ('202', 'Menu', '修改密码', '2', '1', '50', '14', '_mainFrame', 'BackGround', '', null, null);
INSERT INTO `s_menu` VALUES ('203', 'Menu', '监控管理', '2', '1', '50', '75', '_mainFrame', 'BackGround', '', '', null);

-- ----------------------------
-- Table structure for s_organization
-- ----------------------------
DROP TABLE IF EXISTS `s_organization`;
CREATE TABLE `s_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `lvl` int(11) DEFAULT NULL,
  `seq` int(11) DEFAULT '0',
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_name` varchar(255) DEFAULT NULL,
  `leaf` char(1) DEFAULT NULL,
  `usable` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_organization
-- ----------------------------
INSERT INTO `s_organization` VALUES ('1', '浙江', '0', '0', '0', '无', '0', '1');
INSERT INTO `s_organization` VALUES ('2', '杭州', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('3', '宁波', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('4', '温州', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('5', '绍兴', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('6', '湖州', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('7', '嘉兴', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('8', '金华', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('9', '衢州', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('10', '台州', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('11', '丽水', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('12', '舟山', '1', '0', '1', '浙江', '0', '1');
INSERT INTO `s_organization` VALUES ('13', '上城区', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('14', '下城区', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('15', '江干区', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('16', '拱墅区', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('17', '西湖区', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('18', '滨江区', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('19', '余杭区', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('20', '萧山区', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('21', '富阳区', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('22', '建德市', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('23', '临安市', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('24', '桐庐县', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('25', '淳安县', '2', '0', '2', '杭州', '1', '1');
INSERT INTO `s_organization` VALUES ('37', '海曙区', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('38', '江东区', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('39', '江北区', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('40', '北仑区', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('41', '镇海区', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('42', '鄞州区', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('43', '余姚市', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('44', '慈溪市', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('45', '奉化市', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('46', '象山县', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('47', '宁海县', '2', '0', '3', '宁波', '1', '1');
INSERT INTO `s_organization` VALUES ('48', '鹿城区', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('49', '龙湾区', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('50', '瓯海区', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('51', '洞头区', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('52', '瑞安市', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('53', '乐清市', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('54', '永嘉县', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('55', '平阳县', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('56', '苍南县', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('57', '文成县', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('58', '泰顺县', '2', '0', '4', '温州', '1', '1');
INSERT INTO `s_organization` VALUES ('59', '越城区', '2', '0', '5', '绍兴', '1', '1');
INSERT INTO `s_organization` VALUES ('60', '柯桥区', '2', '0', '5', '绍兴', '1', '1');
INSERT INTO `s_organization` VALUES ('61', '上虞区', '2', '0', '5', '绍兴', '1', '1');
INSERT INTO `s_organization` VALUES ('62', '诸暨市', '2', '0', '5', '绍兴', '1', '1');
INSERT INTO `s_organization` VALUES ('63', '嵊州市', '2', '0', '5', '绍兴', '1', '1');
INSERT INTO `s_organization` VALUES ('64', '新昌县', '2', '0', '5', '绍兴', '1', '1');
INSERT INTO `s_organization` VALUES ('65', '吴兴区', '2', '0', '6', '湖州', '1', '1');
INSERT INTO `s_organization` VALUES ('66', '南浔区', '2', '0', '6', '湖州', '1', '1');
INSERT INTO `s_organization` VALUES ('67', '德清县', '2', '0', '6', '湖州', '1', '1');
INSERT INTO `s_organization` VALUES ('68', '长兴县', '2', '0', '6', '湖州', '1', '1');
INSERT INTO `s_organization` VALUES ('69', '安吉县', '2', '0', '6', '湖州', '1', '1');
INSERT INTO `s_organization` VALUES ('71', '南湖区', '2', '0', '7', '嘉兴', '1', '1');
INSERT INTO `s_organization` VALUES ('72', '秀洲区', '2', '0', '7', '嘉兴', '1', '1');
INSERT INTO `s_organization` VALUES ('73', '海宁市', '2', '0', '7', '嘉兴', '1', '1');
INSERT INTO `s_organization` VALUES ('74', '平湖市', '2', '0', '7', '嘉兴', '1', '1');
INSERT INTO `s_organization` VALUES ('75', '桐乡市', '2', '0', '7', '嘉兴', '1', '1');
INSERT INTO `s_organization` VALUES ('76', '嘉善县', '2', '0', '7', '嘉兴', '1', '1');
INSERT INTO `s_organization` VALUES ('77', '海盐县', '2', '0', '7', '嘉兴', '1', '1');
INSERT INTO `s_organization` VALUES ('78', '婺城区', '2', '0', '8', '金华', '1', '1');
INSERT INTO `s_organization` VALUES ('79', '金东区', '2', '0', '8', '金华', '1', '1');
INSERT INTO `s_organization` VALUES ('80', '兰溪市', '2', '0', '8', '金华', '1', '1');
INSERT INTO `s_organization` VALUES ('81', '东阳市', '2', '0', '8', '金华', '1', '1');
INSERT INTO `s_organization` VALUES ('82', '永康市', '2', '0', '8', '金华', '1', '1');
INSERT INTO `s_organization` VALUES ('83', '义乌市', '2', '0', '8', '金华', '1', '1');
INSERT INTO `s_organization` VALUES ('84', '武义县', '2', '0', '8', '金华', '1', '1');
INSERT INTO `s_organization` VALUES ('85', '浦江县', '2', '0', '8', '金华', '1', '1');
INSERT INTO `s_organization` VALUES ('86', '磐安县', '2', '0', '8', '金华', '1', '1');
INSERT INTO `s_organization` VALUES ('87', '柯城区', '2', '0', '9', '衢州', '1', '1');
INSERT INTO `s_organization` VALUES ('88', '衢江区', '2', '0', '9', '衢州', '1', '1');
INSERT INTO `s_organization` VALUES ('89', '江山市', '2', '0', '9', '衢州', '1', '1');
INSERT INTO `s_organization` VALUES ('90', '常山县', '2', '0', '9', '衢州', '1', '1');
INSERT INTO `s_organization` VALUES ('91', '开化县', '2', '0', '9', '衢州', '1', '1');
INSERT INTO `s_organization` VALUES ('92', '龙游县', '2', '0', '9', '衢州', '1', '1');
INSERT INTO `s_organization` VALUES ('93', '椒江区', '2', '0', '10', '台州', '1', '1');
INSERT INTO `s_organization` VALUES ('94', '黄岩区', '2', '0', '10', '台州', '1', '1');
INSERT INTO `s_organization` VALUES ('95', '路桥区', '2', '0', '10', '台州', '1', '1');
INSERT INTO `s_organization` VALUES ('96', '临海市', '2', '0', '10', '台州', '1', '1');
INSERT INTO `s_organization` VALUES ('97', '温岭市', '2', '0', '10', '台州', '1', '1');
INSERT INTO `s_organization` VALUES ('98', '玉环县', '2', '0', '10', '台州', '1', '1');
INSERT INTO `s_organization` VALUES ('99', '三门县', '2', '0', '10', '台州', '1', '1');
INSERT INTO `s_organization` VALUES ('100', '天台县', '2', '0', '10', '台州', '1', '1');
INSERT INTO `s_organization` VALUES ('101', '仙居县', '2', '0', '10', '台州', '1', '1');
INSERT INTO `s_organization` VALUES ('102', '莲都区', '2', '0', '11', '丽水', '1', '1');
INSERT INTO `s_organization` VALUES ('103', '龙泉市', '2', '0', '11', '丽水', '1', '1');
INSERT INTO `s_organization` VALUES ('104', '青田县', '2', '0', '11', '丽水', '1', '1');
INSERT INTO `s_organization` VALUES ('105', '缙云县', '2', '0', '11', '丽水', '1', '1');
INSERT INTO `s_organization` VALUES ('106', '遂昌县', '2', '0', '11', '丽水', '1', '1');
INSERT INTO `s_organization` VALUES ('107', '松阳县', '2', '0', '11', '丽水', '1', '1');
INSERT INTO `s_organization` VALUES ('108', '云和县', '2', '0', '11', '丽水', '1', '1');
INSERT INTO `s_organization` VALUES ('109', '庆元县', '2', '0', '11', '丽水', '1', '1');
INSERT INTO `s_organization` VALUES ('110', '景宁畲族自治县', '2', '0', '11', '丽水', '1', '1');
INSERT INTO `s_organization` VALUES ('111', '定海区', '2', '0', '12', '舟山', '1', '1');
INSERT INTO `s_organization` VALUES ('112', '普陀区', '2', '0', '12', '舟山', '1', '1');
INSERT INTO `s_organization` VALUES ('113', '岱山县', '2', '0', '12', '舟山', '1', '1');
INSERT INTO `s_organization` VALUES ('114', '嵊泗县', '2', '0', '12', '舟山', '1', '1');

-- ----------------------------
-- Table structure for s_resource
-- ----------------------------
DROP TABLE IF EXISTS `s_resource`;
CREATE TABLE `s_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pattern` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `identify` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `lvl` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `leaf` bit(1) DEFAULT NULL,
  `returnExample` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `format` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_resource
-- ----------------------------
INSERT INTO `s_resource` VALUES ('1', 'Module', '系统', '/**/*', '', '', '/', '0', '0', null, '\0', '', '', '');
INSERT INTO `s_resource` VALUES ('2', 'Module', '用户管理', '/**/user*', '用户管理', 'user', '/userAction', '1', '1', '1', '\0', null, null, null);
INSERT INTO `s_resource` VALUES ('3', 'Privilege', '用户列表', '/userAction/list*', '用户列表', 'list', '/userAction/list', '1', '2', '2', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('4', 'Privilege', '用户详情', '/**/userAction/detail*', '用户详情', 'detail', '/userAction/detail', '5', '2', '2', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('5', 'Privilege', '用户修改', '/**/userAction/update*', '用户修改', 'update', '/userAction/update', '3', '2', '2', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('6', 'Privilege', '用户修改页面', '/userAction/update_page*', '用户修改页面', 'page', '/userAction/update_page', null, '3', '5', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('7', 'Privilege', '用户新增', '/**/userAction/create*', '用户新增', 'create', '/userAction/create', '2', '2', '2', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('8', 'Privilege', '用户新增页面', '/**/userAction/create_page*', '用户新增页面', 'page', '/userAction/create_page', null, '3', '7', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('9', 'Privilege', '用户删除', '/**/userAction/delete*', '用户删除', 'delete', '/userAction/delete', '4', '2', '2', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('10', 'Privilege', '是否存在相同用户名', '/**/userAction/sameUsername*', '是否存在相同用户名', 'sameUsername', '/userAction/sameUsername', null, '2', '2', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('11', 'Privilege', '登录页面', '/**/userAction/goLogin*', '用户登录页面', 'goLogin', '/userAction/goLogin', null, '2', '2', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('12', 'Privilege', '主页面', '/**/userAction/goMain*', '登录后的主页面', 'goMain', '/userAction/goMain', null, '2', '2', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('13', 'Privilege', '用户密码修改', '/**/userAction/update_pwd*', '用户密码修改', 'update_pwd', '/userAction/update_pwd', null, '2', '2', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('14', 'Privilege', '用户密码修改页面', '/**/userAction/update_pwd_page*', '用户密码修改页面', 'page', '/userAction/update_pwd_page', null, '3', '13', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('15', 'Module', '组织架构管理', '/**/org*', '组织架构管理', 'org', '/org', '3', '1', '1', '\0', null, null, null);
INSERT INTO `s_resource` VALUES ('16', 'Privilege', '组织架构管理首页面', '/**/orgAction/index*', '组织架构管理首页面', 'index', '/orgAction/index', '1', '2', '15', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('17', 'Privilege', '加载组织架构树', '/**/orgAction/read*', '加载组织架构树', 'read', '/orgAction/read', null, '2', '15', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('18', 'Privilege', '组织新增', '/**/orgAction/create*', '组织新增', 'create', '/orgAction/create', '2', '2', '15', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('19', 'Privilege', '组织新增页面', '/**/orgAction/create_page*', '组织新增页面', 'page', '/orgAction/create_page', null, '3', '18', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('20', 'Privilege', '组织修改', '/**/orgAction/update*', '组织修改', 'update', '/orgAction/update', '3', '2', '15', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('21', 'Privilege', '组织修改页面', '/**/orgAction/update_page*', '组织修改页面', 'page', '/orgAction/update_page', null, '3', '20', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('22', 'Privilege', '组织删除', '/**/orgAction/delete*', '组织删除', 'delete', '/orgAction/delete', '4', '2', '15', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('23', 'Privilege', '组织详情', '/**/orgAction/detail*', '组织详情', 'detail', '/orgAction/detail', '5', '2', '15', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('24', 'Privilege', '组织架构查询', '/**/orgAction/query*', '组织架构查询', 'query', '/orgAction/query', null, '2', '15', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('25', 'Module', '角色管理', '/**/role*', '角色管理', 'role', '/roleAction', '2', '1', '1', '\0', null, null, null);
INSERT INTO `s_resource` VALUES ('26', 'Privilege', '角色修改', '/**/roleAction/update*', '角色修改', 'update', '/roleAction/update', '3', '2', '25', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('27', 'Privilege', '角色修改页面', '/**/roleAction/update_page*', '角色修改页面', 'page', '/roleAction/update_page', null, '3', '26', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('28', 'Privilege', '角色列表', '/**/roleAction/list*', '角色列表', 'list', '/roleAction/list', '1', '2', '25', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('29', 'Privilege', '角色选择', '/**/roleAction/list_select*', '角色选择', 'select', '/roleAction/list_select', null, '3', '28', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('30', 'Privilege', '角色新增', '/**/roleAction/create*', '角色新增', 'create', '/roleAction/create', '2', '2', '25', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('31', 'Privilege', '角色新增页面', '/**/roleAction/create_page*', '角色新增页面', 'page', '/roleAction/create_page', null, '3', '30', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('32', 'Privilege', '角色删除', '/**/roleAction/delete*', '角色删除', 'delete', '/roleAction/delete', '4', '2', '25', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('33', 'Privilege', '角色详情', '/**/roleAction/detail*', '角色详情', 'detail', '/roleAction/detail', '5', '2', '25', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('34', 'Module', '资源管理', '/**/resource*', '', 'resource', '/resource', '4', '1', '1', '\0', null, null, null);
INSERT INTO `s_resource` VALUES ('35', 'Privilege', '资源管理首页面', '/**/resourceAction/index*', '资源管理首页面', 'index', '/resourceAction/index', null, '2', '34', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('36', 'Privilege', '资源管理详情页面', '/**/resourceAction/detail*', '资源管理详情页面', 'detail', '/resourceAction/detail', null, '2', '34', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('37', 'Privilege', '资源新建', '/**/resourceAction/create*', '资源新建', 'create', '/resourceAction/create', null, '2', '34', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('38', 'Privilege', '资源删除', '/**/resourceAction/delete*', '资源删除', 'delete', '/resourceAction/delete', null, '2', '34', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('39', 'Privilege', '资源更新', '/**/resourceAction/updatePrivilege*', '资源更新', 'updatePrivilege', '/resourceAction/updatePrivilege', null, '2', '34', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('40', 'Privilege', '模块更新', '/**/resourceAction/updateModule*', '模块更新', 'updateModule', '/resourceAction/updateModule', null, '2', '34', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('41', 'Privilege', '资源树加载', '/**/resourceAction/read*', '资源树加载', 'read', '/resourceAction/read', null, '2', '34', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('42', 'Module', '字典表管理', '/**/dictionary*', '', 'dictionary', '/dictionary', '5', '1', '1', '\0', null, null, null);
INSERT INTO `s_resource` VALUES ('43', 'Privilege', '字典表管理首页面', '/**/dictionaryAction/index*', '字典表管理首页面', 'index', '/dictionaryAction/index', '1', '2', '42', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('44', 'Privilege', '字典表新增', '/**/dictionaryAction/create*', '字典表新增', 'create', '/dictionaryAction/create', '2', '2', '42', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('45', 'Privilege', '字典表新增页面', '/**/dictionaryAction/create_page*', '字典表新增页面', 'page', '/dictionaryAction/create_page', null, '3', '44', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('46', 'Privilege', '字典表修改', '/**/dictionaryAction/update*', '字典表修改', 'update', '/dictionaryAction/update', '3', '2', '42', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('47', 'Privilege', '字典表修改页面', '/**/dictionaryAction/update_page*', '字典表修改页面', 'page', '/dictionaryAction/update_page', '4', '3', '46', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('48', 'Privilege', '字典表删除', '/**/dictionaryAction/delete*', '字典表删除', 'delete', '/dictionaryAction/delete', '4', '2', '42', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('49', 'Privilege', '字典表详情', '/**/dictionaryAction/detail*', '字典表详情', 'detail', '/dictionaryAction/detail', '5', '2', '42', '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('50', 'Privilege', '加载字典表树', '/**/dictionaryAction/read*', '加载字典表树', 'read', '/dictionaryAction/read', '6', '2', '42', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('51', 'Privilege', '字典表查找', '/**/dictionaryAction/query*', '字典表查找', 'query', '/dictionaryAction/query', null, '2', '42', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('52', 'Module', '菜单管理', '/**/menu*', '', 'menu', '/menu', '6', '1', '1', '\0', null, null, null);
INSERT INTO `s_resource` VALUES ('53', 'Privilege', '菜单管理首页面', '/**/menuAction/index*', '菜单管理首页面', 'index', '/menuAction/index', '1', '2', '52', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('54', 'Privilege', '菜单树加载', '/**/menuAction/read*', '菜单树加载', 'read', '/menuAction/read', null, '2', '52', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('55', 'Privilege', '菜单新增', '/**/menuAction/create*', '菜单新增', 'create', '/menuAction/create', '2', '2', '52', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('56', 'Privilege', '菜单新增页面', '/**/menuAction/create_page*', '菜单新增页面', 'page', '/menuAction/create_page', null, '3', '55', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('57', 'Privilege', '菜单修改', '/**/menuAction/update*', '菜单修改', 'update', '/menuAction/update', '3', '2', '52', '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('58', 'Privilege', '菜单修改页面', '/**/menuAction/update_page*', '菜单修改页面', 'page', '/menuAction/update_page', null, '3', '57', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('59', 'Privilege', '菜单删除', '/**/menuAction/delete*', '菜单删除', 'delete', '/menuAction/delete', '4', '2', '52', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('60', 'Privilege', '菜单详情', '/**/menuAction/detail*', '菜单详情', 'detail', '/menuAction/detail', '5', '2', '52', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('61', 'Privilege', '菜单移动', '/**/menuAction/moveTo*', '菜单移动', 'moveTo', '/menuAction/moveTo', null, '2', '52', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('62', 'Module', '缓存管理', '/**/cache*', '', 'cache', '/cache', '7', '1', '1', '\0', null, null, null);
INSERT INTO `s_resource` VALUES ('63', 'Privilege', '缓存列表', '/**/cacheAction/list*', '缓存列表', 'list', '/cacheAction/list', null, '2', '62', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('64', 'Privilege', '缓存清除', '/**/cacheAction/delete*', '缓存清除', 'delete', '/cacheAction/delete', null, '2', '62', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('65', 'Module', '系统公共资源', '/**/system*', '系统公共资源', 'system', '/systemAction', '7', '1', '1', '\0', null, null, null);
INSERT INTO `s_resource` VALUES ('66', 'Privilege', '系统登出', '/**/systemAction/j_spring_security_logout*', '系统登出', 'j_spring_security_logout', '/systemAction/j_spring_security_logout', null, '2', '65', '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('67', 'Module', '监控管理', null, null, null, null, null, '1', '1', '\0', null, null, null);
INSERT INTO `s_resource` VALUES ('68', 'Privilege', '监控管理列表', '/**#path#/list*', '监控管理列表', 'list', '#path#/list', '1', '2', null, '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('69', 'Privilege', '监控管理详情', '/**#path#/detail*', '', 'detail', '#path#/detail', '5', '2', null, '', null, '', 'html');
INSERT INTO `s_resource` VALUES ('70', 'Privilege', '监控管理修改', '/**#path#/update*', '', 'update', '#path#/update', '3', '2', null, '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('71', 'Privilege', '监控管理修改页面', '/**#path#/update_page*', '', 'page', '#path#/update_page', null, '3', '70', '', null, '', 'html ');
INSERT INTO `s_resource` VALUES ('72', 'Privilege', '监控管理新增', '/**#path#/create*', '', 'create', '#path#/create', '2', '2', null, '\0', null, '', 'json');
INSERT INTO `s_resource` VALUES ('73', 'Privilege', '监控管理新增页面', '/**#path#/create_page*', '', 'page', '#path#/create_page', null, '3', '72', '', null, '', 'html ');
INSERT INTO `s_resource` VALUES ('74', 'Privilege', '监控管理删除', '/**#path#/delete*', '', 'delete', '#path#/delete', '4', '2', null, '', null, '', 'json');
INSERT INTO `s_resource` VALUES ('75', 'Privilege', '主机名', '/**/monitorHistoryAction/index*', '主机名', 'index', '/monitorHistoryAction/index', '1', '2', '67', '\0', null, null, 'json');
INSERT INTO `s_resource` VALUES ('76', 'Privilege', 'Zabbix server', '/**/monitorHistoryAction/detail*', null, 'Zabbix server', '/monitorHistoryAction/detail?hostName=Zabbix server', '2', '3', '75', '\0', null, null, 'json');
INSERT INTO `s_resource` VALUES ('77', 'Privilege', 'cpu', '/**/monitorHistoryAction/detail*', null, 'CPU', '/monitorHistoryAction/detail?type=cpu', null, '4', '76', '', null, null, 'json');
INSERT INTO `s_resource` VALUES ('78', 'Privilege', 'Zabbix agentd', '/**/monitorHistoryAction/detail*', null, 'Zabbix agentd 001', '/monitorHistoryAction/detail?hostName=Zabbix agentd 001', '1', '3', '75', '\0', null, null, 'json');
INSERT INTO `s_resource` VALUES ('79', 'Privilege', '内存', '/**/monitorHistoryAction/detail*', null, 'memory', '/monitorHistoryAction/detail?type=memory', null, '4', '76', '', null, null, 'json');
INSERT INTO `s_resource` VALUES ('80', 'Privilege', '硬盘', '/**/monitorHistoryAction/detail*', null, 'disk', '/monitorHistoryAction/detail?type=disk', null, '4', '76', '', null, null, 'json');
INSERT INTO `s_resource` VALUES ('81', 'Privilege', '网卡', '/**/monitorHistoryAction/detail*', null, 'if', '/monitorHistoryAction/detail?type=if', null, '4', '76', '', null, null, 'json');
INSERT INTO `s_resource` VALUES ('82', 'Privilege', 'cpu', '/**/monitorHistoryAction/detail*', null, 'CPU', '/monitorHistoryAction/detail?type=cpu', null, '4', '78', '', null, null, 'json');
INSERT INTO `s_resource` VALUES ('83', 'Privilege', '内存', '/**/monitorHistoryAction/detail*', null, 'memory', '/monitorHistoryAction/detail?type=memory', null, '4', '78', '', null, null, 'json');
INSERT INTO `s_resource` VALUES ('84', 'Privilege', '硬盘', '/**/monitorHistoryAction/detail*', null, 'disk', '/monitorHistoryAction/detail?type=disk', null, '4', '78', '', null, null, 'json');
INSERT INTO `s_resource` VALUES ('85', 'Privilege', '网卡', '/**/monitorHistoryAction/detail*', null, 'if', '/monitorHistoryAction/detail?type=if', null, '4', '78', '', null, null, 'json');
INSERT INTO `s_resource` VALUES ('86', 'Module', '报表管理', '/**/report*/*', null, 'report', '/reportAction', '10', '1', '1', '', null, null, null);

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1451 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('150', 'Role', '登录用户', '2015-07-20 11:11:38', '登录用户');
INSERT INTO `s_role` VALUES ('1450', 'Role', '系统管理员', '2015-07-20 11:11:38', '系统管理员');

-- ----------------------------
-- Table structure for s_role_resource_rel
-- ----------------------------
DROP TABLE IF EXISTS `s_role_resource_rel`;
CREATE TABLE `s_role_resource_rel` (
  `resource_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role_resource_rel
-- ----------------------------
INSERT INTO `s_role_resource_rel` VALUES ('1', '1450');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `accountNonExpired` char(1) DEFAULT NULL,
  `accountNonLocked` char(1) DEFAULT NULL,
  `credentialsNonExpired` char(1) DEFAULT NULL,
  `enabled` char(1) DEFAULT NULL,
  `dtype` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `login_count` bigint(20) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('153', 'admin', 'DF10EF8509DC176D733D59549E7DBFAF', '1', '1', '1', '1', 'User', '超级管理员', '2015-07-20 11:10:56', null, null, null);
INSERT INTO `s_user` VALUES ('154', 'wangjb', 'A95026EDE7EECF5C8B356113E26A4460', '1', '1', '1', '1', 'User', '王xx', '2016-06-24 14:21:13', null, null, '1');
INSERT INTO `s_user` VALUES ('155', 'test', 'DF10EF8509DC176D733D59549E7DBFAF', '1', '1', '1', '1', 'User', '测试账号-普通用户', '2016-08-11 10:46:58', null, null, '1');

-- ----------------------------
-- Table structure for s_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role_rel`;
CREATE TABLE `s_user_role_rel` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_role_rel
-- ----------------------------
INSERT INTO `s_user_role_rel` VALUES ('153', '1450');
INSERT INTO `s_user_role_rel` VALUES ('154', '1450');
INSERT INTO `s_user_role_rel` VALUES ('155', '150');
