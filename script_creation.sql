-- -- -- -- -- -- -- -- -- --
CREATE TABLE `role` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `Name` varchar(25) NOT NULL,

    PRIMARY KEY (`Id`),

    UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `country` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `Name` varchar(25) NOT NULL,

    PRIMARY KEY (`Id`),

    UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `city` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `Zipcode` int NOT NULL,
    `Name` varchar(25) NOT NULL,
    `IdCountry` char(36) DEFAULT NULL,

    PRIMARY KEY (`Id`),

    UNIQUE KEY `Zipcode` (`Zipcode`),

    KEY `IdCountry` (`IdCountry`),

    CONSTRAINT `FK_CITY_COUNTRY` FOREIGN KEY (`IdCountry`) REFERENCES `country` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `employee` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `FirstName` varchar(25) NOT NULL,
    `LastName` varchar(25) NOT NULL,
    `Password` blob NOT NULL,
    `IsActive` tinyint(1) NOT NULL DEFAULT '1',
    `Street` varchar(50) NOT NULL,
    `StreetNumber` int NOT NULL,
    `UnitNumber` int DEFAULT NULL,
    `IdRole` char(36) DEFAULT NULL,
    `HireDate` date NOT NULL,
    `ManagerId` char(36) DEFAULT NULL,
    `CityId` char(36) NOT NULL,

    PRIMARY KEY (`Id`),

    KEY `IdRole` (`IdRole`),
    KEY `ManagerId` (`ManagerId`),
    KEY `CityId` (`CityId`),

    CONSTRAINT `FK_EMPLOYEE_ROLE` FOREIGN KEY (`IdRole`) REFERENCES `role` (`Id`),
    CONSTRAINT `FK_EMPLOYEE_EMPLOYEE` FOREIGN KEY (`ManagerId`) REFERENCES `employee` (`Id`),
    CONSTRAINT `FK_EMPLOYEE_CITY` FOREIGN KEY (`CityId`) REFERENCES `city` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `customer` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `LoyaltyCardNumber` int NOT NULL,
    `FirstName` varchar(25) NOT NULL,
    `LastName` varchar(25) NOT NULL,
    `BirthDate` date NOT NULL,
    `Email` varchar(50) NOT NULL,
    `Phone` varchar(50) DEFAULT NULL,
    `LoyaltyPoints` int NOT NULL DEFAULT '0',

    PRIMARY KEY (`Id`),

    UNIQUE KEY `LoyaltyCardNumber` (`LoyaltyCardNumber`),
    UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `purchase` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `Date` date NOT NULL,
    `IdEmployee` char(36) DEFAULT NULL,
    `IdCustomer` char(36) DEFAULT NULL,

    PRIMARY KEY (`Id`),

    KEY `IdEmployee` (`IdEmployee`),
    KEY `IdCustomer` (`IdCustomer`),

    CONSTRAINT `FK_PURCHASE_EMPLOYEE` FOREIGN KEY (`IdEmployee`) REFERENCES `employee` (`Id`),
    CONSTRAINT `FK_PURCHASE_CUSTOMER` FOREIGN KEY (`IdCustomer`) REFERENCES `customer` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `brand` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `Name` varchar(25) NOT NULL,

    PRIMARY KEY (`Id`),

    UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `category` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `Label` varchar(25) NOT NULL,

    PRIMARY KEY (`Id`),

    UNIQUE KEY `Label` (`Label`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `vat` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `Type` varchar(1) NOT NULL,
    `Rate` int NOT NULL,

    PRIMARY KEY (`Id`),

    UNIQUE KEY `Type` (`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `product` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `Barcode` int NOT NULL,
    `Name` varchar(50) NOT NULL,
    `Description` varchar(255) DEFAULT NULL,
    `BasePrice` int NOT NULL,
    `IsAvailable` tinyint(1) NOT NULL DEFAULT '1',
    `IdVAT` char(36) DEFAULT NULL,
    `IdCategory` char(36) DEFAULT NULL,
    `IdBrand` char(36) DEFAULT NULL,

    PRIMARY KEY (`Id`),

    UNIQUE KEY `Barcode` (`Barcode`),

    KEY `IdVAT` (`IdVAT`),
    KEY `IdCategory` (`IdCategory`),
    KEY `IdBrand` (`IdBrand`),

    CONSTRAINT `FK_PRODUCT_VAT` FOREIGN KEY (`IdVAT`) REFERENCES `vat` (`Id`),
    CONSTRAINT `FK_PRODUCT_CATEGORY` FOREIGN KEY (`IdCategory`) REFERENCES `category` (`Id`),
    CONSTRAINT `FK_PRODUCT_BRAND` FOREIGN KEY (`IdBrand`) REFERENCES `brand` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `order_line` (
    `Id` char(36) NOT NULL DEFAULT (uuid()),
    `Quantity` int NOT NULL,
    `IdProduct` char(36) DEFAULT NULL,
    `IdPurchase` char(36) DEFAULT NULL,

    PRIMARY KEY (`Id`),

    KEY `IdProduct` (`IdProduct`),
    KEY `IdPurchase` (`IdPurchase`),

    CONSTRAINT `FK_ORDER_LINE_PRODUCT` FOREIGN KEY (`IdProduct`) REFERENCES `product` (`Id`),
    CONSTRAINT `FK_ORDER_LINE_PURCHASE` FOREIGN KEY (`IdPurchase`) REFERENCES `purchase` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --
