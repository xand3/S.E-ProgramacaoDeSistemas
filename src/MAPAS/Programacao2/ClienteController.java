package MAPAS.Programacao2;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteController {
    private ArrayList<Cliente> clientes;
    private int proximoID;
    public Scanner scan;

    public ClienteController() {
        this.clientes = new ArrayList<>();
        this.proximoID = 1;
        this.scan = new Scanner(System.in);
    }


}
