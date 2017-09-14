package problemaIA;

import java.util.Scanner;

public class AroundTheWall {
	
	public static double minDistance(int radioRobot, int posicionAbscisaInicial,int posicionOrdenadaInicial, int posicionAbscisaFinal,int posicionOrdenadaFinal){
		double pendiente;
		double discriminante;
		double primerCorteAbscisa;
		double segundoCorteAbscisa;
		double primerCorteOrdenada;
		double segundoCorteOrdenada;
		double recorridoTotal;
		double variableTemporal;
		double discriminanteOrdenada;
		
		if (posicionAbscisaInicial-posicionAbscisaFinal!=0){
			
		pendiente=(double) (posicionOrdenadaFinal-posicionOrdenadaInicial)/(posicionAbscisaFinal-posicionAbscisaInicial);
		discriminante=4*pendiente*pendiente*(posicionOrdenadaFinal-posicionAbscisaFinal*pendiente)*(posicionOrdenadaFinal-posicionAbscisaFinal*pendiente)-4*(1+pendiente*pendiente)*(pendiente*pendiente*posicionAbscisaFinal*posicionAbscisaFinal+posicionOrdenadaFinal*posicionOrdenadaFinal-2*pendiente*posicionAbscisaFinal*posicionOrdenadaFinal-radioRobot*radioRobot);
		
	    if(discriminante>=0){
	    	//Puntos de corte con la circunferencia
	    	primerCorteAbscisa=(-1*(2*pendiente*(posicionOrdenadaFinal-posicionAbscisaFinal*pendiente))-Math.sqrt(discriminante))/(2*(1+pendiente*pendiente));
	    	segundoCorteAbscisa=(-1*(2*pendiente*(posicionOrdenadaFinal-posicionAbscisaFinal*pendiente))+Math.sqrt(discriminante))/(2*(1+pendiente*pendiente));
	        
	        if(Math.abs(posicionAbscisaInicial-primerCorteAbscisa)>Math.abs(posicionAbscisaInicial-segundoCorteAbscisa)){
	        	variableTemporal=segundoCorteAbscisa;
	        	segundoCorteAbscisa=primerCorteAbscisa;
	        	primerCorteAbscisa=variableTemporal;
	        }
	        if(discriminante==0){
	        	if(primerCorteAbscisa<=0){
	        		recorridoTotal=distanciaPuntoPunto(posicionAbscisaInicial,posicionOrdenadaInicial,posicionAbscisaFinal,posicionOrdenadaFinal);
	        		return recorridoTotal;
	        	}
	        		else{
	        			primerCorteAbscisa=calculaPuntoTangente(radioRobot,posicionAbscisaInicial,posicionOrdenadaInicial);
	        			segundoCorteAbscisa=calculaPuntoTangente(radioRobot,posicionAbscisaFinal,posicionOrdenadaFinal);
	        			primerCorteOrdenada=pendiente*(primerCorteAbscisa-posicionAbscisaFinal)+posicionOrdenadaFinal;
	                	segundoCorteOrdenada=pendiente*(segundoCorteAbscisa-posicionAbscisaFinal)+posicionOrdenadaFinal;
	                	recorridoTotal=calculaRecorridoTotal(radioRobot,posicionAbscisaInicial, posicionOrdenadaInicial, posicionAbscisaFinal,  posicionOrdenadaFinal, primerCorteAbscisa, segundoCorteAbscisa, primerCorteOrdenada, segundoCorteOrdenada);
	                	return recorridoTotal;
	        		}
	        	}
	        else{
	        	primerCorteAbscisa=calculaPuntoTangente(radioRobot,posicionAbscisaInicial,posicionOrdenadaInicial);
	        	segundoCorteAbscisa=calculaPuntoTangente(radioRobot,posicionAbscisaFinal,posicionOrdenadaFinal);
	    		discriminanteOrdenada=posicionOrdenadaInicial*posicionOrdenadaInicial+4*primerCorteAbscisa*(posicionAbscisaInicial-primerCorteAbscisa);
	    		variableTemporal=(posicionOrdenadaInicial+Math.sqrt(discriminanteOrdenada))/2;
	    		
	    		if((variableTemporal*variableTemporal+primerCorteAbscisa*primerCorteAbscisa)==radioRobot*radioRobot){
	    			primerCorteOrdenada=variableTemporal;
	    		}
	    		else{
	    			primerCorteOrdenada=(posicionOrdenadaInicial-Math.sqrt(discriminanteOrdenada))/2;
	    		}
	    		discriminanteOrdenada=posicionOrdenadaFinal*posicionOrdenadaFinal+4*segundoCorteAbscisa*(posicionAbscisaFinal-segundoCorteAbscisa);
	    		variableTemporal=(posicionOrdenadaFinal+Math.sqrt(discriminanteOrdenada))/2;
	    			
	    		if((variableTemporal*variableTemporal+segundoCorteAbscisa*segundoCorteAbscisa)==radioRobot*radioRobot){
	    			segundoCorteOrdenada=variableTemporal;
	    		}
	    		else{
	    			segundoCorteOrdenada=(posicionOrdenadaFinal-Math.sqrt(discriminanteOrdenada))/2;		
	    		}
	            	
	    		recorridoTotal=calculaRecorridoTotal(radioRobot,posicionAbscisaInicial, posicionOrdenadaInicial, posicionAbscisaFinal,  posicionOrdenadaFinal, primerCorteAbscisa, segundoCorteAbscisa, primerCorteOrdenada, segundoCorteOrdenada);
	            return recorridoTotal;
	        		
	        	}
	        	
	        	
	        	
	        }
	        else{
	        	variableTemporal=((radioRobot-posicionOrdenadaInicial)/pendiente)+posicionAbscisaInicial;
	        	
	        	if(variableTemporal<0){
	        		recorridoTotal=distanciaPuntoPunto(posicionAbscisaInicial,posicionOrdenadaInicial,posicionAbscisaFinal,posicionOrdenadaFinal);
	        	}
	        	else{
	        		primerCorteAbscisa=calculaPuntoTangente(radioRobot,posicionAbscisaInicial,posicionOrdenadaInicial);	
	    			segundoCorteAbscisa=calculaPuntoTangente(radioRobot,posicionAbscisaFinal,posicionOrdenadaFinal);
	    			discriminanteOrdenada=posicionOrdenadaInicial*posicionOrdenadaInicial+4*primerCorteAbscisa*(posicionAbscisaInicial-primerCorteAbscisa);
	    			variableTemporal=(posicionOrdenadaInicial+Math.sqrt(discriminanteOrdenada))/2;
	    			if((variableTemporal*variableTemporal+primerCorteAbscisa*primerCorteAbscisa)==radioRobot*radioRobot){
	    				primerCorteOrdenada=variableTemporal;
	    			}
	    			else{
	    				primerCorteOrdenada=(posicionOrdenadaInicial-Math.sqrt(discriminanteOrdenada))/2;
	    			}
	    			
	    			discriminanteOrdenada=posicionOrdenadaFinal*posicionOrdenadaFinal+4*segundoCorteAbscisa*(posicionAbscisaFinal-segundoCorteAbscisa);
	    			variableTemporal=(posicionOrdenadaFinal+Math.sqrt(discriminanteOrdenada))/2;
	    			if((variableTemporal*variableTemporal+segundoCorteAbscisa*segundoCorteAbscisa)==radioRobot*radioRobot){
	    				segundoCorteOrdenada=variableTemporal;
	    			}
	    			else{
	    				segundoCorteOrdenada=(posicionOrdenadaFinal-Math.sqrt(discriminanteOrdenada))/2;
	    			}
	    			
	            	recorridoTotal=calculaRecorridoTotal(radioRobot,posicionAbscisaInicial, posicionOrdenadaInicial, posicionAbscisaFinal,  posicionOrdenadaFinal, primerCorteAbscisa, segundoCorteAbscisa, primerCorteOrdenada, segundoCorteOrdenada);
	            	return recorridoTotal;
	        		
	        	}
	        }
		}
		else{
			if((posicionOrdenadaInicial>0 && posicionOrdenadaFinal>0) || (posicionOrdenadaInicial<0 && posicionOrdenadaFinal<0) || posicionAbscisaInicial<=-1*radioRobot){
				return distanciaPuntoPunto(posicionAbscisaInicial,posicionOrdenadaInicial,posicionAbscisaFinal,posicionOrdenadaFinal);
			}
			else{
				primerCorteAbscisa=calculaPuntoTangente(radioRobot,posicionAbscisaInicial,posicionOrdenadaInicial);
	        	segundoCorteAbscisa=calculaPuntoTangente(radioRobot,posicionAbscisaFinal,posicionOrdenadaFinal);
	    		discriminanteOrdenada=posicionOrdenadaInicial*posicionOrdenadaInicial+4*primerCorteAbscisa*(posicionAbscisaInicial-primerCorteAbscisa);
	    		variableTemporal=(posicionOrdenadaInicial+Math.sqrt(discriminanteOrdenada))/2;
	    		
	    		if((variableTemporal*variableTemporal+primerCorteAbscisa*primerCorteAbscisa)==radioRobot*radioRobot){
	    			primerCorteOrdenada=variableTemporal;
	    		}
	    		else{
	    			primerCorteOrdenada=(posicionOrdenadaInicial-Math.sqrt(discriminanteOrdenada))/2;
	    		}
	    		discriminanteOrdenada=posicionOrdenadaFinal*posicionOrdenadaFinal+4*segundoCorteAbscisa*(posicionAbscisaFinal-segundoCorteAbscisa);
	    		variableTemporal=(posicionOrdenadaFinal+Math.sqrt(discriminanteOrdenada))/2;
	    			
	    		if((variableTemporal*variableTemporal+segundoCorteAbscisa*segundoCorteAbscisa)==radioRobot*radioRobot){
	    			segundoCorteOrdenada=variableTemporal;
	    		}
	    		else{
	    			segundoCorteOrdenada=(posicionOrdenadaFinal-Math.sqrt(discriminanteOrdenada))/2;		
	    		}
	            	
	    		recorridoTotal=calculaRecorridoTotal(radioRobot,posicionAbscisaInicial, posicionOrdenadaInicial, posicionAbscisaFinal,  posicionOrdenadaFinal, primerCorteAbscisa, segundoCorteAbscisa, primerCorteOrdenada, segundoCorteOrdenada);
	            
	    		return recorridoTotal;
	        		
	        	}
				
			
		}
		return recorridoTotal;
	
	}
	
	
	public static double distanciaPuntoPunto(int posicionAbscisaInicial,int posicionOrdenadaInicial,int posicionAbscisaFinal,int posicionOrdenadaFinal){
		
		return Math.sqrt((posicionAbscisaInicial-posicionAbscisaFinal)*(posicionAbscisaInicial-posicionAbscisaFinal)+(posicionOrdenadaInicial-posicionOrdenadaFinal)*(posicionOrdenadaInicial-posicionOrdenadaFinal));
	}
	
	public static double calculaPuntoTangente(int radioRobot,int posicionAbscisaInicial,int posicionOrdenadaInicial){
		
		double discriminantePuntoTangencia;
		double posibleAbscisaTangente1;
		double posibleAbscisaTangente2;
		
		discriminantePuntoTangencia=4*((Math.pow(radioRobot, 4)*posicionAbscisaInicial*posicionAbscisaInicial)-((posicionAbscisaInicial*posicionAbscisaInicial+posicionOrdenadaInicial*posicionOrdenadaInicial)*(Math.pow(radioRobot, 4)-posicionOrdenadaInicial*posicionOrdenadaInicial*radioRobot*radioRobot)));
		
		posibleAbscisaTangente1=(2*radioRobot*radioRobot*posicionAbscisaInicial+Math.sqrt(discriminantePuntoTangencia))/(2*(posicionAbscisaInicial*posicionAbscisaInicial+posicionOrdenadaInicial*posicionOrdenadaInicial));
		posibleAbscisaTangente2=(2*radioRobot*radioRobot*posicionAbscisaInicial-Math.sqrt(discriminantePuntoTangencia))/(2*(posicionAbscisaInicial*posicionAbscisaInicial+posicionOrdenadaInicial*posicionOrdenadaInicial));
		
		
		if(posibleAbscisaTangente1<=0 && posibleAbscisaTangente2<=0){
			if(Math.abs(posicionAbscisaInicial-posibleAbscisaTangente1)>Math.abs(posicionAbscisaInicial-posibleAbscisaTangente2)){
				return posibleAbscisaTangente2;
			}
			else{
				return posibleAbscisaTangente1;
			}
		}
		else{
			if(posibleAbscisaTangente1<=0 ){		
				return posibleAbscisaTangente1;
				
			}
			else{
				return posibleAbscisaTangente2;
			}
		}
		
		
	}
	
	public static double calculaRecorridoTotal(int radioRobot,int posicionAbscisaInicial, int posicionOrdenadaInicial,int posicionAbscisaFinal, int posicionOrdenadaFinal,double primerCorteAbscisa,double segundoCorteAbscisa,double primerCorteOrdenada,double segundoCorteOrdenada){
		
		double anguloInterno;
		double primerTramo;
		double segundoTramo;
		double recorridoTotal;
		double tramoCircunferencia;
		
		anguloInterno=Math.acos((primerCorteAbscisa*segundoCorteAbscisa+primerCorteOrdenada*segundoCorteOrdenada)/(Math.sqrt(primerCorteAbscisa*primerCorteAbscisa+primerCorteOrdenada*primerCorteOrdenada)*Math.sqrt(segundoCorteAbscisa*segundoCorteAbscisa+segundoCorteOrdenada*segundoCorteOrdenada)));
    	//System.out.println((primerCorteAbscisa*segundoCorteAbscisa+primerCorteOrdenada*segundoCorteOrdenada)/(Math.sqrt(primerCorteAbscisa*primerCorteAbscisa+primerCorteOrdenada*primerCorteOrdenada)*Math.sqrt(segundoCorteAbscisa*segundoCorteAbscisa+segundoCorteOrdenada*segundoCorteOrdenada)));
		tramoCircunferencia=anguloInterno*radioRobot;
    	primerTramo=Math.sqrt(Math.pow(posicionAbscisaInicial-primerCorteAbscisa, 2)+Math.pow(posicionOrdenadaInicial-primerCorteOrdenada, 2));
    	segundoTramo=Math.sqrt(Math.pow(posicionAbscisaFinal-segundoCorteAbscisa, 2)+Math.pow(posicionOrdenadaFinal-segundoCorteOrdenada, 2));
    	recorridoTotal=primerTramo+tramoCircunferencia+segundoTramo;
		return recorridoTotal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int posicionAbscisaInicial,posicionOrdenadaInicial,posicionAbscisaFinal,posicionOrdenadaFinal,radioRobot;
		double recorridoTotal;
		Scanner entradaEscaner = new Scanner (System.in);
		
        radioRobot= entradaEscaner.nextInt();
		posicionAbscisaInicial= entradaEscaner.nextInt();
        posicionOrdenadaInicial= entradaEscaner.nextInt();
        posicionAbscisaFinal= entradaEscaner.nextInt();
        posicionOrdenadaFinal= entradaEscaner.nextInt();
         
        recorridoTotal=minDistance(radioRobot,posicionAbscisaInicial,posicionOrdenadaInicial,posicionAbscisaFinal,posicionOrdenadaFinal);
        
        System.out.println(recorridoTotal);
	}

}
