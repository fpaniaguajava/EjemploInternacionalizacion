package com.fernandopaniagua.ejemplo;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class App {

	public static void main(String[] args) {
		new App().ejecutar();
	}
	public void ejecutar() {
		//Obtener todos los Locale disponibles
		System.out.println("***LOCALES disponibles***");
		Locale[] locales = Locale.getAvailableLocales();
		for(Locale l : locales) {
			System.out.println(l);
		}
		
		//Método para obtener el Locale actual
		System.out.println("***LOCALE default***");
		Locale locale = Locale.getDefault();
		System.out.println(locale);
		System.out.println(locale.getLanguage());
		System.out.println(locale.getCountry());
		
		//Constantes de Locale
		System.out.println("***Constantes de locale***");		
		System.out.println(Locale.FRANCE);
		System.out.println(Locale.FRENCH);
		
		//Creación de Locales 'personales'
		System.out.println("***Locale 'personal'***");
		Locale panilocale = new Locale("pa","PAN");
		System.out.println(panilocale);
		
		//Modifación de Locale por defecto
		System.out.println("***Cambio de locale por defecto***");
		Locale.setDefault(Locale.FRANCE);
		locale = Locale.getDefault();
		System.out.println(locale);
		System.out.println(locale.getLanguage());
		System.out.println(locale.getCountry());
		
		mostrarMensajesTraducidos();
	}
	
	private void mostrarMensajesTraducidos() {
		Locale.setDefault(new Locale("es","ES"));
		Locale localeActual = Locale.getDefault();
		ResourceBundle rb = ResourceBundle.getBundle("recursos/errores", localeActual);
		System.err.println(rb.getString("nombrecorto"));
		//Creando un mensaje de error con información variable
		String textoError = rb.getString("nombreinsuficiente");
		System.err.println(MessageFormat.format(textoError,10));
		
		localeActual = Locale.FRANCE;
		System.out.println(localeActual);
		rb = ResourceBundle.getBundle("recursos/errores", localeActual);
		System.err.println(rb.getString("nombrecorto"));
		//Creando un mensaje de error con información variable
		textoError = rb.getString("nombreinsuficiente");
		System.err.println(MessageFormat.format(textoError,10));
		
		localeActual = Locale.CHINA;
		System.out.println(localeActual);
		rb = ResourceBundle.getBundle("recursos/errores", localeActual);
		System.err.println(rb.getString("nombrecorto"));
		//Creando un mensaje de error con información variable
		textoError = rb.getString("nombreinsuficiente");
		System.err.println(MessageFormat.format(textoError,10));
	}

}
