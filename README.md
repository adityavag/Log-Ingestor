# Log-Ingestor
### Requirements

- Java 8 or higher
- Maven

### Installation

1. Clone this repository:

   ```sh
   git clone https://github.com/adityavag/Log-Ingestor.git
   cd Mail
2. Build the poject using Maven:

   ```sh
   mvn clean install
3. Run the application:
   ```sh
   mvn spring-boot:run
### API 
1. GET  : `https://localhost:3000/logs` - Get All Logs
2. POST : `https://localhost:3000/logs` - Ingest Log
3. GET  : `https://localhost:3000/logs/level/{level}` - Query By Level
4. GET  : `https://localhost:3000/logs/message/{message}` - Query By Message
