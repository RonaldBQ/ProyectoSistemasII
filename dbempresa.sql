-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-04-2021 a las 05:00:05
-- Versión del servidor: 10.4.16-MariaDB
-- Versión de PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbempresa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbclientes`
--

CREATE TABLE `tbclientes` (
  `idcliente` int(11) NOT NULL,
  `nombrecli` varchar(80) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `fonocli` varchar(15) NOT NULL,
  `emailcli` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbclientes`
--

INSERT INTO `tbclientes` (`idcliente`, `nombrecli`, `direccion`, `fonocli`, `emailcli`) VALUES
(1, 'Linux Torvalds', 'Belgica Street 12345', '9999-9999', 'linu@gmail.com'),
(2, 'Juan Perez', '87678687', '1234567', 'jperez@gmail.com'),
(4, 'Bill Gates', 'Obrajes calle 19', '2786134', 'sin correo'),
(5, 'Jose Gomez', '23547327', 'Cochabamba', 'JossGomez@hotmail.com'),
(6, 'Bianca Monrroy', '736758', 'La Paz', 'bianc@gmail.com'),
(10, 'Edgar', '', '1234567', 'edgar@gmail.com'),
(11, 'Daniel', 'El Alto, 12 de Octubre', '60705473', 'alv@gmail.com'),
(13, 'Carlos Arturo', 'obrajes', '60547210', 'sin correo'),
(15, 'Pedro', 'San Pedro', '6007115', ''),
(16, 'Mark Zuckerbert', 'California', '6666621', 'facebook.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbos`
--

CREATE TABLE `tbos` (
  `idos` int(11) NOT NULL,
  `fecha_os` date DEFAULT NULL,
  `tipo` varchar(15) NOT NULL,
  `situacion` varchar(70) NOT NULL,
  `equipo` varchar(150) NOT NULL,
  `defecto` varchar(150) NOT NULL,
  `servicio` varchar(150) DEFAULT NULL,
  `tecnico` varchar(50) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `idcliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbos`
--

INSERT INTO `tbos` (`idos`, `fecha_os`, `tipo`, `situacion`, `equipo`, `defecto`, `servicio`, `tecnico`, `valor`, `idcliente`) VALUES
(2, '2020-09-07', 'Presupuesto', 'Abandonado por el Cliente', 'DELL OPTIPLEX 7060', 'Fuente de poder quemada.', 'Cambiar fuente.', 'Edwin Villan', '210.00', 1),
(3, '2020-10-19', 'OS', 'Aguardando Aprobacion', 'Equipo Veriton Acer', 'Falla tarjeta de red.', '', 'Juan Perez', '200.00', 2),
(4, '2020-10-19', 'Presupuesto', 'En revision', 'Delux Core i5', 'En observación debido a que se debe ver \nel diagnostico del Tecnico', 'En revision', 'Carlos Alberto Guisbert Salazar', '500.00', 6),
(5, '2020-10-19', 'OS', 'Entrega OK', 'Equipo DELL Inspiron', 'Sistema Operativo con problemas', 'Reinstalacion de Sistema Operativo previa\ncopia de seguridad de la información.', 'Karem Alvarado Alfaro', '190.00', 5),
(6, '2020-10-19', 'Presupuesto', 'Entrega OK', 'Laptop HP 650', 'Bateria en mal estado', '', 'Jose Perez', '500.00', 5),
(7, '2020-10-19', 'OS', 'En revision', 'DELL Optiplex 3050', 'En revision', '', 'Carlos Alberto Guisbert Salazar', '50.00', 1),
(8, '2020-10-19', 'Presupuesto', 'Entrega OK', 'Equipo generico', 'Sin diagnosticar', '', 'Juan Perez', '25.00', 6),
(10, '2020-10-21', 'OS', 'Entrega OK', 'DELL Inspiron corei5', 'Tarjeta de video no responde.', 'Se cambio la tarjeta de video y se configuro \ncorrectamente', 'Ramiro Villan', '250.00', 10),
(12, '2021-04-13', 'OS', 'En mantenimiento', 'HP Pavillon', 'Cambio de disco HDD a SSD', 'Cambio de disco', 'Juan Perez', '50.00', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbusuarios`
--

CREATE TABLE `tbusuarios` (
  `idusuario` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `fono` varchar(15) DEFAULT NULL,
  `login` varchar(15) NOT NULL,
  `contrasenia` varchar(150) NOT NULL,
  `perfil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbusuarios`
--

INSERT INTO `tbusuarios` (`idusuario`, `usuario`, `fono`, `login`, `contrasenia`, `perfil`) VALUES
(1, 'Carlos Alberto Guisbert Salazar', '73525698', 'cguisbert', '9450476b384b32d8ad8b758e76c98a69', 'ADMIN'),
(2, 'Edwin Villan', '1111111', 'evillan', '9450476b384b32d8ad8b758e76c98a69', 'USUARIO'),
(3, 'Brian Carlos Guisbert Monrroy', '12345', 'bguisbert', '9450476b384b32d8ad8b758e76c98a69', 'ADMIN'),
(4, 'Ivy Monrroy Estrada', '412548', 'imonrroye', '9450476b384b32d8ad8b758e76c98a69', 'USUARIO'),
(5, 'Marco Villan', '1234567', 'mvillan', '9450476b384b32d8ad8b758e76c98a69', 'USUARIO'),
(7, 'Ramiro Villan', '1234567', 'rvillan', '9450476b384b32d8ad8b758e76c98a69', 'USUARIO'),
(8, 'Bladimir Torrelio Espinoza', '1234567', 'btorrelio', '9450476b384b32d8ad8b758e76c98a69', 'USUARIO'),
(9, 'Zenon Cartagena', '', 'zcartagena', '9450476b384b32d8ad8b758e76c98a69', 'ADMIN'),
(10, 'Juan Perez', '', 'jperez', '9450476b384b32d8ad8b758e76c98a69', 'USUARIO'),
(12, 'Masiel Guisbert', '1234567', 'mguisbert', '9450476b384b32d8ad8b758e76c98a69', 'ADMIN'),
(13, 'Ronald', '60547371', 'Ronron', 'dd376f14214c6621c28b62b15f342bf5', 'USUARIO');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistaos`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vistaos` (
`idos` int(11)
,`fecha_os` date
,`tipo` varchar(15)
,`situacion` varchar(70)
,`equipo` varchar(150)
,`defecto` varchar(150)
,`servicio` varchar(150)
,`tecnico` varchar(50)
,`valor` decimal(10,2)
,`nombrecli` varchar(80)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vistaos`
--
DROP TABLE IF EXISTS `vistaos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistaos`  AS SELECT `os`.`idos` AS `idos`, `os`.`fecha_os` AS `fecha_os`, `os`.`tipo` AS `tipo`, `os`.`situacion` AS `situacion`, `os`.`equipo` AS `equipo`, `os`.`defecto` AS `defecto`, `os`.`servicio` AS `servicio`, `os`.`tecnico` AS `tecnico`, `os`.`valor` AS `valor`, `cli`.`nombrecli` AS `nombrecli` FROM (`tbos` `os` join `tbclientes` `cli`) WHERE `os`.`idcliente` = `cli`.`idcliente` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbclientes`
--
ALTER TABLE `tbclientes`
  ADD PRIMARY KEY (`idcliente`);

--
-- Indices de la tabla `tbos`
--
ALTER TABLE `tbos`
  ADD PRIMARY KEY (`idos`),
  ADD KEY `idcliente` (`idcliente`);

--
-- Indices de la tabla `tbusuarios`
--
ALTER TABLE `tbusuarios`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbclientes`
--
ALTER TABLE `tbclientes`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `tbos`
--
ALTER TABLE `tbos`
  MODIFY `idos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `tbusuarios`
--
ALTER TABLE `tbusuarios`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbos`
--
ALTER TABLE `tbos`
  ADD CONSTRAINT `tbos_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `tbclientes` (`idcliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
