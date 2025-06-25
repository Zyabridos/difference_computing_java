.PHONY: build run install clean

build:
	./gradlew build

install:
	./gradlew installDist

run: install
	./build/install/diff_compution_java/bin/diff_compution_java

clean:
	./gradlew clean
