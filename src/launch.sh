mkdir build
mv build ..
javac -d ../build modele/*.java
java -cp ../build modele.Demo
rm -r ../build
