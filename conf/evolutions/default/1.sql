# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user_d (
  id                        bigint auto_increment not null,
  user_name                 varchar(255),
  user_email                varchar(255),
  user_password             varchar(255),
  constraint pk_user_d primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table user_d;

SET FOREIGN_KEY_CHECKS=1;

