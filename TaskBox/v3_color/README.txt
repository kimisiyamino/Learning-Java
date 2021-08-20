1. Скачали с интернета JCDP.jar (с сайта Maven). Это просто библиотека делающая цветной текст
2. Создали pom.xml файл. 
	<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0"
		 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
		 <modelVersion>4.0.0</modelVersion>

		 <groupId>com.eleonoralion</groupId>
		 <artifactId>colored</artifactId>
		 <version>0.1</version>

	</project>

3. Создали иерархию папок src/main/java/com/eleonoralion/ и там файл Main.java

4. Ставим Maven и прописываем переменные среды

5. Открываем тут консоль и пишем mvn compile