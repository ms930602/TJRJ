/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/10/11 16:47:06                          */
/*==============================================================*/


drop table if exists t_buy_ms;

drop table if exists t_game_ms;

drop table if exists t_item_ms;

drop table if exists t_opinion_ms;

drop table if exists t_pre_buy_ms;

drop table if exists t_pre_sell_ms;

drop table if exists t_sell_ms;

/*==============================================================*/
/* Table: t_buy_ms                                              */
/*==============================================================*/
create table t_buy_ms
(
   f_id                 int not null comment '����',
   f_item_id            int not null comment '��Ʒ���',
   f_quantity           decimal(18,2) not null comment '����',
   f_price              decimal(18,2) not null comment '����۸�',
   f_buy_time           datetime not null comment '����ʱ��',
   f_exist_time         datetime comment '��������',
   f_remark             varchar(500) comment '��ע',
   f_createtime         datetime comment '����ʱ��',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_game_ms                                             */
/*==============================================================*/
create table t_game_ms
(
   f_id                 int not null comment '����',
   f_name               varchar(200) not null comment '����',
   f_type               int comment '����',
   f_createtime         datetime not null comment '����ʱ��',
   f_column_a           int comment '��չ�ֶ�1',
   f_column_b           int comment '��չ�ֶ�2',
   f_column_c           varchar(200) comment '��չ�ֶ�3',
   f_column_d           varchar(200) comment '��չ�ֶ�4',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_item_ms                                             */
/*==============================================================*/
create table t_item_ms
(
   f_id                 int not null comment '����',
   f_game_id            int not null comment '��Ϸ���',
   f_name               varchar(200) not null comment '����',
   f_type               char(1) not null comment '����',
   f_createtime         datetime not null comment '����ʱ��',
   f_updatetime         datetime comment '�޸�ʱ��',
   f_remark             varbinary(200) comment '��ע',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_opinion_ms                                          */
/*==============================================================*/
create table t_opinion_ms
(
   f_id                 int not null comment '����',
   f_type               char(1) not null comment '���� 1-��� 2-bug',
   f_title              varchar(256) not null comment '����',
   f_remark             varchar(500) comment '����',
   f_createtime         datetime not null comment '����ʱ��',
   f_create_peo         int not null comment '���������',
   f_handle_type        char(1) not null comment '����״̬ 1-�ѷ��� 2-�Ѵ���',
   f_re_text            varchar(256) comment '��������',
   f_re_time            datetime comment '����ʱ��',
   f_re_reward_text     varchar(256) comment '��������',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_pre_buy_ms                                          */
/*==============================================================*/
create table t_pre_buy_ms
(
   f_id                 int not null comment '����',
   f_item_id            int not null comment '��Ʒ���',
   f_quantity           decimal(18,2) not null comment 'Ԥ������',
   f_price              decimal(18,2) comment 'Ԥ�Ƽ۸�',
   f_time               datetime not null comment 'Ԥ����ʱ��',
   f_remark             varchar(500) comment '��ע',
   f_createtime         datetime not null comment '����ʱ��',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_pre_sell_ms                                         */
/*==============================================================*/
create table t_pre_sell_ms
(
   f_id                 int not null comment '����',
   f_item_id            int not null comment '��Ʒ���',
   f_quantity           decimal(18,2) not null comment 'Ԥ������',
   f_price              decimal(18,2) comment 'Ԥ�Ƽ۸�',
   f_time               datetime not null comment 'Ԥ����ʱ��',
   f_remark             varchar(500) comment '��ע',
   f_createtime         datetime not null comment '����ʱ��',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_sell_ms                                             */
/*==============================================================*/
create table t_sell_ms
(
   f_id                 int not null comment '����',
   f_item_id            int not null comment '��Ʒ���',
   f_quantity           decimal(18,2) not null comment '����',
   f_price              decimal(18,2) not null comment '�����۸�',
   f_sell_time          datetime not null comment '����ʱ��',
   f_remark             varchar(500) comment '��ע',
   f_createtime         datetime not null comment '����ʱ��',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table t_buy_ms add constraint FK_Reference_4 foreign key (f_item_id)
      references t_item_ms (f_id) on delete restrict on update restrict;

alter table t_item_ms add constraint FK_Reference_1 foreign key (f_game_id)
      references t_game_ms (f_id) on delete restrict on update restrict;

alter table t_pre_buy_ms add constraint FK_Reference_2 foreign key (f_item_id)
      references t_item_ms (f_id) on delete restrict on update restrict;

alter table t_pre_sell_ms add constraint FK_Reference_3 foreign key (f_item_id)
      references t_item_ms (f_id) on delete restrict on update restrict;

alter table t_sell_ms add constraint FK_Reference_5 foreign key (f_item_id)
      references t_item_ms (f_id) on delete restrict on update restrict;

