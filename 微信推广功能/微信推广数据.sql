/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/10/21 18:40:17                          */
/*==============================================================*/


drop table if exists t_vx_activities;

drop table if exists t_vx_buy_info;

drop table if exists t_vx_merchant;

drop table if exists t_vx_promoters;

/*==============================================================*/
/* Table: t_vx_activities                                       */
/*==============================================================*/
create table t_vx_activities
(
   f_id                 int not null auto_increment comment '主键',
   f_merchant_id        int not null comment '商户外键',
   f_title              varchar(800) not null comment '标题',
   f_price              decimal(18,2) not null comment '价格',
   f_top_img            varchar(500) not null comment '门户图片',
   f_start_time         datetime not null comment '活动时间',
   f_mp3                varchar(256) comment '活动音乐',
   f_people_num         int not null comment '活动人数',
   f_pay_num            int default 0 comment '购买人数',
   f_select_num         int comment '浏览数',
   f_detail_img         text comment '详情图片',
   f_phone              varchar(256) comment '客户电话',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_vx_buy_info                                         */
/*==============================================================*/
create table t_vx_buy_info
(
   f_id                 int not null auto_increment comment '主键',
   f_name               varchar(500) not null comment '购买人姓名',
   f_phone              varchar(256) not null comment '该买人手机号',
   f_money              decimal(18,2) not null comment '支付金额',
   f_buy_time           datetime not null comment '支付日期',
   f_promoters_id       int comment '返现推广人外键',
   f_re_money           decimal(10,2) comment '返现推广员金额',
   f_share_status       char(1) comment '是否分享 1分享 0 未分享',
   f_share_money        decimal(10,2) comment '分享返现金额',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_vx_merchant                                         */
/*==============================================================*/
create table t_vx_merchant
(
   f_id                 int not null auto_increment comment '主键',
   f_name               varchar(500) not null comment '商户名称',
   f_phone              varchar(256) not null comment '电话',
   f_vx_num             varchar(256) comment '微信号',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_vx_promoters                                        */
/*==============================================================*/
create table t_vx_promoters
(
   f_id                 int not null auto_increment comment '主键',
   f_vx_num             varchar(256) not null comment '微信号',
   f_phone              varchar(256) comment '手机号',
   f_name               varchar(500) comment '姓名',
   f_nickname           varchar(500) comment '昵称',
   f_ext_num            int comment '推广个数',
   f_sum_money          decimal(18,2) comment '返现总金额',
   f_activites          int comment '活动外键',
   f_open_id            varchar(256) comment '授权号',
   f_createtime         datetime not null comment '创建时间',
   primary key (f_id)
);

