.PHONY: comp

comp:
	@(mvn compile)

run: comp
	@(mvn exec:java)

run_d: comp
	@(mvn exec:java -Ddebug)

clean:
	@(mvn clean)
