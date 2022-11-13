package PipeAndFilterPackage;

public class FilterGradAndPostalCode implements Filter<String>{

    @Override
    public String execute(String input) {
        if(input.toUpperCase().contains("SKOPJE")){return "Skopje 1000";}
      else  if(input.toUpperCase().contains("BITOLA")){return "Bitola 7000";}
        else  if(input.toUpperCase().contains("SHTIP")){return "Shtip 2000";}
        else  if(input.toUpperCase().contains("PRILEP")){return "Prilep 7500";}
        else if(input.toUpperCase().contains("KICHEVO")){return "Kichevo 6250";}
        else if(input.toUpperCase().contains("OHRID")){return "Ohrid 6000";}
        else if(input.toUpperCase().contains("TETOVO")){return "Tetovo 1200";}
        else return "";
    }
}
