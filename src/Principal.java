
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Ordenamiento ordenar = new Ordenamiento();
        
        int vector1[] = {5, 6, 3, 44, 22, 1};
        int vector2[] = {55,4,43,44,2,10,4567,638,3,0,-5,-9};
        int vector3[] = {5, 2, 1, 8, 3, 9, 7};
        /*System.out.println("Arreglo original");
        ordenar.mostrarArreglo(vector1);
        System.out.println("Arreglo ordenado con burbuja 1");
        ordenar.burbuja1(vector1);
        ordenar.mostrarArreglo(vector1);
        System.out.println();
        System.out.println("Arreglo original");
        ordenar.mostrarArreglo(vector2);
        System.out.println("Arreglo ordenado con burbuja 2");
        ordenar.burbuja1(vector2);
        ordenar.mostrarArreglo(vector2);*/
        
       //System.out.println("Arreglo orginal");
       // ordenar.mostrarArreglo(vector2);
       //ordenar.radix(vector2);
       //ordenar.mostrarArreglo(vector3);
       //ordenar.quick(vector3, 0, vector3.length-1);
        /* int tam;
        tam=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el tamaño del arreglo"));
        int vectorcito[]= new int[tam];
        for(int i=0;i<tam;i++){
           vectorcito[i]=Integer.parseInt(JOptionPane.showInputDialog(null,
                   "Ingresa el elemento del indice"+i));
            ordenar.insrcion(vectorcito, i+1);
            
            
        }*/
         
          //System.out.println ("Arreglo  original");
         // ordenar.mostrarArreglos(vector3);
          //ordenar.shell(vector3);
          
         /* System.out.println (" \n  Arreglo  vector 1 original");
          ordenar.mostrarArreglos(vector1);
          System.out.println (" \n  Arreglo  vector 2 original ");
          ordenar.mostrarArreglos(vector2);
          ordenar.burbuja(vector1);
           ordenar.burbuja(vector3);
           
           ordenar.intercalacion(vector1, vector2);
           
          */
         
        /* System.out.println (" \n  Arreglo  vector 2 original");
         ordenar.mostrarArreglos(vector2);
         System.out.println (" \n  Arreglo  vector 2 ordenado por mezcla Directa");
         vector2=ordenar.mezcladirecta(vector2);
         ordenar.mostrarArreglos(vector2);
         */
         
        //System.out.println (" \n  Arreglo  vector 2 original");
        //ordenar.mostrarArreglos(vector2);
         //System.out.println (" \n  Arreglo  vector 2 ordenado por mezcla natural");
         //ordenar.mezclanatural(vector2);
         //ordenar.mostrarArreglos(vector2);   
        ordenar.mostrarArreglos(vector2);
        ordenar.burbuja1(vector2);
        ordenar.mostrarArreglos(vector2);
        int indice=ordenar.busquedaBinaria(vector2, 10);
        if(indice!=-1){
        	System.out.println("Elemento 10 encontrado en el indice "+indice);
        }else{
        	System.out.println("Elemento 10 NO encontrado");
        }
        Funcionhash hash=new Funcionhash(8);
        String[] elementos={ "20","33","21","10","12","14","56","100"};
        hash.funcionhash(elementos, hash.arreglo);
        hash.mostar();
        String buscado=hash.buscarclave("33");
        if( buscado==null){
             System.out.println("   el elemento 33 no se encuentra en la tabla" ); }
        
	}
	 
 }