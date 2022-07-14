namespace Collections;


public interface IList<T> : ICollection<T>
{
    T this[int index]
    {
        get;
        set;
    }
    
    bool TryGetAt(int index, out T? value);

    void Insert(int index, T value);
    
    bool Remove(T value);

    void RemoveAt(int index);
}