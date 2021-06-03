/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : gwwz

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2021-03-08 12:22:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bulletin
-- ----------------------------
DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE `bulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` longtext,
  `content` longtext,
  `userId` int(11) DEFAULT NULL,
  `createTime` longtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bulletin
-- ----------------------------
INSERT INTO `bulletin` VALUES ('5', '2购物网站管理系统简介', '休闲博览会，以“一个主题、两大盛会、三个园区、四大板块”的姿态，喜迎八方来客。以“休闲——提升生活品质”为主题，与中国杭州西湖国际博览会同办，以杭州为主会场，杭州萧山区湘湖、滨江区白马湖、淳安县千岛湖为三大主园区，安排了休闲展示、休闲论坛、休闲活动和休闲体验四大板块项目，设立海宁、上虞、诸暨、德清、安吉、武义等10个分会场。', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('6', '3购物网站管理系统万人团购空调“超速度”：6小时狂销4300台', '开团10分钟，火速销出1223台空调，引来60万人次的访问……6月1日上午10点，西博商城购物城联合西博团购聚划算平台发起的“空调玩定制、万人大团购”在众人期待下正式开团，大部分消费者们在团购前已经摩拳擦掌，截至下午4时，空调总销量已经达到4300台。\r\n据线下某知名家电连锁卖场的门店负责人透露，线下大卖场的单店一天销售的空调平均数量为150台左右，最好的门店日销数量也差不多就400台左右。也就是说，聚划算6小时，卖出了线下一个大卖场10天的量，相当于线下卖场速度的28倍。\r\n6月1日，是全国空调补贴正式取消的期限，线下空调的涨价呼声一浪高过一浪。不过，西博用户显然找到了更好的“避暑”方法。\r\n \r\n“定制款空调，价格竟然这么给力”\r\n    6月1日上午，打开西博聚划算的网友小王几乎不相信自己的眼睛。“定制空调，价格竟然可以这么给力！”尽管已被告知此次活动采取“人越多越划算”的模式进行团购，但在定制款及价格公布之前，不少消费者仍然将信将疑。在消费者的既定印象中，“定制”从某种程度而言就是高价格的代名词。\r\n而随着出售台数的上涨，消费者可以返还的金额也越来越多。“我早早拍下了这款空调，看着买的人逐渐增多，非常激动，也很好玩。我的选择是正确的。”网友“one棵菜”买的是1P“萌时代”外观空调。截至四点，空调团购数额已经达到4300余台，并且这一数额仍然在持续上升。\r\n“什么是性价比？性价比就是以批发的价格，享受定制的待遇。”一位网友的话，道出了定制式团购的魅力所在。\r\n    而西博团购聚划算平台总监慧空认为，“规模化，是其中的关键所在。西博网有海量用户，将消费者的想法、意愿和需求聚合起来，通过团的越多越便宜的方式，一方面激励消费者购买，另一方面，以规模化来和企业、供应商讲价格。”\r\n \r\n6天时间，60万消费者共同定制两款空调\r\n和平时的团购不同，此次聚划算团购的两款空调，是数万名西博网友，在6天时间内以选票的形式“公投”出的定制款空调，定制范围细化到外观、功能、功率等各方面，最后以这一民意结果与奥克斯厂商实际生产承受度相结合，所敲定的最终结果。\r\n从产品页面上来看，这两款空调有1.5P、1P两个功率适用于不同面积的房间，每款空调，都有投票人气最高的两种面板可以选择。而在功能方面，内外静双音、瞬间制冷制热、干燥防霉净芯等消费者更希望的功能在这两款空调中得到实现和加强。\r\n“对于此次接到的定单，奥克斯马上进行产品生产，并在6月份内完成配送安装。”奥克斯家用空调国内营销总经理金杰告诉记者，“奥克斯有强大的研发能力，足够的原材料储备数量及生产、物流、安装等一系列后续服务。”奥克斯方面显然已经作好了充分准备，等待这一批定制购物网站的生成。\r\n而此次活动的运输将由西博物流宝支持，配送范围覆盖了全国15个省及直辖市。\r\n \r\n大家电行业新课题：用户定制化生产\r\n \r\n而对于大家电行业的业内人士而言，此次空调团购更像是一次信号：面对如今的空调市场，厂家发起的价格战正在逐渐转向了以消费者为驱动的需求细分战。\r\n大家电触网已经不是什么稀奇事。成立于2010年年初的西博商城购物城，是西博网打造的第一个行业垂直市场，同年年底单日最高销售额已超过1亿元。国内外不少家电品牌通过西博，与网购消费群体实现对接，开拓了一个新的市场。\r\n据某家电行业内资深人士透露，按照业内的平均水平，从空调的原材料采购到真正进入终端进行销售，至少要有一年的时间周期。而此次聚划算定制空调活动，对于合作厂商的综合实力，无疑提出了高到苛刻的要求。轻量级、伸缩性很强的供应商快速反应部队，随时响应规模个性化的消费需求，已经成为大家电品牌在新网购时代的一个全新课题。\r\n“当网购成为一个不可忽视社会主流消费力量，谁也无法忽略这一新兴领域带来的机会和挑战。从某种意义上说，传统线下品牌如今在线上渠道的行动和效果，决定了其未来。” 金杰这样告诉记者。\r\n\r\n', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('9', '8网店刮起“林君”风 小店一天赚2千元', '热映，陈数饰演的职场女性林君人气飙升，她所穿过的时尚女装则让网络商家嗅到商机。\r\n\r\n　　不少网店推出的“林君OL式样的小西服”热卖，陈数俨然成了“摇钱树”。\r\n\r\n　　网店沾了“林君”的光\r\n\r\n　　“陈数的吊带裙子”、“林君OL式样的小西服”……随着电视剧《夫妻那些事》热播，女主角戏中穿着的时尚女装成为网店的“揽客招牌”。东亚记者昨日登陆西博网，在搜索栏中输入“林君同款”，检索到2967件宝贝。\r\n\r\n　　据河南一家网店店主何先生介绍，如今，时尚潮流是年轻人追逐的目标，不少潮男潮女们对演员服饰乐于模仿。当《夫妻那些事》播出后，他所负责的网店便择优选择两款服饰上架预售。其中一款是黑白条纹的打底衫，一款是“林君同款”OL式样白色小西服。目前来看，市场反响较好。\r\n\r\n　　他介绍，目前他共掌管4家西博店铺，总的来看，两款服饰平均一天销量近300件。按照每件利润30元计算，平均一家西博小店每天的净利润超2000元。目前，何先生正在积极与厂家洽谈，按照林君戏中穿着的十几款戏服进行设计。3天左右就会陆续上架销售。\r\n\r\n　　与之类似，杭州店主李先生也同样沾了“林君”的光。\r\n\r\n　　李先生说，店内一款贴有“林君同款”标签的蓝色衬衫最近受到消费者青睐。此前这款衬衫是厂家设计的，朋友一句与林君戏服类似的玩笑话让他如梦初醒。于是，他在网店打出“林君同款”标签后，衬衫的销量一路上扬。\r\n\r\n　　“最多的时候一天能卖上百件，平均来看，也能卖80件左右。”他说，由于产品单一，如此的销量在同级别店家中尚处中等水平，每天的利润在1600元左右。“好一点的店铺怎么也超过2000元了。”他说。\r\n\r\n　　“与明星同款”成卖点\r\n\r\n　　事实上，明星同款饰品热卖已不是个例。\r\n\r\n　　《奋斗》里，夏琳佩戴的白色珠子手链、《男人帮》里的休闲家居服、《泡沫之夏》里的绿丝带等等至今仍在网络上热销……\r\n\r\n　　经营网店多年的小陈告诉东亚记者，明星效应在服装、饰品上向来都有较好的宣传效果。部分网店客服除了每日工作外，还要腾出更多的时间来看热播剧。一般，在影视剧未播先火的时候，有些网店已经根据剧照开始收集物件，并且联系到独立经营的服装店制作，与影视剧的火热进度赛跑。“要跟上潮流步伐，这样才能抓住商机啊。”他说。\r\n\r\n　　对此，吉林大学经济管理学院副教授丁肇勇分析，随着生活水平提高，部分年轻人乐于模仿明星穿衣打扮，这便有了市场需求；对商家而言，按照角色定制服饰可短期内生产消费者喜欢的时尚单品，这便有了供给。有供有需便形成市场。\r\n', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('10', '48购物网站管理系统简介', '休闲博览会，以“一个主题、两大盛会、三个园区、四大板块”的姿态，喜迎八方来客。以“休闲——提升生活品质”为主题，与中国杭州西湖国际博览会同办，以杭州为主会场，杭州萧山区湘湖、滨江区白马湖、淳安县千岛湖为三大主园区，安排了休闲展示、休闲论坛、休闲活动和休闲体验四大板块项目，设立海宁、上虞、诸暨、德清、安吉、武义等10个分会场。', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('19', '最新公告购物网站管理系统开通了', '最新公告购物网站管理系统开通了，最新的测试通过上线了', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('20', 'u2购物网站管理系统简介', '休闲博览会，以“一个主题、两大盛会、三个园区、四大板块”的姿态，喜迎八方来客。以“休闲——提升生活品质”为主题，与中国杭州西湖国际博览会同办，以杭州为主会场，杭州萧山区湘湖、滨江区白马湖、淳安县千岛湖为三大主园区，安排了休闲展示、休闲论坛、休闲活动和休闲体验四大板块项目，设立海宁、上虞、诸暨、德清、安吉、武义等10个分会场。', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('29', 'i购物网站管理系统简介', '休闲博览会，以“一个主题、两大盛会、三个园区、四大板块”的姿态，喜迎八方来客。以“休闲——提升生活品质”为主题，与中国杭州西湖国际博览会同办，以杭州为主会场，杭州萧山区湘湖、滨江区白马湖、淳安县千岛湖为三大主园区，安排了休闲展示、休闲论坛、休闲活动和休闲体验四大板块项目，设立海宁、上虞、诸暨、德清、安吉、武义等10个分会场。', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('30', 'p777最新公告购物网站管理系统开通了', '最新公告购物网站管理系统开通了，最新的测试通过上线了', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('41', '77748购物网站管理系统简介', '休闲博览会，以“一个主题、两大盛会、三个园区、四大板块”的姿态，喜迎八方来客。以“休闲——提升生活品质”为主题，与中国杭州西湖国际博览会同办，以杭州为主会场，杭州萧山区湘湖、滨江区白马湖、淳安县千岛湖为三大主园区，安排了休闲展示、休闲论坛、休闲活动和休闲体验四大板块项目，设立海宁、上虞、诸暨、德清、安吉、武义等10个分会场。', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('42', '9999最新公告购物网站管理系统开通了', '最新公告购物网站管理系统开通了，最新的测试通过上线了', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('43', '8888u2购物网站管理系统简介', '休闲博览会，以“一个主题、两大盛会、三个园区、四大板块”的姿态，喜迎八方来客。以“休闲——提升生活品质”为主题，与中国杭州西湖国际博览会同办，以杭州为主会场，杭州萧山区湘湖、滨江区白马湖、淳安县千岛湖为三大主园区，安排了休闲展示、休闲论坛、休闲活动和休闲体验四大板块项目，设立海宁、上虞、诸暨、德清、安吉、武义等10个分会场。', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('44', 'i8888购物网站管理系统简介', '休闲博览会，以“一个主题、两大盛会、三个园区、四大板块”的姿态，喜迎八方来客。以“休闲——提升生活品质”为主题，与中国杭州西湖国际博览会同办，以杭州为主会场，杭州萧山区湘湖、滨江区白马湖、淳安县千岛湖为三大主园区，安排了休闲展示、休闲论坛、休闲活动和休闲体验四大板块项目，设立海宁、上虞、诸暨、德清、安吉、武义等10个分会场。', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('45', 'pjjj最新公告购物网站管理系统开通了', '最新公告购物网站管理系统开通了，最新的测试通过上线了', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('46', '11111111', '1111', '1', '2021-5-5 20:00:00');
INSERT INTO `bulletin` VALUES ('50', '555', '555', '1', '2021-05-17 21:08:41');

-- ----------------------------
-- Table structure for customerdetailinfo
-- ----------------------------
DROP TABLE IF EXISTS `customerdetailinfo`;
CREATE TABLE `customerdetailinfo` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `name` longtext,
  `telphone` longtext,
  `movePhone` longtext,
  `address` longtext,
  PRIMARY KEY (`customerId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customerdetailinfo
-- ----------------------------
INSERT INTO `customerdetailinfo` VALUES ('1', '5454', '545454', '5454', '4444444');
INSERT INTO `customerdetailinfo` VALUES ('2', '小张', '13188889999', '6768855', '北京东路');
INSERT INTO `customerdetailinfo` VALUES ('3', '', '无', '无', '');
INSERT INTO `customerdetailinfo` VALUES ('4', '888', '88', '88', '8888');
INSERT INTO `customerdetailinfo` VALUES ('5', '日', '5555', '5555', '5555');
INSERT INTO `customerdetailinfo` VALUES ('6', '张天', '0109988776', '13155556666', '北京四川路1号');

-- ----------------------------
-- Table structure for customerinfo
-- ----------------------------
DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` longtext,
  `pwd` longtext,
  `registerTime` longtext,
  `isCooled` int(11) DEFAULT NULL,
  `question` longtext,
  `answer` longtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customerinfo
-- ----------------------------
INSERT INTO `customerinfo` VALUES ('1', 'fdsafsd@sfdsf.com', '111111', '2021-5-3 20:00:00', '1', null, null);
INSERT INTO `customerinfo` VALUES ('2', '123456@163.com', '111111', '2021-5-3 20:00:00', '0', null, null);
INSERT INTO `customerinfo` VALUES ('3', '111545454111@sf.com', '111111', '2021-5-3 20:00:00', '0', null, null);
INSERT INTO `customerinfo` VALUES ('4', '8888888@163.com', '111111', '2021-5-3 20:00:00', '0', '111', '111');
INSERT INTO `customerinfo` VALUES ('5', 'qwerty@163.com', '111111', '2021-5-3 20:00:00', '0', '111', '111');
INSERT INTO `customerinfo` VALUES ('6', '777@qq.com', '111111', '2021-5-3 20:00:00', '0', '111', '222');

-- ----------------------------
-- Table structure for goodsinfo
-- ----------------------------
DROP TABLE IF EXISTS `goodsinfo`;
CREATE TABLE `goodsinfo` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `typeDetailInfo` longtext,
  `goodsName` longtext,
  `price` decimal(28,0) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `isNew` int(11) DEFAULT NULL,
  `isRecommend` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `photo` longtext,
  `remark` longtext,
  `countRequire` int(11) DEFAULT NULL,
  `createdate` longtext,
  `userid` longtext,
  `isCooled` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=MyISAM AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodsinfo
-- ----------------------------
INSERT INTO `goodsinfo` VALUES ('80', '26', '购物商品1', '15', '9', '0', '0', '0', 'upload/1.jpg', '产品规格：单件尺寸26x30x11mm，两种颜色配两种造型交叉组合，挂在一个手机绳上\r\n材质:稀土长效夜光粉\r\nPVC执行标准: Q/SEHN 39-2011\r\n产品设计说明：使用中国独有战略资源稀土材料，打造独一无二的休博会吉祥物晶晶形象。作为在世博会、西园会上享誉已久的夜光系列产品，广受消费者青睐，两种活泼可爱的晶晶形象，结合白天吸收光能，夜晚发光的环保健康稀土材料，让吉祥物造型更具实用装饰价值。', '49', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('81', '28', '购物商品2', '50', '9', '1', '1', '0', 'upload/2.jpg', '产品简介：超可爱的毛绒吉祥物玩具，用料考究、做工精细、超柔的面料及优质的填充物，使你抱在怀中的感觉超好。\r\n产品规格：35cm\r\n产品材质:超柔短毛绒\r\n产品工艺：车缝，电绣。', '20', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('91', '29', '购物商品3', '180', '9', '0', '0', '0', 'upload/3.jpg', '产品简介：中国和世界其他各产茶国遍布着众多优良茶园，所产之茶种类丰富、品质高尚，千姿百态的中国六大茶类、风情万种的世界红茶、细致精巧的日本名茶、风味独特的非洲如意茶…… 依托嘉盛研茶园先进的技术手段、丰富的业界经验以及对于世界好茶的高度认知和热爱，精选部分经典好茶，引领爱好茶的人们探寻和品尝来自全世界的各具情味、风格奇异的高品位好茶叶，“好茶，好生活。” 85银色园罐，选用进口特级镀锡铁，表面特殊细磨砂处理，深拉密封，罐贴风格简洁大方，尽显经典闲雅。\r\n休博世界经典好茶（单件）：清凉世界绿茶、龙井茶、铁观音、大红袍、云南普洱、印度大吉岭红茶、白牡丹、非洲天然如意茶、88°香绿茶、日式荞麦与绿茶\r\n产品规格:（长）26×（宽）26×（高）6cm(任选4款/盒)\r\n产品工艺流程和工艺水平：本产品委托嘉盛茶业生产，选料上乘，加工设备和工艺国内一流，通过原料验收--（切碎）--选别（筛分、风选、静电选别）--人工拣杂--远红外复火（提香）--匀堆（拼配混合）--拣重金属（强力磁铁、金属探测器）--内包装--外包装--塑封打包--仓储/发货。科学检测，绿色环保，安全，安心。\r\n\r\n\r\n\r\n\r\n企业简介\r\n    浙江老茶缘茶庄成立于2003 年10 月，是中国国际茶文化研究会下属全资集体企业。与杭州嘉盛茶叶有限公司联手成立“TeaFinder研茶园世界之茶营销中心”实现“研茶园”系列产品渠道销售额200万元；公司采取谨慎稳进的经营策略，在多年连续投资铺点的情况下，依靠节约成本、精打细算和股东融资，保持了健康良好的财务状况，净利润率维持20%左右，资产负债率一直低于40%。', '10', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('92', '31', '购物商品4', '99', '10', '0', '0', '0', 'upload/4.jpg', '产品简介：利用木炭、竹炭、各种果壳和优质煤等作为原料，通过物理和化学方法对原料进行破碎、过筛、催化剂活化、漂洗、烘干和筛选等一系列工序加工制造而成。它具有物理吸附和化学吸附的双重特性，可以有选择的吸附气相、液相中的各种物质，以达到脱色精制、消毒除臭和去污提纯等目的。上面做有休博会LOGO和字样的凹凸工艺。\r\n产品材质：椰子壳活性碳\r\n产品规格：6*6cm\r\n产品包装：纸质精装加手拎袋\r\n产品工艺流程和工艺水平：利用木炭、竹炭、各种果壳和优质煤等作为原料，通过物理和化学方法对原料进行破碎、过筛、催化剂活化、漂洗、烘干和筛选等一系列工序加工制造而成。它具有物理吸附和化学吸附的双重特性，可以有选择的吸附气相、液相中的各种物质，以达到脱色精制、消毒除臭和去污提纯等目的。上面做有休博会LOGO和字样的凹凸工艺。\r\n \r\n\r\n企业简介\r\n    浙江电通是一家集开发、策划、设计、生产、销售为一体专业公司，以生产金银制品商务礼品为主。公司引进国内先进设备(200T,300T,500T,1000T,2000T,2500T)大小冲床机数台，数控车铣床，高精度液压机与六色全自动移印机，产品质量及制作工艺以达到国内外同类产品先进水平。 专业生产纯金纯银制品：纯金、纯银、彩印金、银纪念章、纯银纪念盘等一系列纯银产品及铜质纪念章、奖章、胸章等高档产品。适合于各种商务、会务、广告礼品，摆设品，装饰品，会议庆典赠品，树立公司形象推广，各种促销纪念品，重大庆典活动的首选纪念品和馈赠亲朋', '9', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('93', '29', '购物商品5', '100', '5', '0', '0', '0', 'upload/5.jpg', '产品简介：休博芬芳花茶汇集杭州及世界各地医食同源的优质保健花、草、果、瓜、种，或单品、或组合、或与茶叶配制，花草色泽鲜活，自然健康，寓意美好，养眼养心；德国进口果粒茶梦幻般的浪漫色彩悄然绽放；欧洲果花香茶诱人而丰富的滋味沁人心扉；新颖的天然风味茶，清新的、略带苦涩的、甘甜的，原汁原味，功效丰富…… 一路有她相伴，带着怡人的气息、美妙的滋味，处处跟随您的生活与心情，“休闲茶，休闲时光。”时尚纸罐采用特种环保纸料，牙白大外筒专色烫金字体，全彩修长内筒，带休博会、西博会logo的透明名条颜色鲜艳，彰显时尚休闲。\r\n休博芬芳花茶（单件）：薰衣草、桃花、芙蓉桂雨、卡米罗花草茶、亭亭玉立、玄米茶\r\n产品规格：40*9*15cm\r\n产品工艺流程和工艺水平：本产品委托嘉盛茶业生产，选料上乘，加工设备和工艺国内一流，通过原料验收--（切碎）--选别（筛分、风选、静电选别）--人工拣 杂--远红外复火（提香）--匀堆（拼配混合）--拣重金属（强力磁铁、金属探测器）--内包装--外包装--塑封打包--仓储/发货。科学检测，绿色环保，安全，安心。', '5', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('94', '28', '购物商品6', '99', '9', '1', '1', '0', 'upload/6.jpg', '产品简介：三潭印月是杭州旅游形象的代名词之一， U盘采用锌合金材质，在取材上做到简易、轻便富有现代感，中间U盘感应区设计为带光，与旅游景点的遥相呼应，很应情应景，同时对于开模要求很高，我公司有同模具的产品对于表面的光感度和精细度都能做到很好的效果\r\n产品材质：锌合金\r\n产品规格：3*6*0.8cm\r\n内存:4G\r\n产品包装：纸质精装+手拎袋，辅件为2011年杭州国际休闲博览会标识牌产品设计效果图\r\n产品工艺流程和工艺水平： U盘采用锌合金材质，在取材上做到简易、轻便富有现代感，中间U盘感应区设计为带光，与旅游景点的遥相呼应，很应情应景，同时对于开模要求很高，我公司有同模具的产品对于表面的光感度和精细度都能做到很好的效果。 ', '9', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('95', '26', '购物商品7', '99', '9', '1', '1', '0', 'upload/7.jpg', '产品简介：“三潭印月”艺术花篮 充分展示了杭州这个花园城市的风貌，花篮提手上嵌有杭州市花桂花，花篮中有宝俶山、断桥、西湖，湖中有三潭映月造型。\r\n产品材质：琉璃\r\n产品规格：13×9×9.5cm 包装尺寸：20.5×18×11.2cm\r\n产品工艺：1）雕塑原形；2）上硅胶膜；3）外层套石膏模加强固定；4）在硅胶膜中浇入树脂，凝固后取出；5）再上硅胶膜，重复步骤；6）制作蜡形；7）修蜡；8）翻制耐火石膏模；9）脱蜡；10）烧制；11）拆除耐火石膏模；12）研磨修正；13）检验作品有无断裂。', '9', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('96', '26', '购物商品8', '50', '5', '1', '1', '0', 'upload/4.jpg', '产品介绍：产品原料选用100%纯木浆纸张，使用纯植物可食用级水性墨，安全、无尘、环保，购物商品可以通过美国的FDA认证及欧洲重金属含量测试EN71，所有购物商品可放心直接与皮肤接触和使用。杭州作为旅游名城，以杭州著名景点、建筑、旅游资源、展会、特产等等杭州市代表性作为基础而设计的“M+城市名片”系列彩色纸巾，适合旅游纪念品、馈赠礼品；该系列产品图案设计赏心悦目，包装精美，适应消费者赠送的心理目的。尤其是在西湖成功申遗的今天，世界各地的游客幕名前来杭州，能带上一款具有杭州特色的餐巾纸产品用以特别的旅游手信再好不过了。\r\n规格：210mmX210mm，一箱为48条，每条为10包，每包约24克\r\n品牌：M+\r\n型号：210\r\n餐巾纸单包规格：10片\r\n餐巾纸厚度：3层\r\n纸品是否印花：印花\r\n是否含香味：无香', '5', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('98', '31', '购物商品9', '55', '5', '1', '1', '0', 'upload/3.jpg', '产品简介：时尚个性、轻巧灵便、密闭性好，款式多样。\r\n产品规格：500ml\r\n工艺描述：时尚个性、轻巧灵便、密闭性好，款式多样，不锈钢，烤漆。\r\n ', '5', '2021-5-2 20:00:00', null, '1');
INSERT INTO `goodsinfo` VALUES ('99', '26', '购物商品11', '999', '9', '1', '1', '0', 'upload/2.jpg', '购物商品介绍：古语称：“不觅仙方觅睡方”。英国大戏剧家莎士比亚也将睡眠誉为“生命筵席上的滋补品”。世界卫生组织则将“睡得香”定为衡量人体健康的标准之一。真丝睡衣不仅易干、吸湿、散热性能好，对皮肤也有一定的按摩作用，能增强表皮细胞的活力，并减少微生物在皮肤上滋生的机会，有一定的保健作用。“易好丝语”品牌系列产品设计上选择了淡雅和轻浅的色彩，既合适家庭穿着又有安目宁神的作用；材质上选择了上等天然蚕丝面料，轻薄柔软，其爽滑质感易于安然入眠。', '9', '2021-5-2 20:00:00', null, '1');
INSERT INTO `goodsinfo` VALUES ('100', '32', '购物商品12', '59', '10', '1', '1', '0', 'upload/1.jpg', '这个无图片随便来一个吧 59一个IPHONE赚了啊\r\n名称未做截短？好像有啊，我看一下字数', '500', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('101', '33', '购物商品13', '59', '10', '1', '1', '0', 'upload/7.jpg', '忘记描述是什么了', '500', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('102', '33', '购物商品14', '200', '10', '0', '0', '0', 'upload/6.jpg', '小米手机是两燕昭王求士', '499', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('103', '32', '购物商品15', '1', '1', '1', '1', '0', 'upload/5.jpg', '111111', '1', '2021-5-2 20:00:00', null, '1');
INSERT INTO `goodsinfo` VALUES ('104', '31', '购物商品16', '55', '5', '1', '1', '0', 'upload/4.jpg', '产品简介：时尚个性、轻巧灵便、密闭性好，款式多样。', null, '2021-5-2 20:00:00', null, null);
INSERT INTO `goodsinfo` VALUES ('146', '32', '购物商品17', '3600', '9.9', '0', '0', '0', 'upload/3.jpg', '我要发布一个IPAD', '98', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('147', '26', '购物商品18', '1', '1', '1', '1', '0', 'upload/2.jpg', '12121', '1', '2021-5-2 20:00:00', null, '0');
INSERT INTO `goodsinfo` VALUES ('148', '32', '购物商品19', '444', '1', '1', '1', '0', 'upload/1.jpg', '444444', '43', '2021-04-28 20:37:12', null, '0');

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` longtext,
  PRIMARY KEY (`typeId`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('16', '日用产品');
INSERT INTO `goodstype` VALUES ('17', '电子产品');
INSERT INTO `goodstype` VALUES ('21', '衣服');

-- ----------------------------
-- Table structure for goodstypedetailinfo
-- ----------------------------
DROP TABLE IF EXISTS `goodstypedetailinfo`;
CREATE TABLE `goodstypedetailinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `typeId` longtext,
  `typeDetailInfo` longtext,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstypedetailinfo
-- ----------------------------
INSERT INTO `goodstypedetailinfo` VALUES ('25', '21', '女装');
INSERT INTO `goodstypedetailinfo` VALUES ('26', '16', '平板电视');
INSERT INTO `goodstypedetailinfo` VALUES ('28', '16', '家庭影音');
INSERT INTO `goodstypedetailinfo` VALUES ('29', '16', 'OLED');
INSERT INTO `goodstypedetailinfo` VALUES ('30', '16', '超薄');
INSERT INTO `goodstypedetailinfo` VALUES ('31', '16', '曲面');
INSERT INTO `goodstypedetailinfo` VALUES ('32', '17', 'PAD');
INSERT INTO `goodstypedetailinfo` VALUES ('33', '17', '手机');
INSERT INTO `goodstypedetailinfo` VALUES ('35', '17', '游戏机');
INSERT INTO `goodstypedetailinfo` VALUES ('36', '21', '男装');

-- ----------------------------
-- Table structure for orderdetailinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderdetailinfo`;
CREATE TABLE `orderdetailinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `remark` longtext,
  `addTime` longtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetailinfo
-- ----------------------------
INSERT INTO `orderdetailinfo` VALUES ('4', '3', '5555', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('5', '3', '5555', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('7', '4', '9879878787', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('9', '3', '897789879', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('12', '8', '545454', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('13', '12', '购物网站确认，安排配送', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('14', '12', '顺风承运', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('15', '12', '客户本人签收', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('16', '12', '操作信息添加', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('17', '15', '测试第三方物流信息', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('18', '20', '快递揽收', '2021-5-5 20:30:00');
INSERT INTO `orderdetailinfo` VALUES ('19', '20', '北京到站,客户签收', '2021-5-5 20:30:00');

-- ----------------------------
-- Table structure for ordergoodsinfo
-- ----------------------------
DROP TABLE IF EXISTS `ordergoodsinfo`;
CREATE TABLE `ordergoodsinfo` (
  `orderId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordergoodsinfo
-- ----------------------------
INSERT INTO `ordergoodsinfo` VALUES ('12', '95', '7', '100');
INSERT INTO `ordergoodsinfo` VALUES ('13', '102', '1', '101');
INSERT INTO `ordergoodsinfo` VALUES ('14', '99', '2', '1');
INSERT INTO `ordergoodsinfo` VALUES ('15', '102', '2', '1');
INSERT INTO `ordergoodsinfo` VALUES ('16', '99', '1', '0');
INSERT INTO `ordergoodsinfo` VALUES ('17', '103', '1', '101');
INSERT INTO `ordergoodsinfo` VALUES ('18', '96', '1', '0');
INSERT INTO `ordergoodsinfo` VALUES ('19', '96', '1', '0');
INSERT INTO `ordergoodsinfo` VALUES ('19', '99', '1', '0');
INSERT INTO `ordergoodsinfo` VALUES ('20', '146', '2', '100');
INSERT INTO `ordergoodsinfo` VALUES ('21', '102', '1', '1');
INSERT INTO `ordergoodsinfo` VALUES ('22', '148', '1', '0');
INSERT INTO `ordergoodsinfo` VALUES ('23', '80', '1', '0');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `orderTime` longtext,
  PRIMARY KEY (`orderId`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('12', '4', '100', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('13', '4', '101', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('14', '4', '1', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('15', '4', '1', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('16', '4', '0', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('17', '2', '101', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('18', '5', '0', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('19', '5', '0', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('20', '6', '100', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('21', '2', '1', '2021-5-6 20:00:00');
INSERT INTO `orderinfo` VALUES ('22', '2', '0', '2021-04-28 20:38:28');
INSERT INTO `orderinfo` VALUES ('23', '2', '0', '2021-05-08 19:11:12');

-- ----------------------------
-- Table structure for serviceassessment
-- ----------------------------
DROP TABLE IF EXISTS `serviceassessment`;
CREATE TABLE `serviceassessment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) DEFAULT NULL,
  `serviceAssessment` longtext,
  `assessmentTime` longtext,
  `orderid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serviceassessment
-- ----------------------------
INSERT INTO `serviceassessment` VALUES ('3', '5', '评价测试', '2021-5-9 20:00:00', '18');
INSERT INTO `serviceassessment` VALUES ('5', '2', '878787', '2021-5-9 20:00:00', '17');
INSERT INTO `serviceassessment` VALUES ('6', '6', '卖家很好', '2021-5-9 20:00:00', '20');
INSERT INTO `serviceassessment` VALUES ('7', '2', '333', '2021-04-28 20:38:45', '22');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` longtext,
  `userPwd` longtext,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'admin', '111111', '0');
INSERT INTO `userinfo` VALUES ('4', 'czy', '111111', '1');
INSERT INTO `userinfo` VALUES ('5', 'testczy', '111111', '1');
