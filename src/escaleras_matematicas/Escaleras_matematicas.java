package escaleras_matematicas;

import java.util.Scanner;

public class Escaleras_matematicas {
    public static void main(String[] args) { 
        //Variables y matrices necesarias para el funcionamiento
        //SI SURGE ALGUN ERROR AL COMPILAR, EJECUTAR "prueba3", ahi si deberia funcionar
        int matriz[][] = new int [8][8]; 
        char trampas[][] = new char[8][8];
        char personaje[][] = new char [8][8];
        int tablero= 64;
        int movimientos= 0;
        boolean xd=true;
        char accion_juego;
        int dado = 0;
        
        //Comienza ciclo general, ultimo en cerrar. cierra cuando xd=false
        do{
            //Inicio de menu principal 
            boolean vava = true;
            movimientos= 0;
            Scanner hd = new Scanner(System.in);
            Scanner tx = new Scanner(System.in);
            System.out.println("========MENU PRINCIPAL========");
            System.out.println("1. Iniciar Juego ");
            System.out.println("2. Reanudar Juego");
            System.out.println("3. Salir ");
            System.out.println("Ingrese su opcion: ");
            int accion  = hd.nextInt();
            //Segundo ciclo, controla las deciciones generadas en el menu principal. cierra cuando vava=false
            do{
                dado = 0;
                if(accion==1){
                    System.out.println("GENERANDO TABLERO...");
                    System.out.println("LISTO...");
                    for (int i = 0; i < matriz.length; i++) {
                        //si numero de columna es par, dar la vuelta
                        if (i%2 == 0) {
                            for (int j = matriz.length-1; j >= 0; j--) {
                                matriz[i][j] = tablero;                                       
                                tablero-=1;
                            }
                        }else{
                            //Si la columna no es par, generar normalmente
                            for (int j = 0; j < matriz.length; j++) {  
                                matriz[i][j] = tablero;                             
                                tablero-=1;
                            }
                        }
                            int cantidad_trampas =  (int) (Math.random()*(4-1)+1);
                            for (int j = 0; j < cantidad_trampas; j++) {
                                int trampa_fila = (int) (Math.random()*(8-1)+1);
                                trampas[i][trampa_fila] = '#';        
                            }                     
                        }
                        personaje[7][7] = '@';
                        
                        //Tercer ciclo, controla las impresiones en consola del tablero y sus elementos
                        do{
                            //Comienza a imprimir en consola el tablero  
                            System.out.println("-----------------------------------------------------------------");
                            for(int i = 0; i < matriz.length; i++ ){
                                for(int j = 0; j < matriz.length; j++){   
                                    if (matriz[i][j]<=9){
                                        System.out.print("|    "+matriz[i][j]+"\t"); 
                                    }else{
                                        System.out.print("|   "+matriz[i][j]+"\t");
                                    }

                                }
                                //Imprimir trampas y personaje
                                System.out.println("|");
                                for (int j = 0; j < trampas.length; j++) {
                                    if (trampas[i][j]=='#'&&personaje[i][j]=='@') {
                                        System.out.print("|"+trampas[i][j]+"     "+personaje[i][j]);
                                    }else{
                                        System.out.print("|\t"+trampas[i][j]+personaje[i][j]);
                                    }
                                }
                                System.out.println("|");
                                System.out.println("-----------------------------------------------------------------");
                            }
                            //Eliminar rastros del personaje
                            for (int i = 0; i < personaje.length; i++) {
                                for (int j = 0; j < personaje.length; j++) {
                                    personaje[i][j] = ' ';
                                }
                            }
                            System.out.println("Oprima 'r' para tirar el dado para jugar \n"
                                                + "Oprima 'p' para abrir el menu: ");
                            accion_juego = tx.next().charAt(0);
                            switch(accion_juego){
                                case 'r':
                                    int aux = (int) (Math.random() * (6 - 2) + 2);
                                    System.out.println("HA SALIDO: " + aux);
                                    dado += aux;
                                    movimientos +=aux;
                                    if(dado>=63){
                                        accion_juego = 'p';
                                        break;
                                    }else if (dado > 55) {
                                        personaje[0][dado-56] = '@';
                                    }else if (dado > 47) {
                                        personaje[1][55 - dado] = '@';
                                    }else if (dado > 39) {
                                        personaje[2][dado-40] = '@';
                                    }else if (dado > 31) {
                                        personaje[3][39-dado] = '@';
                                    }else if (dado > 23) {
                                        personaje[4][dado-24] = '@';
                                    }else if (dado > 15) {
                                        personaje[5][23 - dado] = '@';
                                    }else if (dado > 7) {
                                        personaje[6][dado - 8] = '@';
                                    }else{
                                        personaje[7][7 - dado] = '@';
                                    }

                                    for (int i = 0; i < trampas.length; i++) {
                                        for (int j = 0; j < trampas.length; j++) {
                                            if (trampas[i][j]=='#'&&personaje[i][j]=='@') {
                                                System.out.println("HAS CAIDO EN UNA PENALIZACION!!!");
                                            }else{
                                                System.out.print("");
                                            }
                                        }
                                    }
                                break;
                                case 'p':
                                    System.out.println("========MENU DE PAUSA========");
                                    System.out.println("1. Regresar a MENU PRINCIPAL del Juego ");
                                    System.out.println("2. Reanudar Juego");
                                    System.out.println("3. Salir ");

                                    int opcionsubmenu = hd.nextInt();
                                    if (opcionsubmenu == 3){
                                        System.out.println("Gracias por jugar!"); 
                                        System.exit(0);
                                    }else if(opcionsubmenu==2){
                                        continue;
                                    }else{
                                        movimientos=100;
                                    }
                                break;
                            }
                        }while(movimientos<=63);//fin tercer ciclo
                        if(movimientos==100){
                            System.out.println("HAS SALIDO AL MENU PRINCIPAL");
                            movimientos= 0;
                            dado = 0;
                            tablero = 64;
                            for (int i = 0; i < trampas.length; i++) {
                                for (int j = 0; j < trampas.length; j++) {
                                    trampas[i][j] = ' ';
                                }
                            }
                            vava=false;
                            xd = true;
                        }else if(movimientos>=64&&movimientos<=70){
                            System.out.println("HAS GANADO EL JUEGO. FELICIDADES!!!!!!!");
                            System.out.println("Deseas volver al menu principal? Si = 1/No = 0");
                            int eleA1 = hd.nextInt();
                            if (eleA1 == 1) {
                                for (int i = 0; i < trampas.length; i++) {
                                    for (int j = 0; j < trampas.length; j++) {
                                    trampas[i][j] = ' ';
                                    }
                                }
                                vava = false;
                                xd = true;
                                dado = 0;
                                movimientos= 0;
                                tablero = 64;
                            }else if(eleA1==0){
                                vava = false;
                                xd = false;
                                dado = 0;
                                movimientos= 0;
                                tablero = 64;
                            }
                            dado = 0;
                            movimientos= 0;
                            tablero = 64;
                        }else{
                            System.out.println("HAS GANADO EL JUEGO. FELICIDADES!!!!!!!");
                            System.out.println("Deseas volver al menu principal? Si = 1/No = 0");
                            int eleA1 = hd.nextInt();
                            if (eleA1 == 1) {
                                vava = false;
                                xd = true;
                            }else{
                                vava = false;
                                xd = false;
                            }
                            dado = 0;
                            movimientos= 0;
                            tablero = 64;
                        }
                }else if(accion ==2){//fin primera accion. Inicio segunda accion
                    System.out.println("NO HAY JUEGO COMENZADO");
                    movimientos= 0;
                    tablero = 64;
                    vava = false;
                    xd = true;
                }else if(accion==3){//fin segunda opcion. Inicio tercera opcion
                    vava = false;
                    xd=false;
                }
            }while(vava);// cierre segundo ciclo 
        }while(xd);//fin ciclo general. cierre del programa
        System.out.println("Gracias por jugar <3");
    }
}
