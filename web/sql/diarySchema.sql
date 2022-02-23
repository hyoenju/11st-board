create table diary
(
    `id`          bigint primary key auto_increment comment 'ID',
    `title`       varchar(255)  not null comment '제목',
    `content`     varchar(4000) not null comment '본문',
    `created_at`  datetime               default CURRENT_TIMESTAMP not null comment '생성일시',
    `modified_at` datetime               default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP not null comment '수정일시',
    `emotion_score` double comment '감정점수',
    key           `idx_title` (`title`),
    key           `idx_created_at` (`created_at`)
);

create table diary_comment
(
    `id`          bigint primary key auto_increment comment 'ID',
    `diary_id`  bigint                             not null comment '일기 ID',
    `content`     varchar(2000)                      not null comment '본문',
    `created_at`  datetime default CURRENT_TIMESTAMP not null comment '생성일시',
    `created_by`  varchar(255)                       not null comment '생성자',
    key           `idx_created_at` (`created_at`),
    key           `idx_created_by` (`created_by`)
);

