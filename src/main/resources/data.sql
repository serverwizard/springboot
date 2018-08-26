insert into role (id, name)
  values(1, 'ROLE_USER');
insert into role (id, name)
  values(2, 'ROLE_ADMIN');

insert into user (id, name, email, password, join_date)
  values( 1, 'kim', 'urstory@gmail.com', '{bcrypt}$2a$10$Iu9aek0vjbl.9MT7jkswretsyWQrzj0RIV2bY9e47Xsmgh58W4CSW', now());
insert into user (id, name, email, password, join_date)
  values( 2, 'kang', 'carami@gmail.com', '{bcrypt}$2a$10$Iu9aek0vjbl.9MT7jkswretsyWQrzj0RIV2bY9e47Xsmgh58W4CSW', now());

insert into user_role(user_id, role_id)
  values(1, 1);

insert into user_role(user_id, role_id)
  values(1, 2);

insert into user_role(user_id, role_id)
  values(2, 1);

insert into board_category(id, name)
  values(1, 'java');
insert into board_category(id, name)
  values(2, 'free');

insert into board(id, user_id, board_category_id, title, content, read_count, create_date, update_date)
values(1, 1, 2, 'hello 111', 'hello 111111', 2, now(), now());

insert into board(id, user_id, board_category_id, title, content, read_count, create_date, update_date)
values(2, 1, 2, 'hello 222', 'hello 222222', 5, now(), now());

insert into board(id, user_id, board_category_id, title, content, read_count, create_date, update_date)
values(3, 2, 2, 'hello 333', 'hello 333333', 200, now(), now());

insert into board_file(id, board_id, mime_type, name, save_file_name, size)
  values(1, 1, 'image/jpeg', 'a.jpg', '/tmp/a.jpg', 100);

insert into board_file(id, board_id, mime_type, name, save_file_name, size)
  values(2, 1, 'image/jpeg', 'b.jpg', '/tmp/b.jpg', 200);

insert into board_file(id, board_id, mime_type, name, save_file_name, size)
  values(3, 2, 'image/jpeg', 'c.jpg', '/tmp/c.jpg', 300);

insert into board_file(id, board_id, mime_type, name, save_file_name, size)
  values(4, 2, 'image/jpeg', 'd.jpg', '/tmp/d.jpg', 400);