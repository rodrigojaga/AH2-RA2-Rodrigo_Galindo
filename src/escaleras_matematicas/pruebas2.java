package escaleras_matematicas;

import java.util.Scanner;

public class pruebas2 {
    public static void main(String[] args) {
        Scanner hd = new Scanner(System.in);
        Scanner tx = new Scanner(System.in);
        int matriz[][] = new int [8][8];
        char trampas[][] = new char[8][8];
        char personaje[][] = new char [8][8];
        
        int tablero= 64;
        
        
        
        
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
                
             /*   
            for (i = matriz.length-1; i >=0; i--) {
                for (int j = personaje.length; j >=0; j--) {
                    
                    personaje[][] = '@';
                }
            }
             
            */        

               
                
                
        }
        
        
        
        //Comienza a imprimir 
        
        System.out.println("-----------------------------------------------------------------");
        for(int i = 0; i < matriz.length; i++ ){
            /*for (int j = 0; j < trampas.length; j++) {
                if (trampas[i][j]=='#') {
                    
                    System.out.print("| "+trampas[i][j]+" \t");
                }else{
                System.out.print("| "+trampas[i][j]+" \t");
                }
            }
*/
            //System.out.println("");
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
             System.out.println("|");
            System.out.println("-----------------------------------------------------------------");
            
            //System.out.println(" ");
        }
        
        
        
    }
    
    
}
