-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2020 at 11:34 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `youcodetalents`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `id` bigint(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`id`, `first_name`, `last_name`, `email`, `phone`, `password`) VALUES
(15970010, 'Ahmed', 'Mahmoud', 'ahmed.mahmoud.admin@gmail.com', '+212 6 00 00 00 00', '123123');

-- --------------------------------------------------------

--
-- Table structure for table `adminsession`
--

CREATE TABLE `adminsession` (
  `id` bigint(255) NOT NULL,
  `id_administrator` bigint(255) NOT NULL,
  `is_connected` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminsession`
--

INSERT INTO `adminsession` (`id`, `id_administrator`, `is_connected`) VALUES
(1, 15970010, 1);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'La dance'),
(2, 'En chantant'),
(3, 'La scène'),
(4, 'La Comédie'),
(5, 'Calcul mental'),
(6, 'Le cube de Rubik');

-- --------------------------------------------------------

--
-- Table structure for table `participation`
--

CREATE TABLE `participation` (
  `id_user` bigint(255) NOT NULL,
  `id_category` bigint(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `show_start_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `show_end_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `attached_file` varchar(255) NOT NULL,
  `is_accepted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `participation`
--

INSERT INTO `participation` (`id_user`, `id_category`, `description`, `show_start_time`, `show_end_time`, `attached_file`, `is_accepted`) VALUES
(847055784, 6, 'azfafzf', '2020-12-17 16:08:32', '2020-12-17 16:09:19', 'c/file', 0),
(796385394, 2, 'adzzad', '2020-12-17 16:08:32', '2020-12-17 16:09:19', 'c/ddd', 0),
(607287295, 4, 'zefzef', '2020-12-17 16:10:05', '2020-12-17 16:10:05', 'c/ddd', 0),
(385384066, 1, 'walo', '2020-12-17 21:50:15', '2020-12-17 21:50:15', 'c://hh', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `phone`) VALUES
(59654751, 'anas', 'aaaa', 'aaa@aaa.com', '0659484738'),
(97361662, 'ana', 'ana', 'ana@ana.com', '0637485647'),
(120042117, 'anas', 'benz', 'anasbe@gma.com', '0627364536'),
(199070687, 'ach', 'ach', 'ach@ach.com', '0650505050'),
(385384066, 'anas', 'benziti', 'anasbenziti@gmail.com', '0600000000'),
(508676142, 'anas', 'anas', 'anas@anas.com', '0647384746'),
(526201504, 'anas', 'benz', 'anas@benz.com', '0618127283'),
(607287295, 'bbb', 'bbb', 'bb@bb.bb', '0612121221'),
(670356161, 'anas', 'benz', 'anas@ben.com', '0626373625'),
(796385394, 'aaa', 'aaa', 'aaa@aaa.com', '0600000000'),
(847055784, 'anas', 'anastest', 'anas@test.com', '0638494736');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `adminsession`
--
ALTER TABLE `adminsession`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_administrator` (`id_administrator`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `participation`
--
ALTER TABLE `participation`
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_category` (`id_category`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adminsession`
--
ALTER TABLE `adminsession`
  ADD CONSTRAINT `adminsession_ibfk_1` FOREIGN KEY (`id_administrator`) REFERENCES `administrator` (`id`);

--
-- Constraints for table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `participation_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
