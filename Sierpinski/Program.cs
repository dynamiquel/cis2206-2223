using Sierpinski;

Console.WriteLine("Hello, World!");

var carpet = new SierpinskiCarpet(DimensionSize.Nine);
Console.WriteLine(carpet.ToString());

var path = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.Desktop),
    "SierpinskiCarpet.txt");

File.WriteAllTextAsync(path, carpet.ToString());