CREATE DATABASE JB_DOAN_SHOPCLOTHES
GO

USE JB_DOAN_SHOPCLOTHES
GO

CREATE TABLE Category(
	CategoryId int IDENTITY(1,1) primary key,
	CategoryName nvarchar(100) not null unique,
	ParentId int not null default(0),
	--MetaLink nvarchar(max) not null,	--Link danh mục
	--DisplayNo int,	--Thứ tự hiển thị
	--IconImg nvarchar(max),	--Ảnh Icon
	--FeatureImg nvarchar(max),	--Ảnh đại diện
	ShowCategory bit,
	[Description] nvarchar(max),	--Mô tả
	[Status] bit
)
GO

INSERT INTO Category VALUES
(N'Shop', 0,0, 'Shop',1),
(N'Blog', 0,0, 'Blog',1),
(N'Men', 1,1, 'Men',1),
(N'Women', 1, 1,'Women',1),
(N'Kid', 1, 1,'Kid',1),
(N'Underwear', 1,1,'Underwear',1),
(N'Brand Fashion', 1,1, 'Brand Fashion',1),
(N'Accessories', 1,1, 'Accessories',1),
(N'Luxury Brands', 1,1, 'Luxury Brands',1),
(N'Bag', 1,1, 'Bag',1),
(N'Travel',2,1, 'Travel',1),
(N'Fashion',2,1,'Fashion',1),
(N'Model',2,1,'Model',1),
(N'Pinic',2,0,'Pinic',1),
(N'Beauty',2,0,'Beauty',1)
GO



CREATE TABLE Provider(
	ProviderId int IDENTITY(1,1) primary key,	--Mã nhà cung cấp	
	ProviderName nvarchar(100) not null unique,	--Tên nhà cung cấp
	Logo nvarchar(max),	--Ảnh Logo
	[Description] nvarchar(max),	--Mô tả
	[Status] bit
)
GO

INSERT INTO Provider VALUES
(N'S-Shop', 'imgs','men clothes',1),
(N'E-Shop', 'imgs','women clothes',1),
(N'X-SHop', 'imgs','clothes',1),
(N'XX-SHop', 'imgs','clothes',1)
GO


CREATE TABLE Brand(
	BrandId int IDENTITY(1,1) primary key,	-- Mã nhãn hàng
	BrandName nvarchar(100) not null unique,	--Tên nhãn hàng
	Logo nvarchar(max),	--Ảnh Logo
	[Description] nvarchar(max),	--Mô tả
	[Status] bit
)
GO
INSERT INTO Brand VALUES
(N'Calvin Klein', 'imgs','men clothes',1),
(N'Diesel', 'imgs','women clothes',1),
(N'Polo', 'imgs','clothes',1),
(N'Tommy Hilfiger', 'imgs','clothes',1)
GO

CREATE TABLE Style(
	StyleId int IDENTITY(1,1) primary key,	--Mã nhà cung cấp	
	StyleName nvarchar(100) not null unique,	--Tên nhà cung cấp
	[Description] nvarchar(max),	--Mô tả
	[Status] bit
)
GO
INSERT INTO Style VALUES
(N'Streetwear Style', 'men clothes',1),
(N'Ethnic fashion style ', 'women clothes',1),
(N'Formal Office Wear', 'clothes',1),
(N'Evening Black Tie', 'clothes',1),
(N'Sports Wear', 'clothes',1),
(N'Girly Style ', 'clothes',1),
(N'Hip Hop Style', 'clothes',1),
(N'Underwear Style', 'clothes',1),
(N'Business Casual','clothes',1)
GO

CREATE TABLE Product(
	ProductId int IDENTITY(1,1) primary key,
	ProductName nvarchar(255) not null,
	PriceIn float not null, --Giá nhập
	PriceOut float not null, --Giá bán
	Discount float,	--Giảm giá
	Image nvarchar(255), --Ảnh sản phẩm
	Images nvarchar(max), -- Các ảnh sản phẩm
	[Description] nvarchar(max), --Mô tả sản phẩm
	ProviderId int foreign Key references Provider(ProviderId),	--Mã nhà cung cấp
	BrandId int foreign Key references Brand(BrandId),
	--Quantity int not null,	--Số lượng
	CreateDate datetime,	--Ngày tạo
	UpdateDate datetime,	--Ngày tạo
	CountView int,	--Số lượt xem sp
	CountBuy int,	--Số lượt mua
	ShowHome bit,	--Hiển thị trên trang chủ
	[Status] bit
)
GO
INSERT INTO Product VALUES
(N'Pure Pineapple',23,27,39, 'assets/img/products/women-1.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',2,1,'2022-11-05','2022-11-05',79,69,1,1),
(N'Hoodie Pinse',26,29,37, 'assets/img/products/women-2.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',4,1,'2022-11-05','2022-11-05',56,89,1,1),
(N'Flip flops',28,31,33, 'assets/img/products/women-3.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',3,1,'2022-11-05','2022-11-05',68,35,1,1),
(N'Polo shirt',24,32,38, 'assets/img/products/women-4.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',2,1,'2022-11-05','2022-11-05',135,66,1,1),
(N'Bag Pineapple',23,27,39, 'assets/img/products/man-1.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',1,1,'2022-11-05','2022-11-05',100,48,1,1),
(N'Converse Shoe',26,29,37, 'assets/img/products/man-2.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do  tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',1,1,'2022-11-05','2022-11-05',106,69,1,1),
(N'2 Layer Windbreaker',28,31,33, 'assets/img/products/man-3.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',3,1,'2022-11-05','2022-11-05',108,46,1,1),
(N'Hoodie Pineapple',24,32,38, 'assets/img/products/man-4.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',2,1,'2022-11-05','2022-11-05',104,58,1,1),
(N'Hawaiian shirt',24,36,40, 'assets/img/products/product-1.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',3,3,'2022-11-05','2022-11-05',50,30,0,1),
(N'Long-sleeve top`',23,34,46, 'assets/img/products/product-2.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',4,2,'2022-11-05','2022-11-05',63,26,0,1),
(N'Sweater Pineapple',26,33,39, 'assets/img/products/product-3.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',1,1,'2022-11-05','2022-11-05',66,45,0,1),
(N'Guangzhou sweater',21,32,46, 'assets/img/products/product-4.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',3,3,'2022-11-05','2022-11-05',67,23,0,1),
(N'Mens Painted Hat x',25,39,42, 'assets/img/products/product-5.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',2,1,'2022-11-05','2022-11-05',35,24,0,1),
(N'Trench coat',23,39,56, 'assets/img/products/product-6.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',4,1,'2022-11-05','2022-11-05',35,24,0,1),
(N'Bag heels',24,39,46, 'assets/img/products/product-7.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',2,1,'2022-11-05','2022-11-05',35,24,0,1),
(N'Pure Pineapple',28,40,67, 'assets/img/products/product-8.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',2,1,'2022-11-05','2022-11-05',35,24,0,1),
(N'Converse Shoes',23,29,32, 'assets/img/products/product-9.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',2,1,'2022-11-05','2022-11-05',35,24,0,1)
GO
-- INTO Product VALUES
--(N'Converse Shoes',23,29,32, 'assets/img/products/product-9.jpg','assets/img/product-single/product-1.jpg,assets/img/product-single/product-2.jpg,assets/img/product-single/product-3.jpg,assets/img/product-single/product-1.jpg',
--'Lorem ipsum dolor sit amet, consectetur ing elit, sed do eiusmod tempor sum dolor sit amet, consectetur adipisicing elit, sed do mod tempor',2,1,'2022-11-05','2022-11-05',35,24,0,1)
--GO

CREATE TABLE Product_Category(
	ProductCategoryId int IDENTITY(1,1) primary key,
	ProductId int foreign Key references Product(ProductId) ON DELETE CASCADE,
	CategoryId int foreign Key references Category(CategoryId),	
	
)
GO
INSERT INTO Product_Category VALUES
(1, 4),(2, 4),(3, 4),(4, 4),(5, 3),(6, 3),(7, 3),(8, 3),(9, 3),(10, 4),(11, 4),(12, 4),(13, 4),(14, 4),(15,3),(16, 3),(17, 3),
(1, 5),(2, 5),(3, 7),(4,5),(5, 7),(6, 6),(7, 5),(8,7),(9, 5),(10, 5),(11, 5),(12, 7),(13, 6),(14, 5),(15,8),(16, 7),(17, 6)
GO


CREATE TABLE Product_Style(
	ProductStyleId int IDENTITY(1,1) primary key,
	ProductId int foreign Key references Product(ProductId) ON DELETE CASCADE,
	StyleId int foreign Key references Style(StyleId),
	
)
GO

INSERT INTO Product_Style VALUES
(1, 1),(2, 1),(3, 2),(4, 3),(5, 4),(6, 5),(7, 6),(8, 2),(9, 4),(10,7),(11, 8),(12, 3),(13, 2),(14, 5),(15,4),(16, 7),(17, 5),
(1, 2),(2, 7),(3, 4),(4,5),(5, 6),(6, 3),(7, 2),(8,4),(9,6),(10, 7),(11, 4),(12, 5),(13, 8),(14, 7),(15,8),(16, 7),(17,3),
(1, 3),(2, 5),(3, 7),(4,6),(5, 6),(6,8),(7, 4),(8,6),(9,7),(10, 8),(11,3),(12, 4),(13, 7),(14, 3),(15,4),(16, 2),(17,1)
GO

CREATE Table Color (
	ColorId int IDENTITY(1,1) primary key,
	Color varchar(25) unique,	
)
GO
INSERT INTO Color VALUES
('black'),('gray'),('blue'),('red'),('yellow'),('violet'),('green'),('white')

GO
CREATE Table Size(
	SizeId int IDENTITY(1,1) primary key,
	Size varchar(25) unique,
)
GO
INSERT INTO Size VALUES
('S'),('L'),('XL'),('XXL'),('XXXL'),('No-Size'),
('37'),('38'),('39'),('40'),('41'),('42'),('43')
GO

CREATE  Table Product_Color (
	ProductColorId int IDENTITY(1,1) primary key,
	ProductId int foreign Key references Product(ProductId) ON DELETE CASCADE,
	ColorId int foreign Key references Color(ColorId),
	[Status] bit 
)
GO
INSERT INTO Product_Color VALUES
(1, 1, 1 ),(1, 2, 1 ),(1, 3, 1 ),(1, 4, 1 ),(1, 8, 1 ),
(2, 1, 1 ),(2, 2, 1 ),(2, 7, 1 ),(2, 4, 1 ),(2, 6, 1 ),
(3, 1, 1 ),(3, 5, 1 ),(3, 6, 1 ),(3, 7, 1 ),(3, 8, 1 ),
(4, 1, 1 ),(4, 3, 1 ),(4, 4, 1 ),(4, 6, 1 ),(4, 7, 1 ),
(5, 1, 1 ),(5, 8, 1 ),(5, 7, 1 ),(5, 4, 1 ),(5, 8, 1 ),
(6, 1, 1 ),(6,3, 1 ),(5, 4, 1 ),(6, 6, 1 ),(6, 7, 1 ),
(7, 1, 1 ),(7, 4, 1 ),(7, 2, 1 ),(7, 5, 1 ),(7, 6, 1 ),
(8, 1, 1 ),(8, 2, 1 ),(8, 3, 1 ),(8, 4, 1 ),(8, 8, 1 ),
(9, 1, 1 ),(9, 2, 1 ),(9, 7, 1 ),(9, 4, 1 ),(9, 6, 1 ),
(10, 1, 1 ),(10, 5, 1 ),(10, 6, 1 ),(10, 7, 1 ),(10, 8, 1 ),
(11, 1, 1 ),(11, 2, 1 ),(11, 3, 1 ),(11, 4, 1 ),(11, 8, 1 ),
(12, 1, 1 ),(12, 2, 1 ),(12, 7, 1 ),(12, 4, 1 ),(12, 6, 1 ),
(13, 1, 1 ),(13, 5, 1 ),(13, 6, 1 ),(13, 5, 1 ),(13, 8, 1 ),
(14, 1, 1 ),(14, 3, 1 ),(14, 4, 1 ),(14, 6, 1 ),(14, 7, 1 ),
(15, 1, 1 ),(15, 3, 1 ),(15, 7, 1 ),(15, 4, 1 ),(15, 8, 1 ),
(16, 1, 1 ),(16,3, 1 ),(16, 4, 1 ),(16, 6, 1 ),(16, 7, 1 ),
(17, 1, 1 ),(17, 4, 1 ),(17, 2, 1 ),(17, 4, 1 ),(17, 6, 1 )
GO

CREATE Table Product_Size (
	ProductSizeId int IDENTITY(1,1) primary key,
	ProductId int foreign Key references Product(ProductId) ON DELETE CASCADE,
	SizeId int foreign Key references Size(SizeId),
	[Status] bit
)
GO

INSERT INTO Product_Size VALUES
(1, 1, 1 ),(1, 2, 1 ),(1, 3, 1 ),(1, 4, 1 ),(1, 5, 1 ),
(2, 1, 1 ),(2, 2, 1 ),(2, 3, 1 ),(2, 4, 1 ),(2, 5, 1 ),
(3, 1, 1 ),(3, 2, 1 ),(3, 3, 1 ),(3, 4, 1 ),(3, 5, 1 ),
(4, 1, 1 ),(4, 2, 1 ),(4, 3, 1 ),(4, 4, 1 ),(4, 5, 1 ),
(5, 1, 6),
(6, 7, 1 ),(6, 8, 1 ),(6, 9, 1 ),(6, 10, 1 ),(6, 11, 1 ),(6, 12, 1 ),(6, 13, 1),
(7, 1, 1 ),(7, 2, 1 ),(7, 3, 1 ),(7, 4, 1 ),(7, 5, 1 ),
(8, 1, 1 ),(8, 2, 1 ),(8, 3, 1 ),(8, 4, 1 ),(8, 5, 1 ),
(9, 1, 1 ),(9, 2, 1 ),(9, 3, 1 ),(9, 4, 1 ),(9, 5, 1 ),
(10, 1, 1 ),(10, 2, 1 ),(10, 3, 1 ),(10, 4, 1 ),(10, 5, 1 ),
(11, 1, 1 ),(11, 2, 1 ),(11, 3, 1 ),(11, 4, 1 ),(11, 5, 1 ),
(12, 1, 1 ),(12, 2, 1 ),(12, 3, 1 ),(12, 4, 1 ),(12, 5, 1 ),
(13, 1, 6),
(14, 1, 1 ),(14, 2, 1 ),(14, 3, 1 ),(14, 4, 1 ),(14, 5, 1 ),
(15, 1, 1 ),(15, 2, 1 ),(15, 3, 1 ),(15, 4, 1 ),(15, 5, 1 ),
(16, 1, 1 ),(16, 2, 1 ),(16, 3, 1 ),(16, 4, 1 ),(16, 5, 1 ),
(17, 7, 1 ),(17, 8, 1 ),(17, 9, 1 ),(17, 10, 1 ),(17, 11, 1 ),(17, 12, 1 ),(17, 13, 1)
GO


CREATE TABLE SliderHome  (	--Quản lý slide trên trang chủ
	SliderId int IDENTITY(1,1) primary key,	--Mã slide
	SliderImg  nvarchar(255) not null,	--Ảnh slide
	Title nvarchar(255),
	[Description] nvarchar(max),
	Sale int,
	CreateDate datetime,
	DisplayNo int,	--Thứ tự hiển thị
	[Status] bit
)
GO
INSERT INTO SliderHome VALUES
('assets/img/hero-1.jpg', 'Black friday', ' Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore',50,'2022-11-05',1,1),
('assets/img/hero-2.jpg', 'Black friday', ' Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore',50,'2022-11-05',2,1)
GO


CREATE TABLE Blog(
	BlogId int IDENTITY(1,1) primary key,
	BlogTitle nvarchar(255) not null unique,
	BlogContent nvarchar(max),	--Nội dung bài viết
	Author nvarchar(100),	--Tên tác giả
	Description nvarchar(max),	--Mô tả
	FeatureImg nvarchar(max),	--Ảnh đại diện
	Imgs nvarchar(max),
	CreateDate datetime,	--Ngày tạo
	ShowHome bit default(0),
	[Status] bit
)
GO
INSERT INTO Blog VALUES
('The Personality Trait That Makes People Happier','Psum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate.',
'Author','Description','assets/img/blog/blog-1.jpg','assets/img/blog/blog-detail-1.jpg,assets/img/blog/blog-detail-2.jpg,assets/img/blog/blog-detail-3.jpg','2022-11-05',1,1),
('This was one of our first days in Hawaii last week.','Psum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate.',
'Author','Description','assets/img/blog/blog-2.jpg','assets/img/blog/blog-detail-1.jpg,assets/img/blog/blog-detail-2.jpg,assets/img/blog/blog-detail-3.jpg','2022-11-05',1,1),
('Last week I had my first work trip of the year to Sonoma Valley','Psum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate.',
'Author','Description','assets/img/blog/blog-3.jpg','assets/img/blog/blog-detail-1.jpg,assets/img/blog/blog-detail-2.jpg,assets/img/blog/blog-detail-3.jpg','2022-11-05',1,1),
('Happppppy New Year! I know I am a little late on this post','Psum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate.',
'Author','Description','assets/img/blog/blog-4.jpg','assets/img/blog/blog-detail-1.jpg,assets/img/blog/blog-detail-2.jpg,assets/img/blog/blog-detail-3.jpg','2022-11-05',0,1),
('Absolue collection. The Lancome team has been one…','Psum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate.',
'Author','Description','assets/img/blog/blog-5.jpg','assets/img/blog/blog-detail-1.jpg,assets/img/blog/blog-detail-2.jpg,assets/img/blog/blog-detail-3.jpg','2022-11-05',0,1),
('Writing has always been kind of therapeutic for me','Psum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate.',
'Author','Description','assets/img/blog/blog-6.jpg','assets/img/blog/blog-detail-1.jpg,assets/img/blog/blog-detail-2.jpg,assets/img/blog/blog-detail-3.jpg','2022-11-05',0,1)
GO

CREATE TABLE Blog_Category(
	CategoryBlogId int IDENTITY(1,1) primary key,
	BlogId int foreign Key references Blog(BlogId) ON DELETE CASCADE,
	CategoryId int foreign Key references Category(CategoryId),	
)
GO
INSERT INTO Blog_Category VALUES
(1,10),(1,14),(1,13),(2,11),(2,13),(2,14),(3,12),(3,13),(3,14),
(4,10),(4,11),(4,14),(5,13),(2,11),(5,12),(5,13),(6,12),(6,13),(6,14)
GO


CREATE TABLE Customer(
	CustomerId int IDENTITY(1,1) primary key,	--Mã khách hàng
	Email nvarchar(255) not null unique,	--Địa chỉ Email
	[Password] nvarchar(255) not null,	--Mật khẩu
	Phone varchar(20) unique,	--Số điện thoại
	FirstName nvarchar(255), --Tên khách hàng
	LastName nvarchar(255),
	Country nvarchar(255),
	City nvarchar(255),	--Địa chỉ
	StreetAddress nvarchar(255),
	Postcode nvarchar(255),	
	Avatar nvarchar(255),	--Ảnh đại diện
	--Balance float,	--Số dư tài khoản
	CreateDate datetime, --Ngày tạo
	CodeConfirm varchar(5),	--Mã xác nhận
	[Status] bit
)
GO
INSERT INTO Customer VALUES
('','','','','','','','', '','','',' ',1 ),
('brandon@gmail.com','123456','0966741332','Brandon','Kelley','America','New York','37 Buffalo Street', ' ','assets/img/product-single/avatar-1.png','2022-01-05',' ',1 ),
('roybanks@gmail.com','123456','0966795362','Roy','Banks ','America','New York','37 Buffalo Street', ' ','assets/img/product-single/avatar-2.png','2022-01-05',' ',1 ),
('johnwick@gmail.com','123456','0966345362','John','Wick ','America','New York','38 Buffalo Street', ' ','assets/img/product-single/avatar-3.png','2022-01-05',' ',1 )
GO

CREATE TABLE Feeback (
	FeedbackId int IDENTITY(1,1) primary key, --Mã phản hồi
	ProductId int foreign Key references Product(ProductId) ON DELETE CASCADE,
	CustomerId int foreign Key references Customer(CustomerId),
	FullName  nvarchar(100) not null,	--Tên người gửi
	Email varchar(100),	--Email người gửi
	Avatar nvarchar(255),
	--Title nvarchar(255),	--Tiêu đề
	Content nvarchar(max),	--Nội dung
	Rate int,
	CreateDate datetime,	--Ngày tạo
	[Status] bit
)
GO

INSERT INTO Feeback VALUES
(1,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',5,'2022-12-05',1),
(2,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',4,'2022-12-05',1),
(3,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','beautiful!',5,'2022-12-05',1),
(4,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',4,'2022-12-05',1),
(5,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',4,'2022-12-05',1),
(7,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','beautiful!',5,'2022-12-05',1),
(8,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',4,'2022-12-05',1),
(9,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',5,'2022-12-05',1),
(10,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',5,'2022-12-05',1),
(11,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','beautiful!',4,'2022-12-05',1),
(12,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',5,'2022-12-05',1),
(13,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','beautiful!',5,'2022-12-05',1),
(14,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','beautiful!',4,'2022-12-05',1),
(15,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',5,'2022-12-05',1),
(17,1,'Brandon Kelley','brandon@gmail.com','assets/img/product-single/avatar-1.png','Nice!',5,'2022-12-05',1),
(1,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Nice!',4,'2022-12-05',1),
(2,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Perfect!',5,'2022-12-05',1),
(3,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Perfect!',5,'2022-12-05',1),
(4,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Nice!',4,'2022-12-05',1),
(5,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Nice!',5,'2022-12-05',1),
(7,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Perfect!',5,'2022-12-05',1),
(8,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','beautiful!',4,'2022-12-05',1),
(9,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Perfect!',5,'2022-12-05',1),
(10,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Perfect!',5,'2022-12-05',1),
(11,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','beautiful!',4,'2022-12-05',1),
(12,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Nice!',4,'2022-12-05',1),
(13,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Perfect!',5,'2022-12-05',1),
(14,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Nice!',4,'2022-12-05',1),
(15,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','beautiful!',5,'2022-12-05',1),
(17,2,'Roy Banks','roybanks@gmail.com','assets/img/product-single/avatar-2.png','Perfect!',5,'2022-12-05',1)
GO

INSERT INTO Feeback VALUES
(1,3,'John Wick','johnkwick@gmail.com','assets/img/product-single/avatar-3.jpg','Perfect!',5,'2022-12-05',1),
(2,3,'John Wick','johnkwick@gmail.com','assets/img/product-single/avatar-3.jpg','Nice!',4,'2022-12-05',1),
(3,3,'John Wick','johnkwick@gmail.com','assets/img/product-single/avatar-3.jpg','beautiful!',5,'2022-12-05',1),
(4,3,'John Wick','johnkwick@gmail.com','assets/img/product-single/avatar-3.jpg','beautiful!',4,'2022-12-05',1)
GO


CREATE TABLE Favorite(
	FavoriteId int IDENTITY(1,1) primary key,
	CustomerId int foreign Key references Customer(CustomerId) ON DELETE CASCADE,
	CreateDate datetime,
	[Status] bit
)
INSERT INTO Favorite VALUES
(1,'2022-12-05',1),
(2,'2022-12-05',1)
GO

CREATE TABLE Product_Favorite(
	ProductFavoriteId int IDENTITY(1,1) primary key,
	ProductId int foreign Key references Product(ProductId) ON DELETE CASCADE,
	FavoriteId int foreign Key references Favorite(FavoriteId)ON DELETE CASCADE,
	[Status] bit
)
INSERT INTO Product_Favorite VALUES
--(1,1,1),
--(1,2,1),
(2,2,1)
GO

CREATE TABLE [Orders](
	OrderId int IDENTITY(1,1) primary key,	--Mã đơn hàng
	CustomerId int foreign Key references Customer(CustomerId) ON DELETE CASCADE,	--Mã khách hàng
	FirstName nvarchar(255)  not null, --Tên khách hàng
	LastName nvarchar(255)  not null,
	Email nvarchar(100) not null,	--Email người nhận
	Phone nvarchar(20), --SĐT người nhận
	Country nvarchar(255),
	City nvarchar(255),	--Địa chỉ người nhận
	StreetAddress nvarchar(255),
	Postcode nvarchar(255),	
	Total float,	--Tổng tiền
	CreateDate datetime, --Ngày tạo
	UpdateDate datetime, --Cập nhật
	[Status] bit
)
GO
--INSERT INTO [Orders] VALUES
--(1,'Roy',' Banks','roybanks@gmail.com','0966795362','Country','City','StreetAddress','Postcode',33,'2022-12-05',1)
--GO
CREATE TABLE OrderDetail(
	OrderDetailId int IDENTITY(1,1) primary key, --Mã chi tiết
	OrderId int foreign Key references [Orders](OrderId) ON DELETE CASCADE,	--Mã đơn hàng
	ProductId int foreign Key references Product(ProductId) ON DELETE CASCADE,	--Mã sản phẩm
	ColorId int foreign Key references Color(ColorId) ON DELETE CASCADE,
	SizeId int foreign Key references Size(SizeId) ON DELETE CASCADE,
	Quatity int,	--Số lượng
	Price float,	--Đơn giá
	CreateDate datetime,
	[Status] bit
)
GO
--INSERT INTO OrderDetail VALUES
--(1,1,3,26,'2022-12-05'),
--(1,2,1,26,'2022-12-05')
--GO

CREATE TABLE [Users](
	UserId int IDENTITY(1,1) primary key, 
	Email varchar(100) not null unique,  --Email người dùng
	[Password] varchar(100) not null, --Mật khẩu
	Name nvarchar(100) not null unique,		--Họ tên
	Phone varchar(20) not null unique,	--Số điện thoại
	Status bit,
)
GO

INSERT INTO [Users] VALUES
('admin@gmail.com','$2a$12$APWKzq43slDGH1HeN8TfB.LBhlaScVr2qQpTzarXB12Uwdk4tK.he','admin','0976897563',1)
GO


CREATE PROC [sp_Category_Select_Name]
	@Name NVARCHAR(100)
AS
BEGIN
	SELECT c.CategoryId, c.CategoryName, p.ProductId, p.ProductName, p.PriceOut, p.Discount, p.Image,p.Images, p.Description, p.CountView,p.Description, b.BrandName, pv.ProviderName, sz.Size,st.StyleName,cl.Color
	 FROM Category c
	JOIN Product_Category pc ON pc.CategoryID = c.CategoryID
	JOIN Product p ON pc.ProductId = p.ProductId
	JOIN Brand b ON p.BrandId = b.BrandId
	JOIN Provider pv ON p.ProviderId = pv.ProviderId
	JOIN Product_Size ps ON p.ProductId = ps.ProductId
	JOIN Size sz ON sz.SizeId = ps.SizeId
	JOIN Product_Style pst ON p.ProductId = pst.ProductId
	JOIN Style st ON st.StyleId = pst.StyleId
	JOIN Product_Color pcl ON p.ProductId = pcl.ProductId
	JOIN Color cl ON pcl.ColorId = cl.ColorId
	WHERE c.CategoryName like 'men'
END
GO

CREATE PROC [sp_Product_Select_Name]
	@Name NVARCHAR(100)
AS
BEGIN
	SELECT c.CategoryId, c.CategoryName, p.ProductId, p.ProductName, p.PriceOut, p.Discount, p.Image,p.Images, p.Description, p.CountView, b.BrandName, pv.ProviderName, sz.Size,st.StyleName,cl.Color
	 FROM Product p
	JOIN Product_Category pc ON  pc.ProductId = p.ProductId
	JOIN Category c ON pc.CategoryID = c.CategoryID
	JOIN Brand b ON p.BrandId = b.BrandId
	JOIN Provider pv ON p.ProviderId = pv.ProviderId
	JOIN Product_Size ps ON p.ProductId = ps.ProductId
	JOIN Size sz ON sz.SizeId = ps.SizeId
	JOIN Product_Style pst ON p.ProductId = pst.ProductId
	JOIN Style st ON st.StyleId = pst.StyleId
	JOIN Product_Color pcl ON p.ProductId = pcl.ProductId
	JOIN Color cl ON pcl.ColorId = cl.ColorId
	WHERE c.CategoryName like 'men' 
END
GO

CREATE PROC [sp_Product_Find_Name]
	@Name NVARCHAR(100)
AS
BEGIN
	SELECT *
	FROM Product p
	WHERE p.ProductName like 'men' 
END
GO


CREATE VIEW  [vw_Product] AS 
	SELECT DISTINCT c.CategoryId, c.CategoryName, p.ProductId, p.ProductName, p.PriceOut, p.Discount, p.Image,p.Images, p.CountView, b.BrandName, pv.ProviderName, sz.Size,st.StyleName,cl.Color
	 FROM Product p
	JOIN Product_Category pc ON  pc.ProductId = p.ProductId
	JOIN Category c ON pc.CategoryID = c.CategoryID
	JOIN Brand b ON p.BrandId = b.BrandId
	JOIN Provider pv ON p.ProviderId = pv.ProviderId
	JOIN Product_Size ps ON p.ProductId = ps.ProductId
	JOIN Size sz ON sz.SizeId = ps.SizeId
	JOIN Product_Style pst ON p.ProductId = pst.ProductId
	JOIN Style st ON st.StyleId = pst.StyleId
	JOIN Product_Color pcl ON p.ProductId = pcl.ProductId
	JOIN Color cl ON pcl.ColorId = cl.ColorId	
GO

SELECT * FROM [vw_Product]
GO

SELECT DISTINCT p.* FROM Product p
			
			JOIN Product_Category pc ON  pc.ProductId = p.ProductId
			JOIN Category c ON pc.CategoryID = c.CategoryID JOIN Brand b ON p.BrandId = b.BrandId
			JOIN Provider pv ON p.ProviderId = pv.ProviderId
			JOIN Product_Size ps ON p.ProductId = ps.ProductId	JOIN Size sz ON sz.SizeId = ps.SizeId
			JOIN Product_Style pst ON p.ProductId = pst.ProductId	JOIN Style st ON st.StyleId = pst.StyleId
			JOIN Product_Color pcl ON p.ProductId = pcl.ProductId
			JOIN Color cl ON pcl.ColorId = cl.ColorId
go




SELECT * from Category c Where c.CategoryName like 'men'

GO
DELETE FROM Product 
  WHERE ProductId = 17
GO
SELECT * FROM Product
	WHERE ProductId = 19
GO
SELECT * FROM Product
GO
SELECT pc.* FROM Product_Category pc
	JOIN Product p ON  pc.ProductId = p.ProductId
	JOIN Category c ON pc.CategoryID = c.CategoryID where p.ProductId = 9 
GO
SELECT c.* FROM Category c
	JOIN Product_Category pc ON pc.CategoryId = c.CategoryId
	JOIN Product p ON  pc.ProductId = p.ProductId WHERE p.ProductId = 1
GO
SELECT DISTINCT p.* FROM Product p 
	JOIN Product_Size ps ON  ps.ProductId = p.ProductId
	JOIN Size  s ON s.SizeId = ps.SizeId Where s.size  = 'S'
GO
SELECT DISTINCT COUNT(DISTINCT p.ProductId) AS NumberOfProducts,p.* FROM Product p 
	JOIN Product_Size ps ON  ps.ProductId = p.ProductId
	JOIN Size  s ON s.SizeId = ps.SizeId Where p.ProductName like 'pure' OR s.size = ''
GO
SELECT DISTINCT COUNT(p.ProductId) AS NumberOfProducts from Product p
GO
SELECT DISTINCT p.* FROM Product p 
--JOIN Product_Size ps ON  ps.ProductId = p.ProductId
--	JOIN Size  s ON s.SizeId = ps.SizeId
JOIN Product_Category pc ON pc.ProductId = p.ProductId
JOIN Category c ON pc.CategoryID = c.CategoryID 
	where p.priceOut between 10 and 200 or c.CategoryName like 'Men'
GO
SELECT DISTINCT  p.* FROM Product p JOIN Product_Category pc ON  pc.ProductId = p.ProductId
				JOIN Category c ON pc.CategoryID = c.CategoryID	JOIN Brand b ON p.BrandId = b.BrandId
			JOIN Provider pv ON p.ProviderId = pv.ProviderId
			JOIN Product_Size ps ON p.ProductId = ps.ProductId JOIN Size sz ON sz.SizeId = ps.SizeId
			JOIN Product_Style pst ON p.ProductId = pst.ProductId JOIN Style st ON st.StyleId = pst.StyleId
			JOIN Product_Color pcl ON p.ProductId = pcl.ProductId JOIN Color cl ON pcl.ColorId = cl.ColorId
			JOIN Provider provider ON provider.ProviderId = p.ProviderId
			WHERE p.priceOut between 10 and 20 OR c.CategoryName like 'x'
			OR cl.color = 'x' OR sz.size  = 'x' OR b.BrandName like 'x'
			OR st.StyleName like 'x'
GO

SELECT DISTINCT s.* FROM Size s 
	JOIN Product_Size ps ON s.SizeId = ps.SizeId 
	JOIN Product p ON ps.ProductId = p.ProductId WHERE p.ProductId  = 1
GO

CREATE PROC [sp_Product_Filter]
	@minPrice float,
	@maxPrice float,
	@categoryName nvarchar(100),
	@color varchar(25),
	@size varchar(25),
	@brandName nvarchar(100),
	@styleName nvarchar(100)
AS
BEGIN
	SELECT p.*
	 FROM Product p
	JOIN Product_Category pc ON  pc.ProductId = p.ProductId
	JOIN Category c ON pc.CategoryID = c.CategoryID
	JOIN Brand b ON p.BrandId = b.BrandId
	JOIN Provider pv ON p.ProviderId = pv.ProviderId
	JOIN Product_Size ps ON p.ProductId = ps.ProductId
	JOIN Size sz ON sz.SizeId = ps.SizeId
	JOIN Product_Style pst ON p.ProductId = pst.ProductId
	JOIN Style st ON st.StyleId = pst.StyleId
	JOIN Product_Color pcl ON p.ProductId = pcl.ProductId
	JOIN Color cl ON pcl.ColorId = cl.ColorId
	WHERE p.priceOut BETWEEN @minPrice AND @maxPrice OR c.CategoryName like @categoryName	OR cl.Color = @color OR sz.Size  = @size OR b.BrandName like @brandName OR st.StyleName like @styleName
END
GO

SELECT DISTINCT p.* FROM Product p 
	JOIN Product_Category pc ON  pc.ProductId = p.ProductId
	JOIN Category c ON pc.CategoryId = c.CategoryId Where c.CategoryName like 'Men' AND p.showHome= 1
GO
SELECT DISTINCT c.* from Customer c Where c.email = 'johnwick@gmail.com'
GO
SELECT c.* from Customer c Where c.email = 'johnxxx@gmail.com'
GO
SELECT o.* FROM Orders o JOIN Customer c ON c.CustomerId = o.CustomerId Where c.CustomerId = 3
GO

SELECT DISTINCT p.* from Product p JOIN Product_Category pc ON  pc.ProductId = p.ProductId
				JOIN Category c ON pc.CategoryID = c.CategoryID	JOIN Brand b ON p.BrandId = b.BrandId
				JOIN Provider pv ON p.ProviderId = pv.ProviderId
				JOIN Product_Size ps ON p.ProductId = ps.ProductId JOIN Size sz ON sz.SizeId = ps.SizeId
				JOIN Product_Style pst ON p.ProductId = pst.ProductId JOIN Style st ON st.StyleId = pst.StyleId
				JOIN Product_Color pcl ON p.ProductId = pcl.ProductId JOIN Color cl ON pcl.ColorId = cl.ColorId
				JOIN Provider provider ON provider.ProviderId = p.ProviderId
				WHERE p.priceOut BETWEEN 0 AND 100 OR (c.CategoryName = 'Men'	OR cl.Color = '00000' OR sz.Size  = '00000' OR b.BrandName like '00000' OR st.StyleName like '00000')
GO

SELECT DISTINCT p.* from Product p JOIN Product_Category pc ON  pc.ProductId = p.ProductId
				JOIN Category c ON pc.CategoryID = c.CategoryID	JOIN Brand b ON p.BrandId = b.BrandId
				JOIN Provider pv ON p.ProviderId = pv.ProviderId
				JOIN Product_Size ps ON p.ProductId = ps.ProductId JOIN Size sz ON sz.SizeId = ps.SizeId
				JOIN Product_Style pst ON p.ProductId = pst.ProductId JOIN Style st ON st.StyleId = pst.StyleId
				JOIN Product_Color pcl ON p.ProductId = pcl.ProductId JOIN Color cl ON pcl.ColorId = cl.ColorId
				JOIN Provider provider ON provider.ProviderId = p.ProviderId
				WHERE  c.CategoryName like 'Men'
GO

SELECT DISTINCT COUNT(ProductCategoryId) AS NumberOfProductCategorys from Product_Category
GO