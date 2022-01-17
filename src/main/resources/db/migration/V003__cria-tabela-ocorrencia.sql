create table ocorrencia (
    id BIGINT not null auto_increment,
    entrega_id BIGINT not null,
    descricao TEXT not null,
    data_registro DATETIME not null,

    primary key (id)
);

alter table ocorrencia add CONSTRAINT fk_ocorrencia_entrega
foreign key (entrega_id) references entrega (id)