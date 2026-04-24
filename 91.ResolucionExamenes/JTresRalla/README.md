
## Estando en la base
javac ./src/examenMayo/dominio/*.java ./src/examenMayo/ui/*.java -d out

## Estando en la carpeta src
javac ./examenMayo/dominio/*.java ./examenMayo/ui/*.java -d ../out

## Estando en la base
java -cp out examenMayo.ui.JVentana

