-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.11-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- salon için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `salon` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `salon`;

-- tablo yapısı dökülüyor salon.alinan_egitim
CREATE TABLE IF NOT EXISTS `alinan_egitim` (
  `alinan_id` int(11) NOT NULL AUTO_INCREMENT,
  `egitim_id` int(11) NOT NULL DEFAULT 0,
  `uye_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`alinan_id`),
  KEY `alinan_egitim_id_fk` (`egitim_id`),
  KEY `alinan_uye_id_fk` (`uye_id`),
  CONSTRAINT `alinan_egitim_id_fk` FOREIGN KEY (`egitim_id`) REFERENCES `egitimler` (`egitim_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `alinan_uye_id_fk` FOREIGN KEY (`uye_id`) REFERENCES `uyeler` (`uye_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- salon.alinan_egitim: ~21 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `alinan_egitim` DISABLE KEYS */;
INSERT INTO `alinan_egitim` (`alinan_id`, `egitim_id`, `uye_id`) VALUES
	(1, 7, 3),
	(2, 9, 3),
	(3, 4, 4),
	(4, 4, 5),
	(5, 8, 5),
	(6, 10, 5),
	(7, 4, 2),
	(8, 5, 2),
	(9, 9, 2),
	(10, 10, 2),
	(11, 5, 6),
	(12, 7, 6),
	(13, 8, 6),
	(14, 5, 7),
	(15, 7, 7),
	(16, 10, 7),
	(17, 4, 8),
	(18, 8, 8),
	(19, 10, 8),
	(20, 4, 9),
	(21, 8, 9);
/*!40000 ALTER TABLE `alinan_egitim` ENABLE KEYS */;

-- tablo yapısı dökülüyor salon.bilgi_islem
CREATE TABLE IF NOT EXISTS `bilgi_islem` (
  `bilgi_id` int(11) NOT NULL AUTO_INCREMENT,
  `baslangic_tarih` varchar(250) NOT NULL DEFAULT '0',
  `bitis_tarih` varchar(250) NOT NULL DEFAULT '0',
  `uye_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`bilgi_id`),
  KEY `uye_id` (`uye_id`),
  CONSTRAINT `uye_id` FOREIGN KEY (`uye_id`) REFERENCES `uyeler` (`uye_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- salon.bilgi_islem: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `bilgi_islem` DISABLE KEYS */;
INSERT INTO `bilgi_islem` (`bilgi_id`, `baslangic_tarih`, `bitis_tarih`, `uye_id`) VALUES
	(1, '17.05.2020', '18.06.2020', 2),
	(2, '15.02.2020', '15.04.2020', 4),
	(4, '01.01.2020', '12.03.2020', 3);
/*!40000 ALTER TABLE `bilgi_islem` ENABLE KEYS */;

-- tablo yapısı dökülüyor salon.diyet_listesi
CREATE TABLE IF NOT EXISTS `diyet_listesi` (
  `diy_listesi_id` int(11) NOT NULL AUTO_INCREMENT,
  `gramaj` varchar(250) NOT NULL DEFAULT '0',
  `saat_araligi` varchar(500) NOT NULL DEFAULT '0',
  `yemek_ismi` varchar(250) NOT NULL DEFAULT '0',
  `egitim_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`diy_listesi_id`),
  KEY `diy_egitim_id_fk` (`egitim_id`),
  CONSTRAINT `diy_egitim_id_fk` FOREIGN KEY (`egitim_id`) REFERENCES `egitimler` (`egitim_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- salon.diyet_listesi: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `diyet_listesi` DISABLE KEYS */;
INSERT INTO `diyet_listesi` (`diy_listesi_id`, `gramaj`, `saat_araligi`, `yemek_ismi`, `egitim_id`) VALUES
	(1, '250 Gram', 'Sabah Kahvaltısı 11.00-12.00 arası', 'Salata', 4),
	(2, '600 Gram', '13.00-14.00->300 gram\n16.00-17.00->300 gram', 'Tavuk ', 9),
	(3, '600 Gram', '13.00-14.00->300 gram 16.00-17.00->300 gram', 'Pirinç Pilavı', 9);
/*!40000 ALTER TABLE `diyet_listesi` ENABLE KEYS */;

-- tablo yapısı dökülüyor salon.document
CREATE TABLE IF NOT EXISTS `document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `filepath` text NOT NULL,
  `filename` text NOT NULL,
  `filetype` text NOT NULL,
  PRIMARY KEY (`document_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- salon.document: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` (`document_id`, `filepath`, `filename`, `filetype`) VALUES
	(1, 'C:\\Users\\sebat\\OneDrive\\Belgeler\\NetBeansProjects\\Fitness-Web-Site\\web\\upload', 'zumba.jpg', 'image/jpeg'),
	(2, 'C:\\Users\\sebat\\OneDrive\\Belgeler\\NetBeansProjects\\Fitness-Web-Site\\web\\upload', 'yuzme.jpg', 'image/jpeg'),
	(3, 'C:\\Users\\sebat\\OneDrive\\Belgeler\\NetBeansProjects\\Fitness-Web-Site\\web\\upload', 'pilates.jpg', 'image/jpeg'),
	(5, 'C:\\Users\\sebat\\OneDrive\\Belgeler\\NetBeansProjects\\Fitness-Web-Site\\web\\upload', 'fitness.jpg', 'image/jpeg'),
	(6, 'C:\\Users\\sebat\\OneDrive\\Belgeler\\NetBeansProjects\\Fitness-Web-Site\\web\\upload', 'boks.jfif', 'image/jpeg'),
	(9, 'C:\\Users\\sebat\\OneDrive\\Belgeler\\NetBeansProjects\\Fitness-Web-Site\\web\\upload', 'muaythai.png', 'image/png'),
	(11, 'C:\\Users\\sebat\\OneDrive\\Belgeler\\NetBeansProjects\\Fitness-Web-Site\\web\\upload', '4.jpg', 'image/jpeg');
/*!40000 ALTER TABLE `document` ENABLE KEYS */;

-- tablo yapısı dökülüyor salon.egitimler
CREATE TABLE IF NOT EXISTS `egitimler` (
  `egitim_id` int(11) NOT NULL AUTO_INCREMENT,
  `egitim_icerik` varchar(500) NOT NULL DEFAULT '0',
  `egitim_adi` varchar(50) NOT NULL DEFAULT '0',
  `egitim_ucret` varchar(50) NOT NULL DEFAULT '0',
  `egitmen_id` int(11) NOT NULL DEFAULT 0,
  `document_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`egitim_id`),
  KEY `egitim_egitmen_id_fk` (`egitmen_id`),
  KEY `egitim_document_id_fk` (`document_id`),
  CONSTRAINT `egitim_document_id_fk` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `egitim_egitmen_id_fk` FOREIGN KEY (`egitmen_id`) REFERENCES `egitmenler` (`egitmen_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- salon.egitimler: ~6 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `egitimler` DISABLE KEYS */;
INSERT INTO `egitimler` (`egitim_id`, `egitim_icerik`, `egitim_adi`, `egitim_ucret`, `egitmen_id`, `document_id`) VALUES
	(4, 'Bedenin dengeli tutulmasına yardımcı olan ve omurgayı desteklemekte önemli işlevi olan temel kaslar üzerine yoğunlaşılan bir egzersiz programıdır', 'Pilates', '350 Tl', 3, 3),
	(5, 'gölge boksu, kum torbasıyla çalışma, ip atlama ve kondisyon için koşu gibi başka çalışmaları  kapsar.', 'Boks', '100 Tl', 1, 6),
	(7, 'Tayland Boks. Yumruk, diz, dirsek ve tekmelerin kullanıldığı oldukça sert bir dövüş sanatıdır', 'MuayThai', '285 Tl', 2, 9),
	(8, ' Latin esintili bir dans fitness programı olup dünya çapındaki en yaygın dans fitness programıdır.', 'Zumba', '350 Tl', 4, 1),
	(9, 'zinde olmak ya da uğraşılan spora özgü fiziksel gereksinimleri sağlamak için vücudu fiziksel olarak hazırlamak.', 'Vücut Geliştirme Ve Fitness', '300 Tl', 5, 5),
	(10, 'serbest, sırtüstü, kelebek ve kurbağa stillerinin her birinde veya dördü birden karışık olarak, 50, 100, 200, 400, 800, 1500 metrelerde bireysel veya ekip olarak yaptıkları spor', 'Yüzme', '250 Tl', 6, 2);
/*!40000 ALTER TABLE `egitimler` ENABLE KEYS */;

-- tablo yapısı dökülüyor salon.egitmenler
CREATE TABLE IF NOT EXISTS `egitmenler` (
  `egitmen_id` int(11) NOT NULL AUTO_INCREMENT,
  `egitmen_ad` varchar(50) NOT NULL DEFAULT '0',
  `egitmen_soyad` varchar(50) NOT NULL DEFAULT '0',
  `egitmen_cinsiyet` varchar(50) NOT NULL DEFAULT '0',
  `egitmen_tel` varchar(50) NOT NULL DEFAULT '0',
  `egitmen_yas` int(11) NOT NULL DEFAULT 0,
  `egitmen_mail` varchar(50) NOT NULL DEFAULT '0',
  `egitmen_tecrube` varchar(50) NOT NULL DEFAULT '0',
  `uz_alan` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`egitmen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- salon.egitmenler: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `egitmenler` DISABLE KEYS */;
INSERT INTO `egitmenler` (`egitmen_id`, `egitmen_ad`, `egitmen_soyad`, `egitmen_cinsiyet`, `egitmen_tel`, `egitmen_yas`, `egitmen_mail`, `egitmen_tecrube`, `uz_alan`) VALUES
	(1, 'Ata', 'Doğan', 'Erkek', '05444620326', 25, 'ata.dn@gmail.com', '9 Yıl', 'Boks'),
	(2, 'Muhammed', 'Çetin', 'Erkek', '05412365236', 36, 'ceto@gmail.com', '18 Yıl', 'MuayThai'),
	(3, 'Ecem', 'Kartalkaya', 'Kadın', '05369874526', 29, 'ecem@gmail.com', '7 Yıl', 'Pilates'),
	(4, 'Işıl', 'Alkış', 'Kadın', '052659874563', 32, 'isil@gmail.com', '8 Yıl', 'Zumba'),
	(5, 'Mehmet', 'Ali', 'Erkek', '05789652326', 33, 'mehmet@gmail.com', '10 Yıl ', 'Fitness'),
	(6, 'Ali', 'Coşkun', 'Erkek', '05457896526', 44, 'ali@gmail.com', '8 Yıl', 'Yüzme'),
	(7, 'Ahmet', 'Çakar', 'Erkek', '05512769855', 35, 'ahmet@gmail.com', '8 Yıl', 'Tanga');
/*!40000 ALTER TABLE `egitmenler` ENABLE KEYS */;

-- tablo yapısı dökülüyor salon.olcum
CREATE TABLE IF NOT EXISTS `olcum` (
  `olcum_id` int(11) NOT NULL AUTO_INCREMENT,
  `kilo` varchar(50) NOT NULL DEFAULT '0',
  `boy` varchar(50) NOT NULL DEFAULT '0',
  `vucut_kitle_indeksi` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`olcum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- salon.olcum: ~6 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `olcum` DISABLE KEYS */;
INSERT INTO `olcum` (`olcum_id`, `kilo`, `boy`, `vucut_kitle_indeksi`) VALUES
	(1, '69.0', '172.0', '23.32341806381828'),
	(2, '70.0', '183.0', '20.902385858042937'),
	(3, '85.0', '201.0', '21.039083191010125'),
	(4, '75.0', '187.0', '21.447567845806287'),
	(5, '90.0', '180.0', '27.77777777777778'),
	(6, '85.0', '176.0', '27.440599173553718');
/*!40000 ALTER TABLE `olcum` ENABLE KEYS */;

-- tablo yapısı dökülüyor salon.program_listesi
CREATE TABLE IF NOT EXISTS `program_listesi` (
  `por_liste_id` int(11) NOT NULL AUTO_INCREMENT,
  `hareket_adi` varchar(500) NOT NULL DEFAULT '0',
  `tekrar_sayisi` varchar(500) NOT NULL DEFAULT '0',
  `hareket_bolgesi` varchar(500) NOT NULL DEFAULT '0',
  `egitim_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`por_liste_id`),
  KEY `por_egitim_id_fk` (`egitim_id`),
  CONSTRAINT `por_egitim_id_fk` FOREIGN KEY (`egitim_id`) REFERENCES `egitimler` (`egitim_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- salon.program_listesi: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `program_listesi` DISABLE KEYS */;
INSERT INTO `program_listesi` (`por_liste_id`, `hareket_adi`, `tekrar_sayisi`, `hareket_bolgesi`, `egitim_id`) VALUES
	(1, 'Bench press', '3 Set 12 Tekrar', 'Göğüs ', 9),
	(2, 'Press And Point', '3 Set 1\'er dakika', 'Karın ve bacak', 4),
	(3, 'Gölge Boksu', '3 set 5\'er dakika', 'Refleks ve yumruk hızı', 5),
	(4, 'Diz Çekme', '3 Set 30\'ar tane', 'Diz ve karın', 7),
	(5, 'Kelebek Yüzme', '500 Metre', 'Sırt, kol ve göğüs', 10);
/*!40000 ALTER TABLE `program_listesi` ENABLE KEYS */;

-- tablo yapısı dökülüyor salon.uyeler
CREATE TABLE IF NOT EXISTS `uyeler` (
  `uye_id` int(11) NOT NULL AUTO_INCREMENT,
  `uye_ad` varchar(50) NOT NULL DEFAULT '0',
  `uye_soyad` varchar(50) NOT NULL DEFAULT '0',
  `uye_cinsiyet` varchar(50) NOT NULL DEFAULT '0',
  `uye_tel` varchar(50) NOT NULL DEFAULT '0',
  `uye_yas` int(11) NOT NULL DEFAULT 0,
  `uye_mail` varchar(50) NOT NULL DEFAULT '0',
  `uye_kartno` varchar(50) NOT NULL DEFAULT '0',
  `admin` tinyint(1) NOT NULL DEFAULT 0,
  `sifre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uye_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- salon.uyeler: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `uyeler` DISABLE KEYS */;
INSERT INTO `uyeler` (`uye_id`, `uye_ad`, `uye_soyad`, `uye_cinsiyet`, `uye_tel`, `uye_yas`, `uye_mail`, `uye_kartno`, `admin`, `sifre`) VALUES
	(1, 'admin', 'admin', 'admin', '1', 1, 'admin', 'admin', 1, 'admin'),
	(2, 'Muhammed Anıl', 'Aldoğan', 'Erkek', '05326930104', 22, 'anil@gmail.com', '1E44', 0, '123456'),
	(3, 'Mert Batuhan', 'İduğ', 'Erkek', '05362030123', 25, 'mert@gmail.com', '2E44', 0, '123456'),
	(4, 'Ayşe', 'Fatma', 'Kadın', '05362300303', 29, 'ayse@gmail.com', '1K44', 0, 'ayseuye'),
	(5, 'Sevda', 'Sarı', 'Kadın', '05393651214', 27, 'sevda@gmail.com', '2K44', 0, '123456'),
	(6, 'Kuzey Ata', 'Doğan', 'Erkek', '05263542326', 22, 'kuzey@gmail.com', '3E44', 0, '12345'),
	(7, 'Ali', 'Doyar', 'Erkek', '05321112544', 25, 'ali@gmail.com', '4E44', 0, '12345'),
	(8, 'Hatice', 'Dursun', 'Kadın', '05547896514', 26, 'hatice@gmail.com', '3K44', 0, '12345'),
	(9, 'Funda ', 'Kara', 'Kadın', '05330541265', 28, 'funda@gmail.com', '4K44', 0, '12345');
/*!40000 ALTER TABLE `uyeler` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
