create table orders (
    order_id bigint not null auto_increment,
     confirmed bit not null,
      time_key date,
       travel_id bigint,
        user_id bigint,
         primary key (order_id)
         ) engine=MyISAM;


create table user_role (
        user_id bigint not null,
        roles varchar(255)
        ) engine=MyISAM;

create table users (
        user_id bigint not null auto_increment,
        activation_code varchar(255),
        active bit not null,
        birthday date,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (user_id)
        ) engine=MyISAM;

create table tours (
        travel_id bigint not null auto_increment,
        count_limit bigint not null,
        description varchar(255),
        end_date date not null,
        location varchar(255),
        name varchar(255),
        start_date date not null,
        primary key (travel_id)
        ) engine=MyISAM;


alter table orders
    add constraint orders_travel_fk
    foreign key (travel_id)
    references tours (travel_id);


alter table orders
    add constraint orders_user_fk
    foreign key (user_id)
    references users (user_id);

alter table user_role
    add constraint user_role_user_fk
    foreign key (user_id)
    references users (user_id);
