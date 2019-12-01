CREATE SCHEMA jigsaw;


CREATE TABLE jigsaw.forum (
    name character varying(25) PRIMARY KEY,
    title character varying(150) NOT NULL
);

insert into jigsaw.forum(name, title) values('java', 'Java programing language');
insert into jigsaw.forum(name, title) values('scala', 'Scala programing language');
insert into jigsaw.forum(name, title) values('groovy', 'Groovy programing language');
insert into jigsaw.forum(name, title) values('kotlin', 'Kotlin programing language');
insert into jigsaw.forum(name, title) values('javascript', 'Ecmascript');
insert into jigsaw.forum(name, title) values('ruby', 'Programing language with a name of precious stone');

CREATE TABLE jigsaw.post (
  id bigint NOT NULL,
  forum_name character varying(25) constraint fk_post_forum_name_forum_name references jigsaw.forum(name) not null,
  content character varying(255),
  title character varying(255),
  CONSTRAINT post_pkey PRIMARY KEY (id)
);
