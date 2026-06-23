INSERT INTO albums (title, artist, release_date) VALUES
    ('Hello World', 'Aurora Beats', '2021-08-20'),
    ('Strings of Serenity', 'Harmony Collective', '2020-11-10'),
    ('Cosmic Vibes', 'Galaxy Harmonics', '2024-01-18');

INSERT INTO musics (title, duration, album_id) VALUES
    ('Sunset', '00:03:45', 1),
    ('Moonlight', '00:04:12', 1),
    ('Eternal Memories', '00:05:45', 2);

INSERT INTO users (username, password) VALUES ('user', '$2a$10$huFK5JLVWyAXcm4qZlNpge4Lr6r9r4dLbLu7AsMj6Utfk8k4joxTy');

INSERT INTO favorites (user_id, music_id) VALUES (1, 1);
