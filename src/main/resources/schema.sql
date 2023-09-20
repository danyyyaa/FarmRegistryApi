DROP TABLE IF EXISTS regions, farmers, crop_area, farmer_areas CASCADE;

CREATE TABLE IF NOT EXISTS regions
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    code    BIGINT       NOT NULL,
    status  VARCHAR(50)  NOT NULL,
    created TIMESTAMP    NOT NULL,
    updated TIMESTAMP
);

CREATE TABLE IF NOT EXISTS farmers
(
    id                BIGSERIAL PRIMARY KEY,
    organization_name VARCHAR(255) NOT NULL,
    organization_form VARCHAR(255) NOT NULL,
    kpp               INTEGER      NOT NULL,
    ogrn              VARCHAR(255) NOT NULL,
    inn               INTEGER      NOT NULL,
    status            VARCHAR(8)   NOT NULL,
    created           TIMESTAMP    NOT NULL,
    updated           TIMESTAMP,
    region_id         BIGINT REFERENCES regions (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS crop_area
(
    id      BIGSERIAL PRIMARY KEY,
    created TIMESTAMP    NOT NULL,
    updated TIMESTAMP,
    name    VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS farmer_areas
(
    crop_area_id BIGINT REFERENCES crop_area (id) ON DELETE CASCADE,
    farmer_id    BIGINT REFERENCES regions (id) ON DELETE CASCADE,
    PRIMARY KEY (crop_area_id, farmer_id)
);