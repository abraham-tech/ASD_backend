# Inventory Management System for Small Businesses

## Overview

ABC Inc. is a small business that needs an efficient solution to manage inventory. Their current system, a mix of spreadsheets and manual tracking, is time-consuming, error-prone, and lacks features to optimize stock levels and ordering. This inefficiency results in stockouts, slow order delivery, excess inventory, and lost sales.

This project aims to develop a web-based inventory management system that addresses these challenges by providing comprehensive functionalities for tracking products, managing suppliers, processing orders, maintaining stock levels, handling customer management, generating reports and analytics, and managing billing and invoicing.

## Features

### 1. Track Products
- **Create and maintain a database of products** with details like ID, name, description, price, and current stock level.
- **Search and filter products** to quickly find specific items.
- **Update product details** as needed.

### 2. Manage Suppliers
- **Store information about suppliers**, including the products they supply.
- **Add, remove, and edit supplier details** easily.
- **Link suppliers to specific products** for better tracking.

### 3. Process Orders
- **Enable customers to place orders** containing multiple products.
- **Calculate total order cost** based on product prices and quantities.
- **Update stock levels** automatically based on sales.

### 4. Maintain Stock Levels
- **Add or remove products** from inventory.
- **Update stock levels** based on sales and purchases.
- **Generate low-stock alerts** to prevent stockouts.

### 5. Customer Management
- **Store customer information**, including name, contact details, order history, and payment status.
- **Allow customers to view their order history** and current order status.
- **Enable customers to request order cancellations or modifications** online.
- **Track customer feedback and satisfaction levels**.
- **Implement a loyalty program** to reward frequent customers.

### 6. Reporting and Analytics
- **Generate reports on inventory levels**, sales trends, and supplier performance to inform better stock management and purchasing decisions.
- **Analyze sales trends** to identify best-selling products, seasonal demand, and revenue forecasts.
- **Evaluate supplier performance** based on delivery times, order accuracy, and product quality.
- **Generate customer reports** to understand purchasing patterns and customer demographics.
- **Offer customizable report templates** and export options (e.g., PDF, Excel).

### 7. Billing and Invoicing (Handle Financial Transactions)
- **Generate invoices** for completed orders, including detailed billing information.
- **Allow customers to view and pay their invoices online** via various payment methods.
- **Track outstanding payments** and send automated reminders to customers.
- **Integrate with accounting software** to streamline financial management.

## Technical Requirements
- **Web-based system** accessible through a web browser.
- **Responsive design** for access on various devices (desktop, tablet, mobile).
- **Secure authentication** and user roles to manage access and permissions.
- **Reliable database** for storing product, supplier, customer, and order information.
- **Scalable architecture** to handle growing data and user base.

## Installation and Setup
1. **Clone the repository**: `git clone https://github.com/abraham-tech/inventory-management-system`
2. **Navigate to the project directory**: `cd inventory-management-system`
3. **Install dependencies**: `npm install` (or appropriate package manager)
4. **Configure the database**: Set up your database and update the configuration file with the database credentials.
5. **Run the application**: `npm start` (or appropriate command)
6. **Access the application**: Open your web browser and navigate to `http://localhost:3000`

## User Administration 

### User Authentication:

Implement a secure login system requiring a username and password.
Provide password recovery options via email.
Use encryption to store passwords securely.

### User Authorization:

Define user roles such as Admin and Customer, each with specific permissions.
Admin users should have full access to all system functionalities, including product management, supplier management, user management, order processing, and reporting.
Customer users should have access to functionalities such as viewing products, placing orders, viewing order history, and managing their accounts.
Ensure that only authorized users can perform actions based on their role.

### Admin
The admin users are responsible for overseeing the entire inventory management system. They need robust functionalities to manage products, suppliers, customers, and orders. They also require comprehensive reporting tools to analyze inventory levels, sales trends, and supplier performance. Additionally, admins need capabilities to manage user roles and permissions within the system.

### Customer
Customers need a user-friendly interface to browse products, place orders, and track their order status. They should also be able to view their order history, manage their account details, and provide feedback on their purchases. Features like order cancellation, loyalty programs, and online invoice payments also benefit customers.

## Contributing
We welcome contributions from the community. To contribute, please follow these steps:
1. **Fork the repository**.
2. **Create a new branch**: `git checkout -b feature/your-feature-name`
3. **Commit your changes**: `git commit -m 'Add some feature'`
4. **Push to the branch**: `git push origin feature/your-feature-name`
5. **Open a pull request**.

## Class diagram
![Alt text](https://github.com/abraham-tech/inventory-management-system/blob/main/screenshots/classDiagram.png)
![Alt text]( https://github.com/abraham-tech/inventory-management-system/blob/main/screenshots/userClassDiagram.png)

## ER diagrams
![Alt text](https://github.com/abraham-tech/inventory-management-system/blob/main/screenshots/ER_Diagram.png)
![Alt text]( https://github.com/abraham-tech/inventory-management-system/blob/main/screenshots/ER2.png)


## Architecture diagram
![Architecture diagram](https://github.com/abraham-tech/inventory-management-system/blob/main/screenshots/architectureDiagram.png)


## Deployment diagram
![Architecture diagram](https://github.com/abraham-tech/inventory-management-system/blob/main/screenshots/deploymentDiagram.png)

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
For any inquiries or support, please contact us at support@abcinc.com.

---

ABC Inc. aims to streamline its operations, reduce errors, and improve overall business efficiency by providing a comprehensive and user-friendly inventory management system.
