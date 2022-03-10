mkdir build
mv build ..
javac -d ../build modele/*.java
javac -d ../build fenetre/*.java 
java -cp ../build modele.Demo
java -cp ../build fenetre.MyWindow
rm -r ../build
