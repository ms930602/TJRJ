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
   f_id                 int not null comment '主键',
   f_item_id            int not null comment '物品外键',
   f_quantity           decimal(18,2) not null comment '数量',
   f_price              decimal(18,2) not null comment '买入价格',
   f_buy_time           datetime not null comment '买入时间',
   f_exist_time         datetime comment '到期日期',
   f_remark             varchar(500) comment '备注',
   f_createtime         datetime comment '创建时间',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_game_ms                                             */
/*==============================================================*/
create table t_game_ms
(
   f_id                 int not null comment '主键',
   f_name               varchar(200) not null comment '名称',
   f_type               int comment '类型',
   f_createtime         datetime not null comment '创建时间',
   f_column_a           int comment '扩展字段1',
   f_column_b           int comment '扩展字段2',
   f_column_c           varchar(200) comment '扩展字段3',
   f_column_d           varchar(200) comment '扩展字段4',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_item_ms                                             */
/*==============================================================*/
create table t_item_ms
(
   f_id                 int not null comment '主键',
   f_game_id            int not null comment '游戏外键',
   f_name               varchar(200) not null comment '名称',
   f_type               char(1) not null comment '类型',
   f_createtime         datetime not null comment '创建时间',
   f_updatetime         datetime comment '修改时间',
   f_remark             varbinary(200) comment '备注',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_opinion_ms                                          */
/*==============================================================*/
create table t_opinion_ms
(
   f_id                 int not null comment '主键',
   f_type               char(1) not null comment '类型 1-意见 2-bug',
   f_title              varchar(256) not null comment '标题',
   f_remark             varchar(500) comment '内容',
   f_createtime         datetime not null comment '创建时间',
   f_create_peo         int not null comment '创建人外键',
   f_handle_type        char(1) not null comment '处理状态 1-已反馈 2-已处理',
   f_re_text            varchar(256) comment '反馈内容',
   f_re_time            datetime comment '反馈时间',
   f_re_reward_text     varchar(256) comment '奖励内容',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_pre_buy_ms                                          */
/*==============================================================*/
create table t_pre_buy_ms
(
   f_id                 int not null comment '主键',
   f_item_id            int not null comment '物品外键',
   f_quantity           decimal(18,2) not null comment '预买数量',
   f_price              decimal(18,2) comment '预计价格',
   f_time               datetime not null comment '预买入时间',
   f_remark             varchar(500) comment '备注',
   f_createtime         datetime not null comment '创建时间',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_pre_sell_ms                                         */
/*==============================================================*/
create table t_pre_sell_ms
(
   f_id                 int not null comment '主键',
   f_item_id            int not null comment '物品外键',
   f_quantity           decimal(18,2) not null comment '预卖数量',
   f_price              decimal(18,2) comment '预计价格',
   f_time               datetime not null comment '预卖出时间',
   f_remark             varchar(500) comment '备注',
   f_createtime         datetime not null comment '创建时间',
   primary key (f_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_sell_ms                                             */
/*==============================================================*/
create table t_sell_ms
(
   f_id                 int not null comment '主键',
   f_item_id            int not null comment '物品外键',
   f_quantity           decimal(18,2) not null comment '数量',
   f_price              decimal(18,2) not null comment '卖出价格',
   f_sell_time          datetime not null comment '卖出时间',
   f_remark             varchar(500) comment '备注',
   f_createtime         datetime not null comment '创建时间',
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

