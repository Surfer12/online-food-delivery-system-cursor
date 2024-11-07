# Online Food Delivery System

## Overview
This project implements a simplified online food delivery system using Java. It allows customers to place orders for menu items, drivers to accept and deliver those orders, and customers to rate their delivery experience.

## Features
- **Ordering**: Customers can place orders for hamburgers, fries, and drinks.
- **Delivery**: Drivers can accept and deliver orders, with tracking of their basic information.
- **Rating**: Customers can rate drivers on a scale of 1 to 5 after an order is delivered.
- **Order Processing**: Orders are processed in a First-In, First-Out manner.

## Project Structure
```
online-food-delivery-system
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── fooddelivery
│   │   │           ├── App.java
│   │   │           ├── models
│   │   │           │   ├── Customer.java
│   │   │           │   ├── Driver.java
│   │   │           │   ├── MenuItem.java
│   │   │           │   ├── Order.java
│   │   │           │   └── Rating.java
│   │   │           ├── services
│   │   │           │   ├── OrderService.java
│   │   │           │   ├── DeliveryService.java
│   │   │           │   └── RatingService.java
│   │   │           └── utils
│   │   │               └── DataStore.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── fooddelivery
│                   ├── AppTest.java
│                   ├── models
│                   │   ├── CustomerTest.java
│                   │   ├── DriverTest.java
│                   │   ├── MenuItemTest.java
│                   │   ├── OrderTest.java
│                   │   └── RatingTest.java
│                   ├── services
│                   │   ├── OrderServiceTest.java
│                   │   ├── DeliveryServiceTest.java
│                   │   └── RatingServiceTest.java
│                   └── utils
│                       └── DataStoreTest.java
├── .gitignore
├── build.gradle
└── README.md
```

## Setup Instructions
1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd online-food-delivery-system`
3. Build the project using Gradle: `./gradlew build`
4. Run the application: `java -cp build/libs/online-food-delivery-system.jar com.fooddelivery.App`

## Usage Guidelines
- Customers can create an account and place orders through the application interface.
- Drivers can log in to accept and deliver orders.
- After delivery, customers can rate their drivers, which will be stored and managed by the system.

## Contributing
Contributions are welcome! Please submit a pull request for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.