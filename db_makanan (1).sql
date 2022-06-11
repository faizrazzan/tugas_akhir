-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jun 2022 pada 06.48
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_makanan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis_makanan`
--

CREATE TABLE `jenis_makanan` (
  `ID_JENIS_MAKANAN` int(11) NOT NULL,
  `NAMA_JENIS_MAKANAN` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jenis_makanan`
--

INSERT INTO `jenis_makanan` (`ID_JENIS_MAKANAN`, `NAMA_JENIS_MAKANAN`) VALUES
(1, 'KUAH'),
(3, 'goreng');

-- --------------------------------------------------------

--
-- Struktur dari tabel `makanan`
--

CREATE TABLE `makanan` (
  `ID_MAKANAN` int(11) NOT NULL,
  `ID_JENIS_MAKANAN` int(11) DEFAULT NULL,
  `NAMA_MAKANAN` varchar(50) DEFAULT NULL,
  `HARGA_MAKANAN` float DEFAULT NULL,
  `STOK_MAKANAN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `makanan`
--

INSERT INTO `makanan` (`ID_MAKANAN`, `ID_JENIS_MAKANAN`, `NAMA_MAKANAN`, `HARGA_MAKANAN`, `STOK_MAKANAN`) VALUES
(3, 1, 'ayam_goreng', 12000, 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `mengelola`
--

CREATE TABLE `mengelola` (
  `ID_TRANSAKSI` int(11) NOT NULL,
  `ID_MAKANAN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mengelola`
--

INSERT INTO `mengelola` (`ID_TRANSAKSI`, `ID_MAKANAN`) VALUES
(1, 3),
(1, 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `ID_TRANSAKSI` int(11) NOT NULL,
  `TGL_PESAN` datetime DEFAULT NULL,
  `TOTAL_PEMBAYARAN` float DEFAULT NULL,
  `JUMLAH_PESANAN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`ID_TRANSAKSI`, `TGL_PESAN`, `TOTAL_PEMBAYARAN`, `JUMLAH_PESANAN`) VALUES
(1, '2022-06-10 20:28:19', 50000, 5);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jenis_makanan`
--
ALTER TABLE `jenis_makanan`
  ADD PRIMARY KEY (`ID_JENIS_MAKANAN`);

--
-- Indeks untuk tabel `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`ID_MAKANAN`),
  ADD KEY `FK_MAKANAN_MEMILIKI_JENIS_MA` (`ID_JENIS_MAKANAN`);

--
-- Indeks untuk tabel `mengelola`
--
ALTER TABLE `mengelola`
  ADD KEY `FK_MENGELOL_MENGELOLA_TRANSAKS` (`ID_TRANSAKSI`),
  ADD KEY `FK_MENGELOL_MENGELOLA_MAKANAN` (`ID_MAKANAN`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID_TRANSAKSI`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jenis_makanan`
--
ALTER TABLE `jenis_makanan`
  MODIFY `ID_JENIS_MAKANAN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `makanan`
--
ALTER TABLE `makanan`
  MODIFY `ID_MAKANAN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `ID_TRANSAKSI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `makanan`
--
ALTER TABLE `makanan`
  ADD CONSTRAINT `FK_MAKANAN_MEMILIKI_JENIS_MA` FOREIGN KEY (`ID_JENIS_MAKANAN`) REFERENCES `jenis_makanan` (`ID_JENIS_MAKANAN`);

--
-- Ketidakleluasaan untuk tabel `mengelola`
--
ALTER TABLE `mengelola`
  ADD CONSTRAINT `FK_MENGELOL_MENGELOLA_MAKANAN` FOREIGN KEY (`ID_MAKANAN`) REFERENCES `makanan` (`ID_MAKANAN`),
  ADD CONSTRAINT `FK_MENGELOL_MENGELOLA_TRANSAKS` FOREIGN KEY (`ID_TRANSAKSI`) REFERENCES `transaksi` (`ID_TRANSAKSI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
