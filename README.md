```
docker run -p 3306:3306 -d --name mariadb -eMARIADB_ROOT_PASSWORD=Password123! mariadb/server:10.4 
```

```
CREATE DATABASE stable;

CREATE TABLE stable.horsebreed (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);
CREATE TABLE stable.stable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);
CREATE TABLE stable.horse (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    horsebreed_id INT,
    stable_id INT,
    FOREIGN KEY (horsebreed_id) REFERENCES stable.horsebreed(id),
    FOREIGN KEY (stable_id) REFERENCES stable.stable(id)
);
CREATE TABLE stable.equestrian (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(100)
);
CREATE TABLE stable.stableEquestrian (
    stable_id INT,
    equestrian_id INT,
    PRIMARY KEY(stable_id, equestrian_id)
);
```

13 breeds:
```
INSERT INTO stable.horsebreed (name) VALUES
("Aegidienberger"),
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
```
3 stables:
```
INSERT INTO stable.stable (name) VALUES ("Racing gods"), ("Stylish poses"), ("Pro jumpers");
```
10 horses:
```
INSERT INTO stable.horse (name, horsebreed_id, stable_id) VALUES
("Rose", 3, 1),
("Star", 7, 1),
("Blacky", 5, 1),
("Mumu", 11, 1),
("Kuro", 11, 2),
("Blazing", 12, 2),
("Speedy", 13, 3),
("Sture", 1, 3),
("Unicorn", 3, 3);

insert into stable.equestrian (nickname) VALUES
("Garlic"),
("Rove"),
("Gozo"),
("Speedy"),
("Red flash"),
("Comet boy"),
("Electric girl"),
("Trap"),
("Nox"),
("Harly");

insert into stable.stableEquestrian (stable_id, equestrian_id) VALUES
(1,1),
(1,2),
(2,2),
(3,3),
(3,4),
(2,5),
(3,5),
(1,6),
(2,6),
(1,7),
(3,7),
(2,8),
(1,9),
(2,9),
(1,10),
(3,10),
(2,10);
```

# Example queries
```
INSERT INTO horsebreed (name) VALUES("Arabian"), ("Icelandic");
INSERT INTO stable.horsebreed VALUES (1, "first row"), (2, "second row");

# get all stables and horses
SELECT * FROM stable.stable INNER JOIN horse on stable.id = horse.stable_id;
# get stable id 1 and it's horses joined
SELECT * FROM stable.stable INNER JOIN horse on stable.id = horse.stable_id WHERE stable.st able.id = 1;
SELECT * FROM stable.stable INNER JOIN horse on stable.id = horse.stable_id WHERE stable.id = 1;

SELECT * FROM stable.horse INNER JOIN stable.horsebreed on stable.horse.horsebreed_id = stable.horsebreed.id;
SELECT * FROM stable.horse INNER JOIN stable.horsebreed on stable.horse.horsebreed_id = stable.horsebreed.id WHERE stable.horse.id = 1;

SELECT horse.id horseId, horse.name horseName,  horse.horsebreed_id breedId, horsebreed.name horseBreedName FROM stable.horse INNER JOIN stable.horsebreed ON stable.horse.horsebreed_id = stable.horsebreed.id;
SELECT horse.id horseId, horse.name horseName,  horse.horsebreed_id breedId, horsebreed.name horseBreedName FROM stable.horse INNER JOIN stable.horsebreed ON stable.horse.horsebreed_id = stable.horsebreed.id WHERE stable.horse.id = 1;

# find how many stables equestrian 5 is in
SELECT COUNT(*) FROM stable.stableEquestrian WHERE equestrian_id = 5;
# find all stables user 6 rides horses in
SELECT s.id, s.name FROM stable.stable s INNER JOIN stable.stableEquestrian se ON s.id = se.stable_id WHERE se.equestrian_id = 6;
# get all equestrians active in stable 3
SELECT e.id, e.nickname FROM stable.equestrian e INNER JOIN stable.stableEquestrian se ON e.id = se.equestrian_id WHERE se.stable_id = 3;
```