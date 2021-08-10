DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_cpf` varchar(11) DEFAULT NULL,
  `cliente_email` varchar(255) DEFAULT NULL,
  `cliente_nome` varchar(100) DEFAULT NULL,
  `cliente_cep` varchar(10) DEFAULT NULL,
  `cliente_logradouro` varchar(100) DEFAULT NULL,
  `cliente_bairro` varchar(100) DEFAULT NULL,
  `cliente_cidade` varchar(100) DEFAULT NULL,
  `cliente_uf` varchar(2) DEFAULT NULL,
  `cliente_telefone` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
