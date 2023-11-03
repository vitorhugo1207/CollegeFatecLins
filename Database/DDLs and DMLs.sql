/*
    1) Crie as tabelas:
*/
CREATE TABLE clientes(
	codigo NUMBER(3),
	nome VARCHAR2(50),
	idade NUMBER(3),
	sexo VARCHAR2(1),
	CONSTRAINT pk_clientes PRIMARY KEY (codigo),
	CONSTRAINT ck_sexo_cliente CHECK (sexo in ('F', 'M'))
);

CREATE TABLE notafiscal(
	numnota NUMBER(10),
	dataNota DATE NOT NULL,
	valortotal NUMBER(10),
	codcliente NUMBER(3),
	CONSTRAINT pk_notafistal PRIMARY KEY (numnota),
	CONSTRAINT fk_codcliente_TBnotafiscal FOREIGN KEY (codcliente) REFERENCES clientes (codigo)
);

CREATE TABLE produtos(
	codigo NUMBER(3),
	descricao VARCHAR2(100) NOT NULL,
	valorunit VARCHAR2(10),
	CONSTRAINT pk_produtos PRIMARY KEY (codigo)
);

CREATE TABLE itensnotafiscal(
	numitem NUMBER(3),
	numnota NUMBER(10),
	codproduto NUMBER(3),
	qtde NUMBER(5),
	CONSTRAINT pk_itensnotafiscal PRIMARY KEY (numitem, numnota),
	CONSTRAINT fk_numnota_itensnotafiscal FOREIGN KEY (numnota) REFERENCES notafiscal (numnota),
	CONSTRAINT fk_codproduto_itensnotafiscal FOREIGN KEY (codproduto) REFERENCES produtos (codigo)
);

/*
    2) Adicione o campo cidade na tabela cliente
*/
ALTER TABLE clientes ADD (
	cidade VARCHAR2(100)
);

/*
    2.1) Adicione o campo tipoPagamento na tabela nota
*/
ALTER TABLE notafiscal ADD (
	tipoPagamento VARCHAR2(10)
);

/*
    2.2) Adicione o campo qtdEstoque na tabela produto
*/
ALTER TABLE produtos ADD (
	qtdEstoque NUMBER(10)
);

/*
    3) Insira 2 registros em cada tabela
*/
-- CLIENTES
INSERT INTO clientes (codigo, nome, idade, sexo) VALUES (1, 'Vitor', 19, 'M');
INSERT INTO clientes (codigo, nome, idade, sexo) VALUES (2, 'Lumine', 19, 'F');

UPDATE clientes SET cidade = 'Getulina' WHERE codigo = 1 -- Esqueci de colocar cidade no insert;
UPDATE clientes SET cidade = 'Lins' WHERE codigo = 2 -- Esqueci de colocar cidade no insert;

-- NOTA FISCAL
ALTER TABLE notafiscal MODIFY (valortotal FLOAT) -- mudando de number para Float já que é preço;
INSERT INTO notafiscal (numnota, dataNota, valortotal, codcliente, tipoPagamento) VALUES (1123, DATE '2023-11-03', 1134.65, 1, 'debito');
INSERT INTO notafiscal (numnota, dataNota, valortotal, codcliente, tipoPagamento) VALUES (1124, DATE '2023-11-03', 3134.65, 2, 'boleto');

-- PRODUTOS
ALTER TABLE produtos MODIFY (valorunit FLOAT) -- mudando de number para Float já que é preço;
INSERT INTO produtos (codigo, descricao, valorunit, qtdEstoque) VALUES (1, 'PC', 5421.45, 9); 
INSERT INTO produtos (codigo, descricao, valorunit, qtdEstoque) VALUES (2, 'Guitara', 1234.45, 3);

-- ITENSNOTAFISCAL
INSERT INTO itensnotafiscal (numitem, numnota, codproduto, qtde) VALUES (1, 1123, 1, 1);
INSERT INTO itensnotafiscal (numitem, numnota, codproduto, qtde) VALUES (2, 1124, 2, 1);

/*
    4) Atualize todos os registros da tabela cliente com a cidade tendo o valor 'Lins'
*/
UPDATE clientes SET idade = 20 WHERE cidade = 'Lins' -- Atualizando a idade de todos os cleintes que moram em Lins para 20 anos;

/*
    4.1) Atualize o campo estoque com zero
*/
UPDATE produtos SET qtdEstoque = 0;

/*
    4.2) Atualize o estoque do produto código 1 para 100
*/
UPDATE produtos SET qtdEstoque = 100 WHERE codigo = 1;

/*
    5) Exclua o produto codigo 3
*/
DELETE FROM produtos WHERE codigo = 3 -- nada foi deletado já que não criei o produto com codigo 3;

/*
    5) Exclua o produto codigo 3
*/
DELETE FROM itensnotafiscal;