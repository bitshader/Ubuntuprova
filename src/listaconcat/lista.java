package listaconcat;

import java.io.*;

public class lista{
    private Nodo testa=null;
    private Nodo coda=null;
    Rubrica Persona = new Rubrica();
    final InputStreamReader in = new InputStreamReader(System.in);
    final BufferedReader tastiera = new BufferedReader(in);
    
    //costruttore vuoto
    public lista(){

    }

    public void inserisci (String str){
        Nodo n = new Nodo(str);
        Nodo succ,temp;
        boolean aggiunto;

        if(testa==null){        //1 vuoto 
            testa=coda=n;
        }
        else{
            if(str.compareTo(testa.getDato()) <0){       //2 testa
                n.setSuccessivo(testa);
                testa = n;
            }
            else{                                       //3 interno lista
                aggiunto = false;
                temp = testa;
                succ = testa.getSuccessivo();
                while(succ != null){
                    if(str.compareTo(succ.getDato()) <0){
                        temp.setSuccessivo(n);
                        n.setSuccessivo(succ);
                        aggiunto = true;
                        break;
                    }
                    temp = succ;
                    succ = succ.getSuccessivo();
                }
                if(!aggiunto){                  //4 coda
                    coda.setSuccessivo(n);
                    coda = n;
                }
            }
        }
    }

    public void elimina(){
        Nodo temp,succ;
        String eliminaelemento= "";
        String stringainserita= "";
        boolean flag = false;
        System.out.println("Vuoi eliminare un elemento della rubrica ?Y/n");
        try {
            
            eliminaelemento = tastiera.readLine();

        } catch (final Exception e){
            System.out.println("errore");
        } 
        
        if(eliminaelemento.compareTo("Y") == 0){
            flag = true;
        }

        while(flag != false){

        
            System.out.println("Inserire nome persona dalla lista");
            try{
                
                Persona.Nome = tastiera.readLine();

            }catch (final Exception e){
                System.out.println("errore");
            }


            System.out.println("Inserire cognome persona dalla lista");
            try{
                
                Persona.Cognome = tastiera.readLine();

            }catch (final Exception e){
                System.out.println("errore");
            }

            Persona.persona = Persona.Nome + "\t" + Persona.Cognome;

            if ((Persona.persona).compareTo(testa.getDato()) == 0) {
                testa = testa.getSuccessivo();
                System.out.println("Elemento eliminato si trovava all'inizio della lista");
                System.out.println("Elemento si trovava alla posizione 1");
            }
            else{
                temp = testa;
                succ = testa.getSuccessivo();
                int cont = 1;
    
                while(succ != null){
                    cont++;
                    if((Persona.persona).compareTo(succ.getDato()) == 0){
                        temp.setSuccessivo(succ.getSuccessivo());
                        System.out.println("Elemento eliminato si trovava alla posizione"+cont+"della lista");
                        break;
                    }
                    temp = succ;
                    succ = succ.getSuccessivo();
                    
                }
                 if((Persona.persona).compareTo(coda.getDato()) == 0){
                coda = temp;
                System.out.println("Elemento eliminato si trovava alla fine della lista");
            }
            else{
                System.out.println("Elemento non presente");
            }
            }
            
            System.out.println("Vuoi eliminare un altro elemento della rubrica ?Y/n");
            try {
                
                eliminaelemento = tastiera.readLine();
    
            } catch (final Exception e){
                System.out.println("errore");
            } 
    
            if(eliminaelemento.compareTo("Y") == 0){
                flag = true;
            }
            else{
                flag = false;
            }

        }
       

        

        
    }

    public boolean contiene(String str){
        Nodo temp;
        temp = testa;
        while(testa != null){
            if(str.equals(temp.getDato())){
                return true;
            }
            temp = temp.getSuccessivo();
        }
        return false;
    }

    public void stampa(){
        Nodo temp;
        temp=testa;
        System.out.println("Contenuto lista");

        System.out.println("NOMI"+"\t"+"COGNOMI");
        while(temp!= null){

                System.out.println(temp.getDato());
                temp = temp.getSuccessivo();

          
        }
    }
}