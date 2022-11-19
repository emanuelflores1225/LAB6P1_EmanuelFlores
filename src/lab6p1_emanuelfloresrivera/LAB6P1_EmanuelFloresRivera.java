package lab6p1_emanuelfloresrivera;
import java.util.Random;
import java.util.Scanner;

public class LAB6P1_EmanuelFloresRivera {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("----------------------");
            System.out.println("Menu.");
            System.out.println("1. Turing");
            System.out.println("2. Kaprekar");//este no esta facil de entender
            System.out.println("3. Saliendo");
            opcion = leer.nextInt();
            switch(opcion){
                case 1 ->{
                    System.out.println("Ingrese el tamano del array: ");
                    int tam = leer.nextInt();
                    System.out.println("Ingrese las instrucciones EN MAYUSCULAS: ");
                    String ins = leer.next();
                    if (ins.equals(ins.toUpperCase()) || ins.equals(ins.toLowerCase())){
                        imprimir(ins, tam);
                    }
                }
                
                case 2->{
                    int cont = 1;
                    while(cont <= 1){
                        System.out.println("Ingrese un numero: ");
                        int num = leer.nextInt();
                        String ING = String.valueOf(num);
                        int num_Ing;
                        if(!ING.equals("6174")){
                            if(validar(ING)){
                                num_Ing = Integer.parseInt(ING);
                                System.out.println(Kaprekar(num_Ing));
                            }
                            else{
                                System.out.println("No es un numero");
                            }
                        }
                        else{
                            System.out.println("0");
                        }
                        cont++;
                        }
                }
                
                case 3->{
                    System.out.println("Saliendo");
                }
            }
        }while (opcion !=3);
    }
     //metodos para el problema 1
    public static int[] ARG(int tam){
        int [] temporal = new int[tam];
        Random random = new Random();
        for (int i = 0; i <temporal.length; i++){
            temporal[i] = 1 + random.nextInt(10);//se imprimen todos los numeros random empezando de 0 hasta 9 dependiendo del tamano
        }        
        return temporal; 
    }
    public static void imprimir (String ins, int tam){
        int [] temp = ARG(tam);
        int punt = 0;//se inicializa el puntero en 0, donde va el primer numero
        for (int i = 0; i < ins.length(); i++){
            char ITS = ins.charAt(i);
            if (ITS == 'R'){ //se utiliza R para moverse a la derecha hasta que se llega al ultimo character
                if(punt > temp.length){
                    System.out.println("Invalido");
                }
                else{
                    punt++;
                }
            }
            else if (ITS == 'L'){//se mueve el puntero a la izquierda hasta que se llegue al character 0
                if(punt < 0){
                    System.out.println("Invalido");
                }
                else{
                    punt--;
                }
            }
            else if (ITS == 'X'){//se imprime el character que el character esta ubicado en
                System.out.print(temp[punt]);
            }
        }
        System.out.println();
    }
    
    //metodos para el problema 2   
    public static int recibir(int array){//recibe el numero de cuatro digitos
        int cont=0;
        return cont;
        }    
    public static boolean validar(String numero){
        //Verifica que se hayan insertado solo numeros
        boolean numeroCorrecto = true;
        for(int i = 0; i < numero.length(); i++){
            char cifra = numero.charAt(i);
            int codigoASCII = (int)cifra;
            if(codigoASCII < 48 || codigoASCII > 57){//se valida con codigo ASCII
                numeroCorrecto = false;
                break;
            }
        }
            if(numeroCorrecto){
               //Se agregan los ceros si el numero ingresado tiene menos de cuatro numeros en total
               if(numero.length() == 1){
                   numero = "000" + numero;
               }else{
                    if(numero.length() == 2){
                        numero = "00" + numero;
               }else{
                    if(numero.length() == 3){
                        numero = "0" + numero;
                    }
                    }
               }
            return diff(numero);
                 
            }
        return false;
    }    
    public static boolean diff(String numero){//Se lee la diferencia entre ambos numeros separados
        int DGT = Integer.parseInt((numero.charAt(0)) + "");
        for(int j = 1; j < numero.length(); j++){
            int DGT_2 = Integer.parseInt((numero.charAt(j)) + "");
            if(DGT != DGT_2){
                    return true;
                }
            }
        return false;    
    }    
    public static int Kaprekar(int numero){//se analiza la formula hasta que se llege a 6174 si es posible
        int resta_Numeros = 0;
        int ITRC = 0;//se busca cuantas veces se hace la formula hasta que se llega al limite
        int _numeroMayor;
        int _numeroMenor;
        String numMen = "";
        while(resta_Numeros != 6174 && ITRC < 7){//se tiene que llegar al 6174 antes de que se cruce el limite de 7
            _numeroMayor = numeroMayor(numero);
            for(int i = (_numeroMayor + "").length() - 1; i >= 0; i--){
                numMen += (_numeroMayor + "").charAt(i);
            }
            _numeroMenor = Integer.parseInt(numMen);
            numMen = "";
            resta_Numeros = _numeroMayor - _numeroMenor;
            ITRC++;
            numero = resta_Numeros;
            if(ITRC == 7){//numero de iteraciones
                return 7;
            }
        }
        return ITRC;
    }    
    public static int numeroMayor(int numero){
        String num = String.valueOf(numero);
        if(num.length() == 3){
            num = "0" + num;
        }else{
            if(num.length() == 2){
                num = "00" + num;
            }else{
                if(num.length() == 1){
                    num = "000" + num;
                }
            }
        } //se le agregan los ceros restantes al numero para que se complete
        
        String cifra = "";
        boolean complete = false;
        while(!complete){
            int mayor = Integer.parseInt(num.charAt(0) + "");
            for(int i = 1; i < num.length(); i++){
                int digito = Integer.parseInt(num.charAt(i) + "");
                if(digito > mayor){
                    mayor = digito;
                }
            }
            cifra += mayor + "";
            num = num.replaceFirst(mayor + "", "");
            if(cifra.length() == 4){
                complete = true;
            }
        }
        return Integer.parseInt(cifra);
    }
    
}
