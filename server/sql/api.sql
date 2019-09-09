use db_fas;

SET FOREIGN_KEY_CHECKS = 0;
truncate table tb_api;
truncate table tb_path;
truncate table tb_type;
truncate table tb_state;
SET FOREIGN_KEY_CHECKS = 1;

insert into tb_path (id,base_path) values (1,"base:v1");

insert into tb_type (id,item_type) values (1,"GET");
insert into tb_type (item_type) values ("POST");
insert into tb_type (item_type) values ("PUT");
insert into tb_type (item_type) values ("DELETE");
insert into tb_type (item_type) values ("INPUT");

insert into tb_state (id,state,profile) values (1,0,"API正常");
insert into tb_state (state,profile) values (1,"API禁用");
insert into tb_state (state,profile) values (10,"Token正常");
insert into tb_state (state,profile) values (11,"Token禁用");

insert into tb_api (name,action,flag,check_token,path_id,type_id,state_id) values ("登录","login",0,0,1,1,1);
