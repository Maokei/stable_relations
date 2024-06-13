CREATE TABLE horsebreed
(
    id   INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE stable
(
    id   INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE horse
(
    id            INT AUTO_INCREMENT,
    name          VARCHAR(100),
    horsebreed_id INT,
    stable_id     INT,
    PRIMARY KEY (id),
    FOREIGN KEY (horsebreed_id) REFERENCES horsebreed (id),
    FOREIGN KEY (stable_id) REFERENCES stable (id)
);

CREATE TABLE equestrian
(
    id       INT AUTO_INCREMENT,
    nickname VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE stableEquestrian
(
    stable_id     INT,
    equestrian_id INT,
    PRIMARY KEY (stable_id, equestrian_id)
);

INSERT INTO horsebreed (name)
VALUES ("Aegidienberger"),
       ("American Paint Horse"),
       ("Arabian"),
       ("British Appaloosa"),
       ("Camarillo White Horse"),
       ("Exmoor Pony"),
       ("Icelandic"),
       ("Rocky Mountain Horse"),
       ("Peruvian Horse"),
       ("Norwegian Fjord"),
       ("Misaki uma"),
       ("Dosanko"),
       ("Black Forest Horse");

INSERT INTO stable (name)
VALUES ("Racing gods"),
       ("Stylish poses"),
       ("Pro jumpers");

INSERT INTO horse (name, horsebreed_id, stable_id)
VALUES ("Rose", 3, 1),
       ("Star", 7, 1),
       ("Blacky", 5, 1),
       ("Mumu", 11, 1),
       ("Kuro", 11, 2),
       ("Blazing", 12, 2),
       ("Speedy", 13, 3),
       ("Sture", 1, 3),
       ("Unicorn", 3, 3);

insert into equestrian (nickname)
VALUES ("Garlic"),
       ("Rove"),
       ("Gozo"),
       ("Speedy"),
       ("Red flash"),
       ("Comet boy"),
       ("Electric girl"),
       ("Trap"),
       ("Nox"),
       ("Harly");

insert into stableEquestrian (stable_id, equestrian_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 3),
       (3, 4),
       (2, 5),
       (3, 5),
       (1, 6),
       (2, 6),
       (1, 7),
       (3, 7),
       (2, 8),
       (1, 9),
       (2, 9),
       (1, 10),
       (3, 10),
       (2, 10);