drop table if exists TB_ANSWER_COUNT;

drop table if exists TB_EMS_MSG;

drop table if exists TB_EMS_SEND;

drop table if exists TB_LOGIN_USER;

drop table if exists TB_NMS_TEMPLATE;

drop table if exists TB_NMS_TEMPLATE_DETAL;

drop table if exists TB_QUESTION_BANK;

drop table if exists TB_USER_GROUP;

drop table if exists TB_USER_GROUP_REL;

drop table if exists TB_USER_MSG;

/*==============================================================*/
/* Table: TB_ANSWER_COUNT                                       */
/*==============================================================*/
create table TB_ANSWER_COUNT
(
   ID                   varchar(50) not null,
   TEMPLATEID           numeric(12,0),
   DETALID              numeric(12,0),
   TEXT                 varchar(500),
   RECORDTIME           date,
   primary key (ID)
);

/*==============================================================*/
/* Table: TB_EMS_MSG                                            */
/*==============================================================*/
create table TB_EMS_MSG
(
   ID                   varchar(50) not null,
   TEXT                 varchar(500),
   TYPE                 numeric(1,0),
   primary key (ID)
);

/*==============================================================*/
/* Table: TB_EMS_SEND                                           */
/*==============================================================*/
create table TB_EMS_SEND
(
   ID                   varchar(50) not null,
   PHONENUMBER          numeric(20,0),
   STATUS               numeric(1,0),
   RECORDTIME           date,
   EXECTIME             date,
   SENDTIME             date,
   SENDTEXT             varchar(500),
   TYPE                 numeric(1,0),
   primary key (ID)
);

/*==============================================================*/
/* Table: TB_LOGIN_USER                                         */
/*==============================================================*/
create table TB_LOGIN_USER
(
   ID                   varchar(50) not null,
   USER                 varchar(12),
   PWD                  varchar(20),
   NAME                 varchar(12),
   SEX                  varchar(1) comment '0未知，1男，2女',
   REGTIME              date,
   STATUS               numeric(1,0) comment '正常：0，失效：1，冻结：2',
   LOGINTIME            date comment '用于登陆账号冻结比对',
   ERRORCOUNT           numeric(2,0),
   primary key (ID)
);

alter table TB_LOGIN_USER comment '管理用户表';

/*==============================================================*/
/* Table: TB_NMS_TEMPLATE                                       */
/*==============================================================*/
create table TB_NMS_TEMPLATE
(
   ID                   varchar(50) not null,
   NAME                 varchar(12),
   TYPE                 numeric(1,0) comment '0：问卷调查，1：宣传',
   CREATETIME           date,
   STATUS               numeric(1,0),
   primary key (ID)
);

alter table TB_NMS_TEMPLATE comment '网信模板信息';

/*==============================================================*/
/* Table: TB_NMS_TEMPLATE_DETAL                                 */
/*==============================================================*/
create table TB_NMS_TEMPLATE_DETAL
(
   ID                   varchar(50) not null,
   PID                  numeric(12,0),
   NAME                 varchar(20),
   VALUE                varchar(500),
   TYPE                 numeric(1,0),
   TEXT                 varchar(500),
   ORDERNO              numeric(2,0),
   primary key (ID)
);

/*==============================================================*/
/* Table: TB_QUESTION_BANK                                      */
/*==============================================================*/
create table TB_QUESTION_BANK
(
   ID                   varchar(50) not null,
   DETALID              numeric(12,0),
   TYPE                 numeric(1,0),
   primary key (ID)
);

/*==============================================================*/
/* Table: TB_USER_GROUP                                         */
/*==============================================================*/
create table TB_USER_GROUP
(
   ID                   varchar(50) not null,
   NAME                 varchar(12),
   primary key (ID)
);

/*==============================================================*/
/* Table: TB_USER_GROUP_REL                                     */
/*==============================================================*/
create table TB_USER_GROUP_REL
(
   MSGID                varchar(50),
   GROUPID              varchar(12)
);

/*==============================================================*/
/* Table: TB_USER_MSG                                           */
/*==============================================================*/
create table TB_USER_MSG
(
   ID                   varchar(50) not null,
   PHONENUMBER          varchar(20),
   NAME                 varchar(12),
   primary key (ID)
);
