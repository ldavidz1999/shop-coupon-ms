CREATE  TABLE IF NOT EXISTS favorite_stats (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    item_id varchar(50) NOT NULL,
    quantity int NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_item_id (item_id)
) ENGINE=InnoDB DEFAULT CHARSET =utf8;