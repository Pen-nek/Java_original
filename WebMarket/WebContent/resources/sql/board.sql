CREATE TABLE board (
       num int not null,
       id varchar2(10),
       name varchar2(10) not null,
       subject varchar2(100) not null,
       content varchar2(1000) not null,
       regist_day varchar2(30),
       hit int,
       ip varchar2(20),
       PRIMARY KEY(num)
);

CREATE sequence board_seq;

INSERT INTO board VALUES(board_seq.nextval, 'aaaa', 'aaaa', 'zzzzzzzzzzz','zzzzzzzz', '1', '11', '11');

commit;


select  * from board;

drop table board;