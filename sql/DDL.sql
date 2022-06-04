-- db 생성
CREATE SCHEMA `dbumbrella`;

-- member table
CREATE TABLE `dbumbrella`.`member`
(
    `memberSeq`      INT          NOT NULL AUTO_INCREMENT,
    `memberId`       VARCHAR(45)  NOT NULL,
    `memberPassword` VARCHAR(255) NOT NULL,
    `inputDate`      DATETIME     NOT NULL DEFAULT now(),
    PRIMARY KEY (`memberSeq`)
);

-- area table
CREATE TABLE `area`
(
    `areaSeq`  int(11) NOT NULL AUTO_INCREMENT,
    `areaName` varchar(20) NOT NULL,
    PRIMARY KEY (`areaSeq`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8

-- area_detail
CREATE TABLE `area_detail`
(
    `areaDetailSeq`  int(11) NOT NULL AUTO_INCREMENT,
    `areaDetailName` varchar(30) DEFAULT NULL,
    `areaX`          int(11) NOT NULL,
    `areaY`          int(11) NOT NULL,
    `areaSeq`        int(11) NOT NULL,
    PRIMARY KEY (`areaDetailSeq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8