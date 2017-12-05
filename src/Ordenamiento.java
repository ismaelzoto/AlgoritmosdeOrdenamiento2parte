
public class Ordenamiento {

	//Mostrar los datos del vector
	public void mostrarArreglo(int [] arreglo){
		int k=0;
		for(k=0;k<arreglo.length; k++){
			System.out.print("["+arreglo[k]+"]");
		}
		System.out.println();
	}
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

		mostrarArreglo(arreglo);
	}

	//metodo para incercion
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
	// metodo shell

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
	//metodo intercalacion
	public void intercalacion(int[]arregloA,int[]arregloB){
		int i,j,k;
		int arregloC[]=new int[arregloA.length+arregloB.length];
		//repetir mientras los arreglos A y B tengan elemntos que conparar
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


	//metodo mezcladirecta
	public int [] mezcladirecta (int [] arreglo){
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

	//Mostrar los datos del vector
	public void mostrarArreglos(int []arreglo){
		int k;
		for(k=0;k < arreglo.length; k++){
			System.out.print("["  +arreglo[k] +  " ] ");

		}
		System.out.print("");
	}
}


