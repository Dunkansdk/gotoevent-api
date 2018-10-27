-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2018 a las 01:10:59
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gotoeventapi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artists`
--

CREATE TABLE `artists` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `genre` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calendar`
--

CREATE TABLE `calendar` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `time` datetime NOT NULL,
  `event` bigint(20) NOT NULL,
  `site` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calendar_artists`
--

CREATE TABLE `calendar_artists` (
  `calendar_id` bigint(20) NOT NULL,
  `artists_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `events`
--

CREATE TABLE `events` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text,
  `image` varchar(255) NOT NULL,
  `category` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `events`
--

INSERT INTO `events` (`id`, `name`, `description`, `image`, `category`) VALUES
(1, 'No te va a gustar', 'NTVG Vuelve para realizar el show de cierre de la Gira “Suenan Las Alarmas”, su ultimo disco editado en Mayo de 2017.', 'https://www.tuentrada.com/Articlemedia/Images/TuEntrada/mas_info/Obras/ntvgObras-inter-25nov.jpg', 1),
(2, 'Moldavsky Sigue Suelto! ', NULL, 'https://www.tuentrada.com/Articlemedia/Images/TuEntrada/mas_info/teatroApolo/molda_inter_gran2.jpg', 7),
(3, 'Drink & Food Days', 'Llega la 2ª edición de DRINK & FOOD DAYS BUENOS AIRES. La iniciativa que convoca a descubrir el feliz maridaje entre la coctelería y la buena gastronomía en las mejores barras: rooftops y decks de Hoteles de lujo, Bares y Restaurantes Premium, a un precio promocional.\r\nDel 8 al 22 de noviembre, 20 barras seleccionadas ofrecerán una cena con tragos a un precio promocional, el mismo para todas las barras: $950 por persona: incluye 2 tragos de autor, 1 snack o tapeo para acompañarlos, 1 plato principal, agua y servicio de mesa. También habrá opciones sin alcohol.', 'https://www.tuentrada.com/Articlemedia/images/Brands/drinkdays/home/header18.jpg', 5),
(4, 'OConnor Anti Silence', NULL, 'https://www.tuentrada.com/Articlemedia/Images/TuEntrada/mas_info/El%20Teatrito/anti-silence-inter.jpg', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `event_categories`
--

CREATE TABLE `event_categories` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `event_categories`
--

INSERT INTO `event_categories` (`id`, `name`) VALUES
(1, 'Recital'),
(2, 'Festival'),
(3, 'Concierto'),
(4, 'Obra teatral'),
(5, 'Exposicion'),
(6, 'Familiar'),
(7, 'Standup');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genres`
--

CREATE TABLE `genres` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `genres`
--

INSERT INTO `genres` (`id`, `name`) VALUES
(1, 'Rock and Roll'),
(2, 'Jazz'),
(3, 'Blues'),
(4, 'Reggae'),
(5, 'Metal'),
(6, 'Country'),
(7, 'Funk'),
(8, 'Pop'),
(9, 'Hip Hop');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seats`
--

CREATE TABLE `seats` (
  `id` bigint(20) NOT NULL,
  `number` varchar(12) NOT NULL,
  `price` decimal(19,2) NOT NULL,
  `seat_type` bigint(20) NOT NULL,
  `calendar` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seat_types`
--

CREATE TABLE `seat_types` (
  `id` bigint(20) NOT NULL,
  `types` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sites`
--

CREATE TABLE `sites` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `province` varchar(50) NOT NULL,
  `address` varchar(80) NOT NULL,
  `capacity` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artists`
--
ALTER TABLE `artists`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_s2uno1rfqbsn8cs67rhdw6psn` (`name`),
  ADD KEY `FKcy543wfc52silxbb785fibm8j` (`genre`);

--
-- Indices de la tabla `calendar`
--
ALTER TABLE `calendar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkhxqqvvlj8cbbrn2xa74woh4s` (`event`),
  ADD KEY `FK862msdyngpu2imfqp52af3wlv` (`site`);

--
-- Indices de la tabla `calendar_artists`
--
ALTER TABLE `calendar_artists`
  ADD KEY `FKfon6t95q0duaacixt4xh6gdmg` (`artists_id`),
  ADD KEY `FKkests073l195v47jvmt02prdt` (`calendar_id`);

--
-- Indices de la tabla `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_fn2r8jg0sm5v6vhoa7yqw55vy` (`name`),
  ADD KEY `FK9jv9anxe4d8dp3nmrycjdhscg` (`category`);

--
-- Indices de la tabla `event_categories`
--
ALTER TABLE `event_categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_1et3muobyw9w9dur2ww8bvhh7` (`name`);

--
-- Indices de la tabla `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_pe1a9woik1k97l87cieguyhh4` (`name`);

--
-- Indices de la tabla `seats`
--
ALTER TABLE `seats`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoh3088uix78fe3v89i7e4tvwp` (`calendar`),
  ADD KEY `FKfo2bwxqefwu4o2bc1kwxovkpa` (`seat_type`);

--
-- Indices de la tabla `seat_types`
--
ALTER TABLE `seat_types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_rc5pj6glt9pb0dkv3tcpf7k9y` (`types`);

--
-- Indices de la tabla `sites`
--
ALTER TABLE `sites`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_n87xferjlah59ovflwgndoqhi` (`address`),
  ADD UNIQUE KEY `UK_3yyd9iafwesfu340rddu8gqjs` (`name`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `artists`
--
ALTER TABLE `artists`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `calendar`
--
ALTER TABLE `calendar`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `events`
--
ALTER TABLE `events`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `event_categories`
--
ALTER TABLE `event_categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `genres`
--
ALTER TABLE `genres`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `seats`
--
ALTER TABLE `seats`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seat_types`
--
ALTER TABLE `seat_types`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sites`
--
ALTER TABLE `sites`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
