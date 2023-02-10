package mx.app;

import mx.operaciones.*;
import mx.menus.*;
import javax.swing.JOptionPane;

public class AppConversor extends Operaciones implements Menus{
	private int salir;
	private boolean pedirValor;
	private double moneda;
	private double grados;
	private String opc;
	public AppConversor() {
		iniciarApp();
	}

	private void iniciarApp() {
		do {
			this.opc = menuPrincipal();
			switch(opc) {
						case "Conversos de Moneda":					
							do {
								String valorInput = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir");
								 this.pedirValor = super.validarError(valorInput);			
								 if(this.pedirValor)
									 this.moneda = Double.parseDouble(valorInput);
							}while(!pedirValor);
							this.salir = menuConvertirMoneda(this.moneda);
							break;
						case "Conversor de Temperatura":
								do {
									String valorInput = JOptionPane.showInputDialog("Ingresa los grados que deseas convertir");
									 this.pedirValor = super.validarError(valorInput);			
									 if(this.pedirValor)
										 this.grados = Double.parseDouble(valorInput);
								}while(!pedirValor);
								this.salir = menuConvertirGrados(this.grados);
							break;
							default:
								this.salir = 1;
					}
		}while(this.salir == 0);
		JOptionPane.showOptionDialog(null, "Programa Terminado ", "Mensaje" ,
                JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Ok"},"Ok"); 
		
	}

	@Override
	public int menuConvertirMoneda(double moneda) {
		// TODO Auto-generated method stub
		Object [] menuDinero ={"De Pesos a Dolar","De Pesos a Euro","De Pesos a Libras","De Pesos a Yen","De Pesos a Won Coreano","De Dolar a Pesos","De Euro a Pesos","De Libras a Pesos","De Yen a Pesos","De Won Coreano a Pesos"}; 
		String opc = regresarOpcion(JOptionPane.showInputDialog(null,"Selecciona un conversor", "Elegir",JOptionPane.QUESTION_MESSAGE,null,menuDinero, menuDinero[0]));
		switch(opc) {
			case "De Pesos a Dolar":
				filtrar(moneda, "dolares");
				return menuContinuar();
			case "De Pesos a Euro":
				filtrar(moneda, "euro");
				return menuContinuar();
			case "De Pesos a Libras":
				filtrar(moneda, "libras");
				return menuContinuar();
			case "De Pesos a Yen":
				filtrar(moneda, "yen");
				return menuContinuar();
			case "De Pesos a Won Coreano":
				filtrar(moneda, "won coreano");
				return menuContinuar();
			case "De Dolar a Pesos":
				filtrar(moneda, "dpeso");
				return menuContinuar();
			case "De Euro a Pesos":
				filtrar(moneda, "epeso");
				return menuContinuar();
			case "De Libras a Pesos":
				filtrar(moneda, "lpeso");
				return menuContinuar();
			case "De Yen a Pesos":
				filtrar(moneda, "ypeso");
				return menuContinuar();
			case "De Won Coreano a Pesos":
				filtrar(moneda, "wpeso");
				return menuContinuar();
			default:
				return 1;
		}
	}

	@Override
	public String menuPrincipal() {
		// TODO Auto-generated method stub
		Object [] conversor ={"Conversos de Moneda","Conversor de Temperatura"}; 
		return super.regresarOpcion(JOptionPane.showInputDialog(null,"Selecciona un conversor", "Elegir",JOptionPane.QUESTION_MESSAGE,null,conversor, conversor[0]));
	}
	
	@Override
	public int menuContinuar() {
		// TODO Auto-generated method stub
		return JOptionPane.showConfirmDialog(
		        null, 
		        "¿Quieres continuar?", 
		        "Confirm",
		        JOptionPane.YES_NO_CANCEL_OPTION, 
		        JOptionPane.QUESTION_MESSAGE
		    );
	}

	@Override
	public int menuConvertirGrados(double grados) {
		// TODO Auto-generated method stub
		Object [] menuGrados ={"De Celsius a Fahrenheit","De Celsius a Kelvin","De Fahrenheit a Celsius","De Fahrenheit a Kelvin","De Kelvin a Celsius","De Kelvin a Fahrenheit"}; 
		String opc = regresarOpcion(JOptionPane.showInputDialog(null,"Selecciona un conversor", "Elegir",JOptionPane.QUESTION_MESSAGE,null,menuGrados, menuGrados[0]));
		switch(opc) {
		case "De Celsius a Fahrenheit":
			super.convertirGrados(grados, "GF");
			return menuContinuar();
			
		case "De Celsius a Kelvin":
			super.convertirGrados(grados, "GK");
			return menuContinuar();
			
		case "De Fahrenheit a Celsius":
			super.convertirGrados(grados, "FG");
			return menuContinuar();
			
		case "De Fahrenheit a Kelvin":
			super.convertirGrados(grados, "FK");
			return menuContinuar();
			
		case "De Kelvin a Celsius":
			super.convertirGrados(grados, "KG");
			return menuContinuar();
			
		case "De Kelvin a Fahrenheit":
			super.convertirGrados(grados, "KF");
			return menuContinuar();
			
		default:
			return 1;
		}
	}

}
