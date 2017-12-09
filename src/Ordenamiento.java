
public class Ordenamiento {
	
	int i,j,temporal,pasadas;

	public Ordenamiento(){
		this.i=0;
		this.j=0;
		this.temporal=0;
	}
	//Metodo burbuja version 1
		public void burbuja1(int [] arreglo){
			pasadas=0;
			for(i=0; i<arreglo.length; i++){
				for(j=i+1; j<arreglo.length;j++){
					if (arreglo[i]>arreglo[j]){
						temporal=arreglo[i];
						arreglo[i]=arreglo[j];
						arreglo[j]=temporal;
					}
					pasadas++;
				}
			}
			System.out.println("Termino en "+pasadas+" pasadas");
		}
		//Metodo burbuja version 2
		public void burbuja2(int[] arreglo){
			pasadas=0;
			for(i=1; i<arreglo.length; i++){
				for(j=0; j<arreglo.length-1;j++){
					if (arreglo[j]>arreglo[j+1]){
						temporal=arreglo[j];
						arreglo[j]=arreglo[j+1];
						arreglo[j+1]=temporal;
					}
					pasadas++;
				}
			}
			System.out.println("Termino en "+pasadas+" pasadas");

		}
		//metodo radix
		public void radix(int[] arreglo){
			int x ,i,j;
			for(x=Integer.SIZE-1; x>=0; x--){
				int auxiliar[]=new int[arreglo.length];
				j=0;
				for(i=0;i<arreglo.length; i++){
					boolean mover=arreglo[i]<<x>=0;
					if (x==0 ? !mover:mover){
						auxiliar[j]=arreglo[i];
						j++;
					}else {
						arreglo[i-j]=arreglo[i];
					}
				}
				for(i=j;i<auxiliar.length;i++){
					auxiliar[i]=arreglo[i-j];
				}
				arreglo=auxiliar;
			}
			System.out.println("el arreglo ordenado con radiz es: ");
			mostrarArreglos(arreglo);
		}	
	//Metodo Quick
	public void quick(int[] arreglo,int primero,int ultimo){
		int i,j,pivote,aux;
		i=primero;
		j=ultimo;
		pivote=arreglo[(primero+ultimo)/2];
		System.out.println("El pivote es:" + pivote);
		do{
			while(arreglo[i]<pivote){
				i++;
			}
			while(arreglo[j]>pivote){
				j--;
			}
			//aqui hacemos el intercambio
			if(i<=j){
				aux=arreglo[i];
				arreglo[i]=arreglo[j];
				arreglo[j]=aux;	
				i++;
				j--;
			}
		}while(i<=j);
		if(primero<j){
			quick(arreglo,primero,j);
		}
		if(i<ultimo){
			quick(arreglo,i,ultimo);
		}

		mostrarArreglos(arreglo);
	}
	//Metodo para incercion
	public void insrcion(int[]arreglo,int n){
		int i,j,auxiliar;
		for(i=1;i<n;i++){
			auxiliar=arreglo[i];
			j=i-1;
			while(j>=0 &&arreglo[j]>auxiliar){
				arreglo[j+1]=arreglo[j];
				j=j-1;

			}
			arreglo[j+1]=auxiliar;
		}
		System.out.println("\n Arreglo ordenado por insercion");
		mostrarArreglos(arreglo);
	}
	//Metodo shell
    public void shell(int[] arreglo){
		int salto,i,j,k,auxiliar;
		salto=arreglo.length/2;
		while(salto>0){
			for(i=salto;i<arreglo.length;i++){
				j=i-salto;
				while(j>=0){
					k=j+salto;
					if(arreglo[j]<=arreglo[k]){
						j=-1;
					}else{
						auxiliar=arreglo[k];
						arreglo[j]=arreglo[k];
						arreglo[k]=auxiliar;
						j-=salto;
					}

				}

			}
			salto=salto/2;
		}
		System.out.println("\n Arreglo ordenado con shell");
		mostrarArreglos(arreglo);
	}
	//Metodo intercalacion
	public void intercalacion(int[]arregloA,int[]arregloB){
		int i,j,k;
		int arregloC[]=new int[arregloA.length+arregloB.length];
		//repetir mientras los arreglos A y B tengan elementos que conparar
		for(i=j=k=0;i<arregloA.length && j<arregloB.length;k++){
			if(arregloA[i]<arregloB[j]){
				arregloC[k]=arregloA[i];
				i++;

			}else{
				arregloC[k]=arregloB[j];
				j++;
			}


		}
		//para añadir a arreglo C los elementos del arregloA sobrantes en caso de haberlo
		for(;i<arregloA.length;i++,k++){
			arregloC[k]=arregloA[i];


		}
		//para añadir a arreglo C los elemntos del arregloB sobrantes en caso de haberlo
		for(;j<arregloB.length;j++,k++){
			arregloC[k]=arregloB[j];
		}
		System.out.println("\n Arreglos ordenados por intercalacion");
		mostrarArreglos(arregloC);
	}


	//Metodo mezcla directa
	public int [] mezcladirecta(int [] arreglo){
		int i,j,k;
		if(arreglo.length> 1){
			int nElementosIzq=arreglo.length/2;
			int nElementosDer=arreglo.length-nElementosIzq;
			int arregloIzq[]= new int[nElementosIzq];
			int arregloDer[]= new int[nElementosDer];
			// copiando los elementos de parte primera al erreglo Izq
			for(i=0;i<nElementosIzq;i++){
				arregloIzq[i]=arreglo[i];
			}
			// copiando los elementos de parte segunda al erreglo Der 
			for(i=nElementosIzq;i<nElementosIzq+nElementosDer;i++){
				arregloDer[i - nElementosIzq]=arreglo[i];
			}
			//Recursividad
			arregloIzq=mezcladirecta(arregloIzq);
			arregloDer=mezcladirecta(arregloDer);
			i=0;
			j=0;
			k=0;
			while(arregloIzq.length != j && arregloDer.length != k){
				if(arregloIzq[j]<arregloDer[k]){
					arreglo[i]=arregloIzq[j];
					i++;
					j++;

				}else{
					arreglo[i]=arregloDer[k];
					i++;
					k++;
				}

			}
			//Arreglo final
			while( arregloIzq.length!=j){
				arreglo[i]=arregloIzq[j];
				i++;
				j++;

			}
			while( arregloDer.length !=k){
				arreglo[i]=arregloDer[k];
				i++;
				k++;

			}
		}//Fin del if
		return arreglo;
	}
	//metodo mezcla natural
    public void mezclanatural(int arreglo[]){
		int izquierda=0,izq=0,derecha=arreglo.length-1,der=derecha;
		boolean ordenado=false;
		do{
			ordenado=true;
			izquierda=0;
			while( izquierda< derecha){
				izq = izquierda;
				while( izq<derecha && arreglo[izq]<=arreglo[izq=1]){
					izq++;


				}
				der=izq+1;
				while( der==derecha-1 || der<derecha && arreglo[der]<=arreglo[der+1]){
					der++;

				}
				if( der<=derecha){
					mezcladirecta2(arreglo);
					ordenado=false;

				}
				izquierda=izq;
			}
		}while(!ordenado);
	}
	//metodo mezclaDirecta 2
	public void mezcladirecta2(int [] arreglo){
		int i,j,k;
		if(arreglo.length> 1){
			int nElementosIzq=arreglo.length/2;
			int nElementosDer=arreglo.length-nElementosIzq;
			int arregloIzq[]= new int[nElementosIzq];
			int arregloDer[]= new int[nElementosDer];
			// copiando los elementos de parte primera al erreglo Izq
			for(i=0;i<nElementosIzq;i++){
				arregloIzq[i]=arreglo[i];
			}
			// copiando los elementos de parte segunda al erreglo Der 
			for(i=nElementosIzq;i<nElementosIzq+nElementosDer;i++){
				arregloDer[i - nElementosIzq]=arreglo[i];
			}
			//Recursividad
			arregloIzq=mezcladirecta(arregloIzq);
			arregloDer=mezcladirecta(arregloDer);
			i=0;
			j=0;
			k=0;
			while(arregloIzq.length != j && arregloDer.length != k){
				if(arregloIzq[j]<arregloDer[k]){
					arreglo[i]=arregloIzq[j];
					i++;
					j++;

				}else{
					arreglo[i]=arregloDer[k];
					i++;
					k++;
				}

			}
			//Arreglo final
			while( arregloIzq.length!=j){
				arreglo[i]=arregloIzq[j];
				i++;
				j++;

			}
			while( arregloDer.length !=k){
				arreglo[i]=arregloDer[k];
				i++;
				k++;

			}
		}//Fin del if

	}
	//Metoddo de busqueda secuencial
	public int busquedasecuencial(int arreglo [],int elemento){
		int i;
		boolean encontrado=false;
		
		for(i=0; i<arreglo.length && encontrado == false; i++){
			if (elemento==arreglo[i]){
				encontrado=true;
				return i;
			}
		}
		return -1;
	}
	//metodo de busqueda Binaria
	public int busquedaBinaria(int arreglo[],int elemento){
		int centro,primero,ultimo,valorcentro;
		primero=0;
		ultimo=arreglo.length-1;
		while(primero<=ultimo){
			centro=(primero+ultimo)/2;
			valorcentro=arreglo[centro];
			System.out.println("Comparando a "+elemento+" con "+ arreglo[centro]);
			if(elemento==valorcentro){
				return centro;
			}else if(elemento<valorcentro){
				ultimo=centro-1;//desplazarnos hacia la Izq
				
			}else{
				primero=centro+1;//desplazarnos hacia la Der
			}
		}
		return -1;
		
	}
	//Mostrar los datos del vector
	public void mostrarArreglos(int []arreglo){
		int k;
		for(k=0;k < arreglo.length; k++){
			System.out.print("["  +arreglo[k] +  " ] ");

		}
		System.out.print("");
	}
}


