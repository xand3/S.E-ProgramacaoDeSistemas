package MAPAS.Programacao1;

public class Campo {
    private char simbolo;

    public Campo() {
        this.simbolo = ' ';
    }
    public char getSimbolo() {
        return this.simbolo;
    }
    public void setSimbolo(char simbolo) {
        if (this.simbolo == ' ') {
            this.simbolo = simbolo;
        } else {
            System.out.print("Celula ja usada");
        }
    }
}
