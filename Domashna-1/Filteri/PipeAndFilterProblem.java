package PipeAndFilterPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PipeAndFilterProblem {
    public static void main(String[] args) throws FileNotFoundException {
        Pipe<String> pipe = new Pipe<>();
        FilterGradAndPostalCode filterGradAndPostalCode=new FilterGradAndPostalCode();
        FilterToLowerCase toLowerCase = new FilterToLowerCase();
        FilterToUpperCase toUpperCase = new FilterToUpperCase();
        FilterNameAndAddress nameAndAddress = new FilterNameAndAddress();
        FilterGetFacultyName facultyName = new FilterGetFacultyName();
        GetPostalCodeFilter getPostalCodeFilter=new GetPostalCodeFilter();

        //pipe.addFilter(toUpperCase);
        //pipe.addFilter(getPostalCodeFilter);
        pipe.addFilter(toLowerCase);
        pipe.addFilter(nameAndAddress);
        pipe.addFilter(filterGradAndPostalCode);
        //pipe.addFilter(facultyName);

        Scanner scanner = new Scanner(new File("C:\\Users\\Krste\\Downloads\\pina\\FacultyApp\\faculties_info.csv"));
        scanner.useDelimiter(",");


        while (scanner.hasNextLine()){
            System.out.println(pipe.runFilter(scanner.nextLine()));
        }
    }
}
