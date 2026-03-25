-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-03-2026 a las 08:53:03
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tecnoschool2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `ID_Administrador` int(11) NOT NULL,
  `Usuario` varchar(255) DEFAULT NULL,
  `Contraseña` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`ID_Administrador`, `Usuario`, `Contraseña`) VALUES
(1, 'ucv', 'vallejo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrar_docente`
--

CREATE TABLE `administrar_docente` (
  `ID_Docente` int(11) NOT NULL,
  `Nombre_Docente` varchar(255) DEFAULT NULL,
  `Telefono_Docente` varchar(20) NOT NULL,
  `DNI_Docente` varchar(8) DEFAULT NULL,
  `Dirección_Docente` varchar(255) DEFAULT NULL,
  `FechaN_Docente` varchar(100) DEFAULT NULL,
  `Aula` int(11) NOT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Contraseña` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrar_docente`
--

INSERT INTO `administrar_docente` (`ID_Docente`, `Nombre_Docente`, `Telefono_Docente`, `DNI_Docente`, `Dirección_Docente`, `FechaN_Docente`, `Aula`, `Usuario`, `Contraseña`) VALUES
(1, 'Brandon', '992997088', '12345678', 'Calle B', '2005-01-18', 1, 'Brandon', '12345678'),
(2, 'Castillo Carlos', '987654321', '87654321', 'Huerto Flor calle 34', '2000-09-20', 2, 'Carlos', '87654321'),
(3, 'Perez Miguel', '983746521', '81726354', 'Mz Flor calle 34', '2001-10-23', 9, 'Miguel', '81726354'),
(4, 'Carla Lopez', '918203948', '11111111', 'calle 23', '1997-07-17', 5, 'Carla', '11111111'),
(5, 'Parodi Patricio', '910293849', '22222222', 'av peru 124', '2000-05-30', 6, 'Patricio', '22222222');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrar_estudiante`
--

CREATE TABLE `administrar_estudiante` (
  `ID_Estudiante` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Fecha_N` date NOT NULL,
  `DNI_Estu` varchar(20) NOT NULL,
  `Aula` int(11) NOT NULL,
  `Periodo` varchar(50) NOT NULL,
  `Dirección` varchar(255) NOT NULL,
  `Apoderado` varchar(100) NOT NULL,
  `DNI_Apo` varchar(20) NOT NULL,
  `Teléfono` varchar(20) NOT NULL,
  `Registro` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrar_estudiante`
--

INSERT INTO `administrar_estudiante` (`ID_Estudiante`, `Nombre`, `Fecha_N`, `DNI_Estu`, `Aula`, `Periodo`, `Dirección`, `Apoderado`, `DNI_Apo`, `Teléfono`, `Registro`) VALUES
(1, 'Mario Montes', '2010-05-15', '81726354', 1, '2024', 'Calle 123', 'Maria Montes', '87654321', '987654321', '2024-05-26 15:52:13'),
(2, 'Camila Ramos', '2018-05-11', '87654321', 6, '2024', 'Calle 320', 'Marta Ramos', '15605775', '992997088', '2024-05-26 17:15:10'),
(3, 'Carlos Martin', '2018-05-03', '87654309', 1, '2024', 'Calle 24', 'Mario Martin', '87654321', '992997088', '2024-05-26 23:54:22'),
(4, 'Juan Peña Ramos', '2011-07-15', '09876543', 1, '2023', 'calle 38', 'Miguel Peña', '98068284', '908798970', '2024-06-08 00:52:33'),
(5, 'Jaime Suarez Mendoza', '2018-06-29', '61528736', 1, '2023', 'calle 47', 'Karla Mendoza', '81748274', '918273645', '2024-06-08 01:07:30'),
(6, 'Carlos Quispe Mamani', '2018-01-19', '63729483', 6, '2024', 'calle 66', 'Miguel Quispe', '82749283', '918371644', '2024-06-08 23:42:44'),
(7, 'Brandon', '2016-06-14', '81928374', 2, '2024', 'calle 3', 'Miguel', '01928374', '91827382', '2024-07-08 13:44:09');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `ID_Estudiante` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Aula` varchar(50) NOT NULL,
  `Periodo` varchar(50) NOT NULL,
  `Estado` varchar(20) NOT NULL,
  `Fecha` date NOT NULL DEFAULT curdate()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`ID_Estudiante`, `Nombre`, `Aula`, `Periodo`, `Estado`, `Fecha`) VALUES
(1, 'Mario Montes', '1', '2024', 'Presente', '2024-05-26'),
(2, 'Mario Montes', '1', '2024', 'Presente', '2024-05-25'),
(3, 'Mario Montes', '1', '2024', 'Tardanza', '2024-05-26'),
(4, 'Mario Montes', '1', '2024', 'Ausente', '2024-05-27'),
(5, 'Carlos Martin', '1', '2023', 'Tardanza', '2024-05-27'),
(6, 'Mario Montes', '1', '2024', 'Presente', '2024-05-31'),
(7, 'Carlos Martin', '1', '2023', 'Presente', '2024-05-31'),
(8, 'Mario Montes', '1', '2024', 'Presente', '2024-06-10'),
(9, 'Mario Montes', '1', '2024', 'Presente', '2024-06-10'),
(10, 'Carlos Martin', '1', '2024', 'Presente', '2024-06-10'),
(11, 'Mario Montes', '9', '2024', 'Presente', '2024-06-10'),
(12, 'Camila Ramos', '9', '2024', 'Presente', '2024-06-10'),
(13, 'Carlos Martin', '9', '2024', 'Presente', '2024-06-10'),
(16, 'Mario Montes', '1', '2024', 'Presente', '2024-06-16'),
(17, 'Carlos Martin', '1', '2024', 'Presente', '2024-06-16'),
(18, 'Camila Ramos', '1', '2024', 'Presente', '2024-06-16'),
(19, 'Carlos Quispe Mamani', '1', '2024', 'Presente', '2024-06-16'),
(22, 'Mario Montes', '9', '2024', 'Tardanza', '2024-06-23'),
(23, 'Carlos Martin', '9', '2024', 'Tardanza', '2024-06-23'),
(24, 'Mario Montes', '9', '2024', 'Presente', '2024-06-23'),
(25, 'Carlos Martin', '9', '2024', 'Presente', '2024-06-23'),
(26, 'Camila Ramos', '9', '2024', 'Tardanza', '2024-06-23'),
(27, 'Carlos Quispe Mamani', '9', '2024', 'Tardanza', '2024-06-23'),
(28, 'Mario Montes', '1', '2024', 'Presente', '2024-06-23'),
(29, 'Carlos Martin', '1', '2024', 'Presente', '2024-06-23'),
(30, 'Mario Montes', '1', '2024', 'Presente', '2024-07-01'),
(31, 'Carlos Martin', '1', '2024', 'Presente', '2024-07-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE `aulas` (
  `ID_Aula` int(11) NOT NULL,
  `Grado` varchar(255) DEFAULT NULL,
  `Sección` varchar(255) DEFAULT NULL,
  `Horas` varchar(11) DEFAULT NULL,
  `Disponibilidad` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`ID_Aula`, `Grado`, `Sección`, `Horas`, `Disponibilidad`) VALUES
(1, '1ro', 'A', '5', 'N'),
(2, '1ro', 'B', '5', 'N'),
(3, '1ro', 'C', '5', 'S'),
(4, '1ro', 'D', '5', 'S'),
(5, '2do', 'A', '5', 'N'),
(6, '2do', 'B', '5', 'N'),
(7, '2do', 'C', '5', 'S'),
(8, '2do', 'D', '5', 'S'),
(9, 'ALL', 'ALL', '5', 'N'),
(10, 'ALL', 'ALL', '5', 'S'),
(11, 'ALL', 'ALL', '5', 'S'),
(12, 'ALL', 'ALL', '5', 'S');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `ID_Curso` int(11) NOT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Descripción` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`ID_Curso`, `Nombre`, `Descripción`) VALUES
(1, 'MATEMATICA', 'Este curso abarca conceptos fundamentales de matemáticas, incluyendo aritmética, álgebra, geometría y cálculo. Los estudiantes desarrollarán habilidades de razonamiento lógico y resolución de problemas.'),
(2, 'COMUNICACION', 'En este curso, los estudiantes mejorarán sus habilidades de lectura, escritura, expresión oral y comprensión auditiva. Se enfoca en la comunicación efectiva y el análisis crítico de textos.'),
(3, 'PERSONAL SOCIAL', 'Este curso explora las relaciones interpersonales y el desarrollo personal. Los estudiantes aprenderán sobre valores, ética, ciudadanía y habilidades sociales necesarias para la vida en sociedad.'),
(4, 'CIENCIA Y TECNOLOGIA', 'Este curso introduce a los estudiantes a los principios básicos de las ciencias naturales y la tecnología. Incluye temas de biología, química, física y el impacto de la tecnología en la sociedad.'),
(5, 'ARTE Y CULTURA', 'En este curso, los estudiantes explorarán diversas formas de expresión artística y su impacto cultural. Incluye historia del arte, música, teatro, y artes visuales, fomentando la creatividad y apreciación cultural.'),
(6, 'EDUCACION FISICA', ' los alumnos realizaran deportes'),
(7, 'INGLES', 'curso de ingles - english abc');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente_curso`
--

CREATE TABLE `docente_curso` (
  `ID_DocenteCurso` int(11) NOT NULL,
  `ID_Docente` int(11) DEFAULT NULL,
  `ID_Curso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `docente_curso`
--

INSERT INTO `docente_curso` (`ID_DocenteCurso`, `ID_Docente`, `ID_Curso`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 2, 1),
(7, 2, 2),
(8, 3, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `ID_Horario` int(11) NOT NULL,
  `ID_Docente` int(11) NOT NULL,
  `hora` varchar(100) NOT NULL,
  `lunesCurso` varchar(100) NOT NULL,
  `lunesAula` varchar(100) NOT NULL,
  `martesCurso` varchar(100) NOT NULL,
  `martesAula` varchar(100) NOT NULL,
  `miercolesCurso` varchar(100) NOT NULL,
  `miercolesAula` varchar(100) NOT NULL,
  `juevesCurso` varchar(100) NOT NULL,
  `juevesAula` varchar(100) NOT NULL,
  `viernesCurso` varchar(100) NOT NULL,
  `viernesAula` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`ID_Horario`, `ID_Docente`, `hora`, `lunesCurso`, `lunesAula`, `martesCurso`, `martesAula`, `miercolesCurso`, `miercolesAula`, `juevesCurso`, `juevesAula`, `viernesCurso`, `viernesAula`) VALUES
(1, 1, '7:45 - 8:30', 'COMUNICACION', '1ro - A', 'MATEMATICA', '1ro - A', 'COMUNICACION', '1ro - A', 'MATEMATICA', '1ro - A', 'Vacío', 'Vacío'),
(2, 1, '8:30 - 9:15', 'COMUNICACION', '1ro - A', 'MATEMATICA', '1ro - A', 'COMUNICACION', '1ro - A', 'MATEMATICA', '1ro - A', 'Vacío', 'Vacío'),
(3, 1, '9:15 - 10:00', 'COMUNICACION', '1ro - A', 'MATEMATICA', '1ro - A', 'COMUNICACION', '1ro - A', 'Vacío', 'Vacío', 'PERSONAL SOCIAL', '1ro - A'),
(4, 3, '7:45 - 8:30', 'EDUCACION FISICA', '1ro - B', 'Vacío', 'Vacío', 'Vacío', 'Vacío', 'EDUCACION FISICA', '1ro - B', 'Vacío', 'Vacío'),
(5, 3, '8:30 - 9:15', 'EDUCACION FISICA', '1ro - B', 'Vacío', 'Vacío', 'EDUCACION FISICA', '1ro - A', 'Vacío', 'Vacío', 'Vacío', 'Vacío');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE `nota` (
  `ID_Nota` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Curso` varchar(100) NOT NULL,
  `Bimestre` varchar(100) NOT NULL,
  `Nota` decimal(5,2) NOT NULL,
  `ID_Aula` int(11) NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `nota`
--

INSERT INTO `nota` (`ID_Nota`, `Nombre`, `Curso`, `Bimestre`, `Nota`, `ID_Aula`, `Fecha`) VALUES
(1, 'Mario Montes', 'ARTE Y CULTURA', '1', 16.00, 1, '2024-06-24 00:19:24'),
(2, 'Carlos Martin', 'ARTE Y CULTURA', '1', 16.00, 1, '2024-06-24 00:19:24'),
(5, 'Mario Montes', 'EDUCACION FISICA', '1', 17.00, 9, '2024-06-24 04:03:26'),
(6, 'Carlos Martin', 'EDUCACION FISICA', '1', 16.00, 9, '2024-06-24 04:03:26'),
(7, 'Camila Ramos', 'EDUCACION FISICA', '1', 17.00, 9, '2024-06-24 04:03:47'),
(8, 'Carlos Quispe Mamani', 'EDUCACION FISICA', '1', 17.00, 9, '2024-06-24 04:03:47'),
(9, 'Mario Montes', 'ARTE Y CULTURA', '2', 15.00, 1, '2024-06-24 10:48:53'),
(10, 'Carlos Martin', 'ARTE Y CULTURA', '2', 18.00, 1, '2024-06-24 10:48:53'),
(11, 'Mario Montes', 'EDUCACION FISICA', '2', 7.00, 9, '2024-06-24 10:52:35'),
(12, 'Carlos Martin', 'EDUCACION FISICA', '2', 6.00, 9, '2024-06-24 10:52:35'),
(13, 'Camila Ramos', 'EDUCACION FISICA', '2', 18.00, 9, '2024-06-24 10:52:53'),
(14, 'Carlos Quispe Mamani', 'EDUCACION FISICA', '2', 16.00, 9, '2024-06-24 10:52:53'),
(17, 'Mario Montes', 'ARTE Y CULTURA', '3', 5.00, 1, '2024-07-01 13:36:19'),
(18, 'Carlos Martin', 'ARTE Y CULTURA', '3', 4.00, 1, '2024-07-01 13:36:19'),
(19, 'Mario Montes', 'PERSONAL SOCIAL', '1', 19.00, 1, '2024-07-07 23:31:31'),
(20, 'Carlos Martin', 'PERSONAL SOCIAL', '1', 18.00, 1, '2024-07-07 23:31:31'),
(21, 'Mario Montes', 'PERSONAL SOCIAL', '2', 3.00, 1, '2024-07-08 05:59:56'),
(22, 'Carlos Martin', 'PERSONAL SOCIAL', '2', 14.00, 1, '2024-07-08 05:59:57'),
(23, 'Mario Montes', 'PERSONAL SOCIAL', '3', 3.00, 1, '2024-07-08 06:00:14'),
(24, 'Carlos Martin', 'PERSONAL SOCIAL', '3', 17.00, 1, '2024-07-08 06:00:14');

--
-- Disparadores `nota`
--
DELIMITER $$
CREATE TRIGGER `actualizar_promedio_bimestre_delete` AFTER DELETE ON `nota` FOR EACH ROW BEGIN
    DECLARE promedio DECIMAL(5,2);

    -- Calcular el nuevo promedio por bimestre
    SELECT AVG(Nota) INTO promedio
    FROM nota
    WHERE Nombre = OLD.Nombre
      AND Curso = OLD.Curso
      AND Bimestre = OLD.Bimestre
      AND ID_Aula = OLD.ID_Aula;

    -- Si el promedio es NULL, significa que no hay más notas, entonces eliminamos la entrada en 'nota_prombi'
    IF promedio IS NULL THEN
        DELETE FROM nota_prombi
        WHERE Nombre = OLD.Nombre
          AND Curso = OLD.Curso
          AND Bimestre = OLD.Bimestre
          AND ID_Aula = OLD.ID_Aula;
    ELSE
        -- Actualizar el promedio en la tabla 'nota_prombi'
        UPDATE nota_prombi
        SET Promedio = promedio
        WHERE Nombre = OLD.Nombre
          AND Curso = OLD.Curso
          AND Bimestre = OLD.Bimestre
          AND ID_Aula = OLD.ID_Aula;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `actualizar_promedio_bimestre_insert` AFTER INSERT ON `nota` FOR EACH ROW BEGIN
    DECLARE promedio DECIMAL(5,2);

    -- Calcular el nuevo promedio por bimestre
    SELECT AVG(Nota) INTO promedio
    FROM nota
    WHERE Nombre = NEW.Nombre
      AND Curso = NEW.Curso
      AND Bimestre = NEW.Bimestre
      AND ID_Aula = NEW.ID_Aula;

    -- Actualizar o insertar en la tabla 'nota_prombi'
    INSERT INTO nota_prombi (Nombre, Curso, Promedio, Bimestre, ID_Aula)
    VALUES (NEW.Nombre, NEW.Curso, promedio, NEW.Bimestre, NEW.ID_Aula)
    ON DUPLICATE KEY UPDATE
        Promedio = VALUES(Promedio);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `actualizar_promedio_bimestre_update` AFTER UPDATE ON `nota` FOR EACH ROW BEGIN
    DECLARE promedio DECIMAL(5,2);

    -- Calcular el nuevo promedio por bimestre
    SELECT AVG(Nota) INTO promedio
    FROM nota
    WHERE Nombre = NEW.Nombre
      AND Curso = NEW.Curso
      AND Bimestre = NEW.Bimestre
      AND ID_Aula = NEW.ID_Aula;

    -- Actualizar el promedio en la tabla 'nota_prombi'
    UPDATE nota_prombi
    SET Promedio = promedio
    WHERE Nombre = NEW.Nombre
      AND Curso = NEW.Curso
      AND Bimestre = NEW.Bimestre
      AND ID_Aula = NEW.ID_Aula;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `actualizar_promedio_global_delete` AFTER DELETE ON `nota` FOR EACH ROW BEGIN
    DECLARE promedio DECIMAL(5,2);

    -- Calcular el nuevo promedio global
    SELECT AVG(Nota) INTO promedio
    FROM nota
    WHERE Nombre = OLD.Nombre
      AND Curso = OLD.Curso
      AND ID_Aula = OLD.ID_Aula;

    -- Si el promedio es NULL, significa que no hay más notas, entonces eliminamos la entrada en 'nota_prom'
    IF promedio IS NULL THEN
        DELETE FROM nota_prom
        WHERE Nombre = OLD.Nombre
          AND Curso = OLD.Curso
          AND ID_Aula = OLD.ID_Aula;
    ELSE
        -- Actualizar el promedio en la tabla 'nota_prom'
        UPDATE nota_prom
        SET Promedio = promedio
        WHERE Nombre = OLD.Nombre
          AND Curso = OLD.Curso
          AND ID_Aula = OLD.ID_Aula;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `actualizar_promedio_global_insert` AFTER INSERT ON `nota` FOR EACH ROW BEGIN
    DECLARE promedio DECIMAL(5,2);

    -- Calcular el nuevo promedio global
    SELECT AVG(Nota) INTO promedio
    FROM nota
    WHERE Nombre = NEW.Nombre
      AND Curso = NEW.Curso
      AND ID_Aula = NEW.ID_Aula;

    -- Actualizar o insertar en la tabla 'nota_prom'
    INSERT INTO nota_prom (Nombre, Curso, Promedio, ID_Aula)
    VALUES (NEW.Nombre, NEW.Curso, promedio, NEW.ID_Aula)
    ON DUPLICATE KEY UPDATE
        Promedio = VALUES(Promedio);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `actualizar_promedio_global_update` AFTER UPDATE ON `nota` FOR EACH ROW BEGIN
    DECLARE promedio DECIMAL(5,2);

    -- Calcular el nuevo promedio global
    SELECT AVG(Nota) INTO promedio
    FROM nota
    WHERE Nombre = NEW.Nombre
      AND Curso = NEW.Curso
      AND ID_Aula = NEW.ID_Aula;

    -- Actualizar el promedio en la tabla 'nota_prom'
    UPDATE nota_prom
    SET Promedio = promedio
    WHERE Nombre = NEW.Nombre
      AND Curso = NEW.Curso
      AND ID_Aula = NEW.ID_Aula;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota_prom`
--

CREATE TABLE `nota_prom` (
  `ID_Prom` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Curso` varchar(100) NOT NULL,
  `Promedio` decimal(5,2) NOT NULL,
  `ID_Aula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `nota_prom`
--

INSERT INTO `nota_prom` (`ID_Prom`, `Nombre`, `Curso`, `Promedio`, `ID_Aula`) VALUES
(1, 'Mario Montes', 'ARTE Y CULTURA', 12.00, 1),
(2, 'Carlos Martin', 'ARTE Y CULTURA', 12.67, 1),
(5, 'Mario Montes', 'EDUCACION FISICA', 12.00, 9),
(6, 'Carlos Martin', 'EDUCACION FISICA', 11.00, 9),
(7, 'Camila Ramos', 'EDUCACION FISICA', 17.50, 9),
(8, 'Carlos Quispe Mamani', 'EDUCACION FISICA', 16.50, 9),
(19, 'Mario Montes', 'PERSONAL SOCIAL', 8.33, 1),
(20, 'Carlos Martin', 'PERSONAL SOCIAL', 16.33, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota_prombi`
--

CREATE TABLE `nota_prombi` (
  `ID_PromBI` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Curso` varchar(100) NOT NULL,
  `Promedio` decimal(5,2) NOT NULL,
  `Bimestre` varchar(100) NOT NULL,
  `ID_Aula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `nota_prombi`
--

INSERT INTO `nota_prombi` (`ID_PromBI`, `Nombre`, `Curso`, `Promedio`, `Bimestre`, `ID_Aula`) VALUES
(1, 'Mario Montes', 'ARTE Y CULTURA', 16.00, '1', 1),
(2, 'Carlos Martin', 'ARTE Y CULTURA', 16.00, '1', 1),
(5, 'Mario Montes', 'EDUCACION FISICA', 17.00, '1', 9),
(6, 'Carlos Martin', 'EDUCACION FISICA', 16.00, '1', 9),
(7, 'Camila Ramos', 'EDUCACION FISICA', 17.00, '1', 9),
(8, 'Carlos Quispe Mamani', 'EDUCACION FISICA', 17.00, '1', 9),
(9, 'Mario Montes', 'ARTE Y CULTURA', 15.00, '2', 1),
(10, 'Carlos Martin', 'ARTE Y CULTURA', 18.00, '2', 1),
(11, 'Mario Montes', 'EDUCACION FISICA', 7.00, '2', 9),
(12, 'Carlos Martin', 'EDUCACION FISICA', 6.00, '2', 9),
(13, 'Camila Ramos', 'EDUCACION FISICA', 18.00, '2', 9),
(14, 'Carlos Quispe Mamani', 'EDUCACION FISICA', 16.00, '2', 9),
(17, 'Mario Montes', 'ARTE Y CULTURA', 5.00, '3', 1),
(18, 'Carlos Martin', 'ARTE Y CULTURA', 4.00, '3', 1),
(19, 'Mario Montes', 'PERSONAL SOCIAL', 19.00, '1', 1),
(20, 'Carlos Martin', 'PERSONAL SOCIAL', 18.00, '1', 1),
(21, 'Mario Montes', 'PERSONAL SOCIAL', 3.00, '2', 1),
(22, 'Carlos Martin', 'PERSONAL SOCIAL', 14.00, '2', 1),
(23, 'Mario Montes', 'PERSONAL SOCIAL', 3.00, '3', 1),
(24, 'Carlos Martin', 'PERSONAL SOCIAL', 17.00, '3', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`ID_Administrador`);

--
-- Indices de la tabla `administrar_docente`
--
ALTER TABLE `administrar_docente`
  ADD PRIMARY KEY (`ID_Docente`),
  ADD KEY `FK_administrar_docente_aulas` (`Aula`);

--
-- Indices de la tabla `administrar_estudiante`
--
ALTER TABLE `administrar_estudiante`
  ADD PRIMARY KEY (`ID_Estudiante`),
  ADD KEY `fk_aula` (`Aula`);

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`ID_Estudiante`,`Fecha`);

--
-- Indices de la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD PRIMARY KEY (`ID_Aula`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`ID_Curso`);

--
-- Indices de la tabla `docente_curso`
--
ALTER TABLE `docente_curso`
  ADD PRIMARY KEY (`ID_DocenteCurso`),
  ADD KEY `ID_Docente` (`ID_Docente`),
  ADD KEY `ID_Curso` (`ID_Curso`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`ID_Horario`),
  ADD KEY `fk_IDdocente` (`ID_Docente`);

--
-- Indices de la tabla `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`ID_Nota`),
  ADD KEY `fk_ID_Aula` (`ID_Aula`);

--
-- Indices de la tabla `nota_prom`
--
ALTER TABLE `nota_prom`
  ADD PRIMARY KEY (`ID_Prom`),
  ADD UNIQUE KEY `unique_prom` (`Nombre`,`Curso`,`ID_Aula`);

--
-- Indices de la tabla `nota_prombi`
--
ALTER TABLE `nota_prombi`
  ADD PRIMARY KEY (`ID_PromBI`),
  ADD UNIQUE KEY `unique_prombi` (`Nombre`,`Curso`,`Bimestre`,`ID_Aula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `ID_Administrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `administrar_docente`
--
ALTER TABLE `administrar_docente`
  MODIFY `ID_Docente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `administrar_estudiante`
--
ALTER TABLE `administrar_estudiante`
  MODIFY `ID_Estudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `ID_Estudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de la tabla `aulas`
--
ALTER TABLE `aulas`
  MODIFY `ID_Aula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `ID_Curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `docente_curso`
--
ALTER TABLE `docente_curso`
  MODIFY `ID_DocenteCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `ID_Horario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `nota`
--
ALTER TABLE `nota`
  MODIFY `ID_Nota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de la tabla `nota_prom`
--
ALTER TABLE `nota_prom`
  MODIFY `ID_Prom` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de la tabla `nota_prombi`
--
ALTER TABLE `nota_prombi`
  MODIFY `ID_PromBI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrar_docente`
--
ALTER TABLE `administrar_docente`
  ADD CONSTRAINT `FK_administrar_docente_aulas` FOREIGN KEY (`Aula`) REFERENCES `aulas` (`ID_Aula`);

--
-- Filtros para la tabla `administrar_estudiante`
--
ALTER TABLE `administrar_estudiante`
  ADD CONSTRAINT `fk_aula` FOREIGN KEY (`Aula`) REFERENCES `aulas` (`ID_Aula`);

--
-- Filtros para la tabla `docente_curso`
--
ALTER TABLE `docente_curso`
  ADD CONSTRAINT `docente_curso_ibfk_1` FOREIGN KEY (`ID_Docente`) REFERENCES `administrar_docente` (`ID_Docente`),
  ADD CONSTRAINT `docente_curso_ibfk_2` FOREIGN KEY (`ID_Curso`) REFERENCES `curso` (`ID_Curso`);

--
-- Filtros para la tabla `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `fk_IDdocente` FOREIGN KEY (`ID_Docente`) REFERENCES `administrar_docente` (`ID_Docente`);

--
-- Filtros para la tabla `nota`
--
ALTER TABLE `nota`
  ADD CONSTRAINT `fk_ID_Aula` FOREIGN KEY (`ID_Aula`) REFERENCES `aulas` (`ID_Aula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
