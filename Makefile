comp:
	@(mvn compile)

run:
	@(mvn exec:java)

run_d:
	@(mvn exec:java -Ddebug)

clean:
	@(mvn clean package)
