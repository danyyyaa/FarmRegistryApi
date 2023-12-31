# FarmRegistryApi

Тестовое задание на должность Java backend разработчика
Предусловие:
-	Язык программирования: Java 8;
-	Frameworks: Spring Boot Starter, Spring Web, Spring JPA, Spring Hibernate;
-	База данных: Postgres SQL;

---

Ход работ:
1.	Реализовать API для работы с реестром районов
	Атрибуты районов: 
-	название (обязательное)
-	код района
-	статус архивности (да/нет)


Необходимо реализовать следующие запросы:
-	Получение списка районов, внесенных в реестр. Реализовать фильтрацию возвращаемого списка по названию и коду района.
-	Добавление района 
-	Изменение записи района
-	Отправить в архив (архивные не выводим в реестр)

---

2.	Реализовать реестр фермеров
   
Атрибуты: 
-	название организации (обязательное, фильтр)
-	организационно-правовая форма (ЮР, ИП, ФЛ)
-	ИНН (обязательное, фильтр)
-	КПП
-	ОГРН
-	район регистрации (связь с районом/ID - района) (фильтр)
-	районы посевных полей (множественный выбор, связь с районом)
-	дата регистрации (фильтр)
-	статус архивности (да/нет) (фильтр)

Необходимо реализовать следующие запросы:

-	Получение списка фермеров, внесенных в реестр. Реализовать фильтрацию возвращаемого списка по указанным атрибутам. 
-	Получение данных по фермеру. По районам необходимо предоставлять наименования.
-	Добавление фермера 
-	Изменение записи фермера
-	Отправить в архив (архивные не выводим в реестр)


*один район может содержать несколько фермеров (один ко многим); один фермер может иметь посевные поля в разных районах (многие ко многим)

Ожидаемый результат:
REST-приложение с Open API v3 документацией в виде страницы swagger. Доступ к репозиторию с исходниками приложения. README файл с инструкцией для запуска.

---

Установка и запуск проекта
1. Клонируйте репозиторий проекта
```
git clone git@github.com:danyyyaa/FarmRegistryApi.git
```

2. Подключитесь к базе данных

3. Запустите приложение

