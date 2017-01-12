CREATE TABLE `TB_AT_USER` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `BIRTH` datetime DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `EMAIL` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;




