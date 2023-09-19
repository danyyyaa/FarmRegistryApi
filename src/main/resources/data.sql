INSERT INTO regions (id, name, code, status, created, updated)
VALUES (1, 'name1', 123, 'ACTIVE', NOW(), NOW()),
       (2, 'name2', 123, 'ACTIVE', NOW(), NOW());

INSERT INTO crop_area(id, created, updated, name)
VALUES (1, NOW(), NOW(), 'name1'),
       (2, NOW(), NOW(), 'name2');

