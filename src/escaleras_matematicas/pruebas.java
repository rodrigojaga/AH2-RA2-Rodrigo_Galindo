package escaleras_matematicas;

import java.util.Scanner;

public class pruebas {
    public static void main(String[] args) {
        int matriz[][] = new int [8][8];
        char trampas[][] = new char[8][8];
        char personaje[][] = new char [8][8];
        int tablero= 64;
        char dad1;
        char accion_juego;
        int dado;
        Scanner hd = new Scanner(System.in);
        Scanner tx = new Scanner(System.in);
        System.out.println("========MENU PRINCIPAL========");
        System.out.println("1. Iniciar Juego ");
        System.out.println("2. Reanudar Juego");
        System.out.println("3. Salir ");
        System.out.println("Ingrese su opcion: ");
    
        int accion  = hd.nextInt();
        
        if(accion==1){
            System.out.println("GENERANDO TABLERO...");
            System.out.println("LISTO...");
            System.out.println("Oprima d para tirar el dado: ");
            dad1 = tx.next().charAt(0);
            
            dado = (int) (Math.random()*(6-2)+2);
            
            for (int i = 0; i < matriz.length; i++) {
                        //si numero de columna es par, dar la vuelta
                        if (i%2 == 0) {
                            for (int j = matriz.length-1; j >= 0; j--) {
                                matriz[i][j] = tablero;                                       
                                tablero-=1;
                                
                                
                            }
                            
                            
                        }else{
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
                        
                        
                        //for (int j = personaje.length-1; j >=0; j--) {
                        /*
                            for (int k = personaje.length-1; k >=7; k--) {
                                personaje[i][k] = '@';
                            }
                    */
                //}
                        
                        /*
                        for (int j = personaje.length; j >= 0; j--) {
                            
                                personaje[i][dado] = '@';
                        
                            //personaje[i][dado] = '@';        
                        }
                      */  
                       
                    }
            
            for (int i = personaje.length-1; i >= 0; i--) {
                
                if(i%2==0){
                   
                for (int j = 0; j < personaje.length; j++) {
                    personaje[i][j] = '@';
                }       
                }else{
                    for (int j = personaje.length-1; j >=0; j--) {
                      personaje[i][j] = '@';  
                    }
                }
                
            }
        do{
            
            //Comienza a imprimir en consola 
                    System.out.println("-----------------------------------------------------------------");
                    for(int i = 0; i < matriz.length; i++ ){
                    for(int j = 0; j < matriz.length; j++){   
                        if (matriz[i][j]<=9){
                            System.out.print("| "+matriz[i][j]+" \t"); 
                        }else{
                        System.out.print("| "+matriz[i][j]+" \t");
                        }

                    }
                    System.out.println("|");
                    for (int j = 0; j < trampas.length; j++) {
                        if (trampas[i][j]=='#') {

                            System.out.print("| "+trampas[i][j]+" \t");
                        }else{
                        System.out.print("| "+trampas[i][j]+" \t");
                        }
                    }
                        
                        //for (int j = 0; j < personaje.length; j++) {
                        /*
                            for (int j = 0; j < personaje.length; j++) {
                            System.out.print(personaje[i][j]);    
                            }
                            */
                        //}
                        
                     System.out.println("|");
                    System.out.println("-----------------------------------------------------------------");
                        
                    }
                    for (int i = 0; i < personaje.length; i++) {
                        for (int j = 0; j < personaje.length; j++) {
                            System.out.print(" "+personaje[i][j]);
                        }
                        System.out.println(" ");
            }
                    System.out.println("Oprima 'D' para tirar el dado para jugar u oprima 'A' para abrir el menu: ");
                    accion_juego = tx.next().charAt(0);
                    if(accion_juego == 'd'){    
                        dado = (int) (Math.random()*(6-2)+2);
                        System.out.println("HA SALIDO!: "+dado);
                    }else{
                        System.out.println("========MENU PRINCIPAL========");
                        System.out.println("1. Iniciar Juego ");
                        System.out.println("2. Reanudar Juego");
                        System.out.println("3. Salir ");
                        System.out.println("Ingrese su opcion: ");
                        accion = hd.nextInt();
                    }
                    
        }while(accion_juego!='a');
        }else if(accion ==2){
            
        }
        
   
        
    }
    
}
