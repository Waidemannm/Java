insert into banda (nome,data_fundacao,pais_origem,ativa) values ('Guns and Roses','1978-01-01','EUA',true);
insert into banda (nome,data_fundacao,pais_origem,ativa) values ('Bruno Mars','2001-07-09','EUA',true);
insert into banda (nome,data_fundacao,pais_origem,ativa) values ('Legião Urbana','1982-12-04','Brasil',false);
insert into banda (nome,data_fundacao,pais_origem,ativa) values ('Iron Maiden','1975-11-04','Inglaterra',true);
insert into banda (nome,data_fundacao,pais_origem,ativa) values ('Skank','1982-05-13','Brasil',false);

insert into integrante (fk_banda,nome,data_nascimento,funcao) values (1,'Axl Rose','1962-02-06','Vocalista');
insert into integrante (fk_banda,nome,data_nascimento,funcao) values (2,'Bruno Mars','1985-08-02','Guitarrista');
insert into integrante (fk_banda,nome,data_nascimento,funcao) values (3,'Renato Russo','1948-09-17','Vocalista');
insert into integrante (fk_banda,nome,data_nascimento,funcao) values (4,'Bruce Dickinson','1956-02-06','Baixista');
insert into integrante (fk_banda,nome,data_nascimento,funcao) values (5,'Samuel Rosa','1978-11-19','Baterista');

insert into musica (fk_banda,genero,titulo,duracao) values (1,'SERTANEJO','Welcome to The Jungle', 7.23);
insert into musica (fk_banda,genero,titulo,duracao) values (2,'ROCK','Grenade', 4.17);
insert into musica (fk_banda,genero,titulo,duracao) values (3,'POP','Faroeste Caboclo', 2.38);
insert into musica (fk_banda,genero,titulo,duracao) values (4,'GOSPEL','Run to The Rills', 3.09);
insert into musica (fk_banda,genero,titulo,duracao) values (5,'METAL','Vamos Fugir', 8.23);
insert into musica (fk_banda,genero,titulo,duracao) values (1,'SERTANEJO','Patience', 4.29);
insert into musica (fk_banda,genero,titulo,duracao) values (2,'ROCK','Talking to the Moon', 5.17);
insert into musica (fk_banda,genero,titulo,duracao) values (3,'POP','Tempo Perdido', 3.06);
insert into musica (fk_banda,genero,titulo,duracao) values (4,'GOSPEL','The Trooper', 6.32);
insert into musica (fk_banda,genero,titulo,duracao) values (5,'METAL','Canção Noturna', 4.14);