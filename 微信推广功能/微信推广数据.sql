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
   f_id                 int not null auto_increment comment '����',
   f_merchant_id        int not null comment '�̻����',
   f_title              varchar(800) not null comment '����',
   f_price              decimal(18,2) not null comment '�۸�',
   f_top_img            varchar(500) not null comment '�Ż�ͼƬ',
   f_start_time         datetime not null comment '�ʱ��',
   f_mp3                varchar(256) comment '�����',
   f_people_num         int not null comment '�����',
   f_pay_num            int default 0 comment '��������',
   f_select_num         int comment '�����',
   f_detail_img         text comment '����ͼƬ',
   f_phone              varchar(256) comment '�ͻ��绰',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_vx_buy_info                                         */
/*==============================================================*/
create table t_vx_buy_info
(
   f_id                 int not null auto_increment comment '����',
   f_name               varchar(500) not null comment '����������',
   f_phone              varchar(256) not null comment '�������ֻ���',
   f_money              decimal(18,2) not null comment '֧�����',
   f_buy_time           datetime not null comment '֧������',
   f_promoters_id       int comment '�����ƹ������',
   f_re_money           decimal(10,2) comment '�����ƹ�Ա���',
   f_share_status       char(1) comment '�Ƿ���� 1���� 0 δ����',
   f_share_money        decimal(10,2) comment '�����ֽ��',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_vx_merchant                                         */
/*==============================================================*/
create table t_vx_merchant
(
   f_id                 int not null auto_increment comment '����',
   f_name               varchar(500) not null comment '�̻�����',
   f_phone              varchar(256) not null comment '�绰',
   f_vx_num             varchar(256) comment '΢�ź�',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_vx_promoters                                        */
/*==============================================================*/
create table t_vx_promoters
(
   f_id                 int not null auto_increment comment '����',
   f_vx_num             varchar(256) not null comment '΢�ź�',
   f_phone              varchar(256) comment '�ֻ���',
   f_name               varchar(500) comment '����',
   f_nickname           varchar(500) comment '�ǳ�',
   f_ext_num            int comment '�ƹ����',
   f_sum_money          decimal(18,2) comment '�����ܽ��',
   f_activites          int comment '����',
   f_open_id            varchar(256) comment '��Ȩ��',
   f_createtime         datetime not null comment '����ʱ��',
   primary key (f_id)
);

