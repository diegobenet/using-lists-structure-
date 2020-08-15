/**************************************************************

Autor: Diego Elizondo Benet
Fecha: 21 de Marzo 2020
Doy mi palabra que he realizado esta actividad con integridad academica.
***************************************************************/
import java.io.*;

class Lista{
   Nodo inicio;
   int tam;
   
   public Lista(){
      inicio = null;
      tam = 0;
   }
   
   public boolean vacio(){
      return inicio == null;
   }
   
   public void agregar(Pais pais){
      Nodo T = inicio;
      Nodo aux = inicio;
      Nodo nuevo = new Nodo(pais);
      
      if(vacio()){
         inicio = nuevo;
      }else{
         while(aux.sig != null && aux.pais.nombre.compareTo(pais.nombre) >= -1){
            T = aux;
            aux = aux.sig;
         }
         if(aux.pais.nombre.compareTo(pais.nombre) >= -1){
            aux.sig = nuevo;
         }else{
            nuevo.sig = aux;
            if (aux == inicio){
               inicio = nuevo;
            }else{
               T.sig = nuevo;
            }
         }
      }
   }
   
   public void unir(Lista region, String r){
      Nodo aux = region.inicio;
      while (aux != null){
         PaisAmerica p = new PaisAmerica(aux.pais.nombre,aux.pais.poblacion,aux.pais.capital, r);
         agregarAmerica(p);
         aux = aux.sig;
      } 
   }
   
   public void agregarAmerica(PaisAmerica pais){
      Nodo T = inicio;
      Nodo aux = inicio;
      Nodo nuevo = new Nodo(pais);
      
      if(vacio()){
         inicio = nuevo;
      }else{
         while(aux.sig != null && aux.p.nombre.compareTo(pais.nombre) >= -1){
            T = aux;
            aux = aux.sig;
         }
         
         if(aux.p.nombre.compareTo(pais.nombre) >= -1){
            aux.sig = nuevo;
         }else {
            nuevo.sig = aux;
            if (aux == inicio) {
               inicio = nuevo;
            }else {
               T.sig = nuevo;
            }
         }
      }
   }

   public void desplegar() {
      Nodo aux = inicio;
      if(aux.pais != null){
         while (aux != null) {
            System.out.println("\npais: "+aux.pais.nombre);
            System.out.println("poblacion: "+aux.pais.poblacion);
            System.out.println("capital: "+aux.pais.capital+"\n");
            aux = aux.sig;
         }
      }else{
         while (aux != null) {
            System.out.println("\npais: "+aux.p.nombre);
            System.out.println("poblacion: "+aux.p.poblacion);
            System.out.println("capital: "+aux.p.capital);
            System.out.println("region: ["+aux.p.region+"]\n");
            aux = aux.sig;
         }
      }
   }
}

//CLASE NODO
class Nodo {
   Pais pais;
   Nodo sig;
   PaisAmerica p;
   
   //constructor normal para paises
   public Nodo(Pais pais) {
      this.pais = pais;
      sig = null;
      p = null;
   }
   //constructor para pais AMERICA
   public Nodo(PaisAmerica p){
      this.p = p;
      sig = null;
      pais = null;
   }
}

//CLASE PAIS
class Pais{
   String nombre;
   int poblacion;
   String capital;
   
   public Pais(String nombre, int poblacion, String capital){
      this.nombre = nombre;
      this.poblacion = poblacion;
      this.capital = capital;
   }
}

//clase paisAmerica
class PaisAmerica{
   String nombre;
   int poblacion;
   String capital;
   String region;
   
   public PaisAmerica(String nombre, int poblacion, String capital, String region){
      this.nombre = nombre;
      this.poblacion = poblacion;
      this.capital = capital;
      this.region = region;
   }
}

class Principal {
   public static void main(String[] args) {
      int eleccion = 1;
      
      Lista SUR = new Lista();
      Lista CENTRO = new Lista();
      Lista NORTE = new Lista();
      while (eleccion != 4) {
         //AGREGAR
         if(eleccion ==1){
            System.out.println("agregar en region SUR (s), CENTRO (c) o NORTE (n)");
            char region = Lectura.readChar();
            System.out.println("pais a agregar");
            String pais = Lectura.readString();
            System.out.println("poblacion del pais (en millones)?");
            int poblacion = Lectura.readInt();
            System.out.println("capital del pais?");
            String capital = Lectura.readString();
            
            Pais p = new Pais (pais, poblacion, capital);
            
            if(region == 's'){
               SUR.agregar(p);
            }else if(region == 'c'){
               CENTRO.agregar(p);
            }else if(region == 'n'){
               NORTE.agregar(p);
            }else{
               System.out.println("region invalida");
            }
         }
         //DESPLEGAR
         if(eleccion ==2){
            System.out.println("desplegar region SUR (s), CENTRO (c) o NORTE (n)");
            char region = Lectura.readChar();
            
            if(region == 's'){
               SUR.desplegar();
            }else if(region == 'c'){
               CENTRO.desplegar();
            }else if(region == 'n'){
               NORTE.desplegar();
            }else{
               System.out.println("region invalida");
            }
         }
         //UNIR AMERICA
         if(eleccion == 3){
            Lista AMERICA = new Lista();
            AMERICA.unir(SUR,"SUR");
            AMERICA.unir(CENTRO,"CENTRO");
            AMERICA.unir(NORTE,"NORTE");
            AMERICA.desplegar();
         }
         //opciones del menu
         System.out.println("Ingrese lo que desea hacer:\n"+"agregar un elemento (1)\n"+"Desplegar (2)\n"+"Unir America (3)\n"+"Salir (4)");
         eleccion = Lectura.readInt();
      }
   }
}

class Lectura{
	public static int readInt(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				int num2=Integer.parseInt(num);
			return num2;
	}
	
	public static float readFloat(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				float num2=Float.parseFloat(num);
			return num2;
	}
	
	public static byte readByte(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				byte num2=Byte.parseByte(num);
			return num2;
    }
    
    public static boolean readBoolean(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				boolean num2=Boolean.getBoolean(num);
			return num2;
	}
	
	public static double readDouble(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				double num2=Double.parseDouble(num);
			return num2;
	}
	
	public static long readLong(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				long num2=Long.parseLong(num);
			return num2;
	}
	
	public static short readShort(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				short num2=Short.parseShort(num);
			return num2;
	}
	
	public static char readChar(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				char num2=num.charAt(0);
			return num2;
	}
	public static String readString(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
			return num;
	}
}

// FIN CLASE LECTURA