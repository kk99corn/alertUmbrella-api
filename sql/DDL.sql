-- db 생성
CREATE SCHEMA `dbumbrella`;

-- member table
CREATE TABLE `dbumbrella`.`member`
(
    `memberSeq`      INT          NOT NULL AUTO_INCREMENT,
    `memberId`       VARCHAR(45)  NOT NULL,
    `memberPassword` VARCHAR(255) NOT NULL,
    `inputDate`     DATETIME     NOT NULL DEFAULT now(),
    PRIMARY KEY (`memberSeq`)
);