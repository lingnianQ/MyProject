


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_stu
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `grade` int NOT NULL,
  `score` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_stu
-- ----------------------------
INSERT INTO `t_stu` VALUES (1, '小林', 0, 3, 91);
INSERT INTO `t_stu` VALUES (2, '小美', 1, 2, 99);
INSERT INTO `t_stu` VALUES (3, '小喜', 0, 2, 92);
INSERT INTO `t_stu` VALUES (4, '小黑', 0, 1, 89);
INSERT INTO `t_stu` VALUES (5, '小明', 1, 2, 88);
INSERT INTO `t_stu` VALUES (9, '小零', 0, 2, 88);

SET FOREIGN_KEY_CHECKS = 1;
