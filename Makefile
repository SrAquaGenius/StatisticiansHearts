comp:
	@(javac -d out $(find src -name "*.java"))

run:
	@(java -cp out game.Main)