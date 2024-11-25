
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVu](
	[MaDV] [nchar](10) NOT NULL,
	[MaPDV] [nchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[Ngay] [date] NULL,
 CONSTRAINT [PK_ChiTietDichVu] PRIMARY KEY CLUSTERED 
(
	[MaDV] ASC,
	[MaPDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietTienNghi]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietTienNghi](
	[MaPhong] [nchar](10) NOT NULL,
	[MaTNghi] [nchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK_ChiTietTienNghi] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC,
	[MaTNghi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDV] [nchar](10) NOT NULL,
	[TenDV] [nvarchar](255) NOT NULL,
	[DonGia] [int] NOT NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [char](5) NOT NULL,
	[SoTien] [int] NOT NULL,
	[NgayLap] [date] NOT NULL,
	[MaPDP] [char](10) NULL,
	[MaNV] [char](10) NOT NULL,
	[MaKH] [char](10) NOT NULL,
	[MaPP] [nchar](10) NULL,
	[MaPhong] [nchar](10) NOT NULL,
	[MaPDV] [nchar](10) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [char](10) NOT NULL,
	[TenKh] [nvarchar](255) NOT NULL,
	[SDT] [nchar](11) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[PassWord] [char](10) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[MaLoaiPhong] [nchar](10) NOT NULL,
	[MoTa] [nvarchar](50) NOT NULL,
	[GiaPhong] [int] NOT NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[MaLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [char](10) NOT NULL,
	[HoTen] [nvarchar](255) NOT NULL,
	[SDT] [nchar](11) NOT NULL,
	[DiaChi] [nvarchar](255) NOT NULL,
	[ChucVu] [nchar](10) NOT NULL,
	[PassWord] [char](10) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatPhong]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatPhong](
	[MaPDP] [char](10) NOT NULL,
	[NgayDat] [date] NOT NULL,
	[TienCoc] [int] NOT NULL,
	[MaKh] [char](10) NULL,
	[MaPhong] [nchar](10) NULL,
	[DaThanhToan] [bit] NULL,
 CONSTRAINT [PK_PhieuDatPhong] PRIMARY KEY CLUSTERED 
(
	[MaPDP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDichVu]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDichVu](
	[MaPDV] [nchar](10) NOT NULL,
	[MaKH] [char](10) NOT NULL,
	[TongTien] [int] NOT NULL,
	[DaThanhToan] [bit] NULL,
 CONSTRAINT [PK_PhieuDichVu] PRIMARY KEY CLUSTERED 
(
	[MaPDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuPhat]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuPhat](
	[MaPP] [nchar](10) NOT NULL,
	[NoiDung] [nvarchar](255) NOT NULL,
	[NgayPhat] [date] NOT NULL,
	[SoTien] [int] NOT NULL,
	[DaThanhToan] [bit] NULL,
 CONSTRAINT [PK_PhieuPhat] PRIMARY KEY CLUSTERED 
(
	[MaPP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [nchar](10) NOT NULL,
	[TinhTrang] [bit] NOT NULL,
	[MaLoaiPhong] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TienNghi]    Script Date: 10/24/2023 9:44:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TienNghi](
	[MaTNghi] [nchar](10) NOT NULL,
	[TenTNghi] [nvarchar](255) NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK_TienNghi] PRIMARY KEY CLUSTERED 
(
	[MaTNghi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietDichVu] ([MaDV], [MaPDV], [SoLuong], [Ngay]) VALUES (N'MDV01     ', N'MPDV1     ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([MaDV], [MaPDV], [SoLuong], [Ngay]) VALUES (N'MDV01     ', N'MPDV2     ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([MaDV], [MaPDV], [SoLuong], [Ngay]) VALUES (N'MDV01     ', N'MPDV3     ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([MaDV], [MaPDV], [SoLuong], [Ngay]) VALUES (N'MDV02     ', N'MPDV1     ', 2, NULL)
INSERT [dbo].[ChiTietDichVu] ([MaDV], [MaPDV], [SoLuong], [Ngay]) VALUES (N'MDV03     ', N'MPDV2     ', 1, NULL)
INSERT [dbo].[ChiTietDichVu] ([MaDV], [MaPDV], [SoLuong], [Ngay]) VALUES (N'MDV04     ', N'MPDV3     ', 2, NULL)
INSERT [dbo].[ChiTietDichVu] ([MaDV], [MaPDV], [SoLuong], [Ngay]) VALUES (N'MDV04     ', N'MPDV4     ', 1, CAST(N'2023-10-21' AS Date))
GO
INSERT [dbo].[ChiTietTienNghi] ([MaPhong], [MaTNghi], [SoLuong]) VALUES (N'MP001     ', N'MTN001    ', 1)
INSERT [dbo].[ChiTietTienNghi] ([MaPhong], [MaTNghi], [SoLuong]) VALUES (N'MP001     ', N'MTN002    ', 1)
INSERT [dbo].[ChiTietTienNghi] ([MaPhong], [MaTNghi], [SoLuong]) VALUES (N'MP001     ', N'MTN003    ', 1)
INSERT [dbo].[ChiTietTienNghi] ([MaPhong], [MaTNghi], [SoLuong]) VALUES (N'MP001     ', N'MTN004    ', 1)
GO
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (N'MDV01     ', N'Buffe sáng', 100000)
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (N'MDV02     ', N'Giặt sấy', 50000)
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (N'MDV03     ', N'Bar', 500000)
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (N'MDV04     ', N'Matxa', 200000)
GO
INSERT [dbo].[HoaDon] ([MaHD], [SoTien], [NgayLap], [MaPDP], [MaNV], [MaKH], [MaPP], [MaPhong], [MaPDV]) VALUES (N'MHD01', 1460000, CAST(N'2023-10-14' AS Date), N'MPDP1     ', N'MNV0010001', N'MKH0001110', NULL, N'MP003     ', NULL)
INSERT [dbo].[HoaDon] ([MaHD], [SoTien], [NgayLap], [MaPDP], [MaNV], [MaKH], [MaPP], [MaPhong], [MaPDV]) VALUES (N'MHD02', 1660000, CAST(N'2023-10-14' AS Date), N'MPDP2     ', N'MNV0010001', N'MKH0001110', N'MPP1      ', N'MP005     ', NULL)
INSERT [dbo].[HoaDon] ([MaHD], [SoTien], [NgayLap], [MaPDP], [MaNV], [MaKH], [MaPP], [MaPhong], [MaPDV]) VALUES (N'MHD04', 1570000, CAST(N'2023-10-16' AS Date), N'MPDP4     ', N'MNV0010005', N'MKH0001110', N'MPP2      ', N'MP009     ', NULL)
INSERT [dbo].[HoaDon] ([MaHD], [SoTien], [NgayLap], [MaPDP], [MaNV], [MaKH], [MaPP], [MaPhong], [MaPDV]) VALUES (N'MHD3 ', 710000, CAST(N'2023-10-15' AS Date), N'MPDP3     ', N'MNV0010002', N'MKH0001110', NULL, N'MP008     ', NULL)
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKh], [SDT], [DiaChi], [PassWord]) VALUES (N'1         ', N'1', N'1          ', N'1', N'1         ')
INSERT [dbo].[KhachHang] ([MaKH], [TenKh], [SDT], [DiaChi], [PassWord]) VALUES (N'MKH0001110', N'Tran Van A', N'1234567890 ', N'Tran Hung Dao', N'0001114321')
INSERT [dbo].[KhachHang] ([MaKH], [TenKh], [SDT], [DiaChi], [PassWord]) VALUES (N'MKH0001111', N'Tran Van B', N'1234567891 ', N'Nguyen Van Luong', N'0001115678')
INSERT [dbo].[KhachHang] ([MaKH], [TenKh], [SDT], [DiaChi], [PassWord]) VALUES (N'MKH0001112', N'Tran Van C', N'1234567892 ', N'Binh Hanh TpHCM', N'0001112345')
INSERT [dbo].[KhachHang] ([MaKH], [TenKh], [SDT], [DiaChi], [PassWord]) VALUES (N'MKH0001113', N'Tran Van D', N'1234567893 ', N'Hau Giang', N'0001118888')
GO
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [MoTa], [GiaPhong]) VALUES (N'MLP001    ', N'VIP', 500000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [MoTa], [GiaPhong]) VALUES (N'MLP002    ', N'Thường', 250000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [MoTa], [GiaPhong]) VALUES (N'MLP003    ', N'SVIP', 1000000)
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [SDT], [DiaChi], [ChucVu], [PassWord]) VALUES (N'MNV0010001', N'Nguyen Van A', N'0123456789 ', N'Binh Thanh TPHCM', N'Lễ tân    ', N'1234567890')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [SDT], [DiaChi], [ChucVu], [PassWord]) VALUES (N'MNV0010002', N'Nguyen Thi Be', N'0234567891 ', N'Thu Duc TPHCM', N'Lễ tân    ', N'1234567890')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [SDT], [DiaChi], [ChucVu], [PassWord]) VALUES (N'MNV0010005', N'Le Thi Bao', N'0567891234 ', N'Thu Duc TPHCM', N'Lễ tân    ', N'1234567890')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [SDT], [DiaChi], [ChucVu], [PassWord]) VALUES (N'MNV0010006', N'Ho Quy Bao', N'0678912345 ', N'Binh Thanh TPHCM', N'Lễ tân    ', N'1234567890')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [SDT], [DiaChi], [ChucVu], [PassWord]) VALUES (N'MNV0020003', N'Nguyen CD', N'0345678912 ', N'Quan 12 TPHCM', N'Quản lý   ', N'1234567890')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [SDT], [DiaChi], [ChucVu], [PassWord]) VALUES (N'MNV0020004', N'Tran Van Teo', N'0456789123 ', N'Quan 10 TPHCM', N'Quản lý   ', N'1234567890')
GO
INSERT [dbo].[PhieuDatPhong] ([MaPDP], [NgayDat], [TienCoc], [MaKh], [MaPhong], [DaThanhToan]) VALUES (N'MPDP1     ', CAST(N'2023-10-10' AS Date), 150000, N'MKH0001110', N'MP001', 1)
INSERT [dbo].[PhieuDatPhong] ([MaPDP], [NgayDat], [TienCoc], [MaKh], [MaPhong], [DaThanhToan]) VALUES (N'MPDP2     ', CAST(N'2023-11-10' AS Date), 150000, N'MKH0001110', N'MP002', 1)
INSERT [dbo].[PhieuDatPhong] ([MaPDP], [NgayDat], [TienCoc], [MaKh], [MaPhong], [DaThanhToan]) VALUES (N'MPDP3     ', CAST(N'2023-10-10' AS Date), 300000, N'MKH0001110', N'MP003', 1)
INSERT [dbo].[PhieuDatPhong] ([MaPDP], [NgayDat], [TienCoc], [MaKh], [MaPhong], [DaThanhToan]) VALUES (N'MPDP4     ', CAST(N'2023-12-10' AS Date), 500000, N'MKH0001110', N'MP004', 1)
GO
INSERT [dbo].[PhieuDichVu] ([MaPDV], [MaKH], [TongTien], [DaThanhToan]) VALUES (N'MPDV1     ', N'MKH0001110', 100, 1)
INSERT [dbo].[PhieuDichVu] ([MaPDV], [MaKH], [TongTien], [DaThanhToan]) VALUES (N'MPDV2     ', N'MKH0001110', 200, 1)
INSERT [dbo].[PhieuDichVu] ([MaPDV], [MaKH], [TongTien], [DaThanhToan]) VALUES (N'MPDV3     ', N'MKH0001110', 300, 1)
INSERT [dbo].[PhieuDichVu] ([MaPDV], [MaKH], [TongTien], [DaThanhToan]) VALUES (N'MPDV4     ', N'MKH0001110', 200000, 1)
GO
INSERT [dbo].[PhieuPhat] ([MaPP], [NoiDung], [NgayPhat], [SoTien], [DaThanhToan]) VALUES (N'MPP1      ', N'Giường gãy', CAST(N'2023-10-14' AS Date), 1200000, 1)
INSERT [dbo].[PhieuPhat] ([MaPP], [NoiDung], [NgayPhat], [SoTien], [DaThanhToan]) VALUES (N'MPP2      ', N'Ghế gãy', CAST(N'2023-10-16' AS Date), 500000, 1)
INSERT [dbo].[PhieuPhat] ([MaPP], [NoiDung], [NgayPhat], [SoTien], [DaThanhToan]) VALUES (N'MPP3      ', N'Đèn hỏng', CAST(N'2023-10-20' AS Date), 750000, 1)
GO
INSERT [dbo].[Phong] ([MaPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'MP001     ', 0, N'MLP001    ')
INSERT [dbo].[Phong] ([MaPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'MP002     ', 0, N'MLP001    ')
INSERT [dbo].[Phong] ([MaPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'MP003     ', 0, N'MLP001    ')
INSERT [dbo].[Phong] ([MaPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'MP004     ', 0, N'MLP002    ')
INSERT [dbo].[Phong] ([MaPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'MP005     ', 0, N'MLP003    ')
INSERT [dbo].[Phong] ([MaPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'MP006     ', 0, N'MLP003    ')
INSERT [dbo].[Phong] ([MaPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'MP007     ', 0, N'MLP003    ')
INSERT [dbo].[Phong] ([MaPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'MP008     ', 0, N'MLP002    ')
INSERT [dbo].[Phong] ([MaPhong], [TinhTrang], [MaLoaiPhong]) VALUES (N'MP009     ', 0, N'MLP002    ')
GO
INSERT [dbo].[TienNghi] ([MaTNghi], [TenTNghi], [SoLuong]) VALUES (N'MTN001    ', N'Tủ lạnh', 0)
INSERT [dbo].[TienNghi] ([MaTNghi], [TenTNghi], [SoLuong]) VALUES (N'MTN002    ', N'Tivi', 0)
INSERT [dbo].[TienNghi] ([MaTNghi], [TenTNghi], [SoLuong]) VALUES (N'MTN003    ', N'Tủ đồ', 0)
INSERT [dbo].[TienNghi] ([MaTNghi], [TenTNghi], [SoLuong]) VALUES (N'MTN004    ', N'Máy giặt', 0)
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_DichVu] FOREIGN KEY([MaDV])
REFERENCES [dbo].[DichVu] ([MaDV])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_DichVu]
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_PhieuDichVu] FOREIGN KEY([MaPDV])
REFERENCES [dbo].[PhieuDichVu] ([MaPDV])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_PhieuDichVu]
GO
ALTER TABLE [dbo].[ChiTietTienNghi]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietTienNghi_Phong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[ChiTietTienNghi] CHECK CONSTRAINT [FK_ChiTietTienNghi_Phong]
GO
ALTER TABLE [dbo].[ChiTietTienNghi]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietTienNghi_TienNghi] FOREIGN KEY([MaTNghi])
REFERENCES [dbo].[TienNghi] ([MaTNghi])
GO
ALTER TABLE [dbo].[ChiTietTienNghi] CHECK CONSTRAINT [FK_ChiTietTienNghi_TienNghi]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_PhieuDatPhong] FOREIGN KEY([MaPDP])
REFERENCES [dbo].[PhieuDatPhong] ([MaPDP])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_PhieuDatPhong]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_PhieuDichVu] FOREIGN KEY([MaPDV])
REFERENCES [dbo].[PhieuDichVu] ([MaPDV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_PhieuDichVu]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_PhieuPhat] FOREIGN KEY([MaPP])
REFERENCES [dbo].[PhieuPhat] ([MaPP])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_PhieuPhat]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Phong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Phong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([MaLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([MaLoaiPhong])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO

