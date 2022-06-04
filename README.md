# Сервис получения гифок

Создать сервис, который обращается к сервису курсов валют, и отображает gif:

• если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich

• если ниже - отсюда https://giphy.com/search/broke


Ссылки

• REST API курсов валют - https://docs.openexchangerates.org/

• REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide



Must Have

• Сервис на Spring Boot 2 + Java / Kotlin

• Запросы приходят на HTTP endpoint (должен быть написан в соответствии с rest conventions), туда передается код валюты по отношению с которой сравнивается USD

• Для взаимодействия с внешними сервисами используется Feign

• Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки

• На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)

• Для сборки должен использоваться Gradle

____

# Технологии

• Java 17

• Spring Boot

• Gradle

• Lombok

• OpenFeign

• Wiremock

• JUnit

____

# Запуск

Склонировать репозиторий, выполнив команду:

git clone https://github.com/KirSanich/Alpha-Bank-Test

Перейдя в корневую папку проекта собрать проект:

gradlew build

Собрать докер-образ с произвольным именем, в нашем случае giphy-image:

docker image build ./ -t giphy-image 

Запустить контейнер с нашим образом:

docker run -p 8084:8084 -d --name giphy-service giphy-image

____

# Endpoints
 ` /currency `
 
Возвращает строку, в которой находится url-ссылка на гифку.

### Параметры:

`code:String(RUB)`

### Пример запроса:

`http://localhost:8084/currency?code=RUB`





