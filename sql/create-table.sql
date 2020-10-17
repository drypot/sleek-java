
## thread

create table if not exists thread
(
    id     int          not null,
    cid    smallint     not null,
    hit    int          not null,
    length smallint     not null,
    cdate  datetime(3)  not null,
    udate  datetime(3)  not null,
    writer varchar(255) not null,
    title  varchar(255) not null,
    primary key (id)
);

create index thread_cid_udate on thread (cid, udate desc);
create index thread_udate on thread (udate desc);

## post

create table if not exists post
(
    id      int          not null,
    tid     int          not null,
    cdate   datetime(3)  not null,
    visible bool         not null,
    writer  varchar(255) not null,
    text    longtext     not null,
    files   json         not null,
    primary key (id)
);

create index post_tid_cdate on post (tid, cdate);

## threadmerged

create table if not exists threadmerged
(
    id     int          not null,
    cid    smallint     not null,
    hit    int          not null,
    length smallint     not null,
    cdate  datetime(3)  not null,
    udate  datetime(3)  not null,
    writer varchar(255) not null,
    title  varchar(255) not null,
    text   varchar(255) not null,
    merged longtext     not null,
    fulltext index (merged),
    primary key (id)
) engine = mroonga
  default charset utf8mb4;

