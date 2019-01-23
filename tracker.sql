


-- Database: tracker

DROP DATABASE tracker;

CREATE DATABASE tracker
WITH
OWNER = postgres
ENCODING = 'UTF8'
LC_COLLATE = 'Russian_Russia.1251'
LC_CTYPE = 'Russian_Russia.1251'
TABLESPACE = pg_default
CONNECTION LIMIT = -1;

-- Table: public."Permission"

-- DROP TABLE public."Permission";

CREATE TABLE public."Permission"
(
  "PermissionID" serial,
  "Name" varchar(200) NOT NULL,
  CONSTRAINT "Permission_pkey" PRIMARY KEY ("PermissionID")
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Permission"
  OWNER to postgres;

-- Table: public."Role"

-- DROP TABLE public."Role";

CREATE TABLE public."Role"
(
  "RoleID" serial,
  "Name" varchar(200) NOT NULL,
  CONSTRAINT "Role_pkey" PRIMARY KEY ("RoleID")
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Role"
  OWNER to postgres;

-- Table: public."RolePermission"

-- DROP TABLE public."RolePermission";

CREATE TABLE public."RolePermission"
(
  "RoleID" integer NOT NULL,
  "PermissionID" integer NOT NULL,
  CONSTRAINT "RolePerm_pkey" PRIMARY KEY ("RoleID", "PermissionID"),
  CONSTRAINT "Permission_fkey" FOREIGN KEY ("PermissionID")
  REFERENCES public."Permission" ("PermissionID") MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT "Role_fkey" FOREIGN KEY ("RoleID")
  REFERENCES public."Role" ("RoleID") MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."RolePermission"
  OWNER to postgres;


-- Table: public."User"

-- DROP TABLE public."User";

CREATE TABLE public."User"
(
  "UserID" serial,
  "RoleID" integer,
  "FirstName" varchar(200) NOT NULL,
  "Email" varchar(200) NOT NULL,
  "SecondName" varchar(200) NOT NULL,
  CONSTRAINT "User_pkey" PRIMARY KEY ("UserID"),
  CONSTRAINT "User_Role_fkey" FOREIGN KEY ("RoleID")
  REFERENCES public."Role" ("RoleID") MATCH SIMPLE
  ON UPDATE CASCADE
  ON DELETE SET NULL
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."User"
  OWNER to postgres;


-- Table: public."Category"

-- DROP TABLE public."Category";

CREATE TABLE public."Category"
(
  "CategoryID" serial,
  "Name" varchar(200) NOT NULL,
  CONSTRAINT "Category_pkey" PRIMARY KEY ("CategoryID")
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Category"
  OWNER to postgres;

-- Table: public."State"

-- DROP TABLE public."State";

CREATE TABLE public."State"
(
  "StateID" serial,
  "Name" varchar(200) NOT NULL,
  CONSTRAINT "State_pkey" PRIMARY KEY ("StateID")
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."State"
  OWNER to postgres;



-- Table: public."Item"

-- DROP TABLE public."Item";

CREATE TABLE public."Item"
(
  "ItemID" serial,
  "UserID" integer NOT NULL,
  "CategoryID" integer,
  "StateID" integer,
  "Text" varchar(200) NOT NULL,
  CONSTRAINT "Item_pkey" PRIMARY KEY ("ItemID"),
  CONSTRAINT "Item_Category_fkey" FOREIGN KEY ("CategoryID")
  REFERENCES public."Category" ("CategoryID") MATCH SIMPLE
  ON UPDATE CASCADE
  ON DELETE SET NULL,
  CONSTRAINT "Item_State_fkey" FOREIGN KEY ("StateID")
  REFERENCES public."State" ("StateID") MATCH SIMPLE
  ON UPDATE CASCADE
  ON DELETE SET NULL,
  CONSTRAINT "Item_User_fkey" FOREIGN KEY ("UserID")
  REFERENCES public."User" ("UserID") MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Item"
  OWNER to postgres;

-- Table: public."Comment"

-- DROP TABLE public."Comment";

CREATE TABLE public."Comment"
(
  "CommentID" serial,
  "ItemID" integer NOT NULL,
  "UserID" integer NOT NULL,
  "Text" varchar(200),
  CONSTRAINT "Comment_pkey" PRIMARY KEY ("CommentID"),
  CONSTRAINT "Comment_Item_fkey" FOREIGN KEY ("ItemID")
  REFERENCES public."Item" ("ItemID") MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT "Comment_User_fkey" FOREIGN KEY ("UserID")
  REFERENCES public."User" ("UserID") MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Comment"
  OWNER to postgres;


-- Table: public."Attachment"

-- DROP TABLE public."Attachment";

CREATE TABLE public."Attachment"
(
  "AttachmentID" serial,
  "ItemID" integer NOT NULL,
  "FileName" varchar(200),
  CONSTRAINT "Attachment_pkey" PRIMARY KEY ("AttachmentID"),
  CONSTRAINT "Attach_Item_fkey" FOREIGN KEY ("ItemID")
  REFERENCES public."Item" ("ItemID") MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Attachment"
  OWNER to postgres;


