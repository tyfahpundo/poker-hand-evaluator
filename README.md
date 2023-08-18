# Poker-Hand-Evaluator
This is a Spring Boot application that evaluates poker hands and determines their rank. Given a set of 5 playing cards, the application will determine the highest rank that can be obtained using those cards.
# Getting Started
Follow these steps to set up and run the application.
# Prerequisites
Java Development Kit (JDK) 11 or later
Apache Maven
# Clone the Repository
Clone this repository to your local machine using the following command:
git clone https://github.com/tyfahpundo/poker-hand-evaluator.git
# Build the Application
Open the project in your favourite IDE and build the application using Maven in the IDE Terminal:
mvn clean install
# Run the Application
Run the Spring Boot application using the following command:
mvn spring-boot:run

Once the application is running, you can go to (http://localhost:8080/swagger-ui/index.html), you can use this API  to evaluate poker hands by sending a POST request with a JSON body containing the cards to the /api/evaluate-hand endpoint. For example:
[
  {
    "rank": "A",
    "suit": "Spades"
  },
  {
    "rank": "10",
    "suit": "Clubs"
  },
  {
    "rank": "10",
    "suit": "Hearts"
  },
  {
    "rank": "3",
    "suit": "Diamonds"
  },
  {
    "rank": "3",
    "suit": "Spades"
  }
]

The response will indicate the rank of the hand, for example:

"TWO_PAIR"

# Running Tests
To run the unit tests, use the following command:
mvn test
