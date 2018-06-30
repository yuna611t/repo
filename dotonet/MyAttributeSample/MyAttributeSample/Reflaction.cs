using System;
using System.Reflection;
using System.Collections.Generic;

namespace MyAttributeSample
{
    public class Reflaction
    {

        public void Execute(IMyModel model)
        {
            var type = model.GetType();
            var attributes = type.GetTypeInfo().GetCustomAttributes<TableAttribute>();
            foreach (var attr in attributes)
            {

                if (attr is TableAttribute)
                {
                    var x = attr as TableAttribute;
                    foreach(var prop in type.GetProperties()) {                        
						foreach(var propAttr in prop.GetCustomAttributes()) {
                            if (propAttr is ColumnAttribute) {
                                
                                //((ColumnAttribute)propAttr).ColumnValue;
                            }
                        }
                    }
                        

                    x.DoAction();
                }
            }
        }
    }
}
