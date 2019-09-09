-- db_fas
drop database if exists db_fas;

create database if not exists db_fas
default charset utf8 
collate utf8_general_ci;

use db_fas;

drop table if exists tb_type;
drop table if exists tb_image;
drop table if exists tb_state;
drop table if exists tb_user;
drop table if exists tb_account;
drop table if exists tb_who;
drop table if exists tb_income;
drop table if exists tb_outcome;
drop table if exists tb_debt;
drop table if exists tb_path;
drop table if exists tb_token;
drop table if exists tb_api;
drop table if exists tb_blacklist;

-- 1.for tb_image tb_user
create table if not exists tb_type
(
  id int unsigned auto_increment,  
  item_type varchar(20) not null,
  primary key (id)
)engine=InnoDB default charset=utf8;

-- 2.for tb_user
create table if not exists tb_image
(
  id int unsigned auto_increment,
  image_path varchar(100) unique,
  remarks text,
  time datetime,
  user_id int unsigned,
  type_id int unsigned,
  primary key (id)
)engine=InnoDB default charset=utf8;

-- 3.for tb_user
create table if not exists tb_state
(
  id int unsigned auto_increment,
  state int(5) unique,
  profile varchar(30),
  primary key (id)
)engine=InnoDB default charset=utf8;

-- 4.for tb_account tb_debt
create table if not exists tb_user
(
  id int unsigned auto_increment,
  name varchar(30) not null,
  token varchar(30) not null,
  nick varchar(30),
  type_id int unsigned,
  icon_id int unsigned,
  state_id int unsigned,
  primary key (id)
)engine=InnoDB default charset=utf8;

-- 5.for tb_income tb_outcome
create table if not exists tb_account
(
  id int unsigned auto_increment,
  record_date datetime,
  user_id int unsigned,
  primary key (id)
)engine=InnoDB default charset=utf8;

-- 6.for tb_income tb_outcome tb_debt
create table if not exists tb_who
(
  id int unsigned auto_increment,
  name varchar(30) not null,
  address varchar(50),
  phone varchar(11),
  type_id int unsigned,
  primary key (id)
)engine=InnoDB default charset=utf8;

-- 7.tb_income
create table if not exists tb_income
(
  id int unsigned auto_increment,
  in_amount float(10,2),
  in_price float(10,2),
  time datetime,
  who_id int unsigned,
  account_id int unsigned,
  type_id int unsigned,
  paper_id int unsigned,
  debt boolean default 0,
  repayment_id int unsigned,
  primary key (id)
)engine=InnoDB default charset=utf8;

-- 8.tb_outcome
create table if not exists tb_outcome
(
  id int unsigned auto_increment,  
  out_amount float(10,2),
  out_price float(10,2),
  time datetime,
  who_id int unsigned,
  account_id int unsigned,
  type_id int unsigned,
  paper_id int unsigned,
  debt boolean default 0,
  arrears_id int unsigned,
  primary key (id)
)engine=InnoDB default charset=utf8;

-- 9.tb_debt
create table if not exists tb_debt
(
  id int unsigned auto_increment,
  money float(10,2),
  details text,
  create_date datetime,
  payoff_date datetime,
  who_id int unsigned,
  user_id int unsigned,
  type_id int unsigned,
  image_id int unsigned,
  state_id int unsigned,
  income_id int unsigned,
  outcome_id int unsigned,
  primary key (id)
)engine=InnoDB default charset=utf8;

alter table tb_image add constraint fk_image_user_id foreign key(user_id) REFERENCES tb_user(id);
alter table tb_image add constraint fk_image_type_id foreign key(type_id) REFERENCES tb_type(id);

alter table tb_user add constraint fk_user_type_id foreign key(type_id) REFERENCES tb_type(id);
alter table tb_user add constraint fk_user_icon_id foreign key(icon_id) REFERENCES tb_image(id);
alter table tb_user add constraint fk_user_state_id foreign key(state_id) REFERENCES tb_state(id);

alter table tb_account add constraint fk_account_user_id foreign key(user_id) REFERENCES tb_user(id);

alter table tb_who add constraint fk_account_type_id foreign key(type_id) REFERENCES tb_type(id);

alter table tb_income add constraint fk_income_who_id foreign key(who_id) REFERENCES tb_who(id);
alter table tb_income add constraint fk_income_account_id foreign key(account_id) REFERENCES tb_account(id);
alter table tb_income add constraint fk_income_type_id foreign key(type_id) REFERENCES tb_type(id);
alter table tb_income add constraint fk_income_paper_id foreign key(paper_id) REFERENCES tb_image(id);

alter table tb_outcome add constraint fk_outcome_who_id foreign key(who_id) REFERENCES tb_who(id);
alter table tb_outcome add constraint fk_outcome_account_id foreign key(account_id) REFERENCES tb_account(id);
alter table tb_outcome add constraint fk_outcome_type_id foreign key(type_id) REFERENCES tb_type(id);
alter table tb_outcome add constraint fk_outcome_paper_id foreign key(paper_id) REFERENCES tb_image(id);

alter table tb_debt add constraint fk_debt_who_id foreign key(who_id) REFERENCES tb_who(id);
alter table tb_debt add constraint fk_debt_user_id foreign key(user_id) REFERENCES tb_user(id);
alter table tb_debt add constraint fk_debt_type_id foreign key(type_id) REFERENCES tb_type(id);
alter table tb_debt add constraint fk_debt_image_id foreign key(image_id) REFERENCES tb_image(id);
alter table tb_debt add constraint fk_debt_state_id foreign key(state_id) REFERENCES tb_state(id);

alter table tb_income add constraint fk_income_repayment_id foreign key(repayment_id) REFERENCES tb_debt(id);
alter table tb_outcome add constraint fk_outcome_arrears_id foreign key(arrears_id) REFERENCES tb_debt(id);
alter table tb_debt add constraint fk_debt_income_id foreign key(income_id) REFERENCES tb_income(id);
alter table tb_debt add constraint fk_debt_outcome_id foreign key(outcome_id) REFERENCES tb_outcome(id);

create table if not exists tb_path
(
  id int unsigned auto_increment,
  base_path varchar(100) unique,  
  primary key (id)
)engine=InnoDB default charset=utf8;

create table if not exists tb_token
(
  id int unsigned auto_increment,
  token varchar(50) unique,
  live_time datetime,
  create_date datetime,
  user_id int unsigned,
  state_id int unsigned,
  primary key (id)
)engine=InnoDB default charset=utf8;

create table if not exists tb_api
(
  id int unsigned auto_increment,
  name varchar(30),
  action varchar(50) not null unique,
  flag int(5) not null unique,
  check_token boolean default 1,
  result_format varchar(20) default 'json',
  request_details text,
  response_details text,
  call_limit int(20) default 99999,
  call_count int(20) default 0,
  failed int(20) default 0,
  last_time datetime,
  last_request_ip varchar(20),
  path_id int unsigned,
  type_id int unsigned,
  state_id int unsigned,
  primary key (id)
)engine=InnoDB default charset=utf8;

alter table tb_token add constraint fk_token_user_id foreign key(user_id) REFERENCES tb_user(id);
alter table tb_token add constraint fk_token_state_id foreign key(state_id) REFERENCES tb_state(id);

alter table tb_api add constraint fk_api_path_id foreign key(path_id) REFERENCES tb_path(id);
alter table tb_api add constraint fk_api_type_id foreign key(type_id) REFERENCES tb_type(id);
alter table tb_api add constraint fk_api_state_id foreign key(state_id) REFERENCES tb_state(id);

create table if not exists tb_blacklist
(
  id int unsigned auto_increment,  
  ip varchar(20) not null,
  primary key (id)
)engine=InnoDB default charset=utf8;
