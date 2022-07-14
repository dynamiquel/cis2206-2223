namespace Collections;

public interface ICollection<T>
{
    int Count { get; }
    
    int Add(T value);
    
    bool Contains(T value);
    
    void Clear();

    T[] ToArray();
}