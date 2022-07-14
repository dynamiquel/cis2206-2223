namespace Collections;

public interface IStack<T> : ICollection<T>
{
    T Peek();

    T Pop();

    void Push(T item);
}