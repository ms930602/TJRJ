
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
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '����',
   f_item_id            INT NOT NULL COMMENT '��Ʒ���',
   f_quantity           DECIMAL(18,2) NOT NULL COMMENT '����',
   f_price              DECIMAL(18,2) NOT NULL COMMENT '����۸�',
   f_buy_time           DATETIME NOT NULL COMMENT '����ʱ��',
   f_exist_time         DATETIME COMMENT '��������',
   f_remark             VARCHAR(500) COMMENT '��ע',
   f_createtime         DATETIME COMMENT '����ʱ��',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_game_ms                                             */
/*==============================================================*/
CREATE TABLE t_game_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '����',
   f_name               VARCHAR(200) NOT NULL COMMENT '����',
   f_type               CHAR(1) COMMENT '����',
   f_createtime         DATETIME NOT NULL COMMENT '����ʱ��',
   f_column_a           INT COMMENT '��չ�ֶ�1',
   f_column_b           INT COMMENT '��չ�ֶ�2',
   f_column_c           VARCHAR(200) COMMENT '��չ�ֶ�3',
   f_column_d           VARCHAR(200) COMMENT '��չ�ֶ�4',
   PRIMARY KEY (f_id)
);

/*==============================================================*/
/* Table: t_item_ms                                             */
/*==============================================================*/
CREATE TABLE t_item_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '����',
   f_game_id            INT NOT NULL COMMENT '��Ϸ���',
   f_name               VARCHAR(200) NOT NULL COMMENT '����',
   f_type               CHAR(1) NOT NULL COMMENT '����',
   f_createtime         DATETIME NOT NULL COMMENT '����ʱ��',
   f_updatetime         DATETIME COMMENT '�޸�ʱ��',
   f_remark             VARBINARY(200) COMMENT '��ע',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_opinion_ms                                          */
/*==============================================================*/
CREATE TABLE t_opinion_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '����',
   f_type               CHAR(1) NOT NULL COMMENT '���� 1-��� 2-bug',
   f_title              VARCHAR(256) NOT NULL COMMENT '����',
   f_remark             VARCHAR(500) COMMENT '����',
   f_createtime         DATETIME NOT NULL COMMENT '����ʱ��',
   f_create_peo         INT NOT NULL COMMENT '���������',
   f_handle_type        CHAR(1) NOT NULL COMMENT '����״̬ 1-�ѷ��� 2-�Ѵ���',
   f_re_text            VARCHAR(256) COMMENT '��������',
   f_re_time            DATETIME COMMENT '����ʱ��',
   f_re_reward_text     VARCHAR(256) COMMENT '��������',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_pre_buy_ms                                          */
/*==============================================================*/
CREATE TABLE t_pre_buy_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '����',
   f_item_id            INT NOT NULL COMMENT '��Ʒ���',
   f_quantity           DECIMAL(18,2) NOT NULL COMMENT 'Ԥ������',
   f_price              DECIMAL(18,2) COMMENT 'Ԥ�Ƽ۸�',
   f_time               DATETIME NOT NULL COMMENT 'Ԥ����ʱ��',
   f_remark             VARCHAR(500) COMMENT '��ע',
   f_createtime         DATETIME NOT NULL COMMENT '����ʱ��',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_pre_sell_ms                                         */
/*==============================================================*/
CREATE TABLE t_pre_sell_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '����',
   f_item_id            INT NOT NULL COMMENT '��Ʒ���',
   f_quantity           DECIMAL(18,2) NOT NULL COMMENT 'Ԥ������',
   f_price              DECIMAL(18,2) COMMENT 'Ԥ�Ƽ۸�',
   f_time               DATETIME NOT NULL COMMENT 'Ԥ����ʱ��',
   f_remark             VARCHAR(500) COMMENT '��ע',
   f_createtime         DATETIME NOT NULL COMMENT '����ʱ��',
   PRIMARY KEY (f_id)
)
ENGINE=INNODB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_sell_ms                                             */
/*==============================================================*/
CREATE TABLE t_sell_ms
(
   f_id                 INT NOT NULL AUTO_INCREMENT COMMENT '����',
   f_item_id            INT NOT NULL COMMENT '��Ʒ���',
   f_quantity           DECIMAL(18,2) NOT NULL COMMENT '����',
   f_price              DECIMAL(18,2) NOT NULL COMMENT '�����۸�',
   f_sell_time          DATETIME NOT NULL COMMENT '����ʱ��',
   f_remark             VARCHAR(500) COMMENT '��ע',
   f_createtime         DATETIME NOT NULL COMMENT '����ʱ��',
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

