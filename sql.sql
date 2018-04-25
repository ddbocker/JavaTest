Create Database If Not Exists test Character Set UTF8;
USE test;

DROP TABLE IF EXISTS `data_record`;
CREATE TABLE `data_record` (
`id`  int NOT NULL AUTO_INCREMENT ,
`a1`  int NULL ,
`a2`  int NULL ,
`a3`  int NULL ,
`a4`  int NULL ,
`a5`  int NULL ,
`a6`  int NULL ,
`a7`  int NULL ,
`a8`  int NULL ,
`a9`  int NULL ,
`a10`  int NULL ,
`a11`  int NULL ,
`a12`  int NULL ,
`quality`  varchar(10) NULL ,
`createtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updatetime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='数据明细表'
;

DROP TABLE IF EXISTS `data_file`;
CREATE TABLE `data_file` (
`id`  int NOT NULL AUTO_INCREMENT ,
`filename`  varchar(100) NOT NULL COMMENT '上传文件名' ,
`filetype` varchar(10) NULL COMMENT '文件类型',
`filesize` BIGINT NULL COMMENT '文件大小',
`newfilename`  varchar(50) NOT NULL COMMENT '保存文件名',
`managerid` int NULL COMMENT '操作人id',
`managername` varchar(10) NULL COMMENT '操作人姓名',
`createtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updatetime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='上传文件记录表'
;



