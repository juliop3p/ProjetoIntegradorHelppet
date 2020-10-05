CREATE TABLE `Produtos` (
	`id_produto` INT NOT NULL AUTO_INCREMENT,
	`nome_produto` varchar(255) NOT NULL,
	`preco_produto` DECIMAL NOT NULL,
	`marca_produto` varchar(255) NOT NULL,
	`estoque_produto` INT NOT NULL,
	`descricao_produto` TEXT NOT NULL,
	`fk_id_categoria` INT NOT NULL,
	PRIMARY KEY (`id_produto`)
);

CREATE TABLE `Categorias` (
	`id_categoria` INT NOT NULL AUTO_INCREMENT,
	`secao_categoria` varchar(255) NOT NULL UNIQUE,
	`sub_secao_categoria` varchar(255) NOT NULL UNIQUE,
	`animal_categoria` varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (`id_categoria`)
);

CREATE TABLE `Usuarios_Login` (
	`id_usuario` INT NOT NULL AUTO_INCREMENT,
	`nome_usuario` varchar(255) NOT NULL,
	`email_usuario` varchar(255) NOT NULL UNIQUE,
	`senha_usuario` varchar(255) NOT NULL,
	`cpf_usuario` varchar(11) NOT NULL UNIQUE,
	`telefone_usuario` varchar(11) NOT NULL UNIQUE,
	`endereco_usuario` varchar(255) NOT NULL,
	`data_nascimento_usuario` DATE NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

ALTER TABLE `Produtos` ADD CONSTRAINT `Produtos_fk0` FOREIGN KEY (`fk_id_categoria`) REFERENCES `Categorias`(`id_categoria`);

