package Pack;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Proceso {
	
	String nombre="";
	double imc,peso,talla;
	ArrayList<String> nombresList;
	ArrayList<String> resultadosList;
	
	public Proceso() {
		nombresList=new ArrayList<String>();
		resultadosList=new ArrayList<String>();
		iniciar();
	}
		
	
	public void iniciar() {
		
		System.out.println("Ingresa");
		String menu= "";
		menu+="1.Ingrese los datos\n";
		menu+="2.Consultar\n";
		menu+="3.Buscar por nombre\n";
		menu+="4.Salir\n";
		int opc=0;
		
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			menu(opc);
		} while (opc!=4);
		
		int rep=0;
		do {
			ingresarDatos();
			calcularIMC();
			rep=Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para repetir"));
		} while (rep==1);

		System.out.println(nombresList);
		System.out.println(resultadosList);
		System.out.println();
		menu(opc);

		int rep2=0;
		do {
			consultarPorNombre();
			rep2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para repetir"));
		} while (rep2==1);
		
		
	}
	public void menu(int opcion) {
		switch (opcion) {
		case 1: {
			ingresarDatos();
			break;
		}
		case 2: {
			imprimirListas();
			break;
		}
		case 3: {
				consultarPorNombre();
			
			break;
		}
		
		default:
			}
	}
	
private void consultarPorNombre() {
		
		String nombreConsulta=JOptionPane.showInputDialog("Ingrese el nombre a buscar");

		if (nombresList.contains(nombreConsulta)) {
			for (int i = 0; i < nombresList.size(); i++) {
				if (nombresList.get(i).equalsIgnoreCase(nombreConsulta)) {
					System.out.println("Si existe "+nombreConsulta+","
							+ " tiene "+resultadosList.get(i));
				}
			}	
			
			
			System.out.println("Imprime usando foreach");
			for (String elemento : nombresList) {
				int pos=nombresList.indexOf(elemento);
				if (nombresList.get(pos).equalsIgnoreCase(nombreConsulta)) {
					System.out.println(elemento+", resultado= "+resultadosList.get(pos));
					
				}
			}
			
			
		}else {
			System.out.println("NO existe");
		}
	
	}

	public void imprimirListas() {
		System.out.println("********RESULTADOS**********");
		
		System.out.println(nombresList);
		System.out.println(resultadosList
				);
		
		for (int i = 0; i < nombresList.size(); i++) {
			System.out.println(nombresList.get(i)+", resultado: "+resultadosList.get(i));
		}
		System.out.println("*****************************");
	}

	private void ingresarDatos() {
		nombre=JOptionPane.showInputDialog("Ingrese el nombre");
		nombresList.add(nombre);
		imc=0;
		peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
		talla=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla"));
		calcularIMC();
	}
	
	private void calcularIMC() {
		imc=peso/(talla*talla);
		System.out.println("El IMC es: "+imc);
		
		String result="";
		
		if (imc<18) {
			result=("Anorexia");
		}else if (imc>=18 && imc <20) {
			result=("Delgadez");
		}else if (imc>=20 && imc <27) {
			result=("Normalidad");
		}else if (imc>=27 && imc <30) {
			result=("Obesidad 1");
		}else if (imc>=30 && imc <35) {
			result=("Obesidad 2");
		}else if (imc>=35 && imc <40) {
			result=("Obesidad 3");
		}else if (imc>=40) {
			result=("Obesidad Morbida");
		}

		resultadosList.add(result);
		System.out.println("El Resultado es: "+result);
	}



	
}

