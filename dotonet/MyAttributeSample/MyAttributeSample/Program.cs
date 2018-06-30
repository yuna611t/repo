using System;

namespace MyAttributeSample
{
    class Program
    {
        static void Main(string[] args)
        {

            Reflaction reflection = new Reflaction();
            reflection.Execute(new PersonModel());

        }
    }
}
