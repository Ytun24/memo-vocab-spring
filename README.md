# memo-vocab-spring

## Prerequisites
1. Maven
2. IntelliJ
3. Docker Desktop 
4. Docker compose

## Setup database on local
1. Open terminal at project folder
2. Use `docker compose up`
3. Open PGAdmin on browser `http://localhost:8888`. Access with username and password in `docker-compose.yaml`
4. Add connection following config in `docker-compose.yaml`
5. Create database following config in `flyway.conf`
6. Open Maven side menu on IntelliJ. Go to Plugins > flyway > double click flyway:migrate