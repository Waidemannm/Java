insert into pessoa(nome,data_nascimento,cpf,email_pessoal,telefone) values('Pessoa 1','2005-01-01','1234','pessoa1@fiap.com.br','91234-1234');
insert into pessoa(nome,data_nascimento,cpf,email_pessoal,telefone) values('Pessoa 2','2004-01-01','12345','pessoa2@fiap.com.br','91234-1235');
insert into pessoa(nome,data_nascimento,cpf,email_pessoal,telefone) values('Pessoa 3','2003-01-01','123456','pessoa3@fiap.com.br','91234-1236');

insert into usuario(id,rm,senha,status,fk_pessoa) values(1,'rm1','senha1','ATIVO',1);
insert into usuario(id,rm,senha,status,fk_pessoa) values(2,'rm2','senha2','INATIVO',2);
insert into usuario(id,rm,senha,status,fk_pessoa) values(3,'rm3','senha3','BLOQUEADO',3);