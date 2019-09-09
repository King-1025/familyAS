use db_fas;

SET FOREIGN_KEY_CHECKS = 0;
truncate table tb_user;
SET FOREIGN_KEY_CHECKS = 1;

insert into tb_type (id,item_type) values (10,"开发人员");
insert into tb_type (id,item_type) values (11,"测试人员");

insert into tb_state (id,state,profile) values (10,20,"正常");
insert into tb_state (state,profile) values (21,"禁用");

-- king1025 12345678
insert into tb_user (name,token,nick,type_id,state_id) values (
   "king1025","NTIwMWduaWs4NzY1NDMyMQ==","King-1025",10,10
);

