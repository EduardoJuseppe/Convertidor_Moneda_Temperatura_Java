package mx.operaciones;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Operaciones {
	
	public String regresarOpcion (Object opcion) {
		if(opcion != null) {
			 return opcion.toString();
		}else {
			 return "String";
		}
	}
	
	public boolean validarError(String nombre) {
		if(nombre == null) {
			 JOptionPane.showMessageDialog(null, "El valor es nulo, favor de ingresar un numero",
		                "ERROR!", JOptionPane.ERROR_MESSAGE);
			  return  false;
		 }else if(nombre.equals("")) {
			 JOptionPane.showMessageDialog(null, "El valor es vacio, favor de ingresar un numero",
		                "ERROR!", JOptionPane.ERROR_MESSAGE);
			 return false;
		 }else if(nombre.matches("[0-9.]*")){		 	
			 return  true;
		 }else {
			 JOptionPane.showMessageDialog(null, "Ingresar solo numeros",
		                "ERROR!", JOptionPane.ERROR_MESSAGE);
			 return false;
		 }
	}	
	
	public void filtrar(double moneda, String tipo) {
		// TODO Auto-generated method stub
		double cambio;
		if(tipo == "dolares")
			cambio = 0.053;
		else if(tipo == "euro")
			cambio = 0.049;
		else if(tipo == "libras")
			cambio = 0.044;
		else if(tipo == "yen")
			cambio = 6.94;
		else if(tipo == "won coreano")
			cambio = 66.58;
		else if(tipo == "dpeso") {
			cambio = 18.94;
			tipo = "pesos";
		}
		else if(tipo == "epeso") {
			cambio = 20.29;
			tipo = "pesos";
		}
		else if(tipo == "lpeso") {
			cambio = 22.87;
			tipo = "pesos";
		}
		else if(tipo == "ypeso") {
			cambio = 0.14;
			tipo = "pesos";
		}	
		else if(tipo == "wpeso") {
			cambio = 0.015;
			tipo = "pesos";
		}
		else
			cambio = 1;
		convertirMoneda(moneda, cambio,tipo);
	}

	public void convertirMoneda(double moneda, double cambio, String tipo) {
		// TODO Auto-generated method stub
		double monedaConvertida = moneda*cambio;
		DecimalFormat df = new DecimalFormat("#.00");
		JOptionPane.showMessageDialog(null, "Tienes $"+df.format(monedaConvertida)+" "+tipo,
                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void convertirGrados(double grados, String tipo) {
		double resultado;
		switch(tipo) {
		case"GF":
			resultado = (grados * 9)/5 + 32d;
			mostrarGrados(resultado,"°F");
			break;
		case"GK":
			resultado = grados + 273.15;
			mostrarGrados(resultado,"°K");
			break;
		case"FG":
			resultado = (grados - 32d)*(5/9d);
			mostrarGrados(resultado,"°C");
			break;
		case"FK":
			resultado = (grados - 32d)*(5/9d)+ 273.15;
			mostrarGrados(resultado,"°K");
			break;
		case"KG":
			resultado = grados - 273.15;
			mostrarGrados(resultado,"°C");
			break;
		case"KF":
			resultado = (grados  - 273.15) * 9/5d + 32;
			mostrarGrados(resultado,"°C");
			break;
		default:
			resultado = 1;
		}
	}
	
	public void mostrarGrados(double resultado, String tipoGrados) {
		DecimalFormat df = new DecimalFormat("#.00");
		JOptionPane.showMessageDialog(null, "Tienes $"+df.format(resultado)+" "+tipoGrados,
                "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
}
