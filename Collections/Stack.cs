using System.Runtime.CompilerServices;
using System.Text;

namespace Collections;

public class Stack<T> : IStack<T>
{
    private const int DefaultCapacity = 8;
    
    private T[] items;
    private int stackLength;
    private static readonly T[] emptyArray = new T[0];

    public Stack()
    {
        items = emptyArray;
    }

    public Stack(int capacity)
    {
        items = capacity <= 0 ? emptyArray : new T[capacity];
    }
    
    public int Capacity
    {
        get => items.Length;
        set
        {
            if (value < stackLength)
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

    public int Count => stackLength;
    
    public int Add(T value)
    {
        Push(value);
        return stackLength - 1;
    }

    public bool Contains(T value)
    {
        return stackLength != 0 && Array.IndexOf(items, value, 0, stackLength) != -1;
    }

    public void Clear()
    {
        if (RuntimeHelpers.IsReferenceOrContainsReferences<T>())
            Array.Clear(items, 0, stackLength);
        
        stackLength = 0;
    }

    public T[] ToArray()
    {
        var copiedArray = new T[stackLength];
        Array.Copy(items, copiedArray, stackLength);
        return copiedArray;
    }

    public T Peek()
    {
        int index = stackLength - 1;
        if ((uint) index >= (uint) items.Length)
            throw new InvalidOperationException("EmptyStack");
        
        return items[index];
    }

    public T Pop()
    {
        int index = stackLength - 1;
        if ((uint) index >= (uint) items.Length)
            throw new InvalidOperationException("EmptyStack");

        stackLength = index;
        T obj = items[index];
        if (RuntimeHelpers.IsReferenceOrContainsReferences<T>())
            items[index] = default (T);
        
        return obj;
    }

    public void Push(T item)
    {
        int size = stackLength;
        T[] array = items;
        if ((uint) size < (uint) array.Length)
        {
            array[size] = item;
            stackLength = size + 1;
        }
        else
            PushWithResize(item);
    }
    
    private void PushWithResize(T item)
    {
        Grow(stackLength + 1);
        items[stackLength] = item;
        stackLength++;
    }
    private void Grow(int capacity)
    {
        int newCapacity = items.Length == 0 ? DefaultCapacity : 2 * items.Length;

        if ((uint)newCapacity > Array.MaxLength) 
            newCapacity = Array.MaxLength;

        if (newCapacity < capacity) 
            newCapacity = capacity;

        Capacity = newCapacity;
    }
    
    public override string ToString()
    {
        var sb = new StringBuilder();
        sb.AppendLine($"Total Items: {stackLength}");
        sb.AppendLine($"Capacity: {items.Length}");
        
        for (var i = 0; i < stackLength; i++)
        {
            sb.Append($"[{i}] {items[i]}");
            if (i < stackLength - 1)
                sb.Append(", ");
        }

        return sb.ToString();
    }
}