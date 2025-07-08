alter table topicos add active tinyint;
update topicos set active = 1;