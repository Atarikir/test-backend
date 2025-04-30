alter table budget
    add column if not exists author_id int,
    add constraint fk_budget_author foreign key (author_id) references author(id) on delete set null;