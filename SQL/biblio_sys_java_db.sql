-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.28-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para biblio_sys_java_db
CREATE DATABASE IF NOT EXISTS `biblio_sys_java_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `biblio_sys_java_db`;

-- Copiando estrutura para tabela biblio_sys_java_db.editora
CREATE TABLE IF NOT EXISTS `editora` (
  `id_editora` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `id_endereco` int(11) NOT NULL,
  PRIMARY KEY (`id_editora`),
  KEY `FK_id_endereco_editora` (`id_endereco`) USING BTREE,
  CONSTRAINT `FK_id_endereco_editora` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela biblio_sys_java_db.emprestimo
CREATE TABLE IF NOT EXISTS `emprestimo` (
  `id_emprestimo` int(11) NOT NULL AUTO_INCREMENT,
  `id_pessoa` int(11) NOT NULL,
  `id_livro` int(11) NOT NULL,
  `data_retirada` date NOT NULL,
  `data_devolucao` date NOT NULL,
  `status` int(1) NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id_emprestimo`) USING BTREE,
  KEY `FK_id_pessoa_emprestimo` (`id_pessoa`),
  KEY `FK_id_livro_emprestimo` (`id_livro`),
  CONSTRAINT `FK_id_livro_emprestimo` FOREIGN KEY (`id_livro`) REFERENCES `livro` (`id_livro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_id_pessoa_emprestimo` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela biblio_sys_java_db.endereco
CREATE TABLE IF NOT EXISTS `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `tipo` text NOT NULL,
  `numero` int(11) NOT NULL,
  `bairro` text NOT NULL,
  `complemento` text NOT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela biblio_sys_java_db.livro
CREATE TABLE IF NOT EXISTS `livro` (
  `id_livro` int(11) NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `lancamento` int(4) NOT NULL,
  `colecao` text NOT NULL,
  `autor` text NOT NULL,
  `editora` text NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id_livro`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela biblio_sys_java_db.pessoa
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome_completo` text NOT NULL,
  `data_de_nascimento` date NOT NULL,
  `telefone` text NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  PRIMARY KEY (`id_pessoa`),
  KEY `FK_id_endereco` (`id_endereco`),
  CONSTRAINT `FK_id_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela biblio_sys_java_db.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_pessoa` int(11) NOT NULL,
  `username` text NOT NULL,
  `email` text NOT NULL,
  `senha` text NOT NULL,
  `nivel` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FK_id_pessoa_usuario` (`id_pessoa`) USING BTREE,
  CONSTRAINT `FK_id_pessoa_usuario` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para trigger biblio_sys_java_db.emprestimo_before_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `emprestimo_before_insert` BEFORE INSERT ON `emprestimo` FOR EACH ROW BEGIN
	DECLARE livro_quantidade INT;

	-- Pegar a quantidade do livro na tabela livros
	SELECT quantidade INTO livro_quantidade
	FROM livro
	WHERE id_livro = NEW.id_livro;

	-- Verificar se há livros disponíveis para empréstimo
	IF livro_quantidade > 0 THEN
     	-- Atualizar a quantidade na tabela livros
     	UPDATE livro
     	SET quantidade = quantidade - NEW.quantidade
   	WHERE id_livro = NEW.id_livro;
	ELSE
   	-- Se não houver livros disponíveis, você pode lidar com isso de acordo com a sua lógica de negócios
   	-- Por exemplo, gerar um erro ou realizar outra ação apropriada.
   	-- Aqui, estamos apenas lançando um aviso.
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Não há livros disponíveis para empréstimo';
	END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
