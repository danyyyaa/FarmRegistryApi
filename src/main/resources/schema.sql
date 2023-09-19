DROP TABLE IF EXISTS regions, farmers, crop_area, farmer_areas CASCADE;

CREATE TABLE IF NOT EXISTS regions
(
    id              BIGSERIAL PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    code            BIGINT,
    status          VARCHAR(50)  NOT NULL,
    created         TIMESTAMP    NOT NULL,
    updated         TIMESTAMP
);

CREATE TABLE IF NOT EXISTS farmers
(
    id                BIGSERIAL PRIMARY KEY,
    organization_name VARCHAR(255),
    organization_form VARCHAR(255),
    kpp               INTEGER,
    ogrn              VARCHAR(255),
    inn               INTEGER,
    status            VARCHAR(50),
    created           TIMESTAMP,
    updated           TIMESTAMP,
    region_id         BIGINT REFERENCES regions (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS crop_area
(
    id                BIGSERIAL PRIMARY KEY,
    created           TIMESTAMP,
    updated           TIMESTAMP,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS farmer_areas
(
    crop_area_id BIGINT REFERENCES crop_area (id) ON DELETE CASCADE,
    farmer_id BIGINT REFERENCES regions (id) ON DELETE CASCADE,
    PRIMARY KEY (crop_area_id, farmer_id)
);