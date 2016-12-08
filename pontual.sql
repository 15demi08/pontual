--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

-- Started on 2016-12-08 14:01:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE pontual_jpa;
--
-- TOC entry 2132 (class 1262 OID 32820)
-- Name: pontual_jpa; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE pontual_jpa WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE pontual_jpa OWNER TO postgres;

\connect pontual_jpa

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 32969)
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE departamento (
    id bigint NOT NULL,
    nome character varying(255)
);


ALTER TABLE departamento OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 32979)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE funcionario (
    matricula integer NOT NULL,
    cpf character varying(255),
    administrador boolean,
    login character varying(255),
    nome character varying(255),
    senha character varying(255),
    departamento_id bigint
);


ALTER TABLE funcionario OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 32974)
-- Name: ponto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ponto (
    id bigint NOT NULL,
    dataponto date,
    entrada time without time zone,
    saida time without time zone,
    saidaintervalo time without time zone,
    voltaintervalo time without time zone,
    funcionario_matricula integer
);


ALTER TABLE ponto OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 32964)
-- Name: rotina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE rotina (
    id bigint NOT NULL,
    datafim date,
    datainicio date,
    entrada time without time zone,
    saida time without time zone,
    saidaintervalo time without time zone,
    temintervalo boolean,
    voltaintervalo time without time zone,
    funcionario_matricula integer
);


ALTER TABLE rotina OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 33002)
-- Name: sequence; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);


ALTER TABLE sequence OWNER TO postgres;

--
-- TOC entry 2124 (class 0 OID 32969)
-- Dependencies: 182
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY departamento (id, nome) FROM stdin;
1	Direção Administrativa
2	Finanças
3	Vendas
54	Estoque
101	Linha de Montagem
\.


--
-- TOC entry 2126 (class 0 OID 32979)
-- Dependencies: 184
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY funcionario (matricula, cpf, administrador, login, nome, senha, departamento_id) FROM stdin;
111111	00000000000	t	admin	Admin	admin	1
222222	11111111111	t	demetrius	Demétrius	123456	1
333333	2222222222	f	jeovana	Jeovana	123456	2
444444	33333333333	f	rodrigo	Rodrigo	123456	3
555555	44444444444	f	vinicius	Vinícius	123456	3
\.


--
-- TOC entry 2125 (class 0 OID 32974)
-- Dependencies: 183
-- Data for Name: ponto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ponto (id, dataponto, entrada, saida, saidaintervalo, voltaintervalo, funcionario_matricula) FROM stdin;
51	2016-12-05	09:00:00	18:00:00	12:00:00	13:00:00	444444
52	2016-12-04	09:00:00	18:00:00	12:00:00	13:00:00	444444
53	2016-12-03	09:00:00	18:00:00	12:00:00	13:00:00	444444
\.


--
-- TOC entry 2123 (class 0 OID 32964)
-- Dependencies: 181
-- Data for Name: rotina; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY rotina (id, datafim, datainicio, entrada, saida, saidaintervalo, temintervalo, voltaintervalo, funcionario_matricula) FROM stdin;
\.


--
-- TOC entry 2127 (class 0 OID 33002)
-- Dependencies: 185
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sequence (seq_name, seq_count) FROM stdin;
SEQ_GEN	150
\.


--
-- TOC entry 1999 (class 2606 OID 32973)
-- Name: departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2003 (class 2606 OID 32986)
-- Name: funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (matricula);


--
-- TOC entry 2001 (class 2606 OID 32978)
-- Name: ponto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ponto
    ADD CONSTRAINT ponto_pkey PRIMARY KEY (id);


--
-- TOC entry 1997 (class 2606 OID 32968)
-- Name: rotina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rotina
    ADD CONSTRAINT rotina_pkey PRIMARY KEY (id);


--
-- TOC entry 2005 (class 2606 OID 33006)
-- Name: sequence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);


--
-- TOC entry 2008 (class 2606 OID 32997)
-- Name: fk_funcionario_departamento_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fk_funcionario_departamento_id FOREIGN KEY (departamento_id) REFERENCES departamento(id);


--
-- TOC entry 2007 (class 2606 OID 32992)
-- Name: fk_ponto_funcionario_matricula; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ponto
    ADD CONSTRAINT fk_ponto_funcionario_matricula FOREIGN KEY (funcionario_matricula) REFERENCES funcionario(matricula);


--
-- TOC entry 2006 (class 2606 OID 32987)
-- Name: fk_rotina_funcionario_matricula; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rotina
    ADD CONSTRAINT fk_rotina_funcionario_matricula FOREIGN KEY (funcionario_matricula) REFERENCES funcionario(matricula);


--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-12-08 14:01:36

--
-- PostgreSQL database dump complete
--

