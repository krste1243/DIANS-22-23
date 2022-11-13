package PipeAndFilterPackage;

public class FilterToLowerCase implements Filter<String>{

    @Override
    public String execute(String input) {
        return input.toLowerCase();
    }
}
