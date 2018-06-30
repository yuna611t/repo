using System;
namespace MyAttributeSample
{
    public class TableAttribute : Attribute
    {

        private string tableName;
		public TableAttribute(string tableName)
        {
            this.tableName = tableName;
        }

        public void DoAction() {
            
        }
	}

    public class ColumnAttribute : Attribute
    {
        private string columnName;
        public string ColumnValue { get { return "ABC"; }}

        public ColumnAttribute(string columnName) {
            this.columnName = columnName;
        }
    }
}
