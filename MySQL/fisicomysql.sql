CREATE database boraagora;
Use boraagora;
CREATE TABLE Cliente (
    id_Cliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email varchar (80),
    senha varchar (40),
    telefone varchar(40),
    nome_Completo varchar(80)
);

CREATE TABLE Destinos (
    id_Destino INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    data_Destino varchar(10),
    nome_Destino varchar(80),
    valor_Destino float
);

CREATE TABLE Compra (
    id_Cliente int,
   id_Destino int,
    data_Compra varchar (10),
    total_Compra float,
    id_Compra INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    FOREIGN KEY(id_Destino) REFERENCES Destinos (id_Destino),
    FOREIGN KEY(id_Cliente) REFERENCES Cliente (id_Cliente)
);
 
ALTER TABLE Compra ADD CONSTRAINT FK_Compra_2
    FOREIGN KEY (id_Cliente)
    REFERENCES Cliente (id_Cliente)
    ON DELETE SET NULL;
 
ALTER TABLE Compra ADD CONSTRAINT FK_Compra_3
    FOREIGN KEY (fk_Destinos_id_Destino)
    REFERENCES Destinos (id_Destino)
    ON DELETE SET NULL;

insert into Cliente (email, senha, telefone, nome_Completo) values ('denise@email' , '123', '963507756', 'Denise Cardoso');
insert into Destinos (data_Destino, nome_Destino, valor_Destino) values ('2024-01-13' , 'Buenos Aires', 1500.00);
insert into Compra (id_Cliente, id_Destino, data_Compra, total_compra) values (1 , 1, '2023-01-13', 1500.00);
