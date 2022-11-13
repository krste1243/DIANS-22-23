package PipeAndFilterPackage;

public class FilterToUpperCase implements Filter<String>{

    @Override
    public String execute(String input) {
        return input.toUpperCase();
    }
}
