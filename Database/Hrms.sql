PGDMP         ,                y            Hrms    13.2    13.2 :    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16563    Hrms    DATABASE     c   CREATE DATABASE "Hrms" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE "Hrms";
                postgres    false            �            1259    16714    candidate_users    TABLE       CREATE TABLE public.candidate_users (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    national_identity character varying(11) NOT NULL,
    birth_year character varying(4) NOT NULL,
    verify boolean
);
 #   DROP TABLE public.candidate_users;
       public         heap    postgres    false            �            1259    16712    candidate_users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.candidate_users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.candidate_users_user_id_seq;
       public          postgres    false    204            �           0    0    candidate_users_user_id_seq    SEQUENCE OWNED BY     V   ALTER SEQUENCE public.candidate_users_user_id_seq OWNED BY public.candidate_users.id;
          public          postgres    false    203            �            1259    16778    confirm_employer_users    TABLE     �   CREATE TABLE public.confirm_employer_users (
    id integer NOT NULL,
    employer_id integer NOT NULL,
    confirmed_staff_user integer,
    confirmed_date timestamp with time zone,
    is_confirmed boolean
);
 *   DROP TABLE public.confirm_employer_users;
       public         heap    postgres    false            �            1259    16776    confirm_employer_users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.confirm_employer_users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.confirm_employer_users_id_seq;
       public          postgres    false    212            �           0    0    confirm_employer_users_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.confirm_employer_users_id_seq OWNED BY public.confirm_employer_users.id;
          public          postgres    false    211            �            1259    16720    employer_users    TABLE       CREATE TABLE public.employer_users (
    user_id integer NOT NULL,
    company_name character varying(100) NOT NULL,
    web_address character varying(50) NOT NULL,
    phone_number character varying(11) NOT NULL,
    verify boolean,
    user_confirm boolean
);
 "   DROP TABLE public.employer_users;
       public         heap    postgres    false            �            1259    16687    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    16735    job_positions    TABLE     j   CREATE TABLE public.job_positions (
    id integer NOT NULL,
    "position" character varying NOT NULL
);
 !   DROP TABLE public.job_positions;
       public         heap    postgres    false            �            1259    16733    job_positions_id_seq    SEQUENCE     �   CREATE SEQUENCE public.job_positions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.job_positions_id_seq;
       public          postgres    false    208                        0    0    job_positions_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.job_positions_id_seq OWNED BY public.job_positions.id;
          public          postgres    false    207            �            1259    16725    staff_users    TABLE     �   CREATE TABLE public.staff_users (
    user_id integer NOT NULL,
    name character varying NOT NULL,
    surname character varying NOT NULL,
    verify boolean
);
    DROP TABLE public.staff_users;
       public         heap    postgres    false            �            1259    16706    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    mail character varying(50) NOT NULL,
    password character varying(16) NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16704    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    202                       0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    201            �            1259    16746    users_verify    TABLE     �   CREATE TABLE public.users_verify (
    id integer NOT NULL,
    verify_code character varying NOT NULL,
    is_confirmed boolean,
    created_date date,
    confirmed_date date,
    user_id integer NOT NULL
);
     DROP TABLE public.users_verify;
       public         heap    postgres    false            �            1259    16744    verify_code_id_seq    SEQUENCE     �   CREATE SEQUENCE public.verify_code_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.verify_code_id_seq;
       public          postgres    false    210                       0    0    verify_code_id_seq    SEQUENCE OWNED BY     J   ALTER SEQUENCE public.verify_code_id_seq OWNED BY public.users_verify.id;
          public          postgres    false    209            H           2604    16717    candidate_users id    DEFAULT     }   ALTER TABLE ONLY public.candidate_users ALTER COLUMN id SET DEFAULT nextval('public.candidate_users_user_id_seq'::regclass);
 A   ALTER TABLE public.candidate_users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    204    204            K           2604    16781    confirm_employer_users id    DEFAULT     �   ALTER TABLE ONLY public.confirm_employer_users ALTER COLUMN id SET DEFAULT nextval('public.confirm_employer_users_id_seq'::regclass);
 H   ALTER TABLE public.confirm_employer_users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211    212            I           2604    16738    job_positions id    DEFAULT     t   ALTER TABLE ONLY public.job_positions ALTER COLUMN id SET DEFAULT nextval('public.job_positions_id_seq'::regclass);
 ?   ALTER TABLE public.job_positions ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    207    208            G           2604    16709    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    202    202            J           2604    16749    users_verify id    DEFAULT     q   ALTER TABLE ONLY public.users_verify ALTER COLUMN id SET DEFAULT nextval('public.verify_code_id_seq'::regclass);
 >   ALTER TABLE public.users_verify ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209    210            �          0    16714    candidate_users 
   TABLE DATA           c   COPY public.candidate_users (id, name, surname, national_identity, birth_year, verify) FROM stdin;
    public          postgres    false    204   WF       �          0    16778    confirm_employer_users 
   TABLE DATA           u   COPY public.confirm_employer_users (id, employer_id, confirmed_staff_user, confirmed_date, is_confirmed) FROM stdin;
    public          postgres    false    212   �F       �          0    16720    employer_users 
   TABLE DATA           p   COPY public.employer_users (user_id, company_name, web_address, phone_number, verify, user_confirm) FROM stdin;
    public          postgres    false    205   �F       �          0    16735    job_positions 
   TABLE DATA           7   COPY public.job_positions (id, "position") FROM stdin;
    public          postgres    false    208    G       �          0    16725    staff_users 
   TABLE DATA           E   COPY public.staff_users (user_id, name, surname, verify) FROM stdin;
    public          postgres    false    206   'G       �          0    16706    users 
   TABLE DATA           3   COPY public.users (id, mail, password) FROM stdin;
    public          postgres    false    202   DG       �          0    16746    users_verify 
   TABLE DATA           l   COPY public.users_verify (id, verify_code, is_confirmed, created_date, confirmed_date, user_id) FROM stdin;
    public          postgres    false    210   �G                  0    0    candidate_users_user_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.candidate_users_user_id_seq', 1, false);
          public          postgres    false    203                       0    0    confirm_employer_users_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.confirm_employer_users_id_seq', 1, false);
          public          postgres    false    211                       0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 23, true);
          public          postgres    false    200                       0    0    job_positions_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.job_positions_id_seq', 10, true);
          public          postgres    false    207                       0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 25, true);
          public          postgres    false    201                       0    0    verify_code_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.verify_code_id_seq', 1, false);
          public          postgres    false    209            Q           2606    16719 $   candidate_users candidate_users_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.candidate_users
    ADD CONSTRAINT candidate_users_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.candidate_users DROP CONSTRAINT candidate_users_pkey;
       public            postgres    false    204            a           2606    16783 2   confirm_employer_users confirm_employer_users_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.confirm_employer_users
    ADD CONSTRAINT confirm_employer_users_pkey PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.confirm_employer_users DROP CONSTRAINT confirm_employer_users_pkey;
       public            postgres    false    212            U           2606    16724 "   employer_users employer_users_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.employer_users
    ADD CONSTRAINT employer_users_pkey PRIMARY KEY (user_id);
 L   ALTER TABLE ONLY public.employer_users DROP CONSTRAINT employer_users_pkey;
       public            postgres    false    205            Y           2606    16743     job_positions job_positions_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT job_positions_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.job_positions DROP CONSTRAINT job_positions_pkey;
       public            postgres    false    208            W           2606    16732    staff_users staff_users_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.staff_users
    ADD CONSTRAINT staff_users_pkey PRIMARY KEY (user_id);
 F   ALTER TABLE ONLY public.staff_users DROP CONSTRAINT staff_users_pkey;
       public            postgres    false    206            S           2606    16849 "   candidate_users uk_identity_number 
   CONSTRAINT     j   ALTER TABLE ONLY public.candidate_users
    ADD CONSTRAINT uk_identity_number UNIQUE (national_identity);
 L   ALTER TABLE ONLY public.candidate_users DROP CONSTRAINT uk_identity_number;
       public            postgres    false    204            M           2606    16847    users uk_mail 
   CONSTRAINT     H   ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_mail UNIQUE (mail);
 7   ALTER TABLE ONLY public.users DROP CONSTRAINT uk_mail;
       public            postgres    false    202            [           2606    17108    job_positions uk_position 
   CONSTRAINT     Z   ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT uk_position UNIQUE ("position");
 C   ALTER TABLE ONLY public.job_positions DROP CONSTRAINT uk_position;
       public            postgres    false    208            ]           2606    16851    users_verify uk_verify_code 
   CONSTRAINT     ]   ALTER TABLE ONLY public.users_verify
    ADD CONSTRAINT uk_verify_code UNIQUE (verify_code);
 E   ALTER TABLE ONLY public.users_verify DROP CONSTRAINT uk_verify_code;
       public            postgres    false    210            O           2606    16711    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    202            _           2606    16754    users_verify verify_code_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.users_verify
    ADD CONSTRAINT verify_code_pkey PRIMARY KEY (id);
 G   ALTER TABLE ONLY public.users_verify DROP CONSTRAINT verify_code_pkey;
       public            postgres    false    210            b           2606    16784 ,   candidate_users candidate_users_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidate_users
    ADD CONSTRAINT candidate_users_user_id_fkey FOREIGN KEY (id) REFERENCES public.users(id) NOT VALID;
 V   ALTER TABLE ONLY public.candidate_users DROP CONSTRAINT candidate_users_user_id_fkey;
       public          postgres    false    2895    204    202            h           2606    16839 G   confirm_employer_users confirm_employer_users_confirmed_staff_user_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.confirm_employer_users
    ADD CONSTRAINT confirm_employer_users_confirmed_staff_user_fkey FOREIGN KEY (confirmed_staff_user) REFERENCES public.staff_users(user_id) NOT VALID;
 q   ALTER TABLE ONLY public.confirm_employer_users DROP CONSTRAINT confirm_employer_users_confirmed_staff_user_fkey;
       public          postgres    false    206    2903    212            g           2606    16834 >   confirm_employer_users confirm_employer_users_employer_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.confirm_employer_users
    ADD CONSTRAINT confirm_employer_users_employer_id_fkey FOREIGN KEY (employer_id) REFERENCES public.employer_users(user_id) NOT VALID;
 h   ALTER TABLE ONLY public.confirm_employer_users DROP CONSTRAINT confirm_employer_users_employer_id_fkey;
       public          postgres    false    2901    212    205            f           2606    16829 5   confirm_employer_users confirm_employer_users_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.confirm_employer_users
    ADD CONSTRAINT confirm_employer_users_id_fkey FOREIGN KEY (id) REFERENCES public.users_verify(id) NOT VALID;
 _   ALTER TABLE ONLY public.confirm_employer_users DROP CONSTRAINT confirm_employer_users_id_fkey;
       public          postgres    false    210    212    2911            c           2606    16789 *   employer_users employer_users_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.employer_users
    ADD CONSTRAINT employer_users_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;
 T   ALTER TABLE ONLY public.employer_users DROP CONSTRAINT employer_users_user_id_fkey;
       public          postgres    false    2895    202    205            d           2606    16794 $   staff_users staff_users_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.staff_users
    ADD CONSTRAINT staff_users_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;
 N   ALTER TABLE ONLY public.staff_users DROP CONSTRAINT staff_users_user_id_fkey;
       public          postgres    false    202    206    2895            e           2606    25554     users_verify user_id_users_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_verify
    ADD CONSTRAINT user_id_users_id_fk FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;
 J   ALTER TABLE ONLY public.users_verify DROP CONSTRAINT user_id_users_id_fk;
       public          postgres    false    2895    210    202            �   _   x�32�tq�t��8��9���Ǔ����������҂���3Ə�Ș�(59�@!7�(��rΌ��ļ�#9����M�L��-M@�c���� [��      �      x������ � �      �      x������ � �      �      x�32�,.)��K����� !��      �      x������ � �      �   4   x�32�LI�K�5Lu өz�����F�&�f\FƜ��)@� ���̹b���� ]��      �      x������ � �     