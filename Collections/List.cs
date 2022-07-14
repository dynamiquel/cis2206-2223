using System.Runtime.CompilerServices;
using System.Text;

namespace Collections;

public class List<T> : IList<T>
{
    private const int DefaultCapacity = 8;
    
    // The internal array.
    private T[] items;
    
    // The number of elements the List is currently using from the internal array.
    private int listLength;
    
    private static readonly T[] emptyArray = new T[0];
    
    public List()
    {
        // Unused List will initialise as an empty array to not waste space.
        items = emptyArray;
    }

    public List(int capacity)
    {
        items = capacity <= 0 ? emptyArray : new T[capacity];
    }
    
    /// <summary>
    /// The size of the internal array. For most performance, always set it slightly higher than the largest
    /// the List will be.
    /// </summary>
    public int Capacity
    {
        get => items.Length;
        set
        {
            if (value < listLength)
                return;

            if (value == items.Length) 
                return;
            
            if (value > 0)
            {
                Array.Resize(ref items, value);
            }
            else
            {
                items = emptyArray;
            }
        }
    }

    public int Count => listLength;
    
    public int Add(T value)
    {
        // The internal array has reached it's limit, grow.
        if ((uint)listLength == (uint)items.Length)
            Grow(listLength + 1);
        
        // Add the item to the of the internal array and increment the listLength.
        listLength++;
        items[listLength - 1] = value;
        return listLength - 1;
    }

    private void Grow(int capacity)
    {
        // Calculate the new capacity required.
        int newCapacity = items.Length == 0 ? DefaultCapacity : 2 * items.Length;

        // Ensure newCapacity cannot exceed the maximum array size in .NET.
        if ((uint)newCapacity > Array.MaxLength) 
            newCapacity = Array.MaxLength;

        if (newCapacity < capacity) 
            newCapacity = capacity;

        // Set the new Capacity.
        Capacity = newCapacity;
    }

    public bool Contains(T value)
    {
        return listLength != 0 && Array.IndexOf(items, value, 0, listLength) != -1;
    }

    public void Clear()
    {
        if (RuntimeHelpers.IsReferenceOrContainsReferences<T>())
            Array.Clear(items, 0, listLength);
        
        listLength = 0;
    }
    
    public bool Remove(T value)
    {
        var index = Array.IndexOf(items, value, 0, listLength);
        if (index < 0) 
            return false;
        
        RemoveAt(index);
        return true;
    }

    public T[] ToArray()
    {
        var copiedArray = new T[listLength];
        Array.Copy(items, copiedArray, listLength);
        return copiedArray;
    }

    public T this[int index]
    {
        get
        {
            if ((uint)index >= (uint)listLength)
                throw new IndexOutOfRangeException();
            
            return items[index];
        }

        set
        {
            if ((uint)index >= (uint)listLength)
                throw new IndexOutOfRangeException();

            items[index] = value;
        }
    }

    public bool TryGetAt(int index, out T? value)
    {
        if ((uint)index >= (uint)listLength)
        {
            value = default;
            return false;
        }
            
        value = items[index];
        return true;
    }
    
    public void Insert(int index, T value)
    {
        if ((uint)index > (uint)listLength)
            throw new IndexOutOfRangeException();
        
        if (listLength == items.Length) 
            Grow(listLength + 1);
        
        if (index < listLength)
            Array.Copy(items, index, items, index + 1, listLength - index);

        items[index] = value;
        listLength++;
    }

    public void RemoveAt(int index)
    {
        if ((uint)index >= (uint)listLength)
            throw new IndexOutOfRangeException();

        listLength--;
        if (index < listLength)
            Array.Copy(items, index + 1, items, index, listLength - index);

        if (RuntimeHelpers.IsReferenceOrContainsReferences<T>())
        {
            items[listLength] = default!;
        }
    }

    public override string ToString()
    {
        var sb = new StringBuilder();
        sb.AppendLine($"Total Items: {listLength}");
        sb.AppendLine($"Capacity: {items.Length}");
        
        for (var i = 0; i < listLength; i++)
        {
            sb.Append($"[{i}] {items[i]}");
            if (i < listLength - 1)
                sb.Append(", ");
        }

        return sb.ToString();
    }
}