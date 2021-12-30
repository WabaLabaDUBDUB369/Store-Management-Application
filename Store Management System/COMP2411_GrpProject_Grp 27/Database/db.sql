-- Database: `f1`
DROP TABLE customer;
DROP TABLE employee;
DROP TABLE supplier;
DROP TABLE login;
DROP TABLE product;
DROP TABLE purchaseinfo;


-- Table structure for table `customer`
CREATE TABLE customer (
  userId varchar(10) NOT NULL PRIMARY KEY,
  customerName varchar(30) NOT NULL,
  phoneNumber varchar(14) NOT NULL,
  address varchar(50) NOT NULL
);


-- Data for table `customer`
INSERT INTO customer VALUES('J101', 'James', '+85260756898', '55/F,Longham Place');
INSERT INTO customer VALUES('T809', 'Tony','+85290823742', 'T87,Ai Kok Tsui Road');
INSERT INTO customer VALUES('C483', 'Carl', '+85245976480', '610 Nathan Road,Mongkok');
INSERT INTO customer VALUES('B508', 'Bobby', '+85298064089', 'Dominion Centre Wan Chai');
INSERT INTO customer VALUES('J658', 'Jenny', '+85245975401', '42/46 Shanghai Street,Jordan,Kowloon ');
INSERT INTO customer VALUES('J201', 'Jones', '+85270568374', 'Tsun King Road Shatin,Eastern District');
INSERT INTO customer VALUES('R001', 'Raymond', '+85260779245', 'Capitol Centre,Causeway Bay');
INSERT INTO customer VALUES('C998', 'Conor', '+85256090034', 'Fortress Tower 250,Kings Road North Point');
INSERT INTO customer VALUES('D881', 'Donald', '+85210358546', '17-21 Kung Yip');
INSERT INTO customer VALUES('P771', 'Patricia', '+85230986946', '23 Luk Hop Street,Sanpokong');
INSERT INTO customer VALUES('H434', 'Henry', '+85245930568', 'Bonham Centre,Sheung Wan');
INSERT INTO customer VALUES('R604', 'Rory', '+85210294856', '23-31 Kung Yip Street,Kwai Tsing District');
INSERT INTO customer VALUES('k929', 'karen', '+85229485038', '12 Hing Yip Street,Kwun Tong District');
INSERT INTO customer VALUES('M112', 'Mathew', '+85295062945', '555 Nathan Rd.,Kowloon City District');
INSERT INTO customer VALUES('J556', 'Jacky', '+8524593056', '99 Queens Rd Central Hk,Wan Chai District');
INSERT INTO customer VALUES('V009', 'Vanicia', '+85226328283', '287-299 Queens Road Central,Wan Chai District');
INSERT INTO customer VALUES('D192', 'Donnie', '+85229374625', '888 Canton Road.,Tsim Sha Tsui');
INSERT INTO customer VALUES('A339', 'Anthony', '+85236452745', '8 Hysan Avenue Causeway Bay,Wan Chai District');



-- Table structure for table `employee`
CREATE TABLE employee (
  userId varchar(10) NOT NULL PRIMARY KEY,
  employeeName varchar(50) NOT NULL,
  phoneNumber varchar(14) NOT NULL,
  role varchar(8) NOT NULL,
  salary number(8,2) NOT NULL
);


-- Data for table `employee`
INSERT INTO employee VALUES('W938', 'William', '+85210293475', 'Manager', 50000.00);
INSERT INTO employee VALUES('C923', 'Christopher', '+85202937465', 'General', 30000.00);
INSERT INTO employee VALUES('D010', 'Daisy', '+85260796309', 'General', 25000.00);
INSERT INTO employee VALUES('J495', 'Josh', '+85283749283', 'General', 15000.00);
INSERT INTO employee VALUES('A655', 'Alexis', '+85273942323', 'Manager', 40000.00);
INSERT INTO employee VALUES('D238', 'Dennis', '+85247353364', 'General', 20000.00);




--
-- Table structure for table `supplier`
--

CREATE TABLE supplier (
  supplierId varchar(10) NOT NULL PRIMARY KEY,
  supplierName varchar(50) NOT NULL,
  supplierLocation varchar(50) NOT NULL,
  productId varchar(50) NOT NULL
);

--
-- Data for table `supplier`
--

INSERT INTO supplier VALUES('H01', 'HYGIENE SUPPLY', 'CENTRAL', '3, 4');
INSERT INTO supplier VALUES('F02', 'FRESH GROCERIES', 'WHAMPOA', '6, 10, 11, 12');
INSERT INTO supplier VALUES('L03', 'LOCAL SUPPLY DEPOT', 'TSIM SHA TSUI', '1, 2, 5');
INSERT INTO supplier VALUES('A04', 'ALL IN ONE SUPPLY', 'MONGKOK', '7, 8, 9');
INSERT INTO supplier VALUES('T05', 'THE REGIONAL RETAIL', 'HUNG HOM', '13, 15, 18');
INSERT INTO supplier VALUES('H06', 'HOME APPLIANCE SUPPLY', 'AUSTIN', '14, 16, 17');

-- -------------------------------------------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE login (
  userId varchar(12) NOT NULL,
  password varchar(12) NOT NULL,
  status number(1) NOT NULL
);

--
-- Data for table `login`
--

INSERT INTO login VALUES('W938', 'W938', 0);
INSERT INTO login VALUES('C923', 'C923', 0);
INSERT INTO login VALUES('D010', 'D010', 0);
INSERT INTO login VALUES('J495', 'J495', 0);
INSERT INTO login VALUES('A655', 'A655', 0);
INSERT INTO login VALUES('D238', 'D238', 0);

INSERT INTO login VALUES('J101', 'J101', 1);
INSERT INTO login VALUES('T809', 'T809', 1);
INSERT INTO login VALUES('C483', 'C483', 1);
INSERT INTO login VALUES('B508', 'B508', 1);
INSERT INTO login VALUES('J658', 'J658', 1);
INSERT INTO login VALUES('J201', 'J201', 1);
INSERT INTO login VALUES('R001', 'R001', 1);
INSERT INTO login VALUES('C998', 'C998', 1);
INSERT INTO login VALUES('D881', 'D881', 1);
INSERT INTO login VALUES('P771', 'P771', 1);
INSERT INTO login VALUES('H434', 'H434', 1);
INSERT INTO login VALUES('R604', 'R604', 1);
INSERT INTO login VALUES('k929', 'k929', 1);
INSERT INTO login VALUES('M112', 'M112', 1);
INSERT INTO login VALUES('J556', 'J556', 1);
INSERT INTO login VALUES('V009', 'V009', 1);
INSERT INTO login VALUES('D192', 'D192', 1);
INSERT INTO login VALUES('A339', 'A339', 1);

-- -----------------------------------------------------------------------------------------


--
-- Table structure for table `product`
--

CREATE TABLE product (
  productId NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  productName varchar(50) NOT NULL,
  price number(8,2) NOT NULL,
  quantity number(8) NOT NULL
);

--
-- Data for table `product`
--

INSERT INTO product (productName, price, quantity) VALUES ('SHAMPOO', 66.00, 8);
INSERT INTO product (productName, price, quantity) VALUES('SOAP', 10.00, 20);
INSERT INTO product (productName, price, quantity) VALUES('TOOTHBRUSH', 5.00, 30);
INSERT INTO product (productName, price, quantity) VALUES('TOOTHPASTE', 8.00, 16);
INSERT INTO product (productName, price, quantity) VALUES('MOUTHWASH', 20.00, 19);

INSERT INTO product (productName, price, quantity) VALUES('EGGS', 30.00, 150);
INSERT INTO product (productName, price, quantity) VALUES('CHICKEN', 45.00, 32);
INSERT INTO product (productName, price, quantity) VALUES('BEEF', 55.00, 27);
INSERT INTO product (productName, price, quantity) VALUES('FISH', 60.00, 35);
INSERT INTO product (productName, price, quantity) VALUES('VEGETABLE', 20.00, 50);
INSERT INTO product (productName, price, quantity) VALUES('MILK', 11.00, 40);
INSERT INTO product (productName, price, quantity) VALUES('CHEESE', 50.00, 40);

INSERT INTO product (productName, price, quantity) VALUES('WASHING MACHINE', 8999.00, 27);
INSERT INTO product (productName, price, quantity) VALUES('VACUUM CLEANER', 49999.00, 30);
INSERT INTO product (productName, price, quantity) VALUES('REFRIGERATOR', 11999.00, 15);
INSERT INTO product (productName, price, quantity) VALUES('MICROWAVE', 3999.00, 20);
INSERT INTO product (productName, price, quantity) VALUES('TOASTER', 2999.00, 35);
INSERT INTO product (productName, price, quantity) VALUES('AIR CONDITIONER', 12999.00, 12);

-- -----------------------------------------------------------------------------------------

--
-- Table structure for table `purchaseinfo`
--

CREATE TABLE purchaseinfo (
  purchaseId NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  userId varchar(12) NOT NULL,
  productId varchar(12) NOT NULL,
  cost number(12,2) NOT NULL,
  amount number(8) NOT NULL,
  purchaseDate varchar(18) NOT NULL
);
--
-- Data for table `purchaseinfo`
--

INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('J101', '6', 30.00, 1, '2018-09-26');
INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('T809', '13', 8999.00, 1, '2018-03-28');
INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('P771', '11', 11.00, 2, '2018-03-15');
INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('R604', '16', 3999.00, 1, '2018-05-04');
INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('k929', '8', 55.00, 3, '2018-05-13');
INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('J556', '11', 11.00, 5, '2018-07-23');
INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('J556', '4', 8.00, 6, '2018-08-19');
INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('D192', '2', 10.00, 1, '2018-09-09');
INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('J658', '17', 2999.00, 1, '2018-09-25');
INSERT INTO purchaseinfo (userId, productId, cost, amount, purchaseDate) VALUES ('A655', '7', 45.00, 4, '2018-10-22');

-- -----------------------------------------------------------------------------------------

COMMIT;
