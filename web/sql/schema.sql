create table article (
    `id` bigint primary key auto_increment comment 'ID',
    `title` varchar(255) not null comment '제목',
    `content` varchar(4000) not null comment '본문',
    `view_count` integer not null default 0 comment '조회수',
    `like_count` integer not null default 0 comment '좋아요 수',
    `hashtag` varchar(255) default null comment '해시태그',
    `created_at` datetime default CURRENT_TIMESTAMP not null comment '생성일시',
    `created_by` varchar(255) not null comment '생성자',
    `modified_at` datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP not null comment '수정일시',
    `modified_by` varchar(255) not null comment '수정자',
    key `idx_title` (`title`),
    key `idx_created_at` (`created_at`),
    key `idx_created_by` (`created_by`)
);

create table article_comment (
    `id` bigint primary key auto_increment comment 'ID',
    `article_id` bigint not null comment '게시글 ID',
    `content` varchar(2000) not null comment '본문',
    `created_at` datetime default CURRENT_TIMESTAMP not null comment '생성일시',
    `created_by` varchar(255) not null comment '생성자',
    `modified_at` datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP not null comment '수정일시',
    `modified_by` varchar(255) not null comment '수정자',
    key `idx_created_at` (`created_at`),
    key `idx_created_by` (`created_by`)
);

