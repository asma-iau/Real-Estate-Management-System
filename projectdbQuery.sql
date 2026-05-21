CREATE DATABASE realestatemangmentsystem;
USE   realestatemangmentsystem ;

-- 1. USER TABEL 
CREATE TABLE USERS (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    Password VARCHAR(100)
);
    
-- 2.  OWNER TABEL
CREATE TABLE OWNER (
    OwnerID INT AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(255),
    Fname VARCHAR(100) NOT NULL, -- COMPSITE
    Lname VARCHAR(100) NOT NULL,  -- COMPSITE
    PhoneNumber VARCHAR(20),
    Oname VARCHAR(100)
);

-- 3.  AGENT TABEL
CREATE TABLE AGENT (
    AgentID INT AUTO_INCREMENT PRIMARY KEY,
    AName VARCHAR(100),
    Fname VARCHAR(100) NOT NULL,
    Lname VARCHAR(100) NOT NULL,
    Supervises INT,
    FOREIGN KEY (Supervises) REFERENCES AGENT(AgentID) ON DELETE SET NULL
);

-- 4.  PROPERTY TABEL 
CREATE TABLE PROPERTY (
    PropertyID INT AUTO_INCREMENT PRIMARY KEY,
    Location VARCHAR(255) NOT NULL,
    Status VARCHAR(50),
    PropertyType VARCHAR(50),
    OwnerID INT,                                                 
    AgentID INT,
    FOREIGN KEY (OwnerID) REFERENCES OWNER(OwnerID) ON DELETE CASCADE,
    FOREIGN KEY (AgentID) REFERENCES AGENT(AgentID) ON DELETE SET NULL
);
ALTER TABLE PROPERTY ADD COLUMN price DOUBLE NOT NULL DEFAULT 0;
UPDATE PROPERTY SET price= 550000 WHERE PropertyID = 1;
UPDATE PROPERTY SET price= 1200000 WHERE PropertyID = 2;
UPDATE PROPERTY SET price= 600000 WHERE PropertyID = 3;
UPDATE PROPERTY SET price= 400000 WHERE PropertyID = 4;
UPDATE PROPERTY SET price= 220000 WHERE PropertyID = 5;
UPDATE PROPERTY SET price= 440000 WHERE PropertyID = 6;
UPDATE PROPERTY SET price= 550000 WHERE PropertyID = 7;
UPDATE PROPERTY SET price= 550000 WHERE PropertyID = 8;
UPDATE PROPERTY SET price= 550000 WHERE PropertyID = 9;
UPDATE PROPERTY SET price= 550000 WHERE PropertyID = 10;

-- 5.  CLIENT TABEL
CREATE TABLE CLIENT (
    ClientID INT AUTO_INCREMENT PRIMARY KEY,
    CName VARCHAR(100) NOT NULL,
    PhoneNumber VARCHAR(20),
    Email VARCHAR(255) UNIQUE
);

-- 6. TRANSACTION TABEL
CREATE TABLE TRANSACTION (
    TransactionID INT AUTO_INCREMENT PRIMARY KEY,
    Date DATE,
    FinalPrice DECIMAL(15,2) NOT NULL,
    ClientID INT,
    AgentID INT,
    PropertyID INT UNIQUE,
    FOREIGN KEY (ClientID) REFERENCES CLIENT(ClientID) ON DELETE CASCADE,
    FOREIGN KEY (AgentID) REFERENCES AGENT(AgentID) ON DELETE SET NULL,
    FOREIGN KEY (PropertyID) REFERENCES PROPERTY(PropertyID) ON DELETE CASCADE
);
 
 -- INSERT 
INSERT INTO OWNER (Email, Fname, Lname, PhoneNumber, Oname) VALUES
('ahmed.ali@email.com', 'Ahmed', 'Ali', '0501111111', 'Ahmed Ali'),
('sara.mohammed@email.com', 'Sara', 'Mohammed', '0502222222', 'Sara Mohammed'),
('khaled.hassan@email.com', 'Khaled', 'Hassan', '0503333333', 'Khaled Hassan'),
('noura.ibrahim@email.com', 'Noura', 'Ibrahim', '0504444444', 'Noura Ibrahim'),
('fahad.abdullah@email.com', 'Fahad', 'Abdullah', '0505555555', 'Fahad Abdullah'),
('layla.yousef@email.com', 'Layla', 'Yousef', '0506666666', 'Layla Yousef');

INSERT INTO OWNER (Email, Fname, Lname, PhoneNumber, Oname) VALUES
('amal.faris@email.com', 'Amal', 'Faris', '0507777777', 'Amal Faris'),
('yara.nasser@email.com', 'Yara', 'Nasser', '0508888888', 'Yara Nasser'),
('salman.rami@email.com', 'Salman', 'Rami', '0509999999', 'Salman Rami'),
('huda.tariq@email.com', 'Huda', 'Tariq', '0501010101', 'Huda Tariq');

INSERT INTO AGENT (AName, Fname, Lname, Supervises) VALUES
('Ali Saleh', 'Ali', 'Saleh', NULL),
('Mona Yousef', 'Mona', 'Yousef', 1),
('Hassan Omar', 'Hassan', 'Omar', 1),
('Nadia Ahmed', 'Nadia', 'Ahmed', 2),
('Omar Khaled', 'Omar', 'Khaled', NULL),
('Reem Saad', 'Reem', 'Saad', 3);

INSERT INTO AGENT (AName, Fname, Lname, Supervises) VALUES
('Faisal Noor', 'Faisal', 'Noor', NULL),
('Lama Ali', 'Lama', 'Ali', 2),
('Majed Saleh', 'Majed', 'Saleh', 3),
('Sara Nasser', 'Sara', 'Nasser', NULL);

INSERT INTO CLIENT (CName, PhoneNumber, Email) VALUES
('Omar Ibrahim', '0511112222', 'omar@email.com'),
('Nadia Fahad', '0522223333', 'nadia@email.com'),
('Yousef Hassan', '0533334444', 'yousef@email.com'),
('Fatima Ali', '0544445555', 'fatima@email.com'),
('Mohammed Saad', '0555556666', 'mohammed@email.com'),
('Aisha Khalid', '0566667777', 'aisha@email.com');

INSERT INTO CLIENT (CName, PhoneNumber, Email) VALUES
('Khalid Majed', '0577778888', 'khalid@email.com'),
('Lina Saeed', '0588889999', 'lina@email.com'),
('Dana Nabil', '0501212121', 'dana@email.com');

INSERT INTO PROPERTY (Location, Status, PropertyType, OwnerID, AgentID) VALUES
('Riyadh', 'Available', 'Apartment', 1, 1),
('Jeddah', 'Sold', 'Land', 2, 2),
('Dammam', 'Rented', 'VIA', 3, 3),
('Riyadh', 'Available', 'Apartment', 4, 1),
('Khobar', 'Sold', 'Land', 5, 4),
('Makkah', 'Rented', 'Apartment', 6, 5);

INSERT INTO PROPERTY (Location, Status, PropertyType, OwnerID, AgentID) VALUES
('Riyadh', 'Available', 'Villa', 7, 2),
('Jeddah', 'Sold', 'Apartment', 8, 3),
('Dammam', 'Rented', 'Land', 9, 1),
('Khobar', 'Available', 'Apartment', 10, 4);

INSERT INTO TRANSACTION (Date, FinalPrice, ClientID, AgentID, PropertyID) VALUES
('2025-01-15', 550000.00, 1, 1, 1),
('2025-02-20', 1200000.00, 2, 2, 2),
('2025-04-05', 320000.00, 3, 1, 4),
('2025-05-12', 2100000.00, 4, 4, 5),
('2025-06-18', 480000.00, 5, 5, 6),
('2025-07-01', 900000.00, 8, 2, 8),
('2025-07-10', 650000.00, 1, 3, 9);


-- DELETE 
DELETE FROM CLIENT WHERE ClientID = 6;

-- UPDATE 
UPDATE PROPERTY SET Status = 'Rented' WHERE PropertyID =3;
UPDATE OWNER SET PhoneNumber = '0500001111' WHERE OwnerID = 2;

-- LIKE
SELECT * FROM CLIENT WHERE CName LIKE 'M%';
SELECT * FROM PROPERTY WHERE Location LIKE '%Riyadh%';
SELECT * FROM OWNER WHERE Fname LIKE '-----';

-- BETWEEN 
SELECT * FROM TRANSACTION WHERE FinalPrice BETWEEN 500000 AND 1000000;
SELECT * FROM OWNER WHERE OwnerID BETWEEN 1 AND 3;

-- IN 
SELECT * FROM PROPERTY WHERE PropertyType IN ('Apartmernt' ,'Land');
SELECT * FROM AGENT WHERE AgentID IN (1,2,3);


 -- 7. ORDER BY
SELECT * FROM PROPERTY ORDER BY Location ASC;
SELECT * FROM TRANSACTION ORDER BY FinalPrice DESC;

-- 8. IS NULL
SELECT * FROM AGENT WHERE Supervises IS NULL;
SELECT * FROM PROPERTY WHERE AgentID IS NULL;

-- 9. INTERSECT - EXCEPT - UNION
-- UNION
SELECT Fname FROM OWNER
UNION
SELECT Fname  FROM AGENT;

-- INTERSECT
SELECT Fname FROM OWNER
WHERE Fname IN (
    SELECT Fname FROM AGENT
);

-- EXCEPT
SELECT Fname FROM OWNER
WHERE Fname NOT IN (
    SELECT Fname FROM AGENT
);


-- 10. AGGREGATE FUNCTIONS + GROUP BY + HAVING

SELECT AgentID, COUNT(*) AS TotalProperties
FROM PROPERTY
GROUP BY AgentID
HAVING COUNT(*) >= 1;


SELECT Status, AVG(FinalPrice) AS AveragePrice
FROM PROPERTY
JOIN TRANSACTION
ON PROPERTY.PropertyID = TRANSACTION.PropertyID
GROUP BY Status
HAVING AVG(FinalPrice) > 400000;

-- 11. NATURAL JOIN
SELECT * FROM PROPERTY
NATURAL JOIN TRANSACTION;

-- 12. OUTER JOIN
-- LEFT OUTER JOIN
SELECT OWNER.Fname, OWNER.Lname, PROPERTY.Location
FROM OWNER
LEFT OUTER JOIN PROPERTY
ON OWNER.OwnerID = PROPERTY.OwnerID;

-- RIGHT OUTER JOIN
SELECT AGENT.AName, PROPERTY.Location
FROM AGENT
RIGHT OUTER JOIN PROPERTY
ON AGENT.AgentID = PROPERTY.AgentID;

-- EXISTS
SELECT * FROM AGENT A
WHERE EXISTS (
    SELECT * FROM PROPERTY P
    WHERE P.AgentID = A.AgentID
);

-- NESTED QUERY
SELECT * FROM PROPERTY
WHERE OwnerID IN (
    SELECT OwnerID
    FROM OWNER
    WHERE Fname = 'Ahmed'
);

-- FUNCTION
DELIMITER $$
CREATE FUNCTION GetTotalProperties(owner_id INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total INT;
    SELECT COUNT(*)
    INTO total
    FROM PROPERTY
    WHERE OwnerID = owner_id;
    RETURN total;
END $$

DELIMITER ;
SELECT GetTotalProperties(1);

-- STORED PROCEDURE
DELIMITER $$
CREATE PROCEDURE ShowAgentProperties(IN agent_num INT)
BEGIN
    SELECT *
    FROM PROPERTY
    WHERE AgentID = agent_num;
END $$
DELIMITER ;
CALL ShowAgentProperties(1);

-- TRIGGER
DELIMITER $$
CREATE TRIGGER ChangePropertyStatus
AFTER INSERT ON TRANSACTION
FOR EACH ROW
BEGIN
    UPDATE PROPERTY
    SET Status = 'Sold'
    WHERE PropertyID = NEW.PropertyID;
END $$
DELIMITER ;

SHOW TRIGGERS;

-- VIEW
CREATE VIEW PropertyDetails AS
SELECT PropertyID, Location, Status, PropertyType
FROM PROPERTY;
SELECT * FROM PropertyDetails;





