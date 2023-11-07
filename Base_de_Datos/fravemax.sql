-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-11-2023 a las 02:18:00
-- Versión del servidor: 8.0.34
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fravemax`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `domicilio` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(50) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `apellido`, `nombre`, `domicilio`, `telefono`) VALUES
(1, 'Salazar', 'Joaquin', 'Paraguay 749', '4754172'),
(2, 'Pèrez ', 'Sofia', 'Córdoba 1351', '4611223'),
(3, 'Torres', 'Martìn', 'San Juan 2720', '4896123'),
(4, 'López', 'Estela', 'Arijón 3102', '4581246'),
(5, 'Molina ', 'Carla', 'Pueyrredón 5177', '4633611');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `id_detalleVenta` int NOT NULL,
  `id_venta` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  `precioTotalVentas` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`id_detalleVenta`, `id_venta`, `id_producto`, `cantidad`, `precioTotalVentas`) VALUES
(1, 1, 10, 2, 192.198),
(2, 2, 5, 1, 88.999),
(3, 3, 8, 1, 458.999),
(4, 4, 16, 3, 336.597),
(5, 5, 4, 2, 459.998),
(6, 6, 14, 1, 171.504);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int NOT NULL,
  `nombreProducto` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `descripcion` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `precioActual` double NOT NULL,
  `stock` int NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombreProducto`, `descripcion`, `precioActual`, `stock`, `estado`) VALUES
(1, 'Lavarropas ', ' Dream Automàtic 5 kg Blanco', 201.679, 8, 1),
(2, 'Lavarropas ', 'Samsung Automàtico 8 kg WA450UP', 317.678, 5, 1),
(3, 'Smart TV', 'Philips HD 32\" Android Gris Oscuro', 99.949, 6, 1),
(4, 'Smart TV', 'Samsung 50\" Android Gris Oscuro', 229.999, 3, 1),
(5, 'Microondas', 'BGH 20 Lts B120w Blanco', 85.505, 2, 1),
(6, 'Microondas', 'Daewoo 23 Lts Gris', 88.999, 5, 1),
(7, 'Heladera', 'No frost Gafa HGF Blanca 326 Lts', 283.799, 3, 1),
(8, 'Heladera', 'Samsung con Freezer 330 Lts', 458.999, 3, 1),
(9, 'Aspiradora', 'Klindo 2 en 1 21 Lts', 59.988, 7, 1),
(10, 'Freidora', 'Ostel Dig 40 DDF', 96.099, 5, 1),
(11, 'Procesadora', 'Liliana Totalmix 459DM', 41.674, 6, 1),
(12, 'Cafetera', 'Mondrine de Filtro 20 Lts Negra', 24.999, 3, 1),
(13, 'Jarra Electrica', 'Moulinex BY397S Negra', 32.589, 5, 1),
(14, 'Notebook', 'Netgreen 14\" Cel 64GB', 171.507, 4, 1),
(15, 'Notebook', 'Lenovo 14 Ci3 5G 8GB 256GB ', 389.999, 5, 1),
(16, 'Plancha', 'SecaAxel PL1200 Blanca', 112.199, 7, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL,
  `usuario` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `contraseña` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `usuario`, `contraseña`) VALUES
(1, '\0Augusto Bourdet', 'AB123'),
(2, '\0Johana Veas', 'JV123'),
(3, '\0Soledad Lazzaroni', 'SL123'),
(4, 'Johnny Benitez', 'JB123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int NOT NULL,
  `id_cliente` int NOT NULL,
  `fechadeVenta` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `id_cliente`, `fechadeVenta`) VALUES
(1, 2, '2023-10-01'),
(2, 4, '2023-10-12'),
(3, 1, '2023-10-18'),
(4, 2, '2023-10-18'),
(5, 5, '2023-10-30'),
(6, 3, '2023-10-30');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`id_detalleVenta`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_venta` (`id_venta`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `contraseña` (`contraseña`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `id_detalleVenta` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  ADD CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
