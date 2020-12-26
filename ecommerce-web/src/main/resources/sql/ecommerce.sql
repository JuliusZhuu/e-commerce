/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.105_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 192.168.1.105:3306
 Source Schema         : ecommerce

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 26/12/2020 10:16:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '连接',
  `imageUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `enabled` int(0) NULL DEFAULT NULL COMMENT '是否开启该活动',
  `endTime` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (1, '合作 谁是你的菜', NULL, 'http://192.168.1.105/eecommerce/images/31da695c84cabd0eaff054265da29e5c.jpg', '合作 谁是你的菜', 1, NULL);
INSERT INTO `banner` VALUES (2, '活动 美食节', '', 'http://192.168.1.105/eecommerce/images/baea18aa59217cabd190b19fc1cf1617.jpg', '活动 美食节', 0, NULL);
INSERT INTO `banner` VALUES (3, '活动 母亲节', NULL, 'http://192.168.1.105/eecommerce/images/d5683f01e132851229be21c52d808b62.jpg', '活动 母亲节', 0, NULL);
INSERT INTO `banner` VALUES (4, '活动 母亲节', NULL, 'http://192.168.1.105/eecommerce/images/af7d906e174cb160ab5a979310aa223d.jpg', '活动 母亲节', 0, NULL);

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `simpleDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isShow` int(0) NULL DEFAULT NULL,
  `floorPrice` decimal(10, 2) NULL DEFAULT NULL,
  `isNew` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES (1, 'TEFAL制造商', '严选对标国际品质，致力于高品质生活好物，\r\n执着寻求优质厨房电器供应商，\r\n携手WMF、Tefal制造商，打造高品质厨', 'http://192.168.1.105/eecommerce/images/713daad73395a4f3d06f5dd07ed927d4.jpg', 1, 259.00, 0);
INSERT INTO `brand` VALUES (2, '内野制造商', '严选从世界各地挑选毛巾，最终选择了为日本内野代工的工厂，追求毛巾的柔软度与功能性。品质比肩商场几百元的毛巾', 'http://192.168.1.105/eecommerce/images/e50654982984206b54e9226e5ab7f90c.jpg', 1, 29.00, 0);
INSERT INTO `brand` VALUES (3, '膳魔师制造商', '严选深入保温行业内部，', 'http://192.168.1.105/eecommerce/images/c4ab88f475e375c5748fa13d8bf2858d.png', 1, 40.00, 0);
INSERT INTO `brand` VALUES (4, '日本KEYUCA制造商', 'KEYUCA是日本餐具及料理用具品牌，', 'http://192.168.1.105/eecommerce/images/d91db0c68c50cd109c16f0ad1427ed0b.jpg', 1, 49.00, 0);

-- ----------------------------
-- Table structure for cart_list
-- ----------------------------
DROP TABLE IF EXISTS `cart_list`;
CREATE TABLE `cart_list`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '添加的用户',
  `goodsId` int(0) NOT NULL COMMENT '商品id',
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `retailPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '折扣价',
  `marketPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '市场价',
  `goodsNumber` int(0) NULL DEFAULT NULL COMMENT '添加的数量',
  `listPicUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主图',
  `isChecked` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否被选中,1选中0未选中',
  `goodsSn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品条形码',
  `isDelete` int(0) NULL DEFAULT 0 COMMENT '是否删除,0未删除1删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  INDEX `goodsId`(`goodsId`) USING BTREE,
  INDEX `goodsName`(`goodsName`) USING BTREE,
  INDEX `listPicUrl`(`listPicUrl`) USING BTREE,
  CONSTRAINT `cart_list_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cart_list_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cart_list_ibfk_3` FOREIGN KEY (`goodsName`) REFERENCES `goods` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cart_list_ibfk_4` FOREIGN KEY (`listPicUrl`) REFERENCES `goods` (`listPicUrl`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_list
-- ----------------------------
INSERT INTO `cart_list` VALUES (1, 'julius', 1001, '日式和风懒人沙发', 599.00, 599.00, NULL, 'http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png', '0', NULL, 0);
INSERT INTO `cart_list` VALUES (3, 'julius', 1008, '日式蓬软太鼓抱枕', 29.00, NULL, 19, 'http://yanxuan.nosdn.127.net/ad953e16ad8c33b714e7af941ce8cd56.png', '0', NULL, 0);

-- ----------------------------
-- Table structure for channel
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iconUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of channel
-- ----------------------------
INSERT INTO `channel` VALUES (1, '居家', NULL, 'https://yanxuan.nosdn.127.net/4f00675caefd0d4177892ad18bfc2df6.png');
INSERT INTO `channel` VALUES (2, '餐厨', NULL, 'https://yanxuan.nosdn.127.net/4aab4598017b5749e3b63309d25e9f6b.png');
INSERT INTO `channel` VALUES (3, '配件', NULL, 'https://yanxuan.nosdn.127.net/288b0e864a24763bade8e22c0c39ff02.png');
INSERT INTO `channel` VALUES (4, '饮食', NULL, 'https://yanxuan.nosdn.127.net/93168242df456b5f7bf3c89653b3db76.png');
INSERT INTO `channel` VALUES (5, '志趣', '', 'https://yanxuan.nosdn.127.net/f0698297aaac41b778c1ea65eefb8b34.png');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `listPicUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `retailPrice` decimal(10, 2) NULL DEFAULT NULL,
  `categoryId` int(0) NULL DEFAULT NULL COMMENT '分类id',
  `brandId` int(0) NULL DEFAULT NULL COMMENT '品牌id',
  `goodsSn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条形码',
  `goodsNumber` int(0) NOT NULL COMMENT '库存',
  `goodsBrief` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简单描述',
  `goodsDesc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '细节图描述，存储多个图片的url，以;分隔',
  `isOnSale` int(0) NULL DEFAULT 1 COMMENT '是否在售,1在售0未在售',
  `addTime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `isDelete` int(0) NULL DEFAULT 0 COMMENT '是否删除,1删除,0未删除',
  `goodsUnit` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '件' COMMENT '单位,例如,件',
  `isHot` int(0) NULL DEFAULT 0 COMMENT '是否热卖,1热门0非热门',
  `goodsId` int(0) NULL DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsId`(`goodsId`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `listPicUrl`(`listPicUrl`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '日式和风懒人沙发', 'http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png', 599.00, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2020-12-25 03:15:52', NULL, '件', 0, 1001);
INSERT INTO `goods` VALUES (2, '典雅美式全棉刺绣抱枕', 'http://yanxuan.nosdn.127.net/a2045004de8a6225289376ad54317fc8.png', 59.00, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2020-12-25 03:15:54', NULL, NULL, 0, 1002);
INSERT INTO `goods` VALUES (3, '日式多功能手卷午睡枕坐垫', 'http://yanxuan.nosdn.127.net/37bc0fa3524a904ac740340fa92bd515.png', 79.00, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2020-12-25 03:15:56', NULL, NULL, 0, 1003);
INSERT INTO `goods` VALUES (4, '日式简约素色窗帘', 'http://yanxuan.nosdn.127.net/63f5da1f5363af43aa91864bf66af48e.png', 259.00, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2020-12-25 03:15:59', NULL, NULL, 0, 1004);
INSERT INTO `goods` VALUES (5, '日式素雅纯色流星纹窗帘', 'http://yanxuan.nosdn.127.net/9126151f028a8804026d530836b481cb.png', 299.00, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2020-12-25 03:16:06', NULL, NULL, 0, 1005);
INSERT INTO `goods` VALUES (6, '日式天然蔺草席三件套', 'http://yanxuan.nosdn.127.net/fabf9ac36751a2e1322135c56f1dc338.png', 299.00, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2020-12-25 03:16:08', NULL, NULL, 0, 1006);
INSERT INTO `goods` VALUES (7, '日式和风蔺草蒲团坐垫', 'http://yanxuan.nosdn.127.net/39dea35a3ea2361e4b054ee2f421af53.png', 86.00, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2020-12-25 03:16:10', NULL, NULL, 0, 1007);
INSERT INTO `goods` VALUES (8, '日式蓬软太鼓抱枕', 'http://yanxuan.nosdn.127.net/ad953e16ad8c33b714e7af941ce8cd56.png', 29.00, 1008002, 0, NULL, 1000, '萌趣太鼓造型 软糯轻柔回弹', NULL, 1, '2020-12-25 08:31:30', 0, '件', 0, 1008);

-- ----------------------------
-- Table structure for goods_attribute
-- ----------------------------
DROP TABLE IF EXISTS `goods_attribute`;
CREATE TABLE `goods_attribute`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `goodsId` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsId`(`goodsId`) USING BTREE,
  CONSTRAINT `goods_attribute_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_attribute
-- ----------------------------
INSERT INTO `goods_attribute` VALUES (1, 1008, '材质', '面料: 96% 涤纶 4%氨纶\r\n填充物：100%聚酯纤维');
INSERT INTO `goods_attribute` VALUES (2, 1008, '尺寸', '直径40cm/ 直径55cm');
INSERT INTO `goods_attribute` VALUES (3, 1008, '执行标准', 'GB/T 22843-2009');
INSERT INTO `goods_attribute` VALUES (4, 1008, '产地', '中国浙江');
INSERT INTO `goods_attribute` VALUES (5, 1008, '颜色', '天青色/ 松叶绿/ 珊瑚红/ 姜黄色/ 香芋粉/ 卡其色/ 深咖色/ 海军蓝');

-- ----------------------------
-- Table structure for goods_gallery
-- ----------------------------
DROP TABLE IF EXISTS `goods_gallery`;
CREATE TABLE `goods_gallery`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `goodsId` int(0) NOT NULL COMMENT '商品id',
  `imgUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `imgDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsId`(`goodsId`) USING BTREE,
  CONSTRAINT `goods_gallery_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息顶部轮播图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_gallery
-- ----------------------------
INSERT INTO `goods_gallery` VALUES (1, 1008, 'http://yanxuan.nosdn.127.net/6c077e6fdbb1097c530ec38f805bef96.jpg', NULL);
INSERT INTO `goods_gallery` VALUES (2, 1008, 'http://yanxuan.nosdn.127.net/18327e601ce72fce5295c3e8a4e5edb8.jpg', NULL);
INSERT INTO `goods_gallery` VALUES (3, 1008, 'http://yanxuan.nosdn.127.net/5599380c7fcccc15cb60d1e1f2f4ebca.jpg', NULL);
INSERT INTO `goods_gallery` VALUES (4, 1008, 'http://yanxuan.nosdn.127.net/aa818e0f542b19dca3dedbd82299f5d4.jpg', NULL);

-- ----------------------------
-- Table structure for goods_issue
-- ----------------------------
DROP TABLE IF EXISTS `goods_issue`;
CREATE TABLE `goods_issue`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `goodsId` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回答',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsId`(`goodsId`) USING BTREE,
  CONSTRAINT `goods_issue_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`goodsId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品常见问题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_issue
-- ----------------------------
INSERT INTO `goods_issue` VALUES (1, 1008, '购买运费如何收取?', '单笔订单金额（不含运费）满88元免邮费；不满88元，每单收取10元运费。\r\n(港澳台地区需满');
INSERT INTO `goods_issue` VALUES (2, 1008, '使用什么快递发货?', '严选默认使用顺丰快递发货（个别商品使用其他快递），配送范围覆盖全国大部分地区（港澳台地区除');
INSERT INTO `goods_issue` VALUES (3, 1008, '如何申请退货？', '1.自收到商品之日起30日内，顾客可申请无忧退货，退款将原路返还，不同的银行处理时间不同');
INSERT INTO `goods_issue` VALUES (4, 1008, '如何开具发票？', '1.如需开具普通发票，请在下单时选择“我要开发票”并填写相关信息（APP仅限2.4.0及以');

-- ----------------------------
-- Table structure for history_keyword_list
-- ----------------------------
DROP TABLE IF EXISTS `history_keyword_list`;
CREATE TABLE `history_keyword_list`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户搜索关键词表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history_keyword_list
-- ----------------------------
INSERT INTO `history_keyword_list` VALUES (1, '女式蝶边真丝内裤', NULL);
INSERT INTO `history_keyword_list` VALUES (2, '单鞋', NULL);
INSERT INTO `history_keyword_list` VALUES (3, '520元礼包抢先领', NULL);
INSERT INTO `history_keyword_list` VALUES (4, '日式', NULL);
INSERT INTO `history_keyword_list` VALUES (5, '夏凉被', NULL);

-- ----------------------------
-- Table structure for hot_keyword_list
-- ----------------------------
DROP TABLE IF EXISTS `hot_keyword_list`;
CREATE TABLE `hot_keyword_list`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isHot` int(0) NULL DEFAULT 0,
  `isDefault` int(0) NULL DEFAULT 0,
  `isShow` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '热门搜索关键词表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hot_keyword_list
-- ----------------------------
INSERT INTO `hot_keyword_list` VALUES (1, '520元礼包抢先领', 1, 1, 1);
INSERT INTO `hot_keyword_list` VALUES (2, '单鞋', 0, NULL, NULL);
INSERT INTO `hot_keyword_list` VALUES (3, '墨镜', 0, NULL, NULL);
INSERT INTO `hot_keyword_list` VALUES (4, '夏凉被', 0, NULL, NULL);
INSERT INTO `hot_keyword_list` VALUES (5, '新品上市', 0, NULL, NULL);
INSERT INTO `hot_keyword_list` VALUES (6, '日式', 0, NULL, NULL);
INSERT INTO `hot_keyword_list` VALUES (7, '母亲节', 0, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'julius', '2222');

SET FOREIGN_KEY_CHECKS = 1;
