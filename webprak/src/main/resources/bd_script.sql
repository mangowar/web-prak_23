CREATE TABLE person (
  "person_id" serial,
  "registration_date" date,
  "role" text not null ,
  "login" text not null ,
  "password" text not null ,
  "profile_picture" int,
  primary key(person_id)
);

CREATE TABLE themes (
  "theme_id" serial primary key,
  "theme_name" text not null ,
  "theme_creator" int not null references person
);

CREATE TABLE topics (
  "topic_id" serial primary key,
  "topic_name" text not null ,
  "theme_id" int not null references themes
);

CREATE TABLE topic_creators (
  "person_id" int not null references person,
  "topic_id" int not null references topics
);

CREATE TABLE messages (
  "message_id" serial primary key,
  "topic_id" int not null references topics,
  "person_id" int not null references person,
  "date" date not null ,
  "message_text" text not null ,
  "files" int
);







