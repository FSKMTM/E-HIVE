--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7
-- Dumped by pg_dump version 11.7

-- Started on 2020-06-13 10:15:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 201 (class 1259 OID 69252)
-- Name: meritev; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.meritev (
    id integer NOT NULL,
    cas_meritve timestamp without time zone,
    vrednost double precision,
    podnica integer,
    tip_koda character varying(255)
);


ALTER TABLE public.meritev OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 69250)
-- Name: meritev_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.meritev_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.meritev_id_seq OWNER TO postgres;

--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 200
-- Name: meritev_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.meritev_id_seq OWNED BY public.meritev.id;


--
-- TOC entry 198 (class 1259 OID 69239)
-- Name: podnica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.podnica (
    id integer NOT NULL,
    naziv character varying(255)
);


ALTER TABLE public.podnica OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 69237)
-- Name: podnica_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.podnica_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.podnica_id_seq OWNER TO postgres;

--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 197
-- Name: podnica_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.podnica_id_seq OWNED BY public.podnica.id;


--
-- TOC entry 196 (class 1259 OID 16475)
-- Name: sequence; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);


ALTER TABLE public.sequence OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 69245)
-- Name: tip; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tip (
    koda character varying(255) NOT NULL
);


ALTER TABLE public.tip OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 69260)
-- Name: varoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.varoa (
    id integer NOT NULL,
    cas_meritve timestamp without time zone,
    ime_datoteke character varying(255),
    podnica integer
);


ALTER TABLE public.varoa OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 69258)
-- Name: varoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.varoa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.varoa_id_seq OWNER TO postgres;

--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 202
-- Name: varoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.varoa_id_seq OWNED BY public.varoa.id;


--
-- TOC entry 2706 (class 2604 OID 69255)
-- Name: meritev id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.meritev ALTER COLUMN id SET DEFAULT nextval('public.meritev_id_seq'::regclass);


--
-- TOC entry 2705 (class 2604 OID 69242)
-- Name: podnica id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.podnica ALTER COLUMN id SET DEFAULT nextval('public.podnica_id_seq'::regclass);


--
-- TOC entry 2707 (class 2604 OID 69263)
-- Name: varoa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.varoa ALTER COLUMN id SET DEFAULT nextval('public.varoa_id_seq'::regclass);


--
-- TOC entry 2715 (class 2606 OID 69257)
-- Name: meritev meritev_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.meritev
    ADD CONSTRAINT meritev_pkey PRIMARY KEY (id);


--
-- TOC entry 2711 (class 2606 OID 69244)
-- Name: podnica podnica_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.podnica
    ADD CONSTRAINT podnica_pkey PRIMARY KEY (id);


--
-- TOC entry 2709 (class 2606 OID 16479)
-- Name: sequence sequence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);


--
-- TOC entry 2713 (class 2606 OID 69249)
-- Name: tip tip_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tip
    ADD CONSTRAINT tip_pkey PRIMARY KEY (koda);


--
-- TOC entry 2717 (class 2606 OID 69265)
-- Name: varoa varoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.varoa
    ADD CONSTRAINT varoa_pkey PRIMARY KEY (id);


--
-- TOC entry 2718 (class 2606 OID 69266)
-- Name: meritev fk_meritev_podnica; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.meritev
    ADD CONSTRAINT fk_meritev_podnica FOREIGN KEY (podnica) REFERENCES public.podnica(id);


--
-- TOC entry 2719 (class 2606 OID 69271)
-- Name: meritev fk_meritev_tip_koda; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.meritev
    ADD CONSTRAINT fk_meritev_tip_koda FOREIGN KEY (tip_koda) REFERENCES public.tip(koda);


--
-- TOC entry 2720 (class 2606 OID 69276)
-- Name: varoa fk_varoa_podnica; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.varoa
    ADD CONSTRAINT fk_varoa_podnica FOREIGN KEY (podnica) REFERENCES public.podnica(id);


-- Completed on 2020-06-13 10:15:17

--
-- PostgreSQL database dump complete
--

