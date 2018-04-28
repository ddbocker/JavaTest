Create Database If Not Exists test Character Set UTF8;
USE test;

DROP TABLE IF EXISTS `data_record`;
CREATE TABLE `data_record` (
`id`  int NOT NULL AUTO_INCREMENT ,
`a1`   decimal(21,10) NULL ,
`a2`   decimal(21,10) NULL ,
`a3`   decimal(21,10) NULL ,
`a4`   decimal(21,10) NULL ,
`a5`   decimal(21,10) NULL ,
`a6`   decimal(21,10) NULL ,
`a7`   decimal(21,10) NULL ,
`a8`   decimal(21,10) NULL ,
`a9`   decimal(21,10) NULL ,
`a10`  decimal(21,10) NULL ,
`a11`  decimal(21,10) NULL ,
`a12`  decimal(21,10) NULL ,
`quality`  varchar(10) NULL ,
`file_recordid` INT NOT NULL COMMENT '文件记录id',
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
`filepath` VARCHAR(200) NULL COMMENT '文件全路径',
`newfilename`  varchar(50) NOT NULL COMMENT '保存文件名',
`managerid` int NULL COMMENT '操作人id',
`managername` varchar(10) NULL COMMENT '操作人姓名',
`createtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updatetime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='上传文件记录表';

DROP TABLE IF EXISTS `data_analyze`;
CREATE TABLE `data_analyze` (
`id`  int NOT NULL AUTO_INCREMENT ,
`file_recordid` INT NOT NULL COMMENT '文件记录id',
`column_name` varchar(10) NULL COMMENT '列名',
`column_type` TINYINT NOT NULL DEFAULT 0 COMMENT '列类型，0：数字，1：字符', 
`avg` decimal(21,10) NULL COMMENT '平均值',
`std` decimal(21,10) NULL COMMENT '标准差',
`ns` INT NULL COMMENT '离群值',
`factor` INT NULL COMMENT '因子数',
`createtime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updatetime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='样本分析记录';

