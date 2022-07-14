namespace Collections;

public interface ICollection<T>
{
    /// <summary>
    /// The number of items in the Collection.
    /// </summary>
    int Count { get; }
    
    /// <summary>
    /// Adds the value to the end of the Collection.
    /// </summary>
    /// <returns>Index the value occupies within the Collection.</returns>
    int Add(T value);
    
    /// <summary>
    /// Check whether the Collection contains the given value.
    /// </summary>
    bool Contains(T value);
    
    /// <summary>
    /// Removes all values from the Collection and sets to 0.
    /// </summary>
    void Clear();

    /// <summary>
    /// Returns an array copy of the Collection.
    /// </summary>
    T[] ToArray();
}