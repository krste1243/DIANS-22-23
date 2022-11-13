package PipeAndFilterPackage;

public class FilterNameAndAddress implements Filter<String>{

    @Override
    public String execute(String input) {
        int firstIdx = input.indexOf('\"');
        int lastIdx = input.lastIndexOf('\"');
        if(firstIdx == -1 || lastIdx == -1)
            return "";
        input = input.substring(firstIdx+1,lastIdx);
        return input;
    }
}
