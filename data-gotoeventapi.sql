--
-- Volcado de datos para la tabla `genres`
--
INSERT INTO `genres`(`name`) VALUES 
("Generico"),
("Rock and Roll"),
("Blues"),
("Reggae"),
("Metal"),
("Country"),
("Trap"),
("Pop"),
("Hip Hop");

--
-- Volcado de datos para la tabla `event_categories`
--
INSERT INTO `event_categories`(`name`) VALUES 
("Recital"),
("Festival"),
("Concierto"),
("Obra teatral"),
("Exposicion"),
("Familiar"),
("Standup");

--
-- Volcado de datos para la tabla `events`
--
INSERT INTO `events`(`name`, `description`, `image`, `category`) VALUES ("Turf", "Turf anuncia su último show del año en Capital Federal el Sábado 3 de Noviembre 21 hs. en La Trastienda (ATP) como cierre del exitoso año que tuvieron donde presentaron la Gira Odisea por todo Argentina y Latinoamérica.", "https://www.tuentrada.com/Articlemedia/Images/TuEntrada/mas_info/Trastienda%20san%20telmo/turf-inter.jpg", 1),
("Divididos 30 Años", "https://www.tuentrada.com/Articlemedia/Images/TuEntrada/mas_info/Divididos/divididos-graficagenerica-inter.jpg", 1),
("Paulo Londra", "Londra es un sub-20 que brilla en el género más caliente del momento. Sus rimas están llenas de buena vibra y agradecimiento. \"Confiado y Tranquilo\", como el título de su segunda canción, que tiene mas de 13 millones de visualizaciones en Youtube y que lo diferencia de los demás exponentes del género.
Paulo Londra, es sin dudas, una de las promesas dentro del genero. El 28 y 30 de Septiembre y el 12 y 13 de octubre llevará todo su flow al mítico Teatro Gran Rex.", "https://www.tuentrada.com/Articlemedia/Images/Brands/daleplayticket/intermedia/londraSanJuan.jpg", 1);

--
-- Volcado de datos para la tabla `artists`
--
INSERT INTO `artists`(`name`, `genre`) VALUES 
("Turf", 2),
("Paulo Londra", 7),
("Divididos", 2);

--
-- Volcado de datos para la tabla `sites`
--
INSERT INTO `sites` (`id`, `name`, `city`, `province`, `address`) VALUES
(1, 'Estadio Polideportivo Islas Malvinas', 'Mar del Plata', 'Buenos aires', 'Av. Juan B. Justo 3525'),
(2, 'La Trastienda Samsung', 'Capital Federal', 'Buenos aires', 'Av. Eduardo Madero 470'),
(3, 'Estadio Aldo Cantoni', 'San Juan', 'San Juan', 'Urquiza esq. San Luis');

--
-- Volcado de datos para la tabla `seat_types`
--
INSERT INTO `seat_types` (`id`, `type`, `capacity`) VALUES
(10, 'Generales de pie', 420),
(9, 'Mesas entre piso', 100),
(8, 'Butacas Pref.', 150),
(7, 'Preferencial 3 y 7', 30),
(6, 'Preferencial 1 y 2', 30);

--
-- Volcado de datos para la tabla `sites_seat_types`
--
INSERT INTO `sites_seat_types`(`site_id`, `seat_types_id`) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5);