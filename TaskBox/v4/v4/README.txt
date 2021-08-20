Здесь пример создание и сборки проекта через Maven
	mvn archetype:generate
	mvn compile
	mvn package

В jar файле в папке META-INF есть файл манифеста, там дописываем строчку главного класса-запускатора
	Main-Class: M.App