Здесь мы создали классы Diller, Hash и TestDrive (main) с расширением .java
Далее мы отделили исходные файлы и скомпилированные .class файлы (папки src & target)
	C:\JAVA\TaskBox\v1 $		javac -d target/ src/Hash.java
	C:\JAVA\TaskBox\v1\target $ 	javac -d ../target/ ../src/Diller.java
	C:\JAVA\TaskBox\v1\target $ 	javac -d ../target/ ../src/TestDrive.java

Далее мы собрали первый JAR файл из .class файлов в папке target с использованием манифест файла
	C:\JAVA\TaskBox\v1 $ 		echo "Main-Class: com/eleonoralion/TestDrive" > target/manifest.txt
	C:\JAVA\TaskBox\v1 $		jar -cvmf target/manifest.txt Bariga.jar target/com/eleonoralion/*.class

	C:\JAVA\TaskBox\v1 $		java -jar Bariga.jar

Для следующей работы мы собрали ещё один Jar файл
	C:\JAVA\TaskBox\v1\target $ 	jar -cvf drglib.jar com/eleonoralion/Hash com/eleonoralion/Diller