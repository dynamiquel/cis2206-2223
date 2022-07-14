namespace Collections;

public interface IList<T> : ICollection<T>
{
    T this[int index]
    {
        get;
        set;
    }

    /// <summary>
    /// Tries to get the value of the given index in a safe way; no exceptions.
    /// </summary>
    /// <param name="index">The index of the value to look for.</param>
    /// <param name="value">The returned value found in the List.</param>
    /// <returns>Whether the value was found.</returns>
    bool TryGetAt(int index, out T? value);

    /// <summary>
    /// Inserts the given value at the given index.
    /// </summary>
    /// <param name="index"></param>
    /// <param name="value"></param>
    /// <exception cref="IndexOutOfRangeException"></exception>
    void Insert(int index, T value);
    
    /// <summary>
    /// Removes the given value from the List.
    /// </summary>
    /// <returns>Whether the value was found and removed.</returns>
    bool Remove(T value);

    /// <summary>
    /// Removes an item from a given Index.
    /// </summary>
    /// <param name="index"></param>
    /// <exception cref="IndexOutOfRangeException"></exception>
    void RemoveAt(int index);
}