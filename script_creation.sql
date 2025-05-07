-- -- -- -- -- -- -- -- -- --
CREATE TABLE `role` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `name` varchar(25) NOT NULL,

    PRIMARY KEY (`id`),

    UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `country` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `name` varchar(25) NOT NULL,

    PRIMARY KEY (`id`),

    UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `city` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `zipCode` int NOT NULL,
    `name` varchar(25) NOT NULL,
    `idCountry` char(36) DEFAULT NULL,

    PRIMARY KEY (`id`),

    UNIQUE KEY `zipCode` (`zipCode`),

    KEY `idCountry` (`idCountry`),

    CONSTRAINT `FK_CITY_COUNTRY` FOREIGN KEY (`idCountry`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `employee` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `firstName` varchar(25) NOT NULL,
    `lastName` varchar(25) NOT NULL,
    `password` blob NOT NULL,
    `isActive` tinyint(1) NOT NULL DEFAULT '1',
    `street` varchar(50) NOT NULL,
    `streetNumber` int NOT NULL,
    `unitNumber` int DEFAULT NULL,
    `hireDate` date NOT NULL,
    `idRole` char(36) DEFAULT NULL,
    `idManager` char(36) DEFAULT NULL,
    `idCity` char(36) NOT NULL,

    PRIMARY KEY (`id`),

    KEY `idRole` (`idRole`),
    KEY `idManager` (`idManager`),
    KEY `idCity` (`idCity`),

    CONSTRAINT `FK_EMPLOYEE_ROLE` FOREIGN KEY (`idRole`) REFERENCES `role` (`id`),
    CONSTRAINT `FK_EMPLOYEE_EMPLOYEE` FOREIGN KEY (`idManager`) REFERENCES `employee` (`id`),
    CONSTRAINT `FK_EMPLOYEE_CITY` FOREIGN KEY (`idCity`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `customer` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `loyaltyCardNumber` int NOT NULL,
    `firstName` varchar(25) NOT NULL,
    `lastName` varchar(25) NOT NULL,
    `birthDate` date NOT NULL,
    `email` varchar(50) NOT NULL,
    `phone` varchar(50) DEFAULT NULL,
    `loyaltyPoints` int NOT NULL DEFAULT '0',

    PRIMARY KEY (`id`),

    UNIQUE KEY `loyaltyCardNumber` (`loyaltyCardNumber`),
    UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `purchase` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `date` date NOT NULL,
    `idEmployee` char(36) DEFAULT NULL,
    `idCustomer` char(36) DEFAULT NULL,

    PRIMARY KEY (`id`),

    KEY `idEmployee` (`idEmployee`),
    KEY `idCustomer` (`idCustomer`),

    CONSTRAINT `FK_PURCHASE_EMPLOYEE` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`id`),
    CONSTRAINT `FK_PURCHASE_CUSTOMER` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `brand` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `name` varchar(25) NOT NULL,

    PRIMARY KEY (`id`),

    UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `category` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `name` varchar(25) NOT NULL,

    PRIMARY KEY (`id`),

    UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `vat` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `type` varchar(1) NOT NULL,
    `rate` int NOT NULL,

    PRIMARY KEY (`id`),

    UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `product` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `barcode` int NOT NULL,
    `name` varchar(50) NOT NULL,
    `description` varchar(255) DEFAULT NULL,
    `basePrice` int NOT NULL,
    `isAvailable` tinyint(1) NOT NULL DEFAULT '1',
    `idVAT` char(36) DEFAULT NULL,
    `idCategory` char(36) DEFAULT NULL,
    `idBrand` char(36) DEFAULT NULL,

    PRIMARY KEY (`id`),

    UNIQUE KEY `barcode` (`barcode`),

    KEY `idVAT` (`idVAT`),
    KEY `idCategory` (`idCategory`),
    KEY `idBrand` (`idBrand`),

    CONSTRAINT `FK_PRODUCT_VAT` FOREIGN KEY (`idVAT`) REFERENCES `vat` (`id`),
    CONSTRAINT `FK_PRODUCT_CATEGORY` FOREIGN KEY (`idCategory`) REFERENCES `category` (`id`),
    CONSTRAINT `FK_PRODUCT_BRAND` FOREIGN KEY (`idBrand`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --

-- -- -- -- -- -- -- -- -- --
CREATE TABLE `order_line` (
    `id` char(36) NOT NULL DEFAULT (uuid()),
    `quantity` int NOT NULL,
    `idProduct` char(36) DEFAULT NULL,
    `idPurchase` char(36) DEFAULT NULL,

    PRIMARY KEY (`id`),

    KEY `idProduct` (`idProduct`),
    KEY `idPurchase` (`idPurchase`),

    CONSTRAINT `FK_ORDER_LINE_PRODUCT` FOREIGN KEY (`idProduct`) REFERENCES `product` (`id`),
    CONSTRAINT `FK_ORDER_LINE_PURCHASE` FOREIGN KEY (`idPurchase`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
-- -- -- -- -- -- -- -- -- --
