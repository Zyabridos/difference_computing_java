.PHONY: build run install clean run-dist

z: install
	./build/install/diff_compution_java/bin/diff_compution_java -h

run-dist: install
	./build/install/diff_compution_java/bin/diff_compution_java -h

build:
	./gradlew build

install:
	./gradlew installDist

run:
	./gradlew installDist
	./build/install/diff_compution_java/bin/diff_compution_java $(file1) $(file2)

clean:
	./gradlew clean
