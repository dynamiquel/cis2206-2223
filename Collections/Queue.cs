using System.Runtime.CompilerServices;
using System.Text;

namespace Collections;

public class Queue<T> : IQueue<T>
{
    private const int DefaultCapacity = 8;
    
    // The internal array.
    private T[] items;
    
    // The number of elements the Queue is currently using from the internal array.
    private int queueLength;
    
    // The index at which to enqueue if the queue isn't full.
    private int tail;
    
    // The index from which to dequeue if the queue isn't empty.
    private int head;
    private static readonly T[] emptyArray = new T[0];

    public Queue()
    {
        items = emptyArray;
    }

    public Queue(int capacity)
    {
        items = capacity <= 0 ? emptyArray : new T[capacity];
    }
    
    public int Capacity
    {
        get => items.Length;
        set
        {
            T[] newarray = new T[value];

            if (queueLength > 0)
            {
                if (head < tail)
                    Array.Copy(items, head, newarray, 0, queueLength);
                else
                {
                    Array.Copy(items, head, newarray, 0, items.Length - head);
                    Array.Copy(items, 0, newarray, items.Length - head, tail);
                }
            }

            items = newarray;
            head = 0;
            tail = (queueLength == value) ? 0 : queueLength;
        }
    }

    public int Count => queueLength;
    
    public int Add(T value)
    {
        Enqueue(value);
        return tail;
    }

    public bool Contains(T value)
    {
        if (queueLength == 0)
            return false;

        if (head < tail)
        {
            return Array.IndexOf(items, value, head, queueLength) >= 0;
        }

        // We've wrapped around. Check both partitions, the least recently enqueued first.
        return
            Array.IndexOf(items, value, head, items.Length - head) != -1 ||
            Array.IndexOf(items, value, 0, tail) != -1;
    }

    public void Clear()
    {
        if (queueLength == 0)
            return;

        if (RuntimeHelpers.IsReferenceOrContainsReferences<T>())
        {
            // Normal queue (head is before tail).
            if (head < tail)
            {
                // Remove from head (i.e. 0) to the end of the used array.
                Array.Clear(items, head, queueLength);
            }
            // Cycled queue (cycling has occured and now the head is after the tail).
            else
            {
                // Remove from head (i.e. 6) to the end of the used array.
                Array.Clear(items, head, items.Length - head);
                // Remove from 0 to the tail (i.e. 3).
                Array.Clear(items, 0, tail);
            }
            
            queueLength = 0;
        }

        head = 0;
        tail = 0;
    }

    public T[] ToArray()
    {
        if (queueLength == 0)
            return Array.Empty<T>();
        
        var copiedArray = new T[queueLength];
        
        if (head < tail)
        {
            Array.Copy(items, head, copiedArray, 0, queueLength);
        }
        else
        {
            Array.Copy(items, head, copiedArray, 0, items.Length - head);
            Array.Copy(items, 0, copiedArray, items.Length - head, tail);
        }

        return copiedArray;
    }

    public void Enqueue(T item)
    {
        if ((uint) queueLength == (uint) items.Length)
            Grow(queueLength + 1);

        items[tail] = item;
        MoveNext(ref tail);
        queueLength++;
    }

    public T Dequeue()
    {
        if (queueLength == 0)
            throw new InvalidOperationException("EmptyQueue");

        T removedItem = items[head];
        
        if (RuntimeHelpers.IsReferenceOrContainsReferences<T>())
            items[head] = default!;

        MoveNext(ref head);
        queueLength--;

        return removedItem;
    }
    
    private void MoveNext(ref int index)
    {
        int tmp = index + 1;
        if (tmp == items.Length)
            tmp = 0;
        
        index = tmp;
    }

    public T Peek()
    {
        if (queueLength == 0)
            throw new InvalidOperationException("EmptyQueue");

        return items[head];
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
        sb.AppendLine($"Total Items: {queueLength}");
        sb.AppendLine($"Capacity: {items.Length}");
        sb.AppendLine($"Head: {head}");
        sb.AppendLine($"Tail: {tail}");

        var arr = ToArray();
        for (var i = 0; i < arr.Length; i++)
        {
            sb.Append($"[{i}] {items[i]}");
            
            if (i < arr.Length - 1)
                sb.Append(", ");
        }

        return sb.ToString();
    }
}