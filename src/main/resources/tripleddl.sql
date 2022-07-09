CREATE DATABASE triple;

create Table point (
    num BIGINT PRIMARY KEY auto_increment,
    user_id VARCHAR(50) NOT NULL,
    cal_point int NOT NULL,
    total_point bigint NOT NULL,
    create_timeStamp DATETIME NOT NULL,
    update_timeStamp DATETIME NOT NULL
);

CREATE Table point_History (
    num BIGINT PRIMARY KEY auto_increment,
    review_id VARCHAR(50) NOT NULL,
    user_id VARCHAR(50) NOT NULL,
    place_id VARCHAR(50) NOT NULL,
    review_point INT NOT NULL,
    create_timeStamp DATETIME NOT NULL
);

