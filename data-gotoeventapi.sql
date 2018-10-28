--
-- load 'genres' table
--
INSERT INTO `genres`(`name`) VALUES ("Generico");
INSERT INTO `genres`(`name`) VALUES ("Rock and Roll");
INSERT INTO `genres`(`name`) VALUES ("Blues");
INSERT INTO `genres`(`name`) VALUES ("Reggae");
INSERT INTO `genres`(`name`) VALUES ("Metal");
INSERT INTO `genres`(`name`) VALUES ("Country");
INSERT INTO `genres`(`name`) VALUES ("Funk");
INSERT INTO `genres`(`name`) VALUES ("Pop");
INSERT INTO `genres`(`name`) VALUES ("Hip Hop");

--
-- load event_categories table
--
INSERT INTO `event_categories`(`name`) VALUES ("Recital");
INSERT INTO `event_categories`(`name`) VALUES ("Festival");
INSERT INTO `event_categories`(`name`) VALUES ("Concierto");
INSERT INTO `event_categories`(`name`) VALUES ("Obra teatral");
INSERT INTO `event_categories`(`name`) VALUES ("Exposicion");
INSERT INTO `event_categories`(`name`) VALUES ("Familiar");
INSERT INTO `event_categories`(`name`) VALUES ("Standup");

--
-- load events
--
INSERT INTO `events`(`name`, `description`, `image`, `category`) VALUES ("No te va a gustar", "NTVG Vuelve para realizar el show de cierre de la Gira “Suenan Las Alarmas”, su ultimo disco editado en Mayo de 2017.", "https://www.tuentrada.com/Articlemedia/Images/TuEntrada/mas_info/Obras/ntvgObras-inter-25nov.jpg", 1);
INSERT INTO `events`(`name`, `image`, `category`) VALUES ("Moldavsky Sigue Suelto! ", "https://www.tuentrada.com/Articlemedia/Images/TuEntrada/mas_info/teatroApolo/molda_inter_gran2.jpg", 7);
INSERT INTO `events`(`name`, `description`, `image`, `category`) VALUES ("Drink & Food Days", "Llega la 2ª edición de DRINK & FOOD DAYS BUENOS AIRES. La iniciativa que convoca a descubrir el feliz maridaje entre la coctelería y la buena gastronomía en las mejores barras: rooftops y decks de Hoteles de lujo, Bares y Restaurantes Premium, a un precio promocional.
Del 8 al 22 de noviembre, 20 barras seleccionadas ofrecerán una cena con tragos a un precio promocional, el mismo para todas las barras: $950 por persona: incluye 2 tragos de autor, 1 snack o tapeo para acompañarlos, 1 plato principal, agua y servicio de mesa. También habrá opciones sin alcohol.", "https://www.tuentrada.com/Articlemedia/images/Brands/drinkdays/home/header18.jpg", 5);
INSERT INTO `events`(`name`, `image`, `category`) VALUES ("OConnor Anti Silence", "https://www.tuentrada.com/Articlemedia/Images/TuEntrada/mas_info/El%20Teatrito/anti-silence-inter.jpg", 2);

--
-- load artists
--
INSERT INTO `artists`(`name`, `genre`) VALUES ("No te va a gustar", 2);
INSERT INTO `artists`(`name`, `genre`) VALUES ("Moldavsky", 1);
INSERT INTO `artists`(`name`, `genre`) VALUES ("OConnor", 5);