drop schema if exists public cascade;
create schema orm_d;

-- create owner user with all privileges
drop user if exists orm_d_owner;
create user orm_d_owner with password '12345' login;

-- grant all necessary privileges in one step
alter database orm_d owner to orm_d_owner;
grant all privileges on schema orm_d to orm_d_owner;
grant all privileges on all tables in schema orm_d to orm_d_owner;
grant usage on schema orm_d to orm_d_owner;
alter default privileges in schema orm_d grant all on tables to orm_d_owner;

-- set search path
alter user orm_d_owner set search_path to orm_d;
