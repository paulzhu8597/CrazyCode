/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : product

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2015-09-21 20:44:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bringtakeinfo`
-- ----------------------------
DROP TABLE IF EXISTS `bringtakeinfo`;
CREATE TABLE `bringtakeinfo` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `orgname` varchar(64) default NULL COMMENT '所在单位',
  `tel` int(16) default NULL COMMENT '联系电话',
  `mask` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='送取货人';

-- ----------------------------
-- Records of bringtakeinfo
-- ----------------------------
INSERT INTO `bringtakeinfo` VALUES ('1', '李彦宏', '百度', '23479', null);
INSERT INTO `bringtakeinfo` VALUES ('2', '马化腾', '腾讯', '3243', null);
INSERT INTO `bringtakeinfo` VALUES ('3', '马云', '阿里巴巴', '345', null);
INSERT INTO `bringtakeinfo` VALUES ('4', '任正非', '华为', null, null);

-- ----------------------------
-- Table structure for `cargoinfo`
-- ----------------------------
DROP TABLE IF EXISTS `cargoinfo`;
CREATE TABLE `cargoinfo` (
  `id` int(11) NOT NULL auto_increment,
  `cargoname` varchar(64) NOT NULL COMMENT '货物名称',
  `org` varchar(128) default NULL COMMENT '单位',
  `irradtype` varchar(32) default NULL COMMENT '辐照方式',
  `irradtime` datetime default NULL COMMENT '辐照时间',
  `timeorg` varchar(32) default NULL COMMENT '时间单位',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `cargoname` (`cargoname`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='货物信息表';

-- ----------------------------
-- Records of cargoinfo
-- ----------------------------
INSERT INTO `cargoinfo` VALUES ('1', '带鱼', '条', '无', '2015-07-21 00:00:00', '90');
INSERT INTO `cargoinfo` VALUES ('2', '芹菜', '斤', '无', '2015-07-21 13:35:38', '0');
INSERT INTO `cargoinfo` VALUES ('3', '土豆', '斤', '无', '2015-07-21 13:36:03', '0');
INSERT INTO `cargoinfo` VALUES ('4', '香蕉', '斤', '无', '2015-07-21 13:36:39', '0');
INSERT INTO `cargoinfo` VALUES ('5', '西瓜', '斤', '无', '2015-07-21 13:37:02', '0');
INSERT INTO `cargoinfo` VALUES ('6', '西红柿', '斤', '无', '2015-07-22 16:43:02', '0');
INSERT INTO `cargoinfo` VALUES ('7', '地瓜', '斤', '无', '2015-07-22 16:43:22', '0');
INSERT INTO `cargoinfo` VALUES ('8', '黄瓜', '斤', '无', '2015-07-22 16:43:43', '0');
INSERT INTO `cargoinfo` VALUES ('9', '韭菜', '斤', '无', '2015-07-22 16:44:13', '0');
INSERT INTO `cargoinfo` VALUES ('10', '苹果', '斤', '无', '2015-07-22 16:44:32', '0');
INSERT INTO `cargoinfo` VALUES ('11', '豆角', '斤', '无', '2015-07-22 16:44:56', '0');
INSERT INTO `cargoinfo` VALUES ('12', '黄鱼', '斤', '无', '2015-07-22 16:45:51', '0');
INSERT INTO `cargoinfo` VALUES ('13', '海带', '斤', '无', '2015-07-22 16:46:08', '0');
INSERT INTO `cargoinfo` VALUES ('14', '鲶鱼', '斤', '无', '2015-07-22 16:46:31', '0');
INSERT INTO `cargoinfo` VALUES ('15', '猪肉', '斤', '无', '2015-07-22 16:46:55', '0');
INSERT INTO `cargoinfo` VALUES ('16', '豆腐', '斤', '无', '2015-07-22 16:47:12', '0');
INSERT INTO `cargoinfo` VALUES ('17', '蘑菇', '斤', '无', '2015-07-22 16:47:31', '0');
INSERT INTO `cargoinfo` VALUES ('18', '鲅鱼', '斤', '无', '2015-07-22 16:47:47', '0');
INSERT INTO `cargoinfo` VALUES ('19', '金针菇', '斤', '无', '2015-07-22 16:48:07', '0');
INSERT INTO `cargoinfo` VALUES ('20', '鸡蛋', '斤', '无', '2015-07-22 16:48:30', '0');
INSERT INTO `cargoinfo` VALUES ('21', '火烧', '斤', '无', '2015-07-22 16:48:50', '0');
INSERT INTO `cargoinfo` VALUES ('22', '馒头', '斤', '无', '2015-07-22 16:49:04', '0');
INSERT INTO `cargoinfo` VALUES ('23', '榴莲', '斤', '无', '2015-07-22 16:49:26', '0');
INSERT INTO `cargoinfo` VALUES ('24', 'name', 'org', 'itypr', '2015-07-23 11:15:42', 'timeorg');
INSERT INTO `cargoinfo` VALUES ('26', 'edit', 'oddrg', '', '0000-00-00 00:00:00', '');
INSERT INTO `cargoinfo` VALUES ('27', '王二麻子', '诸城', '辐射', '2015-07-24 00:00:00', '小时/个');
INSERT INTO `cargoinfo` VALUES ('28', '旮旯', 'Google', '静态辐射', '2015-09-06 00:00:00', '8');
INSERT INTO `cargoinfo` VALUES ('29', '水电费', '水电费', '水电费', '2015-09-09 00:00:00', '34');

-- ----------------------------
-- Table structure for `chargelog`
-- ----------------------------
DROP TABLE IF EXISTS `chargelog`;
CREATE TABLE `chargelog` (
  `id` int(11) NOT NULL auto_increment,
  `chargeid` int(11) NOT NULL COMMENT '对receivemgrdetail表的那条记录收的款',
  `chargeorg` varchar(128) default NULL COMMENT '交款单位',
  `chargetime` datetime default NULL COMMENT '交款日期',
  `chargeamount` double default NULL COMMENT '交款金额',
  `receivetime` datetime NOT NULL COMMENT '收货日期',
  `cargoname` varchar(128) default NULL COMMENT '货物名称',
  `cargocount` varchar(128) default NULL COMMENT '货物数量',
  `cargoweight` varchar(128) default NULL COMMENT '货物重量',
  `fee` double default NULL COMMENT '费用',
  `paid` double default NULL COMMENT '已付',
  `unpaid` double default NULL COMMENT '未付',
  `mask` varchar(255) default NULL COMMENT '收费说明',
  `operater` varchar(128) default NULL COMMENT '操作员',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='收款记录表';

-- ----------------------------
-- Records of chargelog
-- ----------------------------
INSERT INTO `chargelog` VALUES ('1', '40', '阿里巴巴', '2015-09-11 15:25:00', '5', '2015-09-09 00:00:00', '金针菇', '150', '250', '100', '5', '95', '阿里巴巴第一次收费', null);
INSERT INTO `chargelog` VALUES ('2', '40', '阿里巴巴', '2015-09-11 15:25:59', '1', '2015-09-09 00:00:00', '金针菇', '150', '250', '100', '6', '94', '阿里巴巴第二次收费', null);
INSERT INTO `chargelog` VALUES ('3', '40', '阿里巴巴', '2015-09-11 15:32:59', '94', '2015-09-09 00:00:00', '金针菇', '150', '250', '100', '100', '0', '阿里巴巴第二次收费', null);
INSERT INTO `chargelog` VALUES ('4', '32', '华为', '2015-09-13 12:49:28', '90', '2015-08-29 00:00:00', '带鱼', '23', '45', '100', '90', '10', '百度收费', null);
INSERT INTO `chargelog` VALUES ('5', '30', '百度', '2015-09-13 12:51:14', '50', '2015-08-14 00:00:00', '豆角', '7868', '345', '100', '50', '50', '百度收费', null);
INSERT INTO `chargelog` VALUES ('6', '39', '阿里巴巴', '2015-09-16 16:57:05', '20', '2015-09-09 00:00:00', '蘑菇', '100', '200', '100', '20', '80', '阿里巴巴马云', 'admin');

-- ----------------------------
-- Table structure for `dict_group`
-- ----------------------------
DROP TABLE IF EXISTS `dict_group`;
CREATE TABLE `dict_group` (
  `groupid` varchar(128) NOT NULL COMMENT '分组编号',
  `groupname` varchar(256) NOT NULL COMMENT '分组名称',
  UNIQUE KEY `groupid` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典组表基表';

-- ----------------------------
-- Records of dict_group
-- ----------------------------
INSERT INTO `dict_group` VALUES ('allmenu', '所有菜单');
INSERT INTO `dict_group` VALUES ('irradflags', '辐照类型');
INSERT INTO `dict_group` VALUES ('irradtypes', '辐照方式');
INSERT INTO `dict_group` VALUES ('loadmodel', '辐照装载模式');
INSERT INTO `dict_group` VALUES ('timeorgs', '时间单位');

-- ----------------------------
-- Table structure for `dict_item`
-- ----------------------------
DROP TABLE IF EXISTS `dict_item`;
CREATE TABLE `dict_item` (
  `itemid` varchar(128) default NULL COMMENT '项目编号',
  `groupid` varchar(128) default NULL COMMENT '分组编号',
  `itemname` varchar(256) default NULL COMMENT '项目名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典组表项目表';

-- ----------------------------
-- Records of dict_item
-- ----------------------------
INSERT INTO `dict_item` VALUES ('staticirrad', 'irradtypes', '静态辐射');
INSERT INTO `dict_item` VALUES ('dnyirrad', 'irradtypes', '动态辐射');
INSERT INTO `dict_item` VALUES ('hour', 'timeorgs', '时');
INSERT INTO `dict_item` VALUES ('minute', 'timeorgs', '分');
INSERT INTO `dict_item` VALUES ('firstirrad', 'irradflags', '首次辐射');
INSERT INTO `dict_item` VALUES ('secondirrad', 'irradflags', '重新辐射');
INSERT INTO `dict_item` VALUES ('noirrad', 'irradflags', '不辐射');
INSERT INTO `dict_item` VALUES ('fullload', 'loadmodel', '满载');
INSERT INTO `dict_item` VALUES ('maximum', 'loadmodel', '最大值');
INSERT INTO `dict_item` VALUES ('2', 'allmenu', '货物信息');
INSERT INTO `dict_item` VALUES ('3', 'allmenu', '送货信息');
INSERT INTO `dict_item` VALUES ('4', 'allmenu', '送取货人');
INSERT INTO `dict_item` VALUES ('5', 'allmenu', '单位信息');
INSERT INTO `dict_item` VALUES ('7', 'allmenu', '收货管理');
INSERT INTO `dict_item` VALUES ('8', 'allmenu', '收货确认');
INSERT INTO `dict_item` VALUES ('9', 'allmenu', '辐照管理');
INSERT INTO `dict_item` VALUES ('10', 'allmenu', '出货管理');
INSERT INTO `dict_item` VALUES ('12', 'allmenu', '权限配置');
INSERT INTO `dict_item` VALUES ('15', 'allmenu', '收款');
INSERT INTO `dict_item` VALUES ('17', 'allmenu', '日报表');
INSERT INTO `dict_item` VALUES ('18', 'allmenu', '月报表');

-- ----------------------------
-- Table structure for `irradiation`
-- ----------------------------
DROP TABLE IF EXISTS `irradiation`;
CREATE TABLE `irradiation` (
  `id` int(11) NOT NULL auto_increment,
  `detailid` int(11) default NULL COMMENT '货物详情的主键',
  `baseid` int(11) default NULL COMMENT '货物基本信息表的主键',
  `receiveorgid` varchar(64) default NULL COMMENT '送货单位',
  `cargoname` varchar(64) default NULL COMMENT '货物名称',
  `irradednum` int(11) default NULL COMMENT '辐照数量',
  `countorg` varchar(64) default NULL COMMENT '数量单位',
  `cargoweight` varchar(64) default NULL COMMENT '货物重量',
  `irradtype` varchar(64) default NULL COMMENT '辐照类型',
  `irradtime` varchar(64) default NULL COMMENT '辐照时间',
  `timeorg` varchar(64) default NULL COMMENT '时间单位',
  `doirraddate` date default NULL COMMENT '辐照日期',
  `starttime` datetime default NULL COMMENT '开始时间',
  `position` varchar(64) default NULL COMMENT '吊具号码',
  `takecargocount` varchar(32) default NULL COMMENT '已取货数量',
  `status` varchar(1) default NULL COMMENT '状态',
  `mask` varchar(64) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of irradiation
-- ----------------------------
INSERT INTO `irradiation` VALUES ('1', '25', '17', '1', '黄瓜', '6', '1', '234', 'staticirrad', '64', 'hour', '2015-09-01', '2015-09-01 00:00:00', '', '0', '1', '');
INSERT INTO `irradiation` VALUES ('2', '34', '22', '1', '带鱼', '1234', '3', '123', 'dnyirrad', '123', 'minute', '2015-09-01', '2015-09-01 00:00:00', '4554', '1234', '1', '');
INSERT INTO `irradiation` VALUES ('3', '37', '24', '1', '芹菜', '7', '3', '45', 'staticirrad', '45', 'minute', '2015-09-01', '2015-09-01 00:00:00', '12', '7', '1', '');
INSERT INTO `irradiation` VALUES ('4', '37', '24', '1', '芹菜', '60', '1', '45', 'staticirrad', '45', 'hour', '2015-09-01', '2015-09-01 00:00:00', '98', '0', '0', '');
INSERT INTO `irradiation` VALUES ('5', '36', '24', '1', '带鱼', '34', '1', '53', 'staticirrad', '56', 'hour', '2015-09-01', '2015-09-01 00:00:00', '66', '9', '1', '');
INSERT INTO `irradiation` VALUES ('6', '39', '26', '3', '蘑菇', '50', '2', '200', 'dnyirrad', '6', 'hour', '2015-09-09', '2015-09-09 00:00:00', '1', '0', '1', '');
INSERT INTO `irradiation` VALUES ('7', '39', '26', '3', '蘑菇', '50', '2', '200', 'dnyirrad', '6', 'hour', '2015-09-09', '2015-09-09 00:00:00', '2', '49', '1', '');
INSERT INTO `irradiation` VALUES ('8', '26', '17', '1', '鲶鱼', '23', '1', '67843', 'dnyirrad', '789', 'hour', '2015-09-12', '2015-09-12 00:00:00', '999', '0', '0', '');
INSERT INTO `irradiation` VALUES ('9', '40', '26', '3', '金针菇', '150', '3', '250', 'dnyirrad', '6', 'minute', '2015-09-12', '2015-09-12 00:00:00', '7', '0', '1', '');
INSERT INTO `irradiation` VALUES ('10', '29', '19', '3', '芹菜', '6', '3', '10', 'dnyirrad', '453', 'minute', '2015-09-19', '2015-09-19 00:00:00', '80', '0', '0', '');
INSERT INTO `irradiation` VALUES ('11', '45', '30', '3', '西瓜', '10', '4', '456', 'staticirrad', '456', 'hour', '2015-09-21', '2015-09-21 00:00:00', '7', '10', '1', '');

-- ----------------------------
-- Table structure for `orginfo`
-- ----------------------------
DROP TABLE IF EXISTS `orginfo`;
CREATE TABLE `orginfo` (
  `id` int(11) NOT NULL auto_increment,
  `orgname` varchar(64) NOT NULL COMMENT '计数单位名称',
  `mask` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `orgname` (`orgname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='单位信息';

-- ----------------------------
-- Records of orginfo
-- ----------------------------
INSERT INTO `orginfo` VALUES ('1', '个', null);
INSERT INTO `orginfo` VALUES ('2', '斤', null);
INSERT INTO `orginfo` VALUES ('3', '升', null);
INSERT INTO `orginfo` VALUES ('4', '吨', null);

-- ----------------------------
-- Table structure for `product_chart`
-- ----------------------------
DROP TABLE IF EXISTS `product_chart`;
CREATE TABLE `product_chart` (
  `itemid` varchar(64) NOT NULL COMMENT '特性参数的key',
  `itemvalue` varchar(255) default NULL COMMENT '特性参数的value',
  UNIQUE KEY `itemid` (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='特性参数表';

-- ----------------------------
-- Records of product_chart
-- ----------------------------
INSERT INTO `product_chart` VALUES ('checkRepeatOfsaveReceive', '1');
INSERT INTO `product_chart` VALUES ('NOPRINTPICTUREDEFAULT', 'yangmi.jpg');
INSERT INTO `product_chart` VALUES ('PRINTPICTURESAVEDIR', 'E:/Amusement/新建文件夹 (7)/');

-- ----------------------------
-- Table structure for `product_resources`
-- ----------------------------
DROP TABLE IF EXISTS `product_resources`;
CREATE TABLE `product_resources` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `parentId` int(11) default NULL,
  `resKey` varchar(50) default NULL,
  `type` varchar(40) default NULL,
  `resUrl` varchar(200) default NULL,
  `level` int(4) default NULL,
  `icon` varchar(100) default NULL,
  `ishide` int(3) default '0',
  `description` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_resources
-- ----------------------------
INSERT INTO `product_resources` VALUES ('1', '系统基础管理', '0', 'system', '0', '/system/', '1', 'fa-desktop', '0', '系统基础管理');
INSERT INTO `product_resources` VALUES ('2', '货物信息', '1', 'cargoinfo', '1', '/system/cargoinfo.do?pageNow=0&pageSize=20', '2', null, '0', '货物信息');
INSERT INTO `product_resources` VALUES ('3', '送货信息', '1', 'shippinginfo', '1', '/system/shippinginfo.do', '7', 'fa-list', '0', '送货信息');
INSERT INTO `product_resources` VALUES ('4', '送取货人', '1', 'bringtakeinfo', '1', '/system/bringtakeinfo.do', null, null, '0', '送取货人');
INSERT INTO `product_resources` VALUES ('5', '单位信息', '1', 'orginfo', '1', '/system/orginfo.do', '12', 'fa-list-alt', '0', '单位信息');
INSERT INTO `product_resources` VALUES ('6', '业务管理', '0', 'businessmana', '1', '/business/', null, null, '0', '业务管理');
INSERT INTO `product_resources` VALUES ('7', '收货管理', '6', 'receivingmana', '1', '/business/receivingmana.do', null, null, '0', '收货管理');
INSERT INTO `product_resources` VALUES ('8', '收货确认', '6', 'confirmation', '1', '/business/confirmation.do', null, null, '0', '收货确认');
INSERT INTO `product_resources` VALUES ('9', '辐照管理', '6', 'irradiationmana', '1', '/business/Irradiationmana.do', null, null, '0', '辐照管理');
INSERT INTO `product_resources` VALUES ('10', '出货管理', '6', 'shippingmana', '1', '/business/shoppingmana.do', null, null, '0', '出货管理');
INSERT INTO `product_resources` VALUES ('11', '权限管理', '0', 'privilegemana', '1', '/privilegemana/', null, null, '0', '权限管理');
INSERT INTO `product_resources` VALUES ('12', '权限配置', '11', 'privilegeconfig', '1', '/privilegemana/configuration.do', null, null, '0', '权限配置');
INSERT INTO `product_resources` VALUES ('14', '收款管理', '0', 'collectionmana', '1', '/collection/', null, null, '0', '收款管理');
INSERT INTO `product_resources` VALUES ('15', '收款', '14', 'collectioninit', '1', '/collection/init.do', null, null, '0', '收款');
INSERT INTO `product_resources` VALUES ('16', '报表管理', '0', 'report', '1', '/report/', null, null, '0', '报表管理');
INSERT INTO `product_resources` VALUES ('17', '日报表', '16', 'dayreport', '1', '/report/dayreport.do', null, null, '0', '日报表');
INSERT INTO `product_resources` VALUES ('18', '月报表', '16', 'monthreport', '1', '/report/monthreport.do', null, null, '0', '月报表');

-- ----------------------------
-- Table structure for `receivemgrbase`
-- ----------------------------
DROP TABLE IF EXISTS `receivemgrbase`;
CREATE TABLE `receivemgrbase` (
  `id` int(11) NOT NULL auto_increment,
  `receivetime` datetime NOT NULL COMMENT '收货日期',
  `receiveorgid` varchar(64) NOT NULL COMMENT '送货单位 shippinginfo：orgname',
  `receivepeopleid` varchar(32) NOT NULL COMMENT '送货人 bringtakeinfo：name',
  `telnum` varchar(16) NOT NULL COMMENT '联系电话',
  `status` varchar(1) default NULL COMMENT '是否指纹确认 0:未指纹确认，1:已指纹确认',
  `userid` varchar(32) default NULL COMMENT '操作员编号',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='收货管理基本信息表';

-- ----------------------------
-- Records of receivemgrbase
-- ----------------------------
INSERT INTO `receivemgrbase` VALUES ('13', '2015-08-26 00:00:00', '1', '1', '234', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('14', '2015-08-26 00:00:00', '2', '1', '345', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('15', '2015-08-26 00:00:00', '2', '1', '2342', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('16', '2015-08-26 00:00:00', '', '4', '111111', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('17', '2015-08-26 00:00:00', '1', '3', '345', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('18', '2015-08-27 00:00:00', '3', '3', '34253', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('19', '2015-09-19 00:00:00', '3', '3', '12345678', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('20', '2015-08-14 00:00:00', '2', '1', '456', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('21', '2015-08-29 00:00:00', '1', '4', '34252', '1', 'admin');
INSERT INTO `receivemgrbase` VALUES ('22', '2015-08-31 00:00:00', '1', '1', '123', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('23', '2015-08-31 00:00:00', '1', '1', '123', '1', 'admin');
INSERT INTO `receivemgrbase` VALUES ('24', '2015-09-01 00:00:00', '1', '1', '234', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('26', '2015-09-09 00:00:00', '3', '3', '18765831631', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('27', '2015-09-19 00:00:00', '', '3', '999999', '2', 'admin');
INSERT INTO `receivemgrbase` VALUES ('28', '2015-09-20 00:00:00', '2', '1', '09809890', '0', 'admin');
INSERT INTO `receivemgrbase` VALUES ('29', '2015-09-20 00:00:00', '1', '4', '56567', '1', 'admin');
INSERT INTO `receivemgrbase` VALUES ('30', '2015-09-21 00:00:00', '3', '3', '345', '2', 'admin');

-- ----------------------------
-- Table structure for `receivemgrdetail`
-- ----------------------------
DROP TABLE IF EXISTS `receivemgrdetail`;
CREATE TABLE `receivemgrdetail` (
  `id` int(11) NOT NULL auto_increment,
  `receivemgrid` int(11) default NULL COMMENT '收获管理基本信息id ReceiveMgrBase：id',
  `cargoid` varchar(64) default NULL COMMENT '货物名称 cargoinfo：id',
  `cargocount` varchar(32) default NULL COMMENT '货物数量',
  `countorg` varchar(64) default NULL COMMENT '数量单位 orginfo：orgname',
  `cargoweight` varchar(32) default NULL COMMENT '货物重量(吨)',
  `funguscount` varchar(32) default NULL COMMENT '含菌数',
  `reqreagent` varchar(32) default NULL COMMENT '要求剂量(kgy)',
  `irradtype` varchar(32) default NULL COMMENT '辐照方式 cargoinfo：irradtype',
  `irradtime` varchar(32) default NULL COMMENT '辐照时间',
  `irradtimeorg` varchar(32) default NULL COMMENT '辐照时间单位',
  `irradflag` varchar(32) default NULL COMMENT ' 辐照类型：首次辐照、重新辐照、不辐照',
  `mask` varchar(255) default NULL,
  `irradednum` int(11) default NULL COMMENT '已照数量',
  `status` varchar(1) default NULL COMMENT '状态',
  `fee` double default '0' COMMENT '货物费用',
  `paid` double NOT NULL default '0' COMMENT '已付费用',
  `unpaid` double NOT NULL default '0' COMMENT '未付费用,默认是fee的值',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='收货管理基本信息表的子表-存储详细信息';

-- ----------------------------
-- Records of receivemgrdetail
-- ----------------------------
INSERT INTO `receivemgrdetail` VALUES ('20', '13', '7', '234', '1', '234', '789', '345345', 'staticirrad', '234', 'hour', 'firstirrad', '', '235', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('21', '13', '2', '567556', '1', '567', '675', '755', 'staticirrad', '67', 'hour', 'firstirrad', null, '567556', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('22', '14', '1', '345', '1', '3457', '7', '345', 'staticirrad', '5675675', 'hour', 'firstirrad', null, '345', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('23', '15', '3', '4234', '1', '345', '345', '234', 'staticirrad', '345', 'hour', 'firstirrad', null, '4234', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('24', '16', '12', '34', '1', '345', '345tg', '34', 'staticirrad', '345', 'hour', 'firstirrad', '', '0', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('25', '17', '8', '6', '1', '234', '234', '234', 'staticirrad', '64', 'hour', 'firstirrad', null, '6', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('26', '17', '14', '23', '1', '67843', '234', '234', 'staticirrad', '789', 'hour', 'firstirrad', null, '23', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('27', '18', '3', '234', '3', '234', '234', '234', 'dnyirrad', '234', 'minute', 'secondirrad', null, '234', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('28', '19', '1', '234467', '3', '353', '23456', '56234', 'dnyirrad', '5345', 'minute', 'secondirrad', '', '0', '2', '99', '0', '99');
INSERT INTO `receivemgrdetail` VALUES ('29', '19', '2', '76', '3', '32', '12', '1321', 'dnyirrad', '453', 'minute', 'secondirrad', null, '6', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('30', '20', '11', '7868', '3', '345', '345', '13', 'dnyirrad', '24', 'minute', 'noirrad', 'hah ', '0', '2', '100', '50', '100');
INSERT INTO `receivemgrdetail` VALUES ('31', '20', '10', '23', '4', '45', '456', '456', 'staticirrad', '345', 'minute', 'firstirrad', null, '0', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('32', '21', '1', '23', '3', '45', '45', '45', 'dnyirrad', '456', 'minute', 'firstirrad', null, '0', '1', '100', '90', '10');
INSERT INTO `receivemgrdetail` VALUES ('33', '21', '8', '65', '4', '5', '543', '23', 'staticirrad', '45', 'hour', 'secondirrad', null, '0', '1', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('34', '22', '1', '1234', '1', '123', '123', '1', 'staticirrad', '123', 'hour', 'firstirrad', null, '1234', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('35', '23', '1', '23', '1', '234', '234', '234', 'staticirrad', '234', 'hour', 'firstirrad', null, '0', '1', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('36', '24', '1', '234', '1', '53', '23', '23', 'staticirrad', '56', 'hour', 'firstirrad', null, '34', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('37', '24', '2', '567', '1', '45', '45', '45', 'staticirrad', '45', 'hour', 'firstirrad', null, '60', '2', '100', '0', '100');
INSERT INTO `receivemgrdetail` VALUES ('39', '26', '17', '100', '2', '200', '600', '20', 'dnyirrad', '6', 'hour', 'firstirrad', null, '100', '2', '100', '20', '80');
INSERT INTO `receivemgrdetail` VALUES ('40', '26', '19', '150', '2', '250', '50', '40', 'dnyirrad', '6', 'hour', 'firstirrad', null, '150', '2', '100', '100', '0');
INSERT INTO `receivemgrdetail` VALUES ('41', '27', '14', '456', '2', '34', '453', '5', 'dnyirrad', '5', 'minute', 'secondirrad', null, '0', '2', '0', '0', '0');
INSERT INTO `receivemgrdetail` VALUES ('42', '28', '14', '70', '4', '34', '65', '34', 'dnyirrad', '56', 'minute', 'secondirrad', null, '0', '0', '0', '0', '0');
INSERT INTO `receivemgrdetail` VALUES ('43', '29', '18', '45', '3', '45', '7', '3', 'dnyirrad', '46', 'minute', 'noirrad', null, '0', '1', '0', '0', '0');
INSERT INTO `receivemgrdetail` VALUES ('44', '30', '1', '65', '2', '456', '4567', '65', 'dnyirrad', '456', 'minute', 'noirrad', null, '0', '2', '0', '0', '0');
INSERT INTO `receivemgrdetail` VALUES ('45', '30', '5', '35', '4', '456', '6', '35', 'staticirrad', '456', 'hour', 'secondirrad', null, '10', '2', '0', '0', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) default NULL COMMENT '角色id',
  `rolename` varchar(64) default NULL COMMENT '角色名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('2', '值班员');

-- ----------------------------
-- Table structure for `shippinginfo`
-- ----------------------------
DROP TABLE IF EXISTS `shippinginfo`;
CREATE TABLE `shippinginfo` (
  `id` int(11) NOT NULL auto_increment,
  `orgname` varchar(64) NOT NULL COMMENT '单位名称',
  `mask` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `orgname` (`orgname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='送货信息';

-- ----------------------------
-- Records of shippinginfo
-- ----------------------------
INSERT INTO `shippinginfo` VALUES ('1', '华为', '华为公司');
INSERT INTO `shippinginfo` VALUES ('2', '百度', '北京百度');
INSERT INTO `shippinginfo` VALUES ('3', '阿里巴巴', '杭州阿里巴巴');

-- ----------------------------
-- Table structure for `takecargobase`
-- ----------------------------
DROP TABLE IF EXISTS `takecargobase`;
CREATE TABLE `takecargobase` (
  `id` int(11) NOT NULL auto_increment,
  `taketime` datetime NOT NULL COMMENT '出获日期',
  `takecargoorg` varchar(64) default NULL COMMENT '取货单位',
  `proxyorg` varchar(64) default NULL COMMENT '委托单位',
  `takecargopeople` varchar(64) default NULL COMMENT '取货人',
  `telnum` varchar(64) default NULL COMMENT '联系电话',
  `shippers` varchar(64) default NULL COMMENT '发货人',
  `status` varchar(1) default '0' COMMENT '状态0:初始状态，即刚添加：1：已出货',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='出货信息表基表';

-- ----------------------------
-- Records of takecargobase
-- ----------------------------
INSERT INTO `takecargobase` VALUES ('5', '2015-08-26 00:00:00', '1', '华为子公司', '4', '234', '234', '1');
INSERT INTO `takecargobase` VALUES ('6', '2015-08-26 00:00:00', '2', '百度', '1', '234', '345', '0');
INSERT INTO `takecargobase` VALUES ('7', '2015-09-01 00:00:00', '1', '华为深圳', '4', '345', '战三', '0');
INSERT INTO `takecargobase` VALUES ('8', '2015-09-01 00:00:00', '2', '山东分部', '1', '564', '李四', '0');
INSERT INTO `takecargobase` VALUES ('9', '2015-09-01 00:00:00', '2', '北京总部', '1', '45', '李四', '0');
INSERT INTO `takecargobase` VALUES ('10', '2015-09-08 00:00:00', '1', '子公司', '4', '3453634', '张三', '0');
INSERT INTO `takecargobase` VALUES ('11', '2015-09-09 00:00:00', '1', '华为子公司', '4', '123', '王五', '0');
INSERT INTO `takecargobase` VALUES ('12', '2015-09-09 00:00:00', '3', '杭州', '3', '18765831631', '李四', '0');
INSERT INTO `takecargobase` VALUES ('13', '2015-09-16 00:00:00', '1', '华为山东', '4', '190', '任正非', '1');
INSERT INTO `takecargobase` VALUES ('14', '2015-09-21 00:00:00', '3', '阿里巴巴山东', '3', '456456', '马云秘书', '1');

-- ----------------------------
-- Table structure for `takecargodetail`
-- ----------------------------
DROP TABLE IF EXISTS `takecargodetail`;
CREATE TABLE `takecargodetail` (
  `id` int(11) NOT NULL auto_increment,
  `baseid` int(11) NOT NULL COMMENT '基本信息表Id',
  `cargoname` varchar(64) default NULL COMMENT '货物名称',
  `cargocount` varchar(64) default NULL COMMENT '货物数量',
  `countorg` varchar(64) default NULL COMMENT '数量单位',
  `weight` varchar(64) default NULL COMMENT '重量单位(吨)',
  `irradedid` int(11) NOT NULL default '0' COMMENT '辐照货物Id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='出货信心附表';

-- ----------------------------
-- Records of takecargodetail
-- ----------------------------
INSERT INTO `takecargodetail` VALUES ('7', '5', '地瓜', '234', '1', '234', '0');
INSERT INTO `takecargodetail` VALUES ('8', '5', '芹菜', '567556', '1', '567', '0');
INSERT INTO `takecargodetail` VALUES ('9', '6', '带鱼', '345', '1', '3457', '0');
INSERT INTO `takecargodetail` VALUES ('10', '6', '带鱼', '345', '1', '3457', '0');
INSERT INTO `takecargodetail` VALUES ('11', '7', '带鱼', '', '3', '123', '0');
INSERT INTO `takecargodetail` VALUES ('12', '8', '带鱼', '3', '3', '123', '0');
INSERT INTO `takecargodetail` VALUES ('13', '9', '带鱼', '1231', '3', '123', '0');
INSERT INTO `takecargodetail` VALUES ('14', '10', '带鱼', '9', '1', '53', '5');
INSERT INTO `takecargodetail` VALUES ('15', '11', '芹菜', '2', '3', '45', '3');
INSERT INTO `takecargodetail` VALUES ('16', '11', '芹菜', '2', '3', '45', '3');
INSERT INTO `takecargodetail` VALUES ('17', '12', '蘑菇', '25', '2', '200', '7');
INSERT INTO `takecargodetail` VALUES ('18', '12', '蘑菇', '24', '2', '200', '7');
INSERT INTO `takecargodetail` VALUES ('19', '13', '芹菜', '3', '3', '45', '3');
INSERT INTO `takecargodetail` VALUES ('20', '14', '西瓜', '10', '4', '456', '11');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(32) NOT NULL,
  `userName` varchar(128) NOT NULL,
  `userPassword` varchar(128) NOT NULL,
  `roleid` int(11) NOT NULL,
  `menuids` varchar(128) default NULL,
  UNIQUE KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin', 'admin', '1', '2,3,4,5,7,8,9,10,12,15,17,18');
INSERT INTO `user` VALUES ('root', 'root', 'admin', '2', '2,3,4,5,7,18');
INSERT INTO `user` VALUES ('sir', 'sir', '123456', '1', '7,8,9,10');
