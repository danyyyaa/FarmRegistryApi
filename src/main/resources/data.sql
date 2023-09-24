INSERT INTO regions (name, code, status, created, updated)
VALUES ('name1', 123, 'ACTIVE', NOW(), NOW()),
       ('name2', 123, 'ACTIVE', NOW(), NOW());

INSERT INTO crop_area(created, updated, name)
VALUES (NOW(), NOW(), 'name1'),
       (NOW(), NOW(), 'name2');

