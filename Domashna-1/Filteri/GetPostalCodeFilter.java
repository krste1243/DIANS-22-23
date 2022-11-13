package PipeAndFilterPackage;


public class GetPostalCodeFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        if(input.contains("PLACE")){return "";}
        int firstIdx = input.indexOf('\"');
        int lastIdx = input.lastIndexOf('\"');
        if(firstIdx == -1 || lastIdx == -1)
            return input;
        input = input.substring(firstIdx,lastIdx);
        String[] parts = input.split(",");
        return parts[parts.length - 2];

    }
}