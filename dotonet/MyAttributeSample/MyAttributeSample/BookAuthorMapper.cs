using System;
namespace MyAttributeSample
{
    public class BookAuthorMapper
    {
        private Book book;
        private Author author;

        public BookAuthorMapper(Book book, Author author) {
            this.book = book;
            this.author = author;
        }
    }
}
