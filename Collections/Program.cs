// See https://aka.ms/new-console-template for more information

Console.WriteLine("Hello, World!");

/*var intList = new Collections.List<int>();
Console.WriteLine(intList.ToString());

// Proof for Add.
intList.Add(9);
Console.WriteLine(intList.ToString());

// Proof for end of list Insertion.
intList.Insert(1, 8);
Console.WriteLine(intList.ToString());

// Proof for in list Insertion.
intList.Insert(0, 99);
Console.WriteLine(intList.ToString());

// Proof of reaching Capacity.
intList.Add(7);
intList.Add(6);
intList.Add(5);
intList.Add(4);
intList.Add(3);
Console.WriteLine(intList.ToString());

// Proof of internal array growth (Capacity increase).
intList.Add(2);
Console.WriteLine(intList.ToString());

// Proof of end of line Removal.
intList.RemoveAt(intList.Count - 1);
Console.WriteLine(intList.ToString());

// Proof of in line Removal.
intList.RemoveAt(4);
Console.WriteLine(intList.ToString());

// Proof of getting a desired number.
var seven = intList[3];
Console.WriteLine(seven);

// Proof of Contains working.
Console.WriteLine(intList.Contains(8));*/


/*var stringStack = new Collections.Stack<string>();
Console.WriteLine(stringStack.ToString());

// Proof for Add.
stringStack.Add("Nine");
Console.WriteLine(stringStack.ToString());

// Proof for end of list Insertion.
stringStack.Push("Eight");
Console.WriteLine(stringStack.ToString());

// Proof of reaching Capacity.
stringStack.Push("Seven");
stringStack.Push("Six");
stringStack.Push("Five");
stringStack.Push("Four");
stringStack.Push("Three");
stringStack.Push("Two");
Console.WriteLine(stringStack.ToString());

// Proof of internal array growth (Capacity increase).
stringStack.Add("One");
Console.WriteLine(stringStack.ToString());

// Proof of Pop.
stringStack.Pop();
Console.WriteLine(stringStack.ToString());

// Proof of Peek.
var peek = stringStack.Peek();
Console.WriteLine(peek);

// Proof of Contains working.
Console.WriteLine(stringStack.Contains("Five"));*/


var stringQueue = new Collections.Queue<string>();
Console.WriteLine(stringQueue.ToString());

// Proof for Add.
stringQueue.Add("Nine");
Console.WriteLine(stringQueue.ToString());

// Proof for end of list Insertion.
stringQueue.Enqueue("Eight");
Console.WriteLine(stringQueue.ToString());

stringQueue.Enqueue("Seven");

// Proof of Pop.
Console.WriteLine(stringQueue.Dequeue());
Console.WriteLine(stringQueue.ToString());

// Proof of reaching Capacity.
stringQueue.Enqueue("Six");
stringQueue.Enqueue("Five");
stringQueue.Enqueue("Four");
stringQueue.Enqueue("Three");
stringQueue.Enqueue("Two");
Console.WriteLine(stringQueue.ToString());

// Proof of internal array growth (Capacity increase).
stringQueue.Enqueue("One");
Console.WriteLine(stringQueue.ToString());

// Proof of Pop.
Console.WriteLine(stringQueue.Dequeue());
Console.WriteLine(stringQueue.ToString());

// Proof of Peek.
var peek = stringQueue.Peek();
Console.WriteLine(peek);

// Proof of Contains working.
Console.WriteLine(stringQueue.Contains("Five"));

// Proof of circular
