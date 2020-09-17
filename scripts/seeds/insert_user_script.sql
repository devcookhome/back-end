USE dev_cookhome;

INSERT INTO user (email, username, name, user_password) VALUES ('testedeuser@teste.com','testeuser','Usuário de teste', SHA2('teste',256)),
('testedeuser2@teste.com','testeuser2','Usuário de teste 2', AES_ENCRYPT('teste123', 'chave'));
