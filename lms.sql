-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2021 at 08:55 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

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
('32180018', 'Ferdy Nicolas', 's32180018@ubm.com');

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

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `student_name`, `student_class`, `student_major`) VALUES
('S-0001', 'Hendrik', '6PTI', 'IPA'),
('S-0015', 'Garvin Adrian', '6PTI', 'IPS'),
('S-0036', 'Muhammad Nur Salim', '6PTI', 'IPS'),
('S-0082', 'Jason Alexander', '6PTI', 'IPA'),
('S-0118', 'Ryan Nugraha', '6PTI', 'IPA');

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
('BKSL', 'Bimbingan Konseling', 'Umum', 40),
('EIPS', 'Ekonomi', 'IPS', 80),
('FIPA', 'Fisika', 'IPA', 80),
('GIPS', 'Geografi', 'IPS', 80),
('KIPA', 'Kimia', 'IPA', 80),
('KTIK', 'Komputer dan Teknologi Informasi', 'Umum', 80),
('MTKP', 'Matematika Pilihan', 'Umum', 40),
('MTKU', 'Matematika Umum', 'Umum', 80),
('ORKJ', 'Olahraga dan Kesehatan Jasmani', 'Umum', 80),
('PKWN', 'Pancasila & Kewarganegaraan', 'Umum', 80),
('SBDK', 'Seni Budaya dan Keterampilan', 'Umum', 40),
('SIPS', 'Sosiologi', 'IPS', 80),
('SJRH', 'Sejarah', 'Umum', 40),
('SNMK', 'Seni Musik', 'Umum', 80);

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
('T-0014', 'Jet J Krisnadi', 'EIPS'),
('T-0028', 'Byron Harnope', 'BKSL'),
('T-0033', 'Michael Freddy', 'KTIK'),
('T-0066', 'Felix Dermawan', 'AGET'),
('T-0074', 'Maikel', 'SBDK'),
('T-0075', 'Willy Stevanus Susilo', 'GIPS'),
('T-0076', 'Kalingga Karamitta Gunawan', 'SJRH'),
('T-0082', 'Jason Alexander', 'BIPA'),
('T-0084', 'Vincent', 'PKWN'),
('T-0086', 'Derry Leo Nardi', 'BIND'),
('T-0088', 'Jayaku Brilliantio', 'FIPA'),
('T-0091', 'Daniel Ronaldo Pangestu', 'BING'),
('T-0105', 'Fernando', 'MTKU'),
('T-0112', 'Arvin Christopher', 'SNMK'),
('T-0114', 'Kevin Hosea', 'MTKP'),
('T-0115', 'Daniel', 'KIPA'),
('T-0134', 'Martien Junaedi', 'ORKJ');

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
('32180018', 'ferdy', 'Admin'),
('S-0001', 'napadiam', 'Student'),
('S-0015', 'garvin', 'Student'),
('S-0036', 'salim', 'Student'),
('S-0082', 'jason', 'Student'),
('S-0118', 'yanu', 'Student'),
('T-0014', 'jet', 'Teacher'),
('T-0028', 'byron', 'Teacher'),
('T-0033', 'michael', 'Teacher'),
('T-0066', 'felix', 'Teacher'),
('T-0074', 'maikel', 'Teacher'),
('T-0075', 'willy', 'Teacher'),
('T-0076', 'kalingga', 'Teacher'),
('T-0082', 'jason', 'Teacher'),
('T-0084', 'vincent', 'Teacher'),
('T-0086', 'derry', 'Teacher'),
('T-0088', 'jayaku', 'Teacher'),
('T-0091', 'daniel', 'Teacher'),
('T-0105', 'genshin', 'Teacher'),
('T-0112', 'guppy', 'Teacher'),
('T-0114', 'cibai', 'Teacher'),
('T-0115', 'rajin', 'Teacher'),
('T-0134', 'martien', 'Teacher');

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
