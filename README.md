# playerService
This project is a RESTful service built with Spring Boot. It provides a service to serve player data from a CSV file through two endpoints:

GET /api/players: Returns the list of all players.

GET /api/players/{playerID}: Returns a single player by their ID

# Future Enhancements

Given more time beyond the initial 3-hour development period, the project could be expanded with several enhancements:

* Database Integration: Shift from file-based storage to a robust database to improve query capabilities and data management.
* Caching: Implement caching to reduce database load and improve response times for frequently accessed data.
* Code Refactoring: Improve code structure and quality for better maintainability and readability.
* Logging: Add detailed logging for easier monitoring and debugging.
* Containerization: Containerize the application for simplified deployment and scaling.
* Testing: Broaden testing to include more comprehensive integration and end-to-end tests.
* Authentication: Secure the API by implementing authentication to protect sensitive player data.

