-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2021 at 10:04 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` varchar(10) NOT NULL,
  `admin_name` varchar(50) DEFAULT NULL,
  `admin_contact` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_name`, `admin_contact`) VALUES
('001', 'Jaya', 'Jayaku.com'),
('542534', '65', '456456'),
('ferdy2', 'ferdy', 'over there');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` varchar(10) NOT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `student_class` varchar(10) DEFAULT NULL,
  `student_major` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` varchar(10) NOT NULL,
  `subject_name` varchar(50) DEFAULT NULL,
  `subject_major` varchar(30) DEFAULT NULL,
  `subject_minute` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `subject_name`, `subject_major`, `subject_minute`) VALUES
('AGET', 'Agama dan Etika', 'Umum', 40),
('BIND', 'Bahasa Indonesia', 'Umum', 80),
('BING', 'Bahasa Inggiris', 'Umum', 40),
('BIPA', 'Biologi', 'IPA', 80),
('EIPS', 'Ekonomi', 'IPS', 80),
('FIPA', 'Fisika', 'IPA', 80),
('GIPS', 'Geografi', 'IPS', 80),
('KIPA', 'Kimia', 'IPA', 80),
('KTIK', 'Komputer dan Teknologi Informasi', 'Umum', 80),
('MTKP', 'Matematika Pilihan', 'Umum', 40),
('MTKU', 'Matematika Umum', 'Umum', 80),
('ORKJ', 'Olahraga dan Kesehatan Jasmani', 'Umum', 80),
('SBDK', 'Seni Budaya dan Keterampilan', 'Umum', 40),
('SIPS', 'Sosiologi', 'IPS', 80),
('SJRH', 'Sejarah', 'Umum', 40);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` varchar(10) NOT NULL,
  `teacher_name` varchar(50) DEFAULT NULL,
  `teacher_subject` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `teacher_name`, `teacher_subject`) VALUES
('765765', 'Derry Leo Nardi', 'SIPS'),
('Daniel', 'Daniel Ronaldo', 'MTKU'),
('felir', 'Felix Dermawan', 'AGET'),
('jinto', 'Jayaku Brilliantio', 'EIPS');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(10) NOT NULL,
  `password` text DEFAULT NULL,
  `role` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `role`) VALUES
('001', 'jayaku', 'Admin'),
('542534', '546456', 'Admin'),
('765765', '123', 'Teacher'),
('Daniel', '123', 'Teacher'),
('felir', 'dewa', 'Teacher'),
('Ferdy', '123', 'Student'),
('ferdy2', '123', 'Admin'),
('ferdy3', '123', 'Teacher'),
('jayaku', '123', 'Teacher'),
('jinto', 'dogecoin', 'Teacher');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`),
  ADD KEY `teacher_subject` (`teacher_subject`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`teacher_subject`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
