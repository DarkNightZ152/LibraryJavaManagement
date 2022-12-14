
CREATE DATABASE QLTVjava
on
(
NAME = QLTVnhom9java_dat,
FILENAME = 'D:\Microsoft SQL Server\MSSQL15.DARKSQL\MSSQL\DATA\QuanLyThuViennhom9java.mdf',
SIZE = 4MB,
MAXSIZE = 10MB,
FILEGROWTH = 10%
)
go 
use QLTVjava

-- bang table taikhoan
create table TaiKhoan
(
matk varchar(5) PRIMARY KEY ,
taikhoan varchar(100) not Null,
matkhau varchar(2000) not Null,
quyen Nvarchar(10) not null
)
CREATE FUNCTION AUTO_madg()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(madg) FROM DocGia) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(madg, 3)) FROM DocGia
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'DG00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'DG0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
-- bang table docgia
create table DocGia
(
madg varchar(5) PRIMARY KEY CONSTRAINT madg DEFAULT dbo.AUTO_madg(),
matk varchar(5) ,
hoten Nvarchar(100) not null,
gioitinh Nvarchar(5) not null,
ngaysinh Date check (ngaysinh<getdate()) not null,
diachi Nvarchar(100) not null,
sdt varchar(10)

)
-- bang table thuthu
CREATE FUNCTION AUTO_matt()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(matt) FROM ThuThu) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(matt, 3)) FROM ThuThu
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'TT00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'TT0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
create table ThuThu
(
matt varchar(5) PRIMARY KEY CONSTRAINT matt DEFAULT dbo.AUTO_matt(),
matk varchar(5) not null,
hoten Nvarchar(100) not null,
gioitinh Nvarchar(5) not null,
ngaysinh Date check (ngaysinh<getdate()) not null,
diachi Nvarchar(100) not null,
sdt varchar(10)
)


-- bang table theloai
--DROP FUNCTION AUTO_matl
CREATE FUNCTION AUTO_matl()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(matl) FROM TheLoai) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(matl, 3)) FROM TheLoai
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'TL00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'TL0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
create table TheLoai
(
matl varchar(5) PRIMARY KEY CONSTRAINT matl DEFAULT dbo.AUTO_matl(),
tentl Nvarchar(100) not null,
)

-- bang table sach

CREATE FUNCTION AUTO_mas()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(mas) FROM Sach) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(mas, 3)) FROM Sach
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'MS00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'MS0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
--
create table Sach
(
mas varchar(5) PRIMARY KEY CONSTRAINT mas DEFAULT dbo.AUTO_mas(),
tensach Nvarchar(100) not null,
matl varchar(5),
tacgia Nvarchar(100),
nhaxb Nvarchar(100),
namxb date ,
giasach float ,
soluong int ,
tomtat Ntext,
soluongmuon INT 
)
GO
ALTER TABLE dbo.Sach ADD CONSTRAINT df_soluongmuon DEFAULT 0 FOR soluongmuon;
-- bang table phieumuon
-- select  * from PhieuMuon
CREATE FUNCTION AUTO_mapm()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(mapm) FROM PhieuMuon) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(mapm, 3)) FROM PhieuMuon
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'PM00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'PM0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
create table PhieuMuon
(
mapm varchar(5) PRIMARY KEY CONSTRAINT mapm DEFAULT dbo.AUTO_mapm(),
madg varchar(5) not null,
ngaymuon date ,
songaymuon int,
ghichu Nvarchar(100),
trangthai Nvarchar(100),
mas varchar(5),
soluong int
)
-- bang table hoadon
CREATE FUNCTION AUTO_mahd()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(mahd) FROM HoaDon) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(mahd, 3)) FROM HoaDon
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'HD00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'HD0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
-- 
CREATE TABLE HoaDon(
mahd varchar(5) PRIMARY KEY CONSTRAINT mahd DEFAULT dbo.AUTO_mahd(),
mapm varchar(5),
trangthai Nvarchar(100),
ngaytra date,
thanhtien float
)
go

-- II, Ch??n D??? Li???u V??o C??c B???ng :

	-- b???ng t??i kho???n
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK00', 'admin', 'admin' , N'Admin');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK01', 'quocanh', '1' , N'?????c Gi???');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK02', 'bon', '1' , N'?????c Gi???');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK03', 'bonbon', '1' , N'?????c Gi???');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK04', 'cam', '1' , N'?????c Gi???');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK05', 'tung', '1' , N'?????c Gi???');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK06', '', 'cong' , N'?????c Gi???');

	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK07', 'tt1', '1' , N'Th??? Th??');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK08', 'tt2', '2' , N'Th??? Th??');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK09', 'tt3', '3' , N'Th??? Th??');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK10', 'tt4', '4' , N'Th??? Th??');

	-- delete  from 
	-- b???ng ?????c gi??? 
	select * from DocGia
	--delete  from DocGia 
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK01', N'Tr???n Qu???c Anh', N'Nam', '2001-01-01', N'HN', '0987643276');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK02', N'Ng?? V??n B???n', N'Nam', '2001-03-07', N'HN', '0987643253');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK03', N'Ng?? V??n B???n', N'Nam', '2001-01-01', N'HN', '0987643278');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK04', N'Nguy???n V??n C???m', N'Nam', '2001-06-27', N'HN', '0987643277');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK05', N'B??i C??ng T??ng', N'Nam', '2001-01-01', N'HN', '0987643276');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK06', N'B??i C??ng T??ng', N'Nam', '2001-01-02', N'HN', '0987643576');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK11', N'Tr???n Qu???c Vi???t', N'Nam', '2001-01-02', N'HN', '0987643256');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK12', N'Ng?? V??n Vi???t', N'Nam', '2001-03-03', N'HN', '0987643243');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK13', N'Ng?? V??n Nam', N'Nam', '2001-01-04', N'HN', '0987643228');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK14', N'Nguy???n V??n Ch??nh', N'Nam', '2001-06-28', N'HN', '0981643277');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK15', N'B??i C??ng N??m', N'Nam', '2001-01-09', N'HN', '0987643476');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK16', N'T??? S??u', N'Nam', '2001-01-03', N'HN', '0987623576');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK17', N'Tr???n Qu???c B???y', N'Nam', '2001-02-01', N'HN', '0987543276');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK18', N'Ng?? V??n T??m', N'N???', '2001-04-07', N'HN', '0987643253');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK19', N'Ng?? Th??? Ng???c Ch??n', N'N???', '2001-05-01', N'HN', '0984643278');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK20', N'Nguy???n Th??? Ba', N'N???', '2001-07-27', N'HN', '0987443277');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK21', N'B??i C??ng Hai', N'Nam', '2001-08-01', N'HN', '0987543276');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK22', N'T??? Anh Nh???t', N'Nam', '2001-09-02', N'HN', '0987443576');
	-- b???ng th??? th??
	select * from ThuThu
	insert into ThuThu ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK07', N'Ng?? V??n B???n', 'Nam', '2001-01-01', N'HN', '0987643278');
	insert into ThuThu ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK08', N'Nguy???n V??n C???m', 'Nam', '2001-06-27', N'HN', '0987643277');
	insert into ThuThu ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK09', N'B??i C??ng T??ng', 'Nam', '2001-01-01', N'HN', '0987643276');
	insert into ThuThu ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK10', N'T??? C??ng', 'Nam', '2001-01-02', 'HN', N'0987643576');

	-- b???ng th??? lo???i 
	select * from TheLoai
	--delete from TheLoai
	insert into TheLoai (tentl) values(N'Gi??o Tr??nh' );
	insert into TheLoai (tentl) values(N'Ch??nh tr??? ??? ph??p lu???t' );
	insert into TheLoai (tentl) values(N'Khoa h???c c??ng ngh??? ??? Kinh t???' );
	insert into TheLoai (tentl) values(N'V??n h???c ngh??? thu???t' );
	insert into TheLoai (tentl) values(N'V??n h??a x?? h???i ??? L???ch s???' );
	insert into TheLoai (tentl) values(N'Truy???n, ti???u thuy???t' );
	insert into TheLoai (tentl) values(N'T??m l??, t??m linh, t??n gi??o' );
	insert into TheLoai (tentl) values(N'S??ch thi???u nhi' );

	-- table s??ch
	select * from Sach
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Gi???i T??ch', 'TL001',N'Kh??ng',N'?????i h???c s?? ph???m', '2021-10-10',12000, 50,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'?????i s??? tuy???n t??nh', 'TL001',N'Kh??ng',N'?????i h???c s?? ph???m', '2020-10-10',15000, 50,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'To??n r???i r???c', 'TL001',N'Kh??ng',N'?????i h???c s?? ph???m', '2021-10-10',12500, 50,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'X??c xu???t th???ng k??', 'TL001',N'Kh??ng',N'?????i h???c s?? ph???m', '2021-10-10',20000, 50,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Nh???p m??n l???p tr??nh ', 'TL001',N'Kh??ng',N'?????i h???c s?? ph???m', '2021-10-10',25000, 50,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'K??? thu???t l???p tr??nh', 'TL001',N'Kh??ng',N'?????i h???c s?? ph???m', '2021-10-10',18000, 50,N'kh??ng');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'B??n v??? kh??? ?????c x?? h???i', 'TL002',N'Jean-Jacques Rousseau',N'Kim ?????ng', '2021-10-10',67000, 10,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N' B??n v??? tinh th???n ph??p lu???t', 'TL002',N'Montesquieu',N'Kim ?????ng', '2021-10-10',57000, 10,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Ch??nh tr??? lu???n', 'TL002',N'Aristotle',N'Kim ?????ng', '2021-10-10',87000, 10,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Hi???n Ph??p Vi???t Nam', 'TL002',N'Nhi???u t??c gi???',N'Kim ?????ng', '2021-10-10',56000, 100,N'kh??ng');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Th????ng m???i ??i???n t??? c??n b???n', 'TL003',N'TS. Tr???n Th??? Th???p -TS. Nguy???n Tr???n H??ng',N'Kim ?????ng', '2021-10-10',76000, 20,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'To??n h???c m???t thi??n ti???u thuy???t', 'TL003',N'Mickael Launay',N'Kim ?????ng', '2021-10-10',88000, 10,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'C???m nang Chuy???n ?????i s???', 'TL003',N'B??? Th??ng tin v?? Truy???n th??ng',N'Kim ?????ng', '2021-10-10',52000, 20,N'kh??ng');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'H???nh ph??c ????u d??? ki???m t??m', 'TL004',N'Minh M??o - ????nh Th???ng - Nguy??n Nguy??n',N'Kim ?????ng', '2021-10-10',52000, 20,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Tr??? v??? y??n l???ng', 'TL004',N'Dainin Katagiri',N'Kim ?????ng', '2021-10-10',50000, 20,N'kh??ng');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'L???ch s??? vi???t nam', 'TL005',N'Nhi???u t??c gi???',N'Kim ?????ng', '2021-10-10',76000, 20,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'?????i vi???t s??? k?? to??n th??', 'TL005',N'L?? V??n H??u',N'Kim ?????ng', '2021-10-10',88000, 10,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'L???ch s??? t??n gi??o', 'TL006',N'B??? Th??ng tin v?? Truy???n th??ng',N'Kim ?????ng', '2021-10-10',152000, 20,N'kh??ng');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Doremon (1-24)', 'TL007',N'Fujiko F. Fujio',N'Kim ?????ng', '2021-10-10',340000, 2,N'kh??ng');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'10 v???n c??u h???i v?? sao (55N) - Cu???c s???ng mu??n m??u', 'TL008',N'Nhi???u t??c gi???',N'Kim ?????ng', '2021-10-10',41500, 20,N'kh??ng');

	delete PhieuMuon
	-- table - PhieuMuon
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG001','2021-09-30',7,N'ko',N'???? tr???','MS001',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG002','2021-09-30',7,N'ko',N'???? tr???','MS008',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG003','2021-09-30',7,N'ko',N'???? tr???','MS006',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG004','2021-10-01',7,N'ko',N'???? tr???','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG005','2021-10-01',7,N'ko',N'???? tr???','MS019',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG007','2021-10-01',7,N'ko',N'???? tr???','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG006','2021-10-01',7,N'ko',N'???? tr???','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG004','2021-10-01',7,N'ko',N'???? tr???','MS020',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG009','2021-11-01',7,N'ko',N'???? tr???','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG010','2021-11-01',14,N'ko',N'Ch??a tr???','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG013','2021-11-01',7,N'ko',N'Ch??a tr???','MS020',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG011','2021-11-01',7,N'ko',N'Ch??a tr???','MS020',3)
	
	delete HoaDon
	-- table - HoaDon
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM001',N'B??nh th?????ng', '2021-10-10', 5000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM004',N'B??nh th?????ng', '2021-10-10', 15000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM002',N'H?? H???ng', '2021-10-02', 50000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM003',N'B??nh th?????ng', '2021-10-02', 5000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM005',N'B??nh th?????ng', '2021-10-10', 15000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM006',N'B??nh th?????ng', '2021-10-10', 15000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM007',N'B??nh th?????ng', '2021-10-11', 15000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM008',N'B??nh th?????ng', '2021-10-11', 20000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM009',N'B??nh th?????ng', '2021-10-11', 20000)

