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
   f_id                 int not null auto_increment comment '����',
   f_phone              varchar(100) comment '�ֻ���',
   f_remark             varchar(500) comment '����',
   f_car_id             int comment '��ѯ�������',
   primary key (f_id)
);

/*==============================================================*/
/* Table: f_sale_car                                            */
/*==============================================================*/
create table f_sale_car
(
   f_id                 int not null auto_increment comment '����',
   f_phone              varchar(256) not null comment '�ֻ�����',
   f_status             char(1) default '0' comment '0 δ���� 1 ������ 2 �Ѵ���',
   f_remark             varchar(500) comment '��ע',
   f_create_time        datetime comment '����ʱ��',
   primary key (f_id)
);

/*==============================================================*/
/* Table: t_car_info                                            */
/*==============================================================*/
create table t_car_info
(
   f_id                 int not null auto_increment comment '����',
   f_title              varchar(500) not null comment '����',
   f_price              decimal(18,2) default 0 comment '�ͼ�',
   f_consult_price      varchar(256) comment '�ο���',
   f_new_price          decimal(18,2) default 0 comment '�³��۸�',
   f_show_price         decimal(18,2) default 0 comment '��ʾ�۸�',
   f_showflag           int not null default 0 comment '��ע��',
   f_end_time           datetime comment '��ֹ����',
   f_address            varchar(256) comment '�ص����',
   f_transfer_num       int default 0 comment '��������',
   f_transfer_price_state char(1) comment '�Ƿ񺬹����� 0 ���� 1��֮',
   f_mileage            int comment '�����������Ϊ��λ',
   f_upbk_time          datetime comment '��������',
   f_dw                 varchar(50) comment '��λ �Զ��� �ֶ���',
   f_pl                 varchar(256) comment '����',
   f_bk_citiy           varchar(500) comment '���չ���',
   f_xqbz               varchar(256) comment '��Ǩ��׼',
   f_remark             text comment '����',
   f_status             char(1) comment '0 ���� 1����',
   f_top_img            varchar(256) comment 'ͷͼƬ',
   f_imgs               varchar(500) comment 'ͼƬ id �Զ��Ÿ���',
   f_transaction_statu  char(1) default '1' comment '1 �ϼ� 0 �¼�',
   f_offer_statue       char(1) default '0' comment '�Ƿ��ؼ� 0 �����ؼ� 1 �ؼ�',
   f_brand              varchar(256) comment 'Ʒ��',
   f_type               varchar(256) comment '����',
   f_pk_id              int comment '���',
   f_str_a              varchar(256) comment '��չ�ֶ�',
   f_str_b              varchar(256) comment '��չ�ֶ�2',
   f_int_a              int comment '��չ�ֶ�3',
   f_int_b              int comment '��չ�ֶ�4',
   primary key (f_id)
);

