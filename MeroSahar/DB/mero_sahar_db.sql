-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 03:48 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mero_sahar_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `artical_tbl`
--

CREATE TABLE `artical_tbl` (
  `id` int(11) NOT NULL,
  `heading` varchar(50) NOT NULL,
  `subheading` varchar(50) DEFAULT NULL,
  `content` text,
  `locationid` int(11) NOT NULL,
  `photo` text,
  `date` date DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `tags` text,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artical_tbl`
--

INSERT INTO `artical_tbl` (`id`, `heading`, `subheading`, `content`, `locationid`, `photo`, `date`, `userid`, `tags`, `type`) VALUES
(21, 'kathmandu durbar square', 'durbar square', 'Kathmandu Durbar Square in front of the old royal palace of the former Kathmandu Kingdom is one of three Durbar Squares in the Kathmandu Valley in Nepal, all of which are UNESCO World Heritage Sites. Several buildings in the Square collapsed due to a major earthquake on 25 April 2015', 2, 'uploads\\Nepal-Kathmandu-Durbar-square-2w.jpg', '2019-11-30', 1, 'food', 'Documentary'),
(22, 'Bhaktapur Durbar Square', 'Durbar Square', 'Bhaktapur Durbar Square, is the royal palace of the old Bhaktapur Kingdom, 1,400 metres above sea level. It is a UNESCO World Heritage Site. The Bhaktapur Durbar Square is located in the current town of Bhaktapur, also known as Khwopa, which lies 13 km east of Kathmandu. ', 1, 'uploads\\bhaktapur.jpg', '2019-11-30', 1, 'view,food', 'promotion'),
(23, 'Boudha Stupa', 'Stupa', 'Boudhanath is a stupa in Kathmandu, Nepal. Located about 11 km from the center and northeastern outskirts of Kathmandu, the stupa\'s massive mandala makes it one of the largest spherical stupas in Nepal.', 2, 'uploads\\bauddha-sb-lt.jpeg', '2019-11-30', 3, 'mounten,view', 'promotion'),
(24, 'kathmandu', 'ktm', 'ktm', 2, 'uploads\\bauddha-sb-lt.jpeg', '2019-12-01', 1, 'mounten,view', 'promotion');

-- --------------------------------------------------------

--
-- Table structure for table `blog_tbl`
--

CREATE TABLE `blog_tbl` (
  `id` int(11) NOT NULL,
  `heading` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `locationid` int(11) NOT NULL,
  `photo` text NOT NULL,
  `date` date NOT NULL,
  `userid` int(11) NOT NULL,
  `tag` text NOT NULL,
  `expenses` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hotel_tbl`
--

CREATE TABLE `hotel_tbl` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `conatct` bigint(20) NOT NULL,
  `locationid` int(11) NOT NULL,
  `website` varchar(50) NOT NULL,
  `service` text NOT NULL,
  `rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `location_tabl`
--

CREATE TABLE `location_tabl` (
  `id` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `street` varchar(100) NOT NULL,
  `district` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location_tabl`
--

INSERT INTO `location_tabl` (`id`, `state`, `city`, `street`, `district`) VALUES
(1, 5, 'bhaktapur', 'byasi', 'bhaktapur'),
(2, 5, 'ktm', 'boudha', 'ktm');

-- --------------------------------------------------------

--
-- Table structure for table `review_tbl`
--

CREATE TABLE `review_tbl` (
  `id` int(11) NOT NULL,
  `articalid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `comment` text NOT NULL,
  `date` date NOT NULL,
  `likes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_tbl`
--

CREATE TABLE `user_tbl` (
  `id` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `locationid` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_tbl`
--

INSERT INTO `user_tbl` (`id`, `firstname`, `lastname`, `contact`, `locationid`, `email`, `password`) VALUES
(1, 'rukesh', 'basukala', 9808798884, 1, 'rukesh@gmail.com', '1234'),
(2, 'susan', 'koju', 9808798886, 2, 'susan@gmail.com', '1234'),
(3, 'ram', 'basu', 9808798881, 1, 'ram@gmail.com', '1234'),
(4, 'sita', 'duwal', 9808798882, 1, 'sita@gmail.com', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artical_tbl`
--
ALTER TABLE `artical_tbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `locationid` (`locationid`),
  ADD KEY `userid` (`userid`);

--
-- Indexes for table `blog_tbl`
--
ALTER TABLE `blog_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel_tbl`
--
ALTER TABLE `hotel_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `location_tabl`
--
ALTER TABLE `location_tabl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `review_tbl`
--
ALTER TABLE `review_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_tbl`
--
ALTER TABLE `user_tbl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artical_tbl`
--
ALTER TABLE `artical_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `blog_tbl`
--
ALTER TABLE `blog_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hotel_tbl`
--
ALTER TABLE `hotel_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `location_tabl`
--
ALTER TABLE `location_tabl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `review_tbl`
--
ALTER TABLE `review_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_tbl`
--
ALTER TABLE `user_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `artical_tbl`
--
ALTER TABLE `artical_tbl`
  ADD CONSTRAINT `artical_tbl_ibfk_1` FOREIGN KEY (`locationid`) REFERENCES `location_tabl` (`id`),
  ADD CONSTRAINT `artical_tbl_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user_tbl` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
