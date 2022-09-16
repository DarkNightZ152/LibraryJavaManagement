
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

-- II, Chèn Dữ Liệu Vào Các Bảng :

	-- bảng tài khoản
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK00', 'admin', 'admin' , N'Admin');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK01', 'quocanh', '1' , N'Độc Giả');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK02', 'bon', '1' , N'Độc Giả');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK03', 'bonbon', '1' , N'Độc Giả');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK04', 'cam', '1' , N'Độc Giả');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK05', 'tung', '1' , N'Độc Giả');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK06', '', 'cong' , N'Độc Giả');

	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK07', 'tt1', '1' , N'Thủ Thư');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK08', 'tt2', '2' , N'Thủ Thư');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK09', 'tt3', '3' , N'Thủ Thư');
	insert into TaiKhoan (matk, taikhoan, matkhau, quyen) values ('TK10', 'tt4', '4' , N'Thủ Thư');

	-- delete  from 
	-- bảng độc giả 
	select * from DocGia
	--delete  from DocGia 
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK01', N'Trần Quốc Anh', N'Nam', '2001-01-01', N'HN', '0987643276');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK02', N'Ngô Văn Bốn', N'Nam', '2001-03-07', N'HN', '0987643253');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK03', N'Ngô Văn Bốn', N'Nam', '2001-01-01', N'HN', '0987643278');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK04', N'Nguyễn Văn Cẩm', N'Nam', '2001-06-27', N'HN', '0987643277');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK05', N'Bùi Công Tùng', N'Nam', '2001-01-01', N'HN', '0987643276');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK06', N'Bùi Công Tùng', N'Nam', '2001-01-02', N'HN', '0987643576');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK11', N'Trần Quốc Việt', N'Nam', '2001-01-02', N'HN', '0987643256');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK12', N'Ngô Văn Việt', N'Nam', '2001-03-03', N'HN', '0987643243');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK13', N'Ngô Văn Nam', N'Nam', '2001-01-04', N'HN', '0987643228');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK14', N'Nguyễn Văn Chính', N'Nam', '2001-06-28', N'HN', '0981643277');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK15', N'Bùi Công Năm', N'Nam', '2001-01-09', N'HN', '0987643476');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK16', N'Tạ Sáu', N'Nam', '2001-01-03', N'HN', '0987623576');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK17', N'Trần Quốc Bảy', N'Nam', '2001-02-01', N'HN', '0987543276');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK18', N'Ngô Văn Tám', N'Nữ', '2001-04-07', N'HN', '0987643253');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK19', N'Ngô Thị Ngọc Chín', N'Nữ', '2001-05-01', N'HN', '0984643278');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK20', N'Nguyễn Thị Ba', N'Nữ', '2001-07-27', N'HN', '0987443277');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK21', N'Bùi Công Hai', N'Nam', '2001-08-01', N'HN', '0987543276');
	insert into DocGia ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK22', N'Tạ Anh Nhất', N'Nam', '2001-09-02', N'HN', '0987443576');
	-- bảng thủ thư
	select * from ThuThu
	insert into ThuThu ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK07', N'Ngô Văn Bốn', 'Nam', '2001-01-01', N'HN', '0987643278');
	insert into ThuThu ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK08', N'Nguyễn Văn Cẩm', 'Nam', '2001-06-27', N'HN', '0987643277');
	insert into ThuThu ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK09', N'Bùi Công Tùng', 'Nam', '2001-01-01', N'HN', '0987643276');
	insert into ThuThu ( matk , hoten,gioitinh, ngaysinh, diachi, sdt) values( 'TK10', N'Tạ Công', 'Nam', '2001-01-02', 'HN', N'0987643576');

	-- bảng thể loại 
	select * from TheLoai
	--delete from TheLoai
	insert into TheLoai (tentl) values(N'Giáo Trình' );
	insert into TheLoai (tentl) values(N'Chính trị – pháp luật' );
	insert into TheLoai (tentl) values(N'Khoa học công nghệ – Kinh tế' );
	insert into TheLoai (tentl) values(N'Văn học nghệ thuật' );
	insert into TheLoai (tentl) values(N'Văn hóa xã hội – Lịch sử' );
	insert into TheLoai (tentl) values(N'Truyện, tiểu thuyết' );
	insert into TheLoai (tentl) values(N'Tâm lý, tâm linh, tôn giáo' );
	insert into TheLoai (tentl) values(N'Sách thiếu nhi' );

	-- table sách
	select * from Sach
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Giải Tích', 'TL001',N'Không',N'Đại học sư phạm', '2021-10-10',12000, 50,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Đại số tuyến tính', 'TL001',N'Không',N'Đại học sư phạm', '2020-10-10',15000, 50,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Toán rời rạc', 'TL001',N'Không',N'Đại học sư phạm', '2021-10-10',12500, 50,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Xác xuất thống kê', 'TL001',N'Không',N'Đại học sư phạm', '2021-10-10',20000, 50,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Nhập môn lập trình ', 'TL001',N'Không',N'Đại học sư phạm', '2021-10-10',25000, 50,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Kỹ thuật lập trình', 'TL001',N'Không',N'Đại học sư phạm', '2021-10-10',18000, 50,N'không');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Bàn về khế ước xã hội', 'TL002',N'Jean-Jacques Rousseau',N'Kim Đồng', '2021-10-10',67000, 10,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N' Bàn về tinh thần pháp luật', 'TL002',N'Montesquieu',N'Kim Đồng', '2021-10-10',57000, 10,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Chính trị luận', 'TL002',N'Aristotle',N'Kim Đồng', '2021-10-10',87000, 10,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Hiến Pháp Việt Nam', 'TL002',N'Nhiều tác giả',N'Kim Đồng', '2021-10-10',56000, 100,N'không');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Thương mại điện tử căn bản', 'TL003',N'TS. Trần Thị Thập -TS. Nguyễn Trần Hưng',N'Kim Đồng', '2021-10-10',76000, 20,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Toán học một thiên tiểu thuyết', 'TL003',N'Mickael Launay',N'Kim Đồng', '2021-10-10',88000, 10,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Cẩm nang Chuyển đổi số', 'TL003',N'Bộ Thông tin và Truyền thông',N'Kim Đồng', '2021-10-10',52000, 20,N'không');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Hạnh phúc đâu dễ kiếm tìm', 'TL004',N'Minh Mèo - Đình Thắng - Nguyên Nguyên',N'Kim Đồng', '2021-10-10',52000, 20,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Trở về yên lặng', 'TL004',N'Dainin Katagiri',N'Kim Đồng', '2021-10-10',50000, 20,N'không');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Lịch sử việt nam', 'TL005',N'Nhiều tác giả',N'Kim Đồng', '2021-10-10',76000, 20,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Đại việt sử ký toàn thư', 'TL005',N'Lê Văn Hưu',N'Kim Đồng', '2021-10-10',88000, 10,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Lịch sử tôn giáo', 'TL006',N'Bộ Thông tin và Truyền thông',N'Kim Đồng', '2021-10-10',152000, 20,N'không');

	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'Doremon (1-24)', 'TL007',N'Fujiko F. Fujio',N'Kim Đồng', '2021-10-10',340000, 2,N'không');
	insert into Sach (tensach, matl, tacgia,nhaxb, namxb, giasach, soluong, tomtat) values(N'10 vạn câu hỏi vì sao (55N) - Cuộc sống muôn màu', 'TL008',N'Nhiều tác giả',N'Kim Đồng', '2021-10-10',41500, 20,N'không');

	delete PhieuMuon
	-- table - PhieuMuon
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG001','2021-09-30',7,N'ko',N'Đã trả','MS001',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG002','2021-09-30',7,N'ko',N'Đã trả','MS008',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG003','2021-09-30',7,N'ko',N'Đã trả','MS006',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG004','2021-10-01',7,N'ko',N'Đã trả','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG005','2021-10-01',7,N'ko',N'Đã trả','MS019',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG007','2021-10-01',7,N'ko',N'Đã trả','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG006','2021-10-01',7,N'ko',N'Đã trả','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG004','2021-10-01',7,N'ko',N'Đã trả','MS020',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG009','2021-11-01',7,N'ko',N'Đã trả','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG010','2021-11-01',14,N'ko',N'Chưa trả','MS018',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG013','2021-11-01',7,N'ko',N'Chưa trả','MS020',1)
	insert into PhieuMuon ( madg, ngaymuon, songaymuon, ghichu, trangthai, mas, soluong) values('DG011','2021-11-01',7,N'ko',N'Chưa trả','MS020',3)
	
	delete HoaDon
	-- table - HoaDon
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM001',N'Bình thường', '2021-10-10', 5000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM004',N'Bình thường', '2021-10-10', 15000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM002',N'Hư Hỏng', '2021-10-02', 50000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM003',N'Bình thường', '2021-10-02', 5000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM005',N'Bình thường', '2021-10-10', 15000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM006',N'Bình thường', '2021-10-10', 15000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM007',N'Bình thường', '2021-10-11', 15000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM008',N'Bình thường', '2021-10-11', 20000)
	insert into HoaDon(mapm, trangthai, ngaytra, thanhtien) values('PM009',N'Bình thường', '2021-10-11', 20000)

