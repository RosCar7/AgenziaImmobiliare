-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: localhost    Database: agenzia_immobiliare
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agenzia`
--

DROP TABLE IF EXISTS `agenzia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenzia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `indirizzo` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `versione` int NOT NULL,
  `data_creazione` datetime NOT NULL,
  `data_ultima_modifica` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenzia`
--

LOCK TABLES `agenzia` WRITE;
/*!40000 ALTER TABLE `agenzia` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenzia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agenzia_seq`
--

DROP TABLE IF EXISTS `agenzia_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenzia_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenzia_seq`
--

LOCK TABLES `agenzia_seq` WRITE;
/*!40000 ALTER TABLE `agenzia_seq` DISABLE KEYS */;
INSERT INTO `agenzia_seq` VALUES (1);
/*!40000 ALTER TABLE `agenzia_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `indirizzo` varchar(45) NOT NULL,
  `versione` int NOT NULL,
  `data_creazione` datetime NOT NULL,
  `data_ultima_modifica` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_seq`
--

DROP TABLE IF EXISTS `cliente_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_seq`
--

LOCK TABLES `cliente_seq` WRITE;
/*!40000 ALTER TABLE `cliente_seq` DISABLE KEYS */;
INSERT INTO `cliente_seq` VALUES (1);
/*!40000 ALTER TABLE `cliente_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proprieta`
--

DROP TABLE IF EXISTS `proprieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proprieta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `indirizzo` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `stanze` int NOT NULL,
  `prezzo` decimal(10,2) NOT NULL,
  `id_agenzia` bigint NOT NULL,
  `versione` int NOT NULL,
  `data_creazione` datetime NOT NULL,
  `data_ultima_modifica` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK58kegisjq9592acb11e5fpdl1` (`id_agenzia`),
  CONSTRAINT `FK58kegisjq9592acb11e5fpdl1` FOREIGN KEY (`id_agenzia`) REFERENCES `agenzia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proprieta`
--

LOCK TABLES `proprieta` WRITE;
/*!40000 ALTER TABLE `proprieta` DISABLE KEYS */;
/*!40000 ALTER TABLE `proprieta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proprieta_seq`
--

DROP TABLE IF EXISTS `proprieta_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proprieta_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proprieta_seq`
--

LOCK TABLES `proprieta_seq` WRITE;
/*!40000 ALTER TABLE `proprieta_seq` DISABLE KEYS */;
INSERT INTO `proprieta_seq` VALUES (1);
/*!40000 ALTER TABLE `proprieta_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transazione`
--

DROP TABLE IF EXISTS `transazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transazione` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `importo` decimal(10,2) NOT NULL,
  `descrizione` varchar(45) NOT NULL,
  `id_cliente` bigint NOT NULL,
  `versione` int NOT NULL,
  `data_creazione` datetime NOT NULL,
  `data_ultima_modifica` datetime NOT NULL,
  `id_proprieta` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoxcq6dfwviyn9vvcu0frl36ef` (`id_cliente`),
  KEY `FKc9e8u39rpopdnsybk6urr64wn` (`id_proprieta`),
  CONSTRAINT `FKc9e8u39rpopdnsybk6urr64wn` FOREIGN KEY (`id_proprieta`) REFERENCES `proprieta` (`id`),
  CONSTRAINT `FKoxcq6dfwviyn9vvcu0frl36ef` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transazione`
--

LOCK TABLES `transazione` WRITE;
/*!40000 ALTER TABLE `transazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `transazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transazione_seq`
--

DROP TABLE IF EXISTS `transazione_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transazione_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transazione_seq`
--

LOCK TABLES `transazione_seq` WRITE;
/*!40000 ALTER TABLE `transazione_seq` DISABLE KEYS */;
INSERT INTO `transazione_seq` VALUES (1);
/*!40000 ALTER TABLE `transazione_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visita`
--

DROP TABLE IF EXISTS `visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visita` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `durata` int NOT NULL,
  `id_cliente` bigint NOT NULL,
  `versione` int NOT NULL,
  `data_creazione` datetime NOT NULL,
  `data_ultima_modifica` datetime NOT NULL,
  `id_proprieta` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhfdbv2c4l4lkohc5kirbpje2q` (`id_cliente`),
  KEY `FKlb6v719tafqcduf2m5khftm1g` (`id_proprieta`),
  CONSTRAINT `FKhfdbv2c4l4lkohc5kirbpje2q` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKlb6v719tafqcduf2m5khftm1g` FOREIGN KEY (`id_proprieta`) REFERENCES `proprieta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visita`
--

LOCK TABLES `visita` WRITE;
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visita_seq`
--

DROP TABLE IF EXISTS `visita_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visita_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visita_seq`
--

LOCK TABLES `visita_seq` WRITE;
/*!40000 ALTER TABLE `visita_seq` DISABLE KEYS */;
INSERT INTO `visita_seq` VALUES (1);
/*!40000 ALTER TABLE `visita_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-15 15:30:58
