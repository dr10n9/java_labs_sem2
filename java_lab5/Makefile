JC = javac
JVM = java

all: packages main

packages:
	find -name "*.java" | sort -r > sources | $(JC) -d out/ @sources 

main:
	$(JC) -cp out -d out src/Main.java

run: 
	$(JVM) -cp out Main