cd ..

find ./src -name "*.java" > sources.txt

javac -Xlint:unchecked -d build/  @sources.txt
java -cp build/  fenetre.MyWindow


rm sources.txt
