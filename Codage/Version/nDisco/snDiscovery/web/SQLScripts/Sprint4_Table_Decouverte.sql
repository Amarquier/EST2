CREATE TABLE `decouverte` (
  `userPseudo` varchar(30) NOT NULL,
  `nomImage` varchar(100) NOT NULL,
  `chemin` varchar(30) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `canrefuser` (
  `userPseudo` varchar(30) NOT NULL,
  `nomImage` varchar(100) NOT NULL,
  `chemin` varchar(30) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `certitude` integer NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;