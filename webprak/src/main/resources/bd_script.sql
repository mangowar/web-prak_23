CREATE TABLE person (
  "person_id" serial,
  "registration_date" date,
  "role" text,
  "login" text,
  "password" text,
  "profile_picture" int,
  primary key(person_id)
);

CREATE TABLE themes (
  "theme_id" serial primary key,
  "theme_name" text,
  "theme_creator" int references person
);

CREATE TABLE topics (
  "topic_id" serial primary key,
  "topic_name" text,
  "theme_id" int references themes
);

CREATE TABLE topic_creators (
  "person_id" int references person,
  "topic_id" int references topics
);

CREATE TABLE messages (
  "message_id" serial primary key,
  "topic_id" int references topics,
  "person_id" int references person,
  "date" date,
  "message_text" text,
  "files" int
);








