using System;
using System.Linq;

namespace BidirectionalAssociation
{
    class Program
    {
        static void Main(string[] args)
        {

            Person person = new Person();
            person.AddCar(new Car() {Name = "Car1"});
            person.AddCar(new Car(){Name = "Car2"});
            // person.Cars.Add( new Car() {Name = "XXX"} );
            foreach (var car in person.Cars)
            {
                System.Console.WriteLine( car.Name );
            }
            foreach (var car in person.EditableCars) 
            {
                System.Console.WriteLine( car.Name );
            }
        }
    }
}
