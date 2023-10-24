## Web protocols
модель клиент-сервер используется при построении системы обработки информации на основе СУБД, а также почтовые системы

The client-server model is used to build an information processing system based on a DBMS, as well as mail systems

**HTTP Hyper Text Transfer Protocol**

**HTTPs Hyper Text Transfer Protocol secured** - Данные передаются в засекреченном виде

**SSL/TLS** - протокол шифрования данных

**Public/Privat Key** - подпись цифровым сертификатом

**FTP File Transfer Protocol**

**POP3 SMTP** - почтовые протоколы для отправки и получение писем (POP3 - протокол для входящей почты; SMTP - для исходящей почты)

**IMAP** - почтовые протоколы для отправки

**UDP User Datagram Protocol** - данные уходят набором данных
 
##### Request (запрос)
клиента к серверу

Base Line/ Start line: method; URI; protocol

method - что хотим сделать?

URI где мы это хотим сделать

##### Response (ответ)

от сервера клиенту

Status code standard

HEADERS: param1: atr1,atr2,atr3 Content-type: image cookeis: last-modified: 14.01.2021 15:49:10 GMT

BODY

**Status code**

- 1хх Info (101 switching protocols)
- 2хх Success (200 OK)
- 3хх Redirect (304 Not Modified)
- 4хх Client error (404 Not Found)
- 5хх Server error (500 Internal server error)

**Methods**

- GET - получение ресурса
- POST - создание ресурса
- PUT - обновление ресурса
- DELETE - удаление ресурса

[Презентация](https://docs.google.com/presentation/d/1rWmGrN9HM-oam9BbYRaSiWTYcYh0O0lO/edit?usp=share_link&ouid=116447005932578256378&rtpof=true&sd=true)

