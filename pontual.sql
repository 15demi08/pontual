--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

-- Started on 2016-11-03 01:06:05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE pontual_jpa;
--
-- TOC entry 2143 (class 1262 OID 32820)
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
-- TOC entry 2144 (class 0 OID 0)
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
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 32909)
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE departamento (
    id bigint NOT NULL,
    nome character varying(255)
);


ALTER TABLE departamento OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 32914)
-- Name: departamento_funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE departamento_funcionario (
    departamento_id bigint NOT NULL,
    funcionarios_matricula bigint NOT NULL
);


ALTER TABLE departamento_funcionario OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 32893)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE funcionario (
    matricula bigint NOT NULL,
    cpf character varying(255),
    administrador boolean,
    login character varying(255),
    nome character varying(255),
    senha character varying(255),
    departamento_id bigint
);


ALTER TABLE funcionario OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 32885)
-- Name: ponto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ponto (
    id bigint NOT NULL,
    funcionario_matricula bigint,
    dataponto date,
    entrada time without time zone,
    saida time without time zone,
    saidaintervalo time without time zone,
    voltaintervalo time without time zone
);


ALTER TABLE ponto OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 32901)
-- Name: rotina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE rotina (
    id bigint NOT NULL,
    temintervalo boolean,
    funcionario_matricula bigint,
    datainicio date,
    datafim date,
    entrada time without time zone,
    saida time without time zone,
    saidaintervalo time without time zone,
    voltaintervalo time without time zone
);


ALTER TABLE rotina OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 32944)
-- Name: sequence; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);


ALTER TABLE sequence OWNER TO postgres;

--
-- TOC entry 2136 (class 0 OID 32909)
-- Dependencies: 184
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO departamento VALUES (2, 'Direção Administrativa');
INSERT INTO departamento VALUES (51, 'Recursos Humanos');
INSERT INTO departamento VALUES (101, 'Finanças');


--
-- TOC entry 2137 (class 0 OID 32914)
-- Dependencies: 185
-- Data for Name: departamento_funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2134 (class 0 OID 32893)
-- Dependencies: 182
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO funcionario VALUES (1, '00000000000', true, 'admin', 'Admin', 'admin', 2);


--
-- TOC entry 2133 (class 0 OID 32885)
-- Dependencies: 181
-- Data for Name: ponto; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2135 (class 0 OID 32901)
-- Dependencies: 183
-- Data for Name: rotina; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2138 (class 0 OID 32944)
-- Dependencies: 186
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sequence VALUES ('SEQ_GEN', 150);


--
-- TOC entry 2011 (class 2606 OID 32918)
-- Name: departamento_funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY departamento_funcionario
    ADD CONSTRAINT departamento_funcionario_pkey PRIMARY KEY (departamento_id, funcionarios_matricula);


--
-- TOC entry 2009 (class 2606 OID 32913)
-- Name: departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2005 (class 2606 OID 32900)
-- Name: funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (matricula);


--
-- TOC entry 2003 (class 2606 OID 32892)
-- Name: ponto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ponto
    ADD CONSTRAINT ponto_pkey PRIMARY KEY (id);


--
-- TOC entry 2007 (class 2606 OID 32908)
-- Name: rotina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rotina
    ADD CONSTRAINT rotina_pkey PRIMARY KEY (id);


--
-- TOC entry 2013 (class 2606 OID 32948)
-- Name: sequence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);


--
-- TOC entry 2017 (class 2606 OID 32934)
-- Name: fk_departamento_funcionario_departamento_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY departamento_funcionario
    ADD CONSTRAINT fk_departamento_funcionario_departamento_id FOREIGN KEY (departamento_id) REFERENCES departamento(id);


--
-- TOC entry 2018 (class 2606 OID 32939)
-- Name: fk_departamento_funcionario_funcionarios_matricula; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY departamento_funcionario
    ADD CONSTRAINT fk_departamento_funcionario_funcionarios_matricula FOREIGN KEY (funcionarios_matricula) REFERENCES funcionario(matricula);


--
-- TOC entry 2015 (class 2606 OID 32924)
-- Name: fk_funcionario_departamento_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fk_funcionario_departamento_id FOREIGN KEY (departamento_id) REFERENCES departamento(id);


--
-- TOC entry 2014 (class 2606 OID 32919)
-- Name: fk_ponto_funcionario_matricula; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ponto
    ADD CONSTRAINT fk_ponto_funcionario_matricula FOREIGN KEY (funcionario_matricula) REFERENCES funcionario(matricula);


--
-- TOC entry 2016 (class 2606 OID 32929)
-- Name: fk_rotina_funcionario_matricula; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rotina
    ADD CONSTRAINT fk_rotina_funcionario_matricula FOREIGN KEY (funcionario_matricula) REFERENCES funcionario(matricula);


--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-11-03 01:06:07

--
-- PostgreSQL database dump complete
--

