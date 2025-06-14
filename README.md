### Hexlet tests and linter status:
[![Actions Status](https://github.com/egyxh/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/egyxh/java-project-78/actions)

### Bages
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=bugs)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=egyxh_java-project-78&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=egyxh_java-project-78)

# Валидатор данных

Небольшая Java библиотека для валидации данных
Поддерживает:
	Строки (String)
	Числа (целые и с плавающей точкой)
	Структуры Map (так же со вложенными проверками для пар по ключу)

### Возможности:
	- Валидация строк: required(), minLength(int), contains(String).
	- Валидация чисел: required(), positive(), range(int min, max).
	- Валидация Map: required(), sizeof(int), shape(Map<String, BaseSchema<?>>). 

### Требования:
	Java 17+
	Gradle 8+
### Сборка и тесты

Сборка проекта:
	```bash
	./gradlew build
	```
Запуск тестов:
	```bash
	./gradlew test
	```


