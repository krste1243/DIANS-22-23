package PipeAndFilterPackage;

public interface Filter<T> {
    T execute(T input);
}
