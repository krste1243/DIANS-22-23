package PipeAndFilterPackage;

public class FilterGetFacultyName implements Filter<String>{

    @Override
    public String execute(String input) {
        return input.split(",")[1].substring(1);
    }
}
