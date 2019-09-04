create table member(
    id varchar2(20) not null,
    password varchar2(20) not null,
    name varchar2(20) not null,
    gender varchar2(10),
    birth  varchar2(20),
    mail  varchar2(30),
    phone varchar2(20),
    address varchar2(100),
    regist_day varchar2(50),    
    primary key(id) 
);

--���ڴ� male ���ڴ� female

commit;

--DROP TABLE books;

INSERT INTO member VALUES('abcd', 'abcd', 'ȫ�浿', 'male','20000103', 'abcd@naver.com', '010-0000-0000', 'û�ֽ� ������', '');

commit;

select * from member;