using System;
namespace MyAttributeSample
{
    [Table ("person")]
    public class PersonModel : IMyModel

    {
        [Column("name")]
        public string Name { get; set; }

        [Column("age")]
        public int Age { get; set; }
    }
}
