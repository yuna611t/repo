using System;
using System.Collections.Generic;
using System.Text;
using Microsoft.AspNetCore.Html;

namespace MyFirstApp.Code.Helper
{
    public static class MovieHelper 
    {
        public static HtmlString DisplayMovies(List<MyFirstApp.Models.Movie> model){
            StringBuilder sb = new StringBuilder();
            sb.Append("<ul><li>");
            // build contents
            foreach(var movie in model) {
                sb.Append("<ul>");
                sb.Append("<li>" + @movie.ID + "</li>");
                sb.Append("<li>" + @movie.Title + "</li>");
                sb.Append("<li>" + @movie.ReleaseDate + "</li>");
                sb.Append("<li>" + @movie.Genre + "</li>");
                sb.Append("<li>" + @movie.Price + "</li>");
                sb.Append("</ul>");
            }
            sb.Append("</li></ul>");
            return new HtmlString(sb.ToString());
        }
    }
}
