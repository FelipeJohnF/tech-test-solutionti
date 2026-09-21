-- ============================================================
-- Schema
-- ============================================================

CREATE TABLE usuario (
    id              SERIAL PRIMARY KEY,
    role            VARCHAR(30) NOT NULL DEFAULT 'STANDARD',
    nome            VARCHAR(255) NOT NULL,
    cpf             CHAR(11) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    senha           VARCHAR(255) NOT NULL,
    created_at      TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE endereco (
    id           SERIAL PRIMARY KEY,
    user_id      INTEGER NOT NULL,
    cep          CHAR(8) NOT NULL,
    numero       VARCHAR(20),
    complemento  VARCHAR(255),
    logradouro   VARCHAR(255) NOT NULL,
    bairro       VARCHAR(150) NOT NULL,
    cidade       VARCHAR(150) NOT NULL,
    estado       CHAR(2) NOT NULL,
    created_at   TIMESTAMPTZ NOT NULL DEFAULT now(),
    is_main      BOOLEAN NOT NULL DEFAULT false,
    CONSTRAINT fk_endereco_usuario
        FOREIGN KEY (user_id)
        REFERENCES usuario (id)
        ON DELETE CASCADE
);

-- ============================================================
-- Seed data
-- ============================================================

-- Usuários fictícios
-- Senhas representadas como hashes bcrypt de exemplo (placeholders — substitua por hashes reais gerados pela aplicação)
INSERT INTO usuario (role, nome, cpf, data_nascimento, senha, created_at) VALUES
('ADMIN',    'Carlos Eduardo da Silva',  '12345678901', '1985-04-12', '$2a$12$K8y5j6sKkW7e6jZ...admin_hash',  '2025-01-10 09:30:00-03'),
('STANDARD', 'Mariana Souza Santos',     '23456789012', '1992-08-23', '$2a$12$L9z6k7tLlX8f7kA...client_hash', '2025-01-15 14:20:00-03'),
('STANDARD', 'Lucas Mendes Oliveira',    '34567890123', '1998-11-05', '$2a$12$M0a7l8uMmY9g8lB...client_hash', '2025-02-01 11:15:00-03'),
('STANDARD', 'Beatriz Ferreira Lima',    '45678901234', '1995-02-18', '$2a$12$N1b8m9vNnZ0h9mC...staff_hash',  '2025-02-10 16:45:00-03'),
('STANDARD', 'Thiago Rocha Ribeiro',     '56789012345', '2001-07-30', '$2a$12$O2c9n0wOoA1i0nD...client_hash', '2025-03-01 10:00:00-03');

-- Endereços vinculados aos usuários
INSERT INTO endereco (user_id, cep, numero, complemento, logradouro, bairro, cidade, estado, created_at, is_main) VALUES
-- Usuário 1 (Carlos)
(1, '01310100', '1578', 'Apto 101', 'Avenida Paulista', 'Bela Vista', 'São Paulo', 'SP', '2025-01-10 09:35:00-03', true),

-- Usuário 2 (Mariana - 2 endereços: residencial e trabalho)
(2, '22041001', '450', 'Bloco B, Ap 302', 'Avenida Atlântica', 'Copacabana', 'Rio de Janeiro', 'RJ', '2025-01-15 14:25:00-03', true),
(2, '20040002', '12', 'Sala 804', 'Rua da Assembleia', 'Centro', 'Rio de Janeiro', 'RJ', '2025-01-20 18:10:00-03', false),

-- Usuário 3 (Lucas)
(3, '30140071', '890', NULL, 'Avenida Getúlio Vargas', 'Savassi', 'Belo Horizonte', 'MG', '2025-02-01 11:20:00-03', true),

-- Usuário 4 (Beatriz)
(4, '80020100', '120', 'Conjunto 14', 'Rua XV de Novembro', 'Centro', 'Curitiba', 'PR', '2025-02-10 16:50:00-03', true),

-- Usuário 5 (Thiago)
(5, '40026280', '55', 'Casa', 'Ladeira da Barra', 'Barra', 'Salvador', 'BA', '2025-03-01 10:05:00-03', true);
