/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/2 9:44:12                            */
/*==============================================================*/


drop table if exists f_consultation;

drop table if exists f_sale_car;

drop table if exists t_car_info;

/*==============================================================*/
/* Table: f_consultation                                        */
/*==============================================================*/
create table f_consultation
(
   f_id                 int not null auto_increment comment '主键',
   f_phone              varchar(100) comment '手机号',
   f_remark             varchar(500) comment '描述',
   f_car_id             int comment '咨询车辆外键',
   primary key (f_id)
);

/*==============================================================*/
/* Table: f_sale_car                                            */
/*==============================================================*/
create table f_sale_car
(
   f_id                 int not null auto_increment comment '主键',
   f_phone              varchar(256) not null comment '手机号码',
   f_status             char(1) default '0' comment '0 未处理 1 已锁定 2 已处理',
   f_remark             varchar(500) comment '备注',
   f_create_time        datetime comment '创建时间',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_car_info                                            */
/*==============================================================*/
create table t_car_info
(
   f_id                 int not null auto_increment comment '主键',
   f_title              varchar(500) not null comment '标题',
   f_price              decimal(18,2) default 0 comment '低价',
   f_consult_price      varchar(256) comment '参考价',
   f_new_price          decimal(18,2) default 0 comment '新车价格',
   f_show_price         decimal(18,2) default 0 comment '显示价格',
   f_showflag           int not null default 0 comment '关注数',
   f_end_time           datetime comment '截止日期',
   f_address            varchar(256) comment '地点城市',
   f_transfer_num       int default 0 comment '过户次数',
   f_transfer_price_state char(1) comment '是否含过户费 0 不含 1反之',
   f_mileage            int comment '表显里程万里为单位',
   f_upbk_time          datetime comment '上牌日期',
   f_dw                 varchar(50) comment '档位 自动挡 手动挡',
   f_pl                 varchar(256) comment '排量',
   f_bk_citiy           varchar(500) comment '拍照归属',
   f_xqbz               varchar(256) comment '限迁标准',
   f_remark             text comment '描述',
   f_status             char(1) comment '0 正常 1锁定',
   f_top_img            varchar(256) comment '头图片',
   f_imgs               varchar(500) comment '图片 id 以逗号隔开',
   f_transaction_statu  char(1) default '1' comment '1 上架 0 下架',
   f_offer_statue       char(1) default '0' comment '是否特价 0 不是特价 1 特价',
   f_brand              varchar(256) comment '品牌',
   f_type               varchar(256) comment '车型',
   f_pk_id              int comment '外键',
   f_str_a              varchar(256) comment '扩展字段',
   f_str_b              varchar(256) comment '扩展字段2',
   f_int_a              int comment '扩展字段3',
   f_int_b              int comment '扩展字段4',
   primary key (f_id)
);

