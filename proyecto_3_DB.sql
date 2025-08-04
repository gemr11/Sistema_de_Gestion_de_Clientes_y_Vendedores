-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 04-08-2025 a las 07:05:43
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int NOT NULL,
  `cedula` char(15) NOT NULL,
  `nombre` char(30) NOT NULL,
  `apellido` char(30) NOT NULL,
  `direccion` char(50) DEFAULT NULL,
  `telefono` char(7) DEFAULT NULL,
  `provincia` char(2) DEFAULT NULL,
  `compra_anual` int DEFAULT NULL
) ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `provincia`, `compra_anual`) VALUES
(1, '1-123-4567', 'Eliberto', 'Beitia', 'Calle 1, Ciudad', '2951349', '01', 150000),
(2, '2-234-5678', 'María', 'Ruiz', 'Calle 2, Ciudad', '2345678', '02', 120000),
(3, '3-345-6789', 'Carlos', 'Rodríguez', 'Calle 3, Ciudad', '3456789', '03', 180000),
(4, '4-456-7890', 'Ana', 'Martínez', 'Calle 4, Ciudad', '4567890', '04', 320000),
(5, '5-567-8901', 'Luis', 'Hernández', 'Calle 5, Ciudad', '5678901', '05', 90000),
(6, '6-678-9012', 'Sofía', 'Gómez', 'Calle 6, Ciudad', '6789012', '06', 275000),
(7, '7-789-0123', 'Pedro', 'Vargas', 'Calle 7, Ciudad', '7890123', '07', 330000),
(8, '8-890-1234', 'Lucía', 'Flores', 'Calle 13, Ciudad', '8901234', '08', 210000),
(9, '9-901-2345', 'Jorge', 'Ramírez', 'Calle 9, Ciudad', '9012345', '09', 160000),
(10, '10-012-3458', 'Elena', 'Santos', 'Calle 10, Ciudad', '3123456', '10', 110000),
(11, '1-112-3459', 'Marta', 'López', 'Calle 11, Ciudad', '1123456', '01', 145000),
(12, '2-212-3680', 'Andrés', 'Molina', 'Calle 12, Ciudad', '2123456', '02', 250000),
(13, '3-312-3681', 'Ricardo', 'Castro', 'Calle 13, Ciudad', '3123456', '03', 195000),
(14, '4-412-3482', 'Isabel', 'Ortiz', 'Calle 14, Ciudad', '4123456', '04', 305000),
(15, '5-512-3683', 'Fernando', 'Silva', 'Calle 15, Ciudad', '5123456', '05', 98000),
(16, '6-612-3454', 'Gloria', 'Navarro', 'Calle 16, Ciudad', '6123456', '06', 270000),
(17, '7-712-3685', 'Héctor', 'Méndez', 'Calle 17, Ciudad', '7123456', '07', 315000),
(18, '8-812-3486', 'Patricia', 'Díaz', 'Calle 18, Ciudad', '8123456', '08', 220000),
(19, '9-912-3487', 'Oscar', 'Suárez', 'Calle 19, Ciudad', '9123456', '09', 175000),
(20, '10-022-3458', 'Clara', 'García', 'Calle 20, Ciudad', '3223456', '10', 115000),
(21, '1-122-3489', 'Rafael', 'Ramos', 'Calle 21, Ciudad', '1223456', '01', 155000),
(22, '2-222-3490', 'Verónica', 'Mora', 'Calle 22, Ciudad', '2223456', '02', 240000),
(23, '3-322-5691', 'Alberto', 'Cruz', 'Calle 23, Ciudad', '3223456', '03', 185000),
(24, '4-422-5692', 'Sandra', 'Vega', 'Calle 24, Ciudad', '4223456', '04', 310000),
(25, '5-522-5693', 'Javier', 'Pinto', 'Calle 25, Ciudad', '5223456', '05', 97000),
(26, '6-622-5694', 'Natalia', 'Ríos', 'Calle 26, Ciudad', '6223456', '06', 280000),
(27, '7-722-5695', 'Sergio', 'Pérez', 'Calle 27, Ciudad', '7223456', '07', 320000),
(28, '8-822-5696', 'Daniela', 'Herrera', 'Calle 28, Ciudad', '8223456', '08', 215000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `id` int NOT NULL,
  `codigo` char(2) NOT NULL,
  `descripcion` char(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`id`, `codigo`, `descripcion`) VALUES
(1, '01', 'Electrodomésticos'),
(2, '02', 'Dama'),
(3, '03', 'Caballeros'),
(4, '04', 'Niño'),
(5, '05', 'Juguetería'),
(6, '06', 'Deportes'),
(7, '07', 'Hogar'),
(8, '08', 'Belleza'),
(9, '09', 'Farmacia'),
(10, '10', 'Supermercado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `id` int NOT NULL,
  `codigo` char(2) NOT NULL,
  `descripcion` char(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`id`, `codigo`, `descripcion`) VALUES
(1, '01', 'Bocas del Toro'),
(2, '02', 'Cocle'),
(3, '03', 'Colon'),
(4, '04', 'Chiriqui'),
(5, '05', 'Darien'),
(6, '06', 'Herrera'),
(7, '07', 'Los Santos'),
(8, '08', 'Panamá'),
(9, '09', 'Veraguas'),
(10, '10', 'Panamá Oeste');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `id` int NOT NULL,
  `codigo` char(4) NOT NULL,
  `nombre` char(20) NOT NULL,
  `apellido` char(20) NOT NULL,
  `departamento` char(2) DEFAULT NULL,
  `cargo` char(20) DEFAULT NULL,
  `venta_mensual` int DEFAULT NULL,
  `venta_anual` int DEFAULT NULL
) ;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`id`, `codigo`, `nombre`, `apellido`, `departamento`, `cargo`, `venta_mensual`, `venta_anual`) VALUES
(1, 'V001', 'Idaira', 'Gonzalez', '01', 'Encargada', 50000, 600000),
(2, 'V002', 'Ana', 'Ramírez', '02', 'Encargada', 40000, 480000),
(3, 'V003', 'Carlos', 'Mendoza', '03', 'Asistente', 35000, 420000),
(4, 'V004', 'María', 'Pérez', '04', 'Asistente', 45000, 540000),
(5, 'V005', 'Jorge', 'López', '05', 'Asesor', 30000, 360000),
(6, 'V006', 'Pedro', 'Soto', '06', 'Asesor', 32000, 384000),
(7, 'V007', 'Lucía', 'Vargas', '07', 'Encargada', 28000, 336000),
(8, 'V008', 'Sofía', 'Castro', '08', 'Encargada', 33000, 396000),
(9, 'V009', 'Andrés', 'Navarro', '09', 'Asistente', 37000, 444000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
