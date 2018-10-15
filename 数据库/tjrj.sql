
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/10/15 15:58:36                          */
/*==============================================================*/


DROP TABLE IF EXISTS t_buy_ms;

DROP TABLE IF EXISTS t_opinion_ms;

DROP TABLE IF EXISTS t_pre_buy_ms;

DROP TABLE IF EXISTS t_pre_sell_ms;

DROP TABLE IF EXISTS t_sell_ms;

DROP TABLE IF EXISTS t_item_ms;

DROP TABLE IF EXISTS t_game_ms;
/*==============================================================*/
/* Table: t_buy_ms                                              */
/*==============================================================*/
CREATE TABLE t_buy_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '主键',
   f_item_id            INT NOT NULL COMMENT '物品外键',
   f_quantity           DECIMAL(18,2) NOT NULL COMMENT '数量',
   f_price              DECIMAL(18,2) NOT NULL COMMENT '买入价格',
   f_buy_time           DATETIME NOT NULL COMMENT '买入时间',
   f_exist_time         DATETIME COMMENT '到期日期',
   f_remark             VARCHAR(500) COMMENT '备注',
   f_createtime         DATETIME COMMENT '创建时间',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_game_ms                                             */
/*==============================================================*/
CREATE TABLE t_game_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '主键',
   f_name               VARCHAR(200) NOT NULL COMMENT '名称',
   f_type               CHAR(1) COMMENT '类型',
   f_createtime         DATETIME NOT NULL COMMENT '创建时间',
   f_column_a           INT COMMENT '扩展字段1',
   f_column_b           INT COMMENT '扩展字段2',
   f_column_c           VARCHAR(200) COMMENT '扩展字段3',
   f_column_d           VARCHAR(200) COMMENT '扩展字段4',
   PRIMARY KEY (f_id)
);

/*==============================================================*/
/* Table: t_item_ms                                             */
/*==============================================================*/
CREATE TABLE t_item_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '主键',
   f_game_id            INT NOT NULL COMMENT '游戏外键',
   f_name               VARCHAR(200) NOT NULL COMMENT '名称',
   f_type               CHAR(1) NOT NULL COMMENT '类型',
   f_createtime         DATETIME NOT NULL COMMENT '创建时间',
   f_updatetime         DATETIME COMMENT '修改时间',
   f_remark             VARBINARY(200) COMMENT '备注',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_opinion_ms                                          */
/*==============================================================*/
CREATE TABLE t_opinion_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '主键',
   f_type               CHAR(1) NOT NULL COMMENT '类型 1-意见 2-bug',
   f_title              VARCHAR(256) NOT NULL COMMENT '标题',
   f_remark             VARCHAR(500) COMMENT '内容',
   f_createtime         DATETIME NOT NULL COMMENT '创建时间',
   f_create_peo         INT NOT NULL COMMENT '创建人外键',
   f_handle_type        CHAR(1) NOT NULL COMMENT '处理状态 1-已反馈 2-已处理',
   f_re_text            VARCHAR(256) COMMENT '反馈内容',
   f_re_time            DATETIME COMMENT '反馈时间',
   f_re_reward_text     VARCHAR(256) COMMENT '奖励内容',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_pre_buy_ms                                          */
/*==============================================================*/
CREATE TABLE t_pre_buy_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '主键',
   f_item_id            INT NOT NULL COMMENT '物品外键',
   f_quantity           DECIMAL(18,2) NOT NULL COMMENT '预买数量',
   f_price              DECIMAL(18,2) COMMENT '预计价格',
   f_time               DATETIME NOT NULL COMMENT '预买入时间',
   f_remark             VARCHAR(500) COMMENT '备注',
   f_createtime         DATETIME NOT NULL COMMENT '创建时间',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_pre_sell_ms                                         */
/*==============================================================*/
CREATE TABLE t_pre_sell_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '主键',
   f_item_id            INT NOT NULL COMMENT '物品外键',
   f_quantity           DECIMAL(18,2) NOT NULL COMMENT '预卖数量',
   f_price              DECIMAL(18,2) COMMENT '预计价格',
   f_time               DATETIME NOT NULL COMMENT '预卖出时间',
   f_remark             VARCHAR(500) COMMENT '备注',
   f_createtime         DATETIME NOT NULL COMMENT '创建时间',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_sell_ms                                             */
/*==============================================================*/
CREATE TABLE t_sell_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '主键',
   f_item_id            INT NOT NULL COMMENT '物品外键',
   f_quantity           DECIMAL(18,2) NOT NULL COMMENT '数量',
   f_price              DECIMAL(18,2) NOT NULL COMMENT '卖出价格',
   f_sell_time          DATETIME NOT NULL COMMENT '卖出时间',
   f_remark             VARCHAR(500) COMMENT '备注',
   f_createtime         DATETIME NOT NULL COMMENT '创建时间',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

ALTER TABLE t_buy_ms ADD CONSTRAINT FK_Reference_4 FOREIGN KEY (f_item_id)
      REFERENCES t_item_ms (f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_item_ms ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (f_game_id)
      REFERENCES t_game_ms (f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_pre_buy_ms ADD CONSTRAINT FK_Reference_2 FOREIGN KEY (f_item_id)
      REFERENCES t_item_ms (f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_pre_sell_ms ADD CONSTRAINT FK_Reference_3 FOREIGN KEY (f_item_id)
      REFERENCES t_item_ms (f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_sell_ms ADD CONSTRAINT FK_Reference_5 FOREIGN KEY (f_item_id)
      REFERENCES t_item_ms (f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

