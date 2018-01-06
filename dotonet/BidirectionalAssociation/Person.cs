using System;
using System.Linq;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace BidirectionalAssociation
{
    public class Person
    {
        private IList<Car> _cars = new List<Car>();
        public ReadOnlyCollection<Car> Cars {
            get {return new ReadOnlyCollection<Car>(_cars);}
        }
        
        public void AddCar(Car car){
            car.Owner = this;
        }

        internal IList<Car> FriendCars() {
            return _cars;
        }
    }

    public class Car {
        public string Name {get;set;}

        private Person _owner;
        public Person Owner {
            get { return _owner; }
            set {
                if (_owner != null)
                    _owner.FriendCars().Remove(this);
                _owner = value;
                if (_owner != null)
                    _owner.FriendCars().Add(this);
            }
        }
    }
}
