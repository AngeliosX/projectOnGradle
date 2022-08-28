CREATE TABLE IF NOT EXISTS links_users_roles(
    id SERIAL PRIMARY KEY,
    id_user INTEGER NOT NULL REFERENCES users (id),
    id_roles INTEGER NOT NULL REFERENCES roles (id)
)