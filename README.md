# gotoevent-api
Gotoevent API

## [Database](https://github.com/Dunkansdk/gotoevent-api/blob/master/gotoeventapi.sql) (MySQL):
![ERD SQL](https://github.com/Dunkansdk/gotoevent-api/blob/master/images/der.png)

## Project relationships:
![Project relationships](https://github.com/Dunkansdk/gotoevent-api/blob/master/images/relation_update.png)
<br />
The connection of the Web Service to the api rest is done with the help of RestTemplate. 
** RestTemplate ** is the class that Spring offers for access from the client side to REST Services.

## Endpoints:
  - gotoevent-api (port: 25100):
    - Entity: 
      - /{entity}/ (POST) - ADD
      - /{entity}/ (PUT) - UPDATE
      - /{entity}/ (DELETE) - DELETE
      - /{entity}/ (GET) - GET ALL
      - /{entity} (GET) - GET ONE
